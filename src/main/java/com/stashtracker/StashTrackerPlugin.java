package com.stashtracker;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemVariationMapping;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "STASH Tracker",
	description = "Track which STASH units you have built and filled, grouped by clue tier",
	tags = {"clue", "stash", "treasure", "trail", "emote"}
)
public class StashTrackerPlugin extends Plugin
{
	/** How long after interacting with a STASH object we attribute a chat message to it. */
	private static final long INTERACTION_WINDOW_MS = 5000L;
	/** Fallback radius (tiles) for attributing a chat message to a STASH by player location. */
	private static final int PROXIMITY_TILES = 5;

	@Inject
	private Client client;

	@Inject
	private StashTrackerConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private StashItemOverlay stashItemOverlay;

	@Inject
	private WorldMapPointManager worldMapPointManager;

	private StashTrackerPanel panel;
	private NavigationButton navButton;

	/** Item ids (variant-expanded) still owed to an unfilled STASH; read by the inventory overlay. */
	private volatile Set<Integer> neededItemIds = Collections.emptySet();
	private final List<WorldMapPoint> worldMapPoints = new ArrayList<>();
	private BufferedImage filledImage;
	private BufferedImage builtEmptyImage;
	private BufferedImage notBuiltImage;

	/** Per-account state. Mutated on the client thread and the Swing EDT, so guarded by this lock. */
	private final Object lock = new Object();
	private final Set<StashUnit> built = EnumSet.noneOf(StashUnit.class);
	private final Set<StashUnit> filled = EnumSet.noneOf(StashUnit.class);

	private long accountHash = -1L;

	private StashUnit pendingStash;
	private long pendingStashTime;

	@Provides
	StashTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StashTrackerConfig.class);
	}

	@Override
	protected void startUp()
	{
		filledImage = createMarker(new Color(0x5F, 0xC9, 0x6A));
		builtEmptyImage = createMarker(new Color(0xD0, 0x6A, 0x4F));
		notBuiltImage = createMarker(new Color(0x9E, 0x9E, 0x9E));

		panel = new StashTrackerPanel(this, config);

		final BufferedImage icon = ImageUtil.loadImageResource(StashTrackerPlugin.class, "icon.png");
		navButton = NavigationButton.builder()
			.tooltip("STASH Tracker")
			.icon(icon)
			.priority(7)
			.panel(panel)
			.build();
		clientToolbar.addNavigation(navButton);
		overlayManager.add(stashItemOverlay);

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			syncAccount();
		}
		else
		{
			refresh();
		}
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
		overlayManager.remove(stashItemOverlay);
		clearWorldMapPoints();
		navButton = null;
		panel = null;
		neededItemIds = Collections.emptySet();
		synchronized (lock)
		{
			built.clear();
			filled.clear();
			accountHash = -1L;
			pendingStash = null;
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			syncAccount();
		}
	}

	/** Reloads stored state when the logged-in account changes. */
	private void syncAccount()
	{
		final long hash = client.getAccountHash();
		synchronized (lock)
		{
			if (hash == accountHash)
			{
				return;
			}
			accountHash = hash;
			built.clear();
			filled.clear();
			built.addAll(loadSet("built"));
			filled.addAll(loadSet("filled"));
		}
		refresh();
	}

	/**
	 * A built STASH unit only renders for the player who built it, so seeing its object spawn means
	 * the local player has built it.
	 */
	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (!config.autoDetect())
		{
			return;
		}

		final StashUnit unit = StashUnit.forObjectId(event.getGameObject().getId());
		if (unit == null)
		{
			return;
		}

		boolean changed;
		synchronized (lock)
		{
			changed = built.add(unit);
		}
		if (changed)
		{
			saveSet("built", built);
			refresh();
		}
	}

	/** Remember which built STASH the player just interacted with, to attribute the next message. */
	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		if (!config.autoDetect())
		{
			return;
		}

		final StashUnit unit = StashUnit.forObjectId(event.getId());
		if (unit != null)
		{
			pendingStash = unit;
			pendingStashTime = System.currentTimeMillis();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!config.autoDetect())
		{
			return;
		}

		final ChatMessageType type = event.getType();
		if (type != ChatMessageType.GAMEMESSAGE && type != ChatMessageType.SPAM && type != ChatMessageType.MESBOX)
		{
			return;
		}

		final String message = Text.removeTags(event.getMessage()).toLowerCase();
		if (!message.contains("stash"))
		{
			return;
		}

		// Decide what happened. Messages are matched loosely so wording tweaks don't break detection.
		final Boolean fill;     // true = now filled, false = now empty, null = no fill change
		final Boolean isBuilt;  // true = now built, false = now removed, null = no build change
		if (message.contains("deposit") || message.contains("store") || message.contains("fill"))
		{
			fill = Boolean.TRUE;
			isBuilt = Boolean.TRUE;
		}
		else if (message.contains("withdraw") || message.contains("take") || message.contains("took")
			|| message.contains("retrieve") || message.contains("empt"))
		{
			fill = Boolean.FALSE;
			isBuilt = Boolean.TRUE;
		}
		else if (message.contains("remove") || message.contains("dismantle"))
		{
			fill = Boolean.FALSE;
			isBuilt = Boolean.FALSE;
		}
		else if (message.contains("build") || message.contains("construct"))
		{
			fill = null;
			isBuilt = Boolean.TRUE;
		}
		else
		{
			return;
		}

		final StashUnit unit = resolveStash();
		if (unit == null)
		{
			return;
		}

		boolean changed = false;
		synchronized (lock)
		{
			if (isBuilt != null)
			{
				changed |= isBuilt ? built.add(unit) : built.remove(unit);
			}
			if (fill != null)
			{
				changed |= fill ? filled.add(unit) : filled.remove(unit);
			}
		}

		if (changed)
		{
			saveSet("built", built);
			saveSet("filled", filled);
			refresh();
		}
		pendingStash = null;
	}

	/**
	 * Attribute an action to a STASH unit: prefer the one the player just clicked, otherwise the
	 * closest one to the player (covers instances where the object click already identified it).
	 */
	private StashUnit resolveStash()
	{
		if (pendingStash != null && System.currentTimeMillis() - pendingStashTime <= INTERACTION_WINDOW_MS)
		{
			return pendingStash;
		}

		final WorldPoint location = client.getLocalPlayer() != null
			? client.getLocalPlayer().getWorldLocation()
			: null;
		return StashUnit.nearest(location, PROXIMITY_TILES);
	}

	/** Called by the panel when the user manually toggles a unit's filled state. */
	public void toggleFilledManually(StashUnit unit)
	{
		if (!config.allowManualToggle())
		{
			return;
		}

		synchronized (lock)
		{
			if (!filled.remove(unit))
			{
				filled.add(unit);
				built.add(unit); // a filled unit is necessarily built
			}
		}
		saveSet("built", built);
		saveSet("filled", filled);
		refresh();
	}

	/** Resets all tracked state for the current account. */
	public void resetCurrentAccount()
	{
		synchronized (lock)
		{
			built.clear();
			filled.clear();
		}
		saveSet("built", built);
		saveSet("filled", filled);
		refresh();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (StashTrackerConfig.GROUP.equals(event.getGroup()))
		{
			refresh();
		}
	}

	/** Recomputes derived state (needed items, world map, panel) from the current built/filled sets. */
	private void refresh()
	{
		final Set<StashUnit> builtCopy;
		final Set<StashUnit> filledCopy;
		synchronized (lock)
		{
			builtCopy = built.isEmpty() ? EnumSet.noneOf(StashUnit.class) : EnumSet.copyOf(built);
			filledCopy = filled.isEmpty() ? EnumSet.noneOf(StashUnit.class) : EnumSet.copyOf(filled);
		}

		neededItemIds = computeNeededItems(filledCopy);

		final StashTrackerPanel p = panel;
		if (p != null)
		{
			SwingUtilities.invokeLater(() -> p.update(builtCopy, filledCopy));
		}

		clientThread.invokeLater(() -> rebuildWorldMap(builtCopy, filledCopy));
	}

	/** True if the item id is still owed to an unfilled STASH; queried by the inventory overlay. */
	boolean isNeededItem(int itemId)
	{
		return neededItemIds.contains(itemId);
	}

	private Set<Integer> computeNeededItems(Set<StashUnit> filledUnits)
	{
		final Set<Integer> ids = new HashSet<>();
		for (StashUnit unit : StashUnit.values())
		{
			if (filledUnits.contains(unit))
			{
				continue;
			}
			final StashRequirements.Requirement req = StashRequirements.get(unit);
			if (req == null)
			{
				continue;
			}
			for (int id : req.getItemIds())
			{
				ids.add(id);
				// also match charged / degraded / trimmed variants of the canonical item
				ids.addAll(ItemVariationMapping.getVariations(ItemVariationMapping.map(id)));
			}
		}
		return ids;
	}

	private void rebuildWorldMap(Set<StashUnit> builtUnits, Set<StashUnit> filledUnits)
	{
		clearWorldMapPoints();
		if (!config.showWorldMapMarkers())
		{
			return;
		}

		final boolean onlyUnfilled = config.worldMapOnlyUnfilled();
		for (StashUnit unit : StashUnit.values())
		{
			final boolean isFilled = filledUnits.contains(unit);
			if (onlyUnfilled && isFilled)
			{
				continue;
			}
			final boolean isBuilt = builtUnits.contains(unit);
			final BufferedImage image = isFilled ? filledImage : (isBuilt ? builtEmptyImage : notBuiltImage);

			final WorldMapPoint point = new WorldMapPoint(unit.getWorldPoints()[0], image);
			point.setName(unit.getDisplayName());
			point.setTooltip(mapTooltip(unit, isFilled, isBuilt));
			point.setSnapToEdge(true);
			point.setJumpOnClick(true);
			worldMapPointManager.add(point);
			worldMapPoints.add(point);
		}
	}

	private void clearWorldMapPoints()
	{
		for (WorldMapPoint point : worldMapPoints)
		{
			worldMapPointManager.remove(point);
		}
		worldMapPoints.clear();
	}

	private static String mapTooltip(StashUnit unit, boolean isFilled, boolean isBuilt)
	{
		final String status = isFilled ? "Filled" : (isBuilt ? "Built, empty" : "Not built");
		final StashRequirements.Requirement req = StashRequirements.get(unit);
		final String items = req != null ? " | " + req.getDescription() : "";
		return unit.getDisplayName() + " (" + unit.getTier().getDisplayName() + ") - " + status + items;
	}

	private static BufferedImage createMarker(Color color)
	{
		final BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		final Graphics2D g = image.createGraphics();
		g.setColor(color);
		g.fillOval(2, 2, 12, 12);
		g.setColor(color.darker().darker());
		g.drawOval(2, 2, 12, 12);
		g.dispose();
		return image;
	}

	// ---- persistence (per-account, comma-separated enum names) ----

	private String key(String prefix)
	{
		return prefix + "." + accountHash;
	}

	private void saveSet(String prefix, Set<StashUnit> set)
	{
		if (accountHash == -1L)
		{
			return;
		}

		final String csv;
		synchronized (lock)
		{
			csv = set.stream().map(Enum::name).collect(Collectors.joining(","));
		}

		if (csv.isEmpty())
		{
			configManager.unsetConfiguration(StashTrackerConfig.GROUP, key(prefix));
		}
		else
		{
			configManager.setConfiguration(StashTrackerConfig.GROUP, key(prefix), csv);
		}
	}

	private Set<StashUnit> loadSet(String prefix)
	{
		final Set<StashUnit> result = EnumSet.noneOf(StashUnit.class);
		if (accountHash == -1L)
		{
			return result;
		}

		final String csv = configManager.getConfiguration(StashTrackerConfig.GROUP, key(prefix));
		if (csv == null || csv.isEmpty())
		{
			return result;
		}

		Arrays.stream(csv.split(","))
			.map(String::trim)
			.filter(s -> !s.isEmpty())
			.forEach(name ->
			{
				try
				{
					result.add(StashUnit.valueOf(name));
				}
				catch (IllegalArgumentException ex)
				{
					// stored name no longer exists (renamed enum constant); ignore
					log.debug("Ignoring unknown stored STASH unit: {}", name);
				}
			});
		return result;
	}
}
