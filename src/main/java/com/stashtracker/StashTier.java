package com.stashtracker;

import java.awt.Color;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The six clue-scroll tiers that STASH units are grouped under. The colour is used
 * for the tier section headers in the side panel.
 */
@Getter
@RequiredArgsConstructor
public enum StashTier
{
	BEGINNER("Beginner", new Color(0xA9, 0xA9, 0xA9)),
	EASY("Easy", new Color(0x6F, 0xD0, 0x6F)),
	MEDIUM("Medium", new Color(0x66, 0xB2, 0xFF)),
	HARD("Hard", new Color(0xC8, 0x8B, 0xF0)),
	ELITE("Elite", new Color(0xF0, 0xD0, 0x50)),
	MASTER("Master", new Color(0xE8, 0x6A, 0x5A));

	private final String displayName;
	private final Color color;
}
