package com.stashtracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(StashTrackerConfig.GROUP)
public interface StashTrackerConfig extends Config
{
	String GROUP = "stashtracker";

	@ConfigItem(
		keyName = "autoDetect",
		name = "Auto-detect from game",
		description = "Automatically mark STASH units as built/filled when you build, fill or empty them in game.",
		position = 1
	)
	default boolean autoDetect()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hideFilledByDefault",
		name = "Hide filled by default",
		description = "Start the panel with the 'Hide filled' filter enabled.",
		position = 2
	)
	default boolean hideFilledByDefault()
	{
		return false;
	}

	@ConfigItem(
		keyName = "allowManualToggle",
		name = "Allow manual toggle",
		description = "Let you click a row in the panel to manually flip its filled state. Handy as a fallback when auto-detection misses something.",
		position = 3
	)
	default boolean allowManualToggle()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showRequirements",
		name = "Show required items",
		description = "List the items each unfilled STASH still needs underneath its row in the panel.",
		position = 4
	)
	default boolean showRequirements()
	{
		return true;
	}

	@ConfigItem(
		keyName = "highlightInventoryItems",
		name = "Highlight STASH items",
		description = "Outline items in your inventory/bank/equipment that still need to be deposited into a STASH, so you don't get rid of them.",
		position = 5
	)
	default boolean highlightInventoryItems()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWorldMapMarkers",
		name = "World map markers",
		description = "Show a coloured marker on the world map at every STASH unit location.",
		position = 6
	)
	default boolean showWorldMapMarkers()
	{
		return true;
	}

	@ConfigItem(
		keyName = "worldMapOnlyUnfilled",
		name = "Map: only unfilled",
		description = "Only place world map markers for STASH units that are not yet filled.",
		position = 7
	)
	default boolean worldMapOnlyUnfilled()
	{
		return false;
	}
}
