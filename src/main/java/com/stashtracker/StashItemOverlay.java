package com.stashtracker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.inject.Inject;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

/**
 * Marks items in the inventory, bank and equipment that still need to be deposited into a STASH
 * unit, so the player doesn't accidentally drop, sell or alch a needed item. The marker is a small
 * dot in the top-right corner of the item so it stays unobtrusive in a full bank.
 */
class StashItemOverlay extends WidgetItemOverlay
{
	private static final Color HIGHLIGHT = new Color(0xFF, 0x9B, 0x21);
	private static final Color HALO = new Color(0, 0, 0, 190);
	private static final int DOT = 8;

	private final StashTrackerPlugin plugin;
	private final StashTrackerConfig config;

	@Inject
	StashItemOverlay(StashTrackerPlugin plugin, StashTrackerConfig config)
	{
		this.plugin = plugin;
		this.config = config;
		showOnInventory();
		showOnBank();
		showOnEquipment();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (!config.highlightInventoryItems() || !plugin.isNeededItem(itemId))
		{
			return;
		}

		final Rectangle bounds = itemWidget.getCanvasBounds();
		final int x = bounds.x + bounds.width - DOT;
		final int y = bounds.y;

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// dark halo for contrast against bright item sprites, then the coloured dot
		graphics.setColor(HALO);
		graphics.fillOval(x - 1, y - 1, DOT + 2, DOT + 2);
		graphics.setColor(HIGHLIGHT);
		graphics.fillOval(x, y, DOT, DOT);
	}
}
