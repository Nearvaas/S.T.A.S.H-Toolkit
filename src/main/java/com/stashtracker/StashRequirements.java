package com.stashtracker;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import net.runelite.api.gameval.ItemID;

/**
 * The items deposited into each STASH unit (the emote-clue equipment), generated from
 * RuneLite's clue-scroll EmoteClue data. Item ids are the canonical (non-degraded) pieces;
 * degraded/charged variants are matched at runtime via ItemVariationMapping.
 */
public final class StashRequirements
{
	private StashRequirements()
	{
	}

	/** Description (what to equip) and the item ids stored at a STASH unit. */
	public static final class Requirement
	{
		private final String description;
		private final int[] itemIds;

		Requirement(String description, int[] itemIds)
		{
			this.description = description;
			this.itemIds = itemIds;
		}

		public String getDescription()
		{
			return description;
		}

		public int[] getItemIds()
		{
			return itemIds;
		}
	}

	private static final Map<StashUnit, Requirement> MAP = new EnumMap<>(StashUnit.class);

	static
	{
		MAP.put(StashUnit.NORTHEAST_CORNER_OF_THE_KHARAZI_JUNGLE, new Requirement("Equip any vestment stole and a heraldic rune shield.", new int[]{ItemID.TRAIL_GUTHIX_SCARF, ItemID.TRAIL_SARADOMIN_SCARF, ItemID.TRAIL_ZAMORAK_SCARF, ItemID.TRAIL_ARMADYL_SCARF, ItemID.TRAIL_BANDOS_SCARF, ItemID.TRAIL_ANCIENT_SCARF, ItemID.RUNE_HERALDIC_KITESHIELD1, ItemID.RUNE_HERALDIC_KITESHIELD2, ItemID.RUNE_HERALDIC_KITESHIELD3, ItemID.RUNE_HERALDIC_KITESHIELD4, ItemID.RUNE_HERALDIC_KITESHIELD5}));
		MAP.put(StashUnit.BARBARIAN_OUTPOST_OBSTACLE_COURSE, new Requirement("Equip a steel platebody, maple shortbow and a Wilderness cape.", new int[]{ItemID.STEEL_PLATEBODY, ItemID.MAPLE_SHORTBOW, ItemID.WILDERNESS_CAPE_1}));
		MAP.put(StashUnit.SOUTHEAST_CORNER_OF_THE_MONASTERY, new Requirement("Equip a completed prayer book.", new int[]{ItemID.SARADOMINBOOK_COMPLETE, ItemID.GUTHIXBOOK_COMPLETE, ItemID.ZAMORAKBOOK_COMPLETE, ItemID.ARMADYLBOOK_COMPLETE, ItemID.BANDOSBOOK_COMPLETE, ItemID.ZAROSBOOK_COMPLETE, ItemID.LEAGUE_3_BOOK_SARADOMIN, ItemID.LEAGUE_3_BOOK_GUTHIX, ItemID.LEAGUE_3_BOOK_ZAMORAK, ItemID.LEAGUE_3_BOOK_ARMADYL, ItemID.LEAGUE_3_BOOK_BANDOS, ItemID.LEAGUE_3_BOOK_ZAROS}));
		MAP.put(StashUnit.ENTRANCE_OF_THE_CAVE_OF_DAMIS, new Requirement("Equip a rune crossbow, climbing boots and any mitre.", new int[]{ItemID.TRAIL_GUTHIX_MITRE, ItemID.TRAIL_SARADOMIN_MITRE, ItemID.TRAIL_ZAMORAK_MITRE, ItemID.TRAIL_ANCIENT_MITRE, ItemID.TRAIL_BANDOS_MITRE, ItemID.TRAIL_ARMADYL_MITRE, ItemID.XBOWS_CROSSBOW_RUNITE, ItemID.LEAGUE_3_RUNE_XBOW, ItemID.DEATH_CLIMBINGBOOTS, ItemID.CLIMBING_BOOTS_G, ItemID.FD_RING_VISIBILITY, ItemID.RING_OF_SHADOWS, ItemID.RING_OF_SHADOWS_UNCHARGED}));
		MAP.put(StashUnit.AGILITY_PYRAMID, new Requirement("Equip a blue mystic robe top and any rune heraldic shield.", new int[]{ItemID.MYSTIC_ROBE_TOP, ItemID.RUNE_HERALDIC_KITESHIELD1, ItemID.RUNE_HERALDIC_KITESHIELD2, ItemID.RUNE_HERALDIC_KITESHIELD3, ItemID.RUNE_HERALDIC_KITESHIELD4, ItemID.RUNE_HERALDIC_KITESHIELD5}));
		MAP.put(StashUnit.WELL_OF_VOYAGE, new Requirement("Equip Iban's staff, a black mystic top and a black mystic bottom.", new int[]{ItemID.IBANSTAFF, ItemID.IBANSTAFF_UPGRADED, ItemID.MYSTIC_ROBE_TOP_DARK, ItemID.MYSTIC_ROBE_BOTTOM_DARK}));
		MAP.put(StashUnit.SOUTHEAST_CORNER_OF_THE_FISHING_PLATFORM, new Requirement("Equip barrows gloves, an amulet of glory and a dragon med helm.", new int[]{ItemID.AMULET_OF_GLORY, ItemID.AMULET_OF_GLORY_1, ItemID.AMULET_OF_GLORY_2, ItemID.AMULET_OF_GLORY_3, ItemID.AMULET_OF_GLORY_4, ItemID.AMULET_OF_GLORY_5, ItemID.AMULET_OF_GLORY_6, ItemID.HUNDRED_GAUNTLETS_LEVEL_10, ItemID.DRAGON_MED_HELM}));
		MAP.put(StashUnit.DEATH_ALTAR, new Requirement("Equip a death tiara, a legend's cape and any ring of wealth.", new int[]{ItemID.TIARA_DEATH, ItemID.CAPE_OF_LEGENDS, ItemID.RING_OF_WEALTH}));
		MAP.put(StashUnit.OUTSIDE_THE_BAR_BY_THE_FIGHT_ARENA, new Requirement("Equip a pirate bandana, a dragonstone necklace and and a magic longbow.", new int[]{ItemID.PIRATE_BANDANNA, ItemID.PIRATE_BANDANA_RED, ItemID.PIRATE_BANDANA_BLUE, ItemID.PIRATE_BANDANA_BROWN, ItemID.DRAGONSTONE_NECKLACE, ItemID.MAGIC_LONGBOW}));
		MAP.put(StashUnit.BARROWS_CHEST, new Requirement("Equip any full barrows set.", new int[]{ItemID.BARROWS_AHRIM_HEAD, ItemID.BARROWS_AHRIM_HEAD_ORNAMENT, ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_100, ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_75, ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_50, ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_25, ItemID.BARROWS_AHRIM_HEAD_ORNAMENT_BROKEN, ItemID.BARROWS_AHRIM_WEAPON, ItemID.BARROWS_AHRIM_WEAPON_ORNAMENT, ItemID.BARROWS_AHRIM_BODY, ItemID.BARROWS_AHRIM_BODY_ORNAMENT, ItemID.BARROWS_AHRIM_BODY_ORNAMENT_100, ItemID.BARROWS_AHRIM_BODY_ORNAMENT_75, ItemID.BARROWS_AHRIM_BODY_ORNAMENT_50, ItemID.BARROWS_AHRIM_BODY_ORNAMENT_25, ItemID.BARROWS_AHRIM_BODY_ORNAMENT_BROKEN, ItemID.BARROWS_AHRIM_LEGS, ItemID.BARROWS_AHRIM_LEGS_ORNAMENT, ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_100, ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_75, ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_50, ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_25, ItemID.BARROWS_AHRIM_LEGS_ORNAMENT_BROKEN, ItemID.BARROWS_DHAROK_HEAD, ItemID.BARROWS_DHAROK_WEAPON, ItemID.BARROWS_DHAROK_BODY, ItemID.BARROWS_DHAROK_LEGS, ItemID.BARROWS_GUTHAN_HEAD, ItemID.BARROWS_GUTHAN_WEAPON, ItemID.BARROWS_GUTHAN_BODY, ItemID.BARROWS_GUTHAN_LEGS, ItemID.BARROWS_KARIL_HEAD, ItemID.BARROWS_KARIL_WEAPON, ItemID.BARROWS_KARIL_BODY, ItemID.BARROWS_KARIL_LEGS, ItemID.BARROWS_TORAG_HEAD, ItemID.BARROWS_TORAG_WEAPON, ItemID.BARROWS_TORAG_BODY, ItemID.BARROWS_TORAG_LEGS, ItemID.BARROWS_VERAC_HEAD, ItemID.BARROWS_VERAC_WEAPON, ItemID.BARROWS_VERAC_BODY, ItemID.BARROWS_VERAC_LEGS, ItemID.BARROWS_AHRIM_HEAD_100, ItemID.BARROWS_AHRIM_HEAD_BROKEN, ItemID.BARROWS_AHRIM_WEAPON_100, ItemID.BARROWS_AHRIM_WEAPON_BROKEN, ItemID.BARROWS_AHRIM_WEAPON_ORNAMENT_100, ItemID.BARROWS_AHRIM_WEAPON_ORNAMENT_BROKEN, ItemID.BARROWS_AHRIM_BODY_100, ItemID.BARROWS_AHRIM_BODY_BROKEN, ItemID.BARROWS_AHRIM_LEGS_100, ItemID.BARROWS_AHRIM_LEGS_BROKEN, ItemID.BARROWS_DHAROK_HEAD_100, ItemID.BARROWS_DHAROK_HEAD_BROKEN, ItemID.BARROWS_DHAROK_WEAPON_100, ItemID.BARROWS_DHAROK_WEAPON_BROKEN, ItemID.BARROWS_DHAROK_BODY_100, ItemID.BARROWS_DHAROK_BODY_BROKEN, ItemID.BARROWS_DHAROK_LEGS_100, ItemID.BARROWS_DHAROK_LEGS_BROKEN, ItemID.BARROWS_GUTHAN_HEAD_100, ItemID.BARROWS_GUTHAN_HEAD_BROKEN, ItemID.BARROWS_GUTHAN_WEAPON_100, ItemID.BARROWS_GUTHAN_WEAPON_BROKEN, ItemID.BARROWS_GUTHAN_BODY_100, ItemID.BARROWS_GUTHAN_BODY_BROKEN, ItemID.BARROWS_GUTHAN_LEGS_100, ItemID.BARROWS_GUTHAN_LEGS_BROKEN, ItemID.BARROWS_KARIL_HEAD_100, ItemID.BARROWS_KARIL_HEAD_BROKEN, ItemID.BARROWS_KARIL_WEAPON_100, ItemID.BARROWS_KARIL_WEAPON_BROKEN, ItemID.BARROWS_KARIL_BODY_100, ItemID.BARROWS_KARIL_BODY_BROKEN, ItemID.BARROWS_KARIL_LEGS_100, ItemID.BARROWS_KARIL_LEGS_BROKEN, ItemID.BARROWS_TORAG_HEAD_100, ItemID.BARROWS_TORAG_HEAD_BROKEN, ItemID.BARROWS_TORAG_WEAPON_100, ItemID.BARROWS_TORAG_WEAPON_BROKEN, ItemID.BARROWS_TORAG_BODY_100, ItemID.BARROWS_TORAG_BODY_BROKEN, ItemID.BARROWS_TORAG_LEGS_100, ItemID.BARROWS_TORAG_LEGS_BROKEN, ItemID.BARROWS_VERAC_HEAD_100, ItemID.BARROWS_VERAC_HEAD_BROKEN, ItemID.BARROWS_VERAC_WEAPON_100, ItemID.BARROWS_VERAC_WEAPON_BROKEN, ItemID.BARROWS_VERAC_BODY_100, ItemID.BARROWS_VERAC_BODY_BROKEN, ItemID.BARROWS_VERAC_LEGS_100, ItemID.BARROWS_VERAC_LEGS_BROKEN}));
		MAP.put(StashUnit.IN_THE_MIDDLE_OF_JIGGIG, new Requirement("Equip a Rune spear, rune platelegs and any rune heraldic helm.", new int[]{ItemID.RUNE_SPEAR, ItemID.RUNE_PLATELEGS, ItemID.TRAIL_HERALDIC_HELM_1_RUNE, ItemID.TRAIL_HERALDIC_HELM_5_RUNE}));
		MAP.put(StashUnit.BY_THE_BEAR_CAGE_IN_VARROCK_PALACE_GARDENS, new Requirement("Equip a zamorak godsword.", new int[]{ItemID.ZGS, ItemID.ZGSG}));
		MAP.put(StashUnit.BEHIND_MISS_SCHISM_IN_DRAYNOR_VILLAGE, new Requirement("Equip an abyssal whip, a legend's cape and some spined chaps.", new int[]{ItemID.ABYSSAL_WHIP, ItemID.ABYSSAL_WHIP_LAVA, ItemID.ABYSSAL_WHIP_ICE, ItemID.LEAGUE_3_WHIP, ItemID.ABYSSAL_TENTACLE, ItemID.LEAGUE_3_WHIP_TENTACLE, ItemID.CAPE_OF_LEGENDS, ItemID.DAGGANOTH_RANGED_LEGS}));
		MAP.put(StashUnit.CRYSTALLINE_MAPLE_TREES, new Requirement("Equip Bryophyta's staff and a nature tiara.", new int[]{ItemID.TIARA_NATURE, ItemID.NATURE_STAFF_UNCHARGED, ItemID.NATURE_STAFF_CHARGED}));
		MAP.put(StashUnit.DIGSITE, new Requirement("Equip a green gnome hat, snakeskin boots and an iron pickaxe.", new int[]{ItemID.GNOME_HAT_GREEN, ItemID.SNAKESKIN_BOOTS, ItemID.IRON_PICKAXE}));
		MAP.put(StashUnit.SOUTH_OF_THE_SHRINE_IN_TAI_BWO_WANNAI_VILLAGE, new Requirement("Equip green dragonhide chaps, a ring of dueling and a mithril medium helmet.", new int[]{ItemID.DRAGONHIDE_CHAPS, ItemID.RING_OF_DUELING_1, ItemID.RING_OF_DUELING_2, ItemID.RING_OF_DUELING_3, ItemID.RING_OF_DUELING_4, ItemID.RING_OF_DUELING_5, ItemID.RING_OF_DUELING_6, ItemID.RING_OF_DUELING_7, ItemID.RING_OF_DUELING_8, ItemID.MITHRIL_MED_HELM}));
		MAP.put(StashUnit.WEST_OF_THE_SHAYZIEN_COMBAT_RING, new Requirement("Equip an adamant platebody, adamant full helm and adamant platelegs.", new int[]{ItemID.ADAMANT_PLATELEGS, ItemID.ADAMANT_PLATEBODY, ItemID.ADAMANT_FULL_HELM}));
		MAP.put(StashUnit.TENT_IN_LORD_IORWERTHS_ENCAMPMENT, new Requirement("Equip a charged crystal bow.", new int[]{ItemID.CRYSTAL_BOW, ItemID.BOW_OF_FAERDHINEN_INACTIVE}));
		MAP.put(StashUnit.TENT_IN_LORD_IORWERTHS_ENCAMPMENT, new Requirement("Equip a charged crystal bow.", new int[]{ItemID.CRYSTAL_BOW, ItemID.BOW_OF_FAERDHINEN_INACTIVE}));
		MAP.put(StashUnit.OUTSIDE_THE_LEGENDS_GUILD_GATES, new Requirement("Equip iron platelegs, an emerald amulet and an oak longbow.", new int[]{ItemID.IRON_PLATELEGS, ItemID.OAK_LONGBOW, ItemID.STRUNG_EMERALD_AMULET}));
		MAP.put(StashUnit.OUTSIDE_THE_LEGENDS_GUILD_DOOR, new Requirement("Equip a Cape of Legends, a dragon battleaxe and an amulet of glory.", new int[]{ItemID.CAPE_OF_LEGENDS, ItemID.DRAGON_BATTLEAXE, ItemID.BH_DRAGON_BATTLEAXE_CORRUPTED, ItemID.AMULET_OF_GLORY, ItemID.AMULET_OF_GLORY_1, ItemID.AMULET_OF_GLORY_2, ItemID.AMULET_OF_GLORY_3, ItemID.AMULET_OF_GLORY_4, ItemID.AMULET_OF_GLORY_5, ItemID.AMULET_OF_GLORY_6}));
		MAP.put(StashUnit.EMIRS_ARENA_TICKET_OFFICE, new Requirement("Equip an iron chain body, leather chaps and coif.", new int[]{ItemID.IRON_CHAINBODY, ItemID.LEATHER_CHAPS, ItemID.COIF}));
		MAP.put(StashUnit.TOP_FLOOR_OF_THE_LIGHTHOUSE, new Requirement("Equip a blue dragonhide body, blue dragonhide vambraces and no jewelry.", new int[]{ItemID.BLUE_DRAGONHIDE_BODY, ItemID.BLUE_DRAGON_VAMBRACES}));
		MAP.put(StashUnit.TEMPLE_SOUTHEAST_OF_THE_BAZAAR, new Requirement("Equip any piece of sunfire fanatic armour.", new int[]{ItemID.SUNFIRE_HELM, ItemID.SUNFIRE_BODY, ItemID.SUNFIRE_LEGS}));
		MAP.put(StashUnit.SHILO_VILLAGE_BANK, new Requirement("Equip a blue mystic hat, bone spear and rune platebody.", new int[]{ItemID.MYSTIC_HAT, ItemID.CAVE_GOBLIN_BONE_SPEAR, ItemID.RUNE_PLATEBODY}));
		MAP.put(StashUnit.NEAR_A_LADDER_IN_THE_WILDERNESS_LAVA_MAZE, new Requirement("Equip black dragonhide chaps, a spotted cape and a rolling pin.", new int[]{ItemID.BLACK_DRAGONHIDE_CHAPS, ItemID.HUNTING_LIGHT_CAPE, ItemID.HUNTING_LIGHT_CAPE_WORN, ItemID.HUNDRED_ROLLINGPIN}));
		MAP.put(StashUnit.OUTSIDE_KRIL_TSUTSAROTHS_ROOM, new Requirement("Equip a zamorak full helm and the shadow sword.", new int[]{ItemID.RUNE_FULL_HELM_ZAMORAK, ItemID.SHADOW_MAJ_SHADOW_SWORD}));
		MAP.put(StashUnit.TAVERLEY_STONE_CIRCLE, new Requirement("Equip a blue wizard hat, a bronze two-handed sword and HAM boots.", new int[]{ItemID.BLUEWIZHAT, ItemID.BRONZE_2H_SWORD, ItemID.HAM_BOOTS}));
		MAP.put(StashUnit.NORTH_OF_EVIL_DAVES_HOUSE_IN_EDGEVILLE, new Requirement("Equip a brown apron, leather boots and leather gloves.", new int[]{ItemID.BROWN_APRON, ItemID.LEATHER_BOOTS, ItemID.LEATHER_GLOVES}));
		MAP.put(StashUnit.OGRE_CAGE_IN_KING_LATHAS_TRAINING_CAMP, new Requirement("Equip a green dragonhide body and chaps and a steel square shield.", new int[]{ItemID.DRAGONHIDE_BODY, ItemID.DRAGONHIDE_CHAPS, ItemID.STEEL_SQ_SHIELD}));
		MAP.put(StashUnit.ENTRANA_CHAPEL, new Requirement("Equip a full set of black dragonhide armour.", new int[]{ItemID.BLACK_DRAGON_VAMBRACES, ItemID.BLACK_DRAGONHIDE_CHAPS, ItemID.BLACK_DRAGONHIDE_BODY}));
		MAP.put(StashUnit.NEAR_THE_ENTRANA_FERRY_IN_PORT_SARIM, new Requirement("Equip a coif, steel plateskirt and a sapphire necklace.", new int[]{ItemID.COIF, ItemID.STEEL_PLATESKIRT, ItemID.SAPPHIRE_NECKLACE}));
		MAP.put(StashUnit.OUTSIDE_THE_DIGSITE_EXAM_CENTRE, new Requirement("Equip a white apron, green gnome boots and leather gloves.", new int[]{ItemID.WHITE_APRON, ItemID.GNOME_BOOTS_GREEN, ItemID.LEATHER_GLOVES}));
		MAP.put(StashUnit.ON_THE_BRIDGE_TO_THE_MISTHALIN_WIZARDS_TOWER, new Requirement("Equip an iron medium helmet, emerald ring and a white apron.", new int[]{ItemID.IRON_MED_HELM, ItemID.EMERALD_RING, ItemID.WHITE_APRON}));
		MAP.put(StashUnit.UPSTAIRS_IN_THE_ARDOUGNE_WINDMILL, new Requirement("Equip a blue gnome robe top, HAM robe bottom and an unenchanted tiara.", new int[]{ItemID.GNOME_ROBETOP_BLUE, ItemID.HAM_ROBE, ItemID.TIARA}));
		MAP.put(StashUnit.OUTSIDE_THE_SEERS_VILLAGE_COURTHOUSE, new Requirement("Equip an adamant halberd, blue mystic robe bottom and a diamond ring.", new int[]{ItemID.ADAMANT_HALBERD, ItemID.MYSTIC_ROBE_BOTTOM, ItemID.DIAMOND_RING}));
		MAP.put(StashUnit.OUTSIDE_THE_WILDERNESS_AXE_HUT, new Requirement("Equip only some flared trousers.", new int[]{ItemID.TRAIL_FLARED_PANTS, ItemID.LOCKPICK}));
		MAP.put(StashUnit.NORTH_OF_MOUNT_KARUULM, new Requirement("Equip an adamant warhammer, a ring of life and a pair of mithril boots.", new int[]{ItemID.ADAMNT_WARHAMMER, ItemID.RING_OF_LIFE, ItemID.MITHRIL_ARMOURED_BOOTS}));
		MAP.put(StashUnit.HICKTONS_ARCHERY_EMPORIUM, new Requirement("Equip blue gnome boots, a hard leather body and an unblessed silver sickle.", new int[]{ItemID.GNOME_BOOTS_BLUE, ItemID.HARDLEATHER_BODY, ItemID.SILVER_SICKLE}));
		MAP.put(StashUnit.OUTSIDE_HARRYS_FISHING_SHOP_IN_CATHERBY, new Requirement("equip an adamant sq shield, a bone dagger and mithril platebody.", new int[]{ItemID.ADAMANT_SQ_SHIELD, ItemID.DTTD_BONE_DAGGER, ItemID.MITHRIL_PLATEBODY}));
		MAP.put(StashUnit.GNOME_STRONGHOLD_BALANCING_ROPE, new Requirement("Equip a steel kiteshield, ring of forging and green dragonhide chaps.", new int[]{ItemID.STEEL_KITESHIELD, ItemID.RING_OF_FORGING, ItemID.DRAGONHIDE_CHAPS}));
		MAP.put(StashUnit.TZHAAR_GEM_STORE, new Requirement("Equip a fire cape and TokTz-Xil-Ul.", new int[]{ItemID.TZHAAR_CAPE_FIRE, ItemID.TZHAAR_CAPE_FIRE_TROUVER, ItemID.SKILLCAPE_MAX_FIRECAPE, ItemID.SKILLCAPE_MAX_FIRECAPE_TROUVER, ItemID.INFERNAL_CAPE, ItemID.INFERNAL_CAPE_TROUVER, ItemID.SKILLCAPE_MAX_INFERNALCAPE, ItemID.SKILLCAPE_MAX_INFERNALCAPE_TROUVER, ItemID.TZHAAR_THROWINGRING}));
		MAP.put(StashUnit.OUTSIDE_DRAYNOR_VILLAGE_JAIL, new Requirement("Equip an adamant sword, a sapphire amulet and an adamant plateskirt.", new int[]{ItemID.ADAMANT_SWORD, ItemID.STRUNG_SAPPHIRE_AMULET, ItemID.ADAMANT_PLATESKIRT}));
		MAP.put(StashUnit.CROSSROADS_NORTH_OF_DRAYNOR_VILLAGE, new Requirement("Equip an iron chain body, a sapphire ring and a longbow.", new int[]{ItemID.IRON_CHAINBODY, ItemID.SAPPHIRE_RING, ItemID.LONGBOW}));
		MAP.put(StashUnit.OUTSIDE_THE_FALADOR_PARTY_ROOM, new Requirement("Equip a steel full helmet, steel platebody and an iron plateskirt.", new int[]{ItemID.STEEL_FULL_HELM, ItemID.STEEL_PLATEBODY, ItemID.IRON_PLATESKIRT}));
		MAP.put(StashUnit.NEAR_A_SHED_IN_LUMBRIDGE_SWAMP, new Requirement("Equip a bronze dagger, iron full helmet and a gold ring.", new int[]{ItemID.BRONZE_DAGGER, ItemID.IRON_FULL_HELM, ItemID.GOLD_RING}));
		MAP.put(StashUnit.LUMBRIDGE_SWAMP_CAVES, new Requirement("Equip an air staff, Bronze full helm and an amulet of power.", new int[]{ItemID.STAFF_OF_AIR, ItemID.BRONZE_FULL_HELM, ItemID.AMULET_OF_POWER}));
		MAP.put(StashUnit.OUTSIDE_THE_GREAT_PYRAMID_OF_SOPHANEM, new Requirement("Equip a ring of life, an uncharged amulet of glory and an adamant two-handed sword.", new int[]{ItemID.RING_OF_LIFE, ItemID.AMULET_OF_GLORY, ItemID.ADAMANT_2H_SWORD}));
		MAP.put(StashUnit.CENTRE_OF_CANIFIS, new Requirement("Equip a green gnome robe top, mithril plate legs and an iron two-handed sword.", new int[]{ItemID.GNOME_ROBETOP_GREEN, ItemID.MITHRIL_PLATELEGS, ItemID.IRON_2H_SWORD}));
		MAP.put(StashUnit.KING_BLACK_DRAGONS_LAIR, new Requirement("Equip a black dragonhide body, black dragonhide vambraces and a black dragon mask.", new int[]{ItemID.BLACK_DRAGONHIDE_BODY, ItemID.BLACK_DRAGON_VAMBRACES, ItemID.DRAGONMASK_BLACK}));
		MAP.put(StashUnit.SOUTH_OF_THE_GRAND_EXCHANGE, new Requirement("Equip a pink skirt, pink robe top and a body tiara.", new int[]{ItemID.PINK_SKIRT, ItemID.GNOME_ROBETOP_PINK, ItemID.TIARA_BODY}));
		MAP.put(StashUnit.OUTSIDE_MUDKNUCKLES_HUT, new Requirement("Equip a bandos godsword, a bandos cloak and a bandos platebody.", new int[]{ItemID.RUNE_PLATEBODY_BANDOS, ItemID.TRAIL_BANDOS_CLOAK, ItemID.BGS, ItemID.BGSG}));
		MAP.put(StashUnit.AL_KHARID_SCORPION_MINE, new Requirement("Equip a desert shirt, leather gloves and leather boots.", new int[]{ItemID.DESERT_SHIRT, ItemID.LEATHER_GLOVES, ItemID.LEATHER_BOOTS}));
		MAP.put(StashUnit.INSIDE_THE_DIGSITE_EXAM_CENTRE, new Requirement("Equip a mystic fire staff, a diamond bracelet and rune boots.", new int[]{ItemID.MYSTIC_FIRE_STAFF, ItemID.JEWL_DIAMOND_BRACELET, ItemID.RUNE_ARMOURED_BOOTS}));
		MAP.put(StashUnit.OUTSIDE_THE_SLAYER_TOWER_GARGOYLE_ROOM, new Requirement("Equip a seercull, a combat bracelet and helm of Neitiznot.", new int[]{ItemID.DAGANOTH_CAVE_MAGIC_SHORTBOW, ItemID.JEWL_BRACELET_OF_COMBAT_5, ItemID.JEWL_BRACELET_OF_COMBAT_6, ItemID.FRIS_KINGLY_HELM, ItemID.JEWL_BRACELET_OF_COMBAT_4, ItemID.JEWL_BRACELET_OF_COMBAT}));
		MAP.put(StashUnit.OUTSIDE_THE_FISHING_GUILD, new Requirement("Equip an emerald ring, a sapphire amulet, and a bronze chain body.", new int[]{ItemID.EMERALD_RING, ItemID.STRUNG_SAPPHIRE_AMULET, ItemID.BRONZE_CHAINBODY}));
		MAP.put(StashUnit.SHANTAY_PASS, new Requirement("Equip a pointed blue snail helmet, an air staff and a bronze square shield.", new int[]{ItemID.SNELM_POINT_BLUE, ItemID.STAFF_OF_AIR, ItemID.BRONZE_SQ_SHIELD}));
		MAP.put(StashUnit.AUBURYS_SHOP_IN_VARROCK, new Requirement("Equip an air tiara and a staff of water.", new int[]{ItemID.TIARA_AIR, ItemID.STAFF_OF_WATER}));
		MAP.put(StashUnit.CATHERBY_BEEHIVE_FIELD, new Requirement("Equip a desert shirt, green gnome robe bottoms and a steel axe.", new int[]{ItemID.DESERT_SHIRT, ItemID.GNOME_ROBEBOTTOMS_GREEN, ItemID.STEEL_AXE}));
		MAP.put(StashUnit.OUTSIDE_YANILLE_BANK, new Requirement("Equip a brown apron, adamantite medium helmet and snakeskin chaps.", new int[]{ItemID.BROWN_APRON, ItemID.ADAMANT_MED_HELM, ItemID.SNAKESKIN_CHAPS}));
		MAP.put(StashUnit.TZHAAR_WEAPONS_STORE, new Requirement("Equip a Steel longsword, Blue D'hide body and blue mystic gloves.", new int[]{ItemID.STEEL_LONGSWORD, ItemID.BLUE_DRAGONHIDE_BODY, ItemID.MYSTIC_GLOVES}));
		MAP.put(StashUnit.ENTRANCE_OF_THE_CAVERN_UNDER_THE_WHIRLPOOL, new Requirement("Equip a granite shield, splitbark body and any rune heraldic helm.", new int[]{ItemID.GRANITE_SHIELD, ItemID.SPLITBARK_BODY, ItemID.TRAIL_HERALDIC_HELM_1_RUNE, ItemID.TRAIL_HERALDIC_HELM_5_RUNE}));
		MAP.put(StashUnit.NEAR_A_RUNITE_ROCK_IN_THE_FREMENNIK_ISLES, new Requirement("Equip Rune boots, a proselyte hauberk and a dragonstone ring.", new int[]{ItemID.RUNE_ARMOURED_BOOTS, ItemID.BASIC_TK_RANK2_BODY, ItemID.DRAGONSTONE_RING}));
		MAP.put(StashUnit.NEAR_THE_PIER_IN_ZULANDRA, new Requirement("Equip a dragon 2h sword, bandos boots and an obsidian cape.", new int[]{ItemID.DRAGON_2H_SWORD, ItemID.BANDOS_BOOTS, ItemID.GUARDIAN_BOOTS, ItemID.ECHO_BOOTS, ItemID.TZHAAR_CAPE_OBSIDIAN}));
		MAP.put(StashUnit.TWILIGHT_TEMPLE_MINE, new Requirement("Equip a maple longbow, a ruby amulet and some steel platelegs.", new int[]{ItemID.MAPLE_LONGBOW, ItemID.STRUNG_RUBY_AMULET, ItemID.STEEL_PLATELEGS}));
		MAP.put(StashUnit.FOUNTAIN_OF_HEROES, new Requirement("Equip splitbark legs, dragon boots and a Rune longsword.", new int[]{ItemID.SPLITBARK_LEGS, ItemID.DRAGON_BOOTS, ItemID.DRAGON_BOOTS_GOLD, ItemID.PRIMORDIAL_BOOTS, ItemID.RUNE_LONGSWORD}));
		MAP.put(StashUnit.MOUNTAIN_CAMP_GOAT_ENCLOSURE, new Requirement("Equip a rune full helmet, blue dragonhide chaps and a fire battlestaff.", new int[]{ItemID.RUNE_FULL_HELM, ItemID.BLUE_DRAGONHIDE_CHAPS, ItemID.FIRE_BATTLESTAFF}));
		MAP.put(StashUnit.ROAD_JUNCTION_SOUTH_OF_SINCLAIR_MANSION, new Requirement("Equip a cowl, a blue wizard robe top and an iron scimitar.", new int[]{ItemID.LEATHER_COWL, ItemID.WIZARDS_ROBE, ItemID.IRON_SCIMITAR}));
		MAP.put(StashUnit.NEAR_THE_GEM_STALL_IN_ARDOUGNE_MARKET, new Requirement("Equip a Castlewars bracelet, a dragonstone amulet and a ring of forging.", new int[]{ItemID.STRUNG_DRAGONSTONE_AMULET, ItemID.RING_OF_FORGING, ItemID.JEWL_CASTLEWARS_BRACELET3, ItemID.JEWL_CASTLEWARS_BRACELET}));
		MAP.put(StashUnit.WHERE_ORTUS_MEETS_PROUDSPIRE, new Requirement("Equip a blue wizard hat, a blue wizard robe and wear nothing on your legs.", new int[]{ItemID.BLUEWIZHAT, ItemID.WIZARDS_ROBE}));
		MAP.put(StashUnit.LIMESTONE_MINE, new Requirement("Equip bronze platelegs, a steel pickaxe and a steel medium helmet.", new int[]{ItemID.BRONZE_PLATELEGS, ItemID.STEEL_PICKAXE, ItemID.STEEL_MED_HELM}));
		MAP.put(StashUnit.MAUSOLEUM_OFF_THE_MORYTANIA_COAST, new Requirement("Equip a mithril plate skirt, a maple longbow and no boots.", new int[]{ItemID.MITHRIL_PLATESKIRT, ItemID.MAPLE_LONGBOW}));
		MAP.put(StashUnit.VOLCANO_IN_THE_NORTHEASTERN_WILDERNESS, new Requirement("Equip any headband and crozier.", new int[]{ItemID.TRAIL_ANCIENT_STAFF, ItemID.TRAIL_ARMADYL_STAFF, ItemID.TRAIL_BANDOS_STAFF, ItemID.HEADBAND_RED, ItemID.HEADBAND_BROWN, ItemID.HEADBAND_WHITE, ItemID.HEADBAND_GREEN, ItemID.TRAIL_SARADOMIN_STAFF, ItemID.TRAIL_ZAMORAK_STAFF}));
		MAP.put(StashUnit.GNOME_GLIDER_ON_WHITE_WOLF_MOUNTAIN, new Requirement("Equip mithril platelegs, a ring of life and a rune axe.", new int[]{ItemID.MITHRIL_PLATELEGS, ItemID.RING_OF_LIFE, ItemID.RUNE_AXE}));
		MAP.put(StashUnit.SOUTHEAST_CORNER_OF_LAVA_DRAGON_ISLE, new Requirement("Equip a dragon med helm, a TokTz-Ket-Xil, a brine sabre, rune platebody and an uncharged amulet of glory.", new int[]{ItemID.DRAGON_MED_HELM, ItemID.TZHAAR_SPIKESHIELD, ItemID.OLAF2_BRINE_SABRE, ItemID.RUNE_PLATEBODY, ItemID.AMULET_OF_GLORY}));
		MAP.put(StashUnit.HALFWAY_DOWN_TROLLWEISS_MOUNTAIN, new Requirement("Equip Blue D'hide vambraces, a dragon spear and a rune plateskirt.", new int[]{ItemID.BLUE_DRAGON_VAMBRACES, ItemID.DRAGON_SPEAR, ItemID.RUNE_PLATESKIRT, ItemID.TROLLROMANCE_TOBOGGON_WAXED}));
		MAP.put(StashUnit.OUTSIDE_TWILIGHT_TEMPLE, new Requirement("Equip a rune longsword, rune platebody and a rune plateskirt.", new int[]{ItemID.RUNE_LONGSWORD, ItemID.RUNE_PLATEBODY, ItemID.RUNE_PLATESKIRT}));
		MAP.put(StashUnit.WARRIORS_GUILD_BANK_MASTER, new Requirement("Equip a dragon battleaxe, a slayer helm of any kind and a dragon defender or avernic defender.", new int[]{ItemID.DRAGON_BATTLEAXE, ItemID.BH_DRAGON_BATTLEAXE_CORRUPTED, ItemID.DRAGON_PARRYINGDAGGER, ItemID.DRAGON_PARRYINGDAGGER_T, ItemID.DRAGON_PARRYINGDAGGER_TROUVER, ItemID.INFERNAL_DEFENDER, ItemID.INFERNAL_DEFENDER_TROUVER, ItemID.INFERNAL_DEFENDER_GHOMMAL_5, ItemID.INFERNAL_DEFENDER_GHOMMAL_5_TROUVER, ItemID.INFERNAL_DEFENDER_GHOMMAL_6, ItemID.INFERNAL_DEFENDER_GHOMMAL_6_TROUVER, ItemID.SLAYER_HELM}));
		MAP.put(StashUnit.NEAR_THE_PARROTS_IN_ARDOUGNE_ZOO, new Requirement("Equip a studded leather body, bronze platelegs and a normal staff with no orb.", new int[]{ItemID.STUDDED_BODY, ItemID.BRONZE_PLATELEGS, ItemID.PLAINSTAFF}));
		MAP.put(StashUnit.OUTSIDE_KEEP_LE_FAYE, new Requirement("Equip a coif, an iron platebody and leather gloves.", new int[]{ItemID.COIF, ItemID.IRON_PLATEBODY, ItemID.LEATHER_GLOVES}));
		MAP.put(StashUnit.FISHING_GUILD_BANK, new Requirement("Equip an elemental shield, blue dragonhide chaps and a rune warhammer.", new int[]{ItemID.ELEMENTAL_SHIELD, ItemID.BLUE_DRAGONHIDE_CHAPS, ItemID.RUNE_WARHAMMER}));
		MAP.put(StashUnit.WEST_SIDE_OF_THE_KARAMJA_BANANA_PLANTATION, new Requirement("Equip a diamond ring, amulet of power, and nothing on your chest and legs.", new int[]{ItemID.DIAMOND_RING, ItemID.AMULET_OF_POWER}));
		MAP.put(StashUnit.WARRIORS_GUILD_BANK_ELITE, new Requirement("Equip only a black salamander.", new int[]{ItemID.BLACK_SALAMANDER}));
		MAP.put(StashUnit.HOSIDIUS_MESS, new Requirement("Equip a rune halberd rune platebody and an amulet of strength.", new int[]{ItemID.RUNE_HALBERD, ItemID.RUNE_PLATEBODY, ItemID.AMULET_OF_STRENGTH}));
		MAP.put(StashUnit.CAM_TORUM_ENTRANCE, new Requirement("Equip a full set of blue moon equipment.", new int[]{ItemID.FROST_MOON_HELM, ItemID.FROST_MOON_HELM_DEGRADED, ItemID.FROST_MOON_CHESTPLATE, ItemID.FROST_MOON_CHESTPLATE_DEGRADED, ItemID.FROST_MOON_TASSETS, ItemID.FROST_MOON_TASSETS_DEGRADED, ItemID.FROSTMOON_SPEAR}));
		MAP.put(StashUnit.RIMMINGTON_MINE, new Requirement("Equip a gold necklace, a gold ring and a bronze spear.", new int[]{ItemID.GOLD_NECKLACE, ItemID.GOLD_RING, ItemID.BRONZE_SPEAR}));
		MAP.put(StashUnit.OUTSIDE_CATHERBY_BANK, new Requirement("Equip a maple longbow, green d'hide chaps and an iron med helm.", new int[]{ItemID.MAPLE_LONGBOW, ItemID.DRAGONHIDE_CHAPS, ItemID.IRON_MED_HELM}));
		MAP.put(StashUnit.EAST_OF_THE_LEVEL_19_WILDERNESS_OBELISK, new Requirement("Equip rune platelegs, an iron platebody and blue dragonhide vambraces.", new int[]{ItemID.RUNE_PLATELEGS, ItemID.IRON_PLATEBODY, ItemID.BLUE_DRAGON_VAMBRACES}));
		MAP.put(StashUnit.SHAYZIEN_WAR_TENT, new Requirement("Equip a blue mystic robe bottom, a rune kiteshield and any bob shirt.", new int[]{ItemID.MYSTIC_ROBE_BOTTOM, ItemID.RUNE_KITESHIELD, ItemID.TRAIL_BOB_SHIRT_RED, ItemID.TRAIL_BOB_SHIRT_PURPLE}));
		MAP.put(StashUnit.CENTRE_OF_THE_CATACOMBS_OF_KOUREND, new Requirement("Equip arclight or emberlight along with the amulet of the damned.", new int[]{ItemID.ARCLIGHT, ItemID.ARCLIGHT_INACTIVE, ItemID.EMBERLIGHT, ItemID.DAMNED_AMULET_DEGRADED, ItemID.DAMNED_AMULET}));
		MAP.put(StashUnit.ROAD_JUNCTION_NORTH_OF_RIMMINGTON, new Requirement("Equip a green gnome hat, cream gnome top and leather chaps.", new int[]{ItemID.GNOME_HAT_GREEN, ItemID.GNOME_ROBETOP_CREAM, ItemID.LEATHER_CHAPS}));
		MAP.put(StashUnit.DRAYNOR_MANOR_BY_THE_FOUNTAIN, new Requirement("Equip an iron platebody, studded leather chaps and a bronze full helmet.", new int[]{ItemID.IRON_PLATEBODY, ItemID.STUDDED_CHAPS, ItemID.BRONZE_FULL_HELM}));
		MAP.put(StashUnit.SOUL_ALTAR, new Requirement("Equip a dragon pickaxe, helm of neitiznot and a pair of rune boots.", new int[]{ItemID.DRAGON_PICKAXE, ItemID.DRAGON_PICKAXE_PRETTY, ItemID.INFERNAL_PICKAXE, ItemID.INFERNAL_PICKAXE_EMPTY, ItemID.ZALCANO_PICKAXE, ItemID.TRAILBLAZER_PICKAXE_NO_INFERNAL, ItemID.TRAILBLAZER_RELOADED_PICKAXE_NO_INFERNAL, ItemID.CRYSTAL_PICKAXE, ItemID.CRYSTAL_PICKAXE_INACTIVE, ItemID.TRAILBLAZER_PICKAXE, ItemID.TRAILBLAZER_RELOADED_PICKAXE, ItemID.TRAILBLAZER_PICKAXE_EMPTY, ItemID.TRAILBLAZER_RELOADED_PICKAXE_EMPTY, ItemID.FRIS_KINGLY_HELM, ItemID.RUNE_ARMOURED_BOOTS}));
		MAP.put(StashUnit.OUTSIDE_VARROCK_PALACE_COURTYARD, new Requirement("Equip a black axe, a coif and a ruby ring.", new int[]{ItemID.BLACK_AXE, ItemID.COIF, ItemID.RUBY_RING}));
		MAP.put(StashUnit.CHAPEL_IN_WEST_ARDOUGNE, new Requirement("Equip a dragon spear and red dragonhide chaps.", new int[]{ItemID.DRAGON_SPEAR, ItemID.RED_DRAGONHIDE_CHAPS}));
		MAP.put(StashUnit.EAST_OF_THE_BARBARIAN_VILLAGE_BRIDGE, new Requirement("Equip purple gloves, a steel kiteshield and a mithril full helmet.", new int[]{ItemID.WOLFENGLOVES_PURPLE, ItemID.STEEL_KITESHIELD, ItemID.MITHRIL_FULL_HELM}));
		MAP.put(StashUnit.NORTHWESTERN_CORNER_OF_THE_ENCHANTED_VALLEY, new Requirement("Equip a dragon axe.", new int[]{ItemID.DRAGON_AXE, ItemID.TRAILBLAZER_AXE_NO_INFERNAL, ItemID.DRAGON_AXE_2H, ItemID.CRYSTAL_AXE, ItemID.CRYSTAL_AXE_INACTIVE, ItemID.CRYSTAL_AXE_2H, ItemID.CRYSTAL_AXE_2H_INACTIVE, ItemID.INFERNAL_AXE, ItemID.INFERNAL_AXE_EMPTY, ItemID.TRAILBLAZER_AXE, ItemID.TRAILBLAZER_AXE_EMPTY, ItemID.TRAILBLAZER_RELOADED_AXE, ItemID.TRAILBLAZER_RELOADED_AXE_EMPTY}));
		MAP.put(StashUnit.WHEAT_FIELD_NEAR_THE_LUMBRIDGE_WINDMILL, new Requirement("Equip a blue gnome robetop, a turquoise gnome robe bottom and an oak shortbow.", new int[]{ItemID.GNOME_ROBETOP_BLUE, ItemID.GNOME_ROBEBOTTOMS_TURQUOISE, ItemID.OAK_SHORTBOW}));
		MAP.put(StashUnit.OBSERVATORY, new Requirement("Equip a mithril chain body, green dragonhide chaps and a ruby amulet.", new int[]{ItemID.MITHRIL_CHAINBODY, ItemID.DRAGONHIDE_CHAPS, ItemID.STRUNG_RUBY_AMULET}));
		MAP.put(StashUnit.WESTERN_SALVAGER_OVERLOOK, new Requirement("Equip a Hueycoatl hide coif and some Hueycoatl hide vambraces.", new int[]{ItemID.HUEY_COIF, ItemID.HUEY_VAMBRACES}));
		MAP.put(StashUnit.NEAR_THE_SAWMILL_OPERATORS_BOOTH, new Requirement("Equip a hard leather body, leather chaps and a bronze axe.", new int[]{ItemID.HARDLEATHER_BODY, ItemID.LEATHER_CHAPS, ItemID.BRONZE_AXE}));
		MAP.put(StashUnit.NEAR_HERQUINS_SHOP_IN_FALADOR, new Requirement("Equip a Mithril pickaxe, Black platebody and an Iron Kiteshield.", new int[]{ItemID.MITHRIL_PICKAXE, ItemID.BLACK_PLATEBODY, ItemID.IRON_KITESHIELD}));
		MAP.put(StashUnit.MUDSKIPPER_POINT, new Requirement("Equip a black cape, leather chaps and a steel mace.", new int[]{ItemID.BLACK_CAPE, ItemID.LEATHER_CHAPS, ItemID.STEEL_MACE}));
		MAP.put(StashUnit.NORTHERN_WALL_OF_CASTLE_DRAKAN, new Requirement("Wave on the northern wall of Castle Drakan. Beware of double agents! Wear a dragon sq shield, splitbark body and any boater.", new int[]{ItemID.DRAGON_SQ_SHIELD, ItemID.DRAGON_SQ_SHIELD_GOLD, ItemID.SPLITBARK_BODY, ItemID.STRAWBOATER_RED, ItemID.STRAWBOATER_ORANGE, ItemID.STRAWBOATER_GREEN, ItemID.STRAWBOATER_BLUE, ItemID.STRAWBOATER_BLACK, ItemID.STRAWBOATER_PINK, ItemID.STRAWBOATER_PURPLE, ItemID.STRAWBOATER_WHITE}));
		MAP.put(StashUnit.SEVENTH_CHAMBER_OF_JALSAVRAH, new Requirement("Equip a pharaoh sceptre and a full set of menaphite robes.", new int[]{ItemID.ROGUETRADER_MENAPHITE_HAT, ItemID.ROGUETRADER_MENAPHITE_TOP, ItemID.ROGUETRADER_MENAPHITE_HAT_RED, ItemID.ROGUETRADER_MENAPHITE_TOP_RED, ItemID.ROGUETRADER_MENAPHITE_LEGS, ItemID.ROGUETRADER_MENAPHITE_LEGS2, ItemID.ROGUETRADER_MENAPHITE_LEGS_RED, ItemID.ROGUETRADER_MENAPHITE_LEGS_RED2, ItemID.NTK_JEWELLED_SCEPTRE_3}));
		MAP.put(StashUnit.VARROCK_PALACE_LIBRARY, new Requirement("Equip a green gnome robe top, HAM robe bottom and an iron warhammer.", new int[]{ItemID.GNOME_ROBETOP_GREEN, ItemID.HAM_ROBE, ItemID.IRON_WARHAMMER}));
		MAP.put(StashUnit.DRAYNOR_VILLAGE_MARKET, new Requirement("Equip studded leather chaps, an iron kiteshield and a steel longsword.", new int[]{ItemID.STUDDED_CHAPS, ItemID.IRON_KITESHIELD, ItemID.STEEL_LONGSWORD}));
		MAP.put(StashUnit.CASTLE_WARS_BANK, new Requirement("Equip a ruby amulet, a mithril scimitar and a Wilderness cape.", new int[]{ItemID.STRUNG_RUBY_AMULET, ItemID.MITHRIL_SCIMITAR, ItemID.WILDERNESS_CAPE_1}));
		MAP.put(StashUnit.NOTERAZZOS_SHOP_IN_THE_WILDERNESS, new Requirement("Equip an adamant square shield, blue dragon vambraces and a rune pickaxe.", new int[]{ItemID.ADAMANT_SQ_SHIELD, ItemID.BLUE_DRAGON_VAMBRACES, ItemID.RUNE_PICKAXE}));
		MAP.put(StashUnit.ON_TOP_OF_TROLLHEIM_MOUNTAIN, new Requirement("Equip a lava battlestaff, black dragonhide vambraces and a mind shield.", new int[]{ItemID.LAVA_BATTLESTAFF, ItemID.LAVA_BATTLESTAFF_PRETTY, ItemID.BLACK_DRAGON_VAMBRACES, ItemID.ELEMENTAL_MIND_SHIELD}));
		MAP.put(StashUnit.ENTRANCE_OF_THE_ARCEUUS_LIBRARY, new Requirement("Equip blue dragonhide vambraces, adamant boots and an adamant dagger.", new int[]{ItemID.BLUE_DRAGON_VAMBRACES, ItemID.ADAMANT_ARMOURED_BOOTS, ItemID.ADAMANT_DAGGER}));
		MAP.put(StashUnit.FORTIS_GRAND_MUSEUM, new Requirement("Equip an emerald necklace, blue skirt, and turqoise gnome robe top.", new int[]{ItemID.EMERALD_NECKLACE, ItemID.BLUE_SKIRT, ItemID.GNOME_ROBETOP_TURQUOISE}));
		MAP.put(StashUnit.TOP_FLOOR_OF_THE_YANILLE_WATCHTOWER, new Requirement("Equip a dragon plateskirt, climbing boots and a dragon chainbody.", new int[]{ItemID.DRAGON_PLATESKIRT, ItemID.DRAGON_PLATESKIRT_GOLD, ItemID.DEATH_CLIMBINGBOOTS, ItemID.CLIMBING_BOOTS_G, ItemID.DRAGON_CHAINBODY, ItemID.DRAGON_CHAINBODY_GOLD, ItemID.BULLROARER}));
		MAP.put(StashUnit.GYPSY_TENT_ENTRANCE, new Requirement("Equip a gold ring and a gold necklace.", new int[]{ItemID.GOLD_RING, ItemID.GOLD_NECKLACE}));
		MAP.put(StashUnit.FINE_CLOTHES_ENTRANCE, new Requirement("Equip a chef hat and a red cape.", new int[]{ItemID.CHEFS_HAT, ItemID.RED_CAPE}));
		MAP.put(StashUnit.BOB_AXES_ENTRANCE, new Requirement("Equip a bronze axe and leather boots.", new int[]{ItemID.BRONZE_AXE, ItemID.LEATHER_BOOTS}));
		MAP.put(StashUnit.CHARCOAL_BURNERS, new Requirement("Equip a Farmer's strawhat, Shayzien platebody (5) and Pyromancer robes.", new int[]{ItemID.TITHE_REWARD_HAT_MALE, ItemID.TITHE_REWARD_HAT_FEMALE, ItemID.SHAYZIEN_BODY_5, ItemID.PYROMANCER_BOTTOM}));
		MAP.put(StashUnit.PANDEMONIUM_BAR, new Requirement("Equip a right eye patch and a bronze scimitar.", new int[]{ItemID.EYE_PATCH, ItemID.BRONZE_SCIMITAR}));
		MAP.put(StashUnit.WINTUMBER_ISLAND, new Requirement("Equip a crab helmet and a crab claw.", new int[]{ItemID.HUNDRED_PIRATE_CRAB_SHELL_HELM, ItemID.HUNDRED_PIRATE_CRAB_SHELL_GAUNTLET}));
		MAP.put(StashUnit.BRITTLE_ISLE, new Requirement("Equip a Medallion of the Deep and a rosewood blowpipe.", new int[]{ItemID.MEDALLION_OF_THE_DEEP, ItemID.ROSEWOOD_BLOWPIPE}));
	}

	public static Requirement get(StashUnit unit)
	{
		return MAP.get(unit);
	}

	public static Map<StashUnit, Requirement> all()
	{
		return Collections.unmodifiableMap(MAP);
	}
}
