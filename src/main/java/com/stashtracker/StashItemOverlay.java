package com.stashtracker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

/**
 * Outlines items in the inventory, bank and equipment that still need to be deposited into a STASH
 * unit, so the player doesn't accidentally drop, sell or alch a needed item.
 */
class StashItemOverlay extends WidgetItemOverlay
{
	private static final Color HIGHLIGHT = new Color(0xFF, 0x9B, 0x21);
	private static final Color HIGHLIGHT_FILL = new Color(0xFF, 0x9B, 0x21, 60);

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
		graphics.setColor(HIGHLIGHT_FILL);
		graphics.fill(bounds);
		graphics.setColor(HIGHLIGHT);
		graphics.draw(bounds);
	}
}
