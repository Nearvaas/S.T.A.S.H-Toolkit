package com.stashtracker;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ObjectID;

/**
 * Every STASH unit in Old School RuneScape.
 *
 * <p>The object id is the <i>built</i> STASH object (the {@code HH_*} gameval constants). A built
 * STASH only renders in the scene for the player who built it, so spotting one of these object ids
 * is a reliable signal that the local player has built that unit.</p>
 *
 * <p>The location data and object ids mirror RuneLite's own clue-scroll {@code STASHUnit} enum so
 * they stay accurate against the live game. A handful of units have two possible world points
 * (alternate / instanced tiles).</p>
 */
@Getter
public enum StashUnit
{
	// ---- Beginner ----
	GYPSY_TENT_ENTRANCE(StashTier.BEGINNER, ObjectID.HH_BEGINNER001, "Gypsy tent entrance, Varrock", new WorldPoint(3206, 3422, 0)),
	FINE_CLOTHES_ENTRANCE(StashTier.BEGINNER, ObjectID.HH_BEGINNER002, "Thessaly's / Fine Clothes entrance, Varrock", new WorldPoint(3209, 3416, 0)),
	BOB_AXES_ENTRANCE(StashTier.BEGINNER, ObjectID.HH_BEGINNER003, "Bob's Brilliant Axes entrance, Lumbridge", new WorldPoint(3233, 3200, 0)),

	// ---- Easy ----
	NEAR_A_SHED_IN_LUMBRIDGE_SWAMP(StashTier.EASY, ObjectID.HH_EASY001, "Near a shed in Lumbridge Swamp", new WorldPoint(3201, 3171, 0)),
	ON_THE_BRIDGE_TO_THE_MISTHALIN_WIZARDS_TOWER(StashTier.EASY, ObjectID.HH_EASY002, "On the bridge to the Misthalin Wizards' Tower", new WorldPoint(3115, 3194, 0)),
	DRAYNOR_VILLAGE_MARKET(StashTier.EASY, ObjectID.HH_EASY003, "Draynor Village market", new WorldPoint(3083, 3254, 0)),
	LIMESTONE_MINE(StashTier.EASY, ObjectID.HH_EASY004, "Limestone mine north-east of Varrock", new WorldPoint(3373, 3498, 0)),
	OUTSIDE_THE_LEGENDS_GUILD_GATES(StashTier.EASY, ObjectID.HH_EASY005, "Outside the Legends' Guild gates", new WorldPoint(2735, 3350, 0)),
	MUDSKIPPER_POINT(StashTier.EASY, ObjectID.HH_EASY006, "Mudskipper Point", new WorldPoint(2988, 3111, 0)),
	NEAR_THE_ENTRANA_FERRY_IN_PORT_SARIM(StashTier.EASY, ObjectID.HH_EASY007, "Near the Entrana ferry in Port Sarim", new WorldPoint(3050, 3237, 0)),
	AL_KHARID_SCORPION_MINE(StashTier.EASY, ObjectID.HH_EASY008, "Al Kharid scorpion mine", new WorldPoint(3303, 3289, 0)),
	DRAYNOR_MANOR_BY_THE_FOUNTAIN(StashTier.EASY, ObjectID.HH_EASY009, "Draynor Manor, by the fountain", new WorldPoint(3089, 3331, 0)),
	WHEAT_FIELD_NEAR_THE_LUMBRIDGE_WINDMILL(StashTier.EASY, ObjectID.HH_EASY010, "Wheat field near the Lumbridge windmill", new WorldPoint(3163, 3297, 0)),
	CROSSROADS_NORTH_OF_DRAYNOR_VILLAGE(StashTier.EASY, ObjectID.HH_EASY011, "Crossroads north of Draynor Village", new WorldPoint(3111, 3289, 0)),
	RIMMINGTON_MINE(StashTier.EASY, ObjectID.HH_EASY012, "Rimmington mine", new WorldPoint(2976, 3239, 0)),
	VARROCK_PALACE_LIBRARY(StashTier.EASY, ObjectID.HH_EASY013, "Varrock Palace library", new WorldPoint(3214, 3490, 0)),
	UPSTAIRS_IN_THE_ARDOUGNE_WINDMILL(StashTier.EASY, ObjectID.HH_EASY014, "Upstairs in the Ardougne windmill", new WorldPoint(2635, 3386, 2)),
	OUTSIDE_THE_FALADOR_PARTY_ROOM(StashTier.EASY, ObjectID.HH_EASY015, "Outside the Falador Party Room", new WorldPoint(3043, 3371, 0)),
	TAVERLEY_STONE_CIRCLE(StashTier.EASY, ObjectID.HH_EASY016, "Taverley stone circle", new WorldPoint(2924, 3477, 0)),
	CATHERBY_BEEHIVE_FIELD(StashTier.EASY, ObjectID.HH_EASY018, "Catherby beehive field", new WorldPoint(2764, 3438, 0)),
	NEAR_THE_PARROTS_IN_ARDOUGNE_ZOO(StashTier.EASY, ObjectID.HH_EASY019, "Near the parrots in Ardougne Zoo", new WorldPoint(2608, 3284, 0)),
	ROAD_JUNCTION_NORTH_OF_RIMMINGTON(StashTier.EASY, ObjectID.HH_EASY020, "Road junction north of Rimmington", new WorldPoint(2981, 3278, 0)),
	OUTSIDE_THE_FISHING_GUILD(StashTier.EASY, ObjectID.HH_EASY021, "Outside the Fishing Guild", new WorldPoint(2608, 3393, 0)),
	OUTSIDE_KEEP_LE_FAYE(StashTier.EASY, ObjectID.HH_EASY022, "Outside Keep Le Faye", new WorldPoint(2756, 3399, 0)),
	ROAD_JUNCTION_SOUTH_OF_SINCLAIR_MANSION(StashTier.EASY, ObjectID.HH_EASY024, "Road junction south of Sinclair Mansion", new WorldPoint(2735, 3534, 0)),
	OUTSIDE_THE_DIGSITE_EXAM_CENTRE(StashTier.EASY, ObjectID.HH_EASY025, "Outside the Digsite Exam Centre", new WorldPoint(3353, 3343, 0)),
	NEAR_THE_SAWMILL_OPERATORS_BOOTH(StashTier.EASY, ObjectID.HH_EASY026, "Near the sawmill operator's booth", new WorldPoint(3298, 3490, 0)),
	EMIRS_ARENA_TICKET_OFFICE(StashTier.EASY, ObjectID.HH_EASY027, "Emir's Arena ticket office", new WorldPoint(3316, 3242, 0)),
	OUTSIDE_VARROCK_PALACE_COURTYARD(StashTier.EASY, ObjectID.HH_EASY_EXP1, "Outside Varrock Palace courtyard", new WorldPoint(3211, 3456, 0)),
	NEAR_HERQUINS_SHOP_IN_FALADOR(StashTier.EASY, ObjectID.HH_EASY_EXP2, "Near Herquin's shop in Falador", new WorldPoint(2941, 3339, 0)),
	SOUTH_OF_THE_GRAND_EXCHANGE(StashTier.EASY, ObjectID.HH_EASY_EXP3, "South of the Grand Exchange", new WorldPoint(3159, 3464, 0)),
	AUBURYS_SHOP_IN_VARROCK(StashTier.EASY, ObjectID.HH_EASY_EXP4, "Aubury's shop in Varrock", new WorldPoint(3252, 3404, 0)),
	FORTIS_GRAND_MUSEUM(StashTier.EASY, ObjectID.HH_EASY_VM01, "Fortis Grand Museum", new WorldPoint(1723, 3153, 0)),
	PANDEMONIUM_BAR(StashTier.EASY, ObjectID.HH_EASY_SAIL, "Pandemonium Bar", new WorldPoint(3045, 2963, 0)),

	// ---- Medium ----
	CENTRE_OF_CANIFIS(StashTier.MEDIUM, ObjectID.HH_MEDIUM001, "Centre of Canifis", new WorldPoint(3491, 3489, 0)),
	MAUSOLEUM_OFF_THE_MORYTANIA_COAST(StashTier.MEDIUM, ObjectID.HH_MEDIUM002, "Mausoleum off the Morytania coast", new WorldPoint(3500, 3575, 0)),
	EAST_OF_THE_BARBARIAN_VILLAGE_BRIDGE(StashTier.MEDIUM, ObjectID.HH_MEDIUM003, "East of the Barbarian Village bridge", new WorldPoint(3110, 3422, 0)),
	SOUTH_OF_THE_SHRINE_IN_TAI_BWO_WANNAI_VILLAGE(StashTier.MEDIUM, ObjectID.HH_MEDIUM004, "South of the shrine in Tai Bwo Wannai Village", new WorldPoint(2802, 3081, 0)),
	CASTLE_WARS_BANK(StashTier.MEDIUM, ObjectID.HH_MEDIUM005, "Castle Wars bank", new WorldPoint(2444, 3093, 0)),
	BARBARIAN_OUTPOST_OBSTACLE_COURSE(StashTier.MEDIUM, ObjectID.HH_MEDIUM006, "Barbarian Outpost obstacle course", new WorldPoint(2541, 3550, 0)),
	GNOME_STRONGHOLD_BALANCING_ROPE(StashTier.MEDIUM, ObjectID.HH_MEDIUM007, "Gnome Stronghold balancing rope", new WorldPoint(2473, 3418, 2)),
	OUTSIDE_YANILLE_BANK(StashTier.MEDIUM, ObjectID.HH_MEDIUM008, "Outside Yanille bank", new WorldPoint(2603, 3091, 0)),
	OBSERVATORY(StashTier.MEDIUM, ObjectID.HH_MEDIUM009, "Observatory", new WorldPoint(2439, 3166, 0)),
	OGRE_CAGE_IN_KING_LATHAS_TRAINING_CAMP(StashTier.MEDIUM, ObjectID.HH_MEDIUM010, "Ogre cage in King Lathas' Training Camp", new WorldPoint(2533, 3377, 0)),
	DIGSITE(StashTier.MEDIUM, ObjectID.HH_MEDIUM011, "Digsite", new WorldPoint(3370, 3420, 0)),
	HICKTONS_ARCHERY_EMPORIUM(StashTier.MEDIUM, ObjectID.HH_MEDIUM012, "Hickton's Archery Emporium", new WorldPoint(2825, 3441, 0)),
	SHANTAY_PASS(StashTier.MEDIUM, ObjectID.HH_MEDIUM013, "Shantay Pass", new WorldPoint(3308, 3125, 0)),
	LUMBRIDGE_SWAMP_CAVES(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP1, "Lumbridge Swamp Caves", new WorldPoint(3222, 9584, 0), new WorldPoint(3167, 9570, 0)),
	OUTSIDE_CATHERBY_BANK(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP2, "Outside Catherby bank", new WorldPoint(2807, 3437, 0)),
	OUTSIDE_THE_SEERS_VILLAGE_COURTHOUSE(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP3, "Outside the Seers' Village courthouse", new WorldPoint(2731, 3475, 0)),
	OUTSIDE_HARRYS_FISHING_SHOP_IN_CATHERBY(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP4, "Outside Harry's Fishing Shop in Catherby", new WorldPoint(2837, 3436, 0)),
	TZHAAR_WEAPONS_STORE(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP5, "TzHaar weapons store", new WorldPoint(2479, 5146, 0)),
	NORTH_OF_EVIL_DAVES_HOUSE_IN_EDGEVILLE(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP6, "North of Evil Dave's house in Edgeville", new WorldPoint(3077, 3503, 0)),
	WEST_OF_THE_SHAYZIEN_COMBAT_RING(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP7, "West of the Shayzien combat ring", new WorldPoint(1541, 3631, 0)),
	ENTRANCE_OF_THE_ARCEUUS_LIBRARY(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP8, "Entrance of the Arceuus library", new WorldPoint(1642, 3809, 0)),
	OUTSIDE_DRAYNOR_VILLAGE_JAIL(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP9, "Outside Draynor Village jail", new WorldPoint(3130, 3250, 0)),
	NORTH_OF_MOUNT_KARUULM(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP10, "North of Mount Karuulm", new WorldPoint(1308, 3840, 0)),
	TWILIGHT_TEMPLE_MINE(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP11, "Twilight Temple mine", new WorldPoint(1668, 3287, 0)),
	WHERE_ORTUS_MEETS_PROUDSPIRE(StashTier.MEDIUM, ObjectID.HH_MEDIUM_EXP12, "Where Ortus meets Proudspire", new WorldPoint(1629, 3239, 0)),

	// ---- Hard ----
	EAST_OF_THE_LEVEL_19_WILDERNESS_OBELISK(StashTier.HARD, ObjectID.HH_HARD001, "East of the level 19 Wilderness obelisk", new WorldPoint(3243, 3662, 0)),
	FISHING_GUILD_BANK(StashTier.HARD, ObjectID.HH_HARD002, "Fishing Guild bank", new WorldPoint(2593, 3409, 0)),
	TOP_FLOOR_OF_THE_LIGHTHOUSE(StashTier.HARD, ObjectID.HH_HARD003, "Top floor of the Lighthouse", new WorldPoint(2512, 3640, 2)),
	OUTSIDE_THE_GREAT_PYRAMID_OF_SOPHANEM(StashTier.HARD, ObjectID.HH_HARD005, "Outside the great pyramid of Sophanem", new WorldPoint(3291, 2780, 0)),
	NOTERAZZOS_SHOP_IN_THE_WILDERNESS(StashTier.HARD, ObjectID.HH_HARD006, "Noterazzo's shop in the Wilderness", new WorldPoint(3027, 3699, 0)),
	WEST_SIDE_OF_THE_KARAMJA_BANANA_PLANTATION(StashTier.HARD, ObjectID.HH_HARD007, "West side of the Karamja banana plantation", new WorldPoint(2909, 3169, 0)),
	MOUNTAIN_CAMP_GOAT_ENCLOSURE(StashTier.HARD, ObjectID.HH_HARD008, "Mountain Camp goat enclosure", new WorldPoint(2810, 3677, 0)),
	GNOME_GLIDER_ON_WHITE_WOLF_MOUNTAIN(StashTier.HARD, ObjectID.HH_HARD009, "Gnome glider on White Wolf Mountain", new WorldPoint(2849, 3496, 0)),
	SHILO_VILLAGE_BANK(StashTier.HARD, ObjectID.HH_HARD010, "Shilo Village bank", new WorldPoint(2853, 2952, 0)),
	INSIDE_THE_DIGSITE_EXAM_CENTRE(StashTier.HARD, ObjectID.HH_HARD_EXP1, "Inside the Digsite Exam Centre", new WorldPoint(3356, 3333, 0)),
	NORTHEAST_CORNER_OF_THE_KHARAZI_JUNGLE(StashTier.HARD, ObjectID.HH_HARD_EXP2, "North-east corner of the Kharazi Jungle", new WorldPoint(2952, 2932, 0)),
	VOLCANO_IN_THE_NORTHEASTERN_WILDERNESS(StashTier.HARD, ObjectID.HH_HARD_EXP3, "Volcano in the north-eastern Wilderness", new WorldPoint(3368, 3930, 0)),
	IN_THE_MIDDLE_OF_JIGGIG(StashTier.HARD, ObjectID.HH_HARD_EXP4, "In the middle of Jiggig", new WorldPoint(2478, 3048, 0)),
	AGILITY_PYRAMID(StashTier.HARD, ObjectID.HH_HARD_EXP5, "Agility Pyramid", new WorldPoint(3357, 2830, 0)),
	HOSIDIUS_MESS(StashTier.HARD, ObjectID.HH_HARD_EXP6, "Hosidius mess", new WorldPoint(1646, 3632, 0)),
	OUTSIDE_TWILIGHT_TEMPLE(StashTier.HARD, ObjectID.HH_HARD_EXP7, "Outside Twilight Temple", new WorldPoint(1693, 3243, 0)),

	// ---- Elite ----
	CHAPEL_IN_WEST_ARDOUGNE(StashTier.ELITE, ObjectID.HH_ELITE_EXP1, "Chapel in West Ardougne", new WorldPoint(2527, 3294, 0)),
	NEAR_A_RUNITE_ROCK_IN_THE_FREMENNIK_ISLES(StashTier.ELITE, ObjectID.HH_ELITE_EXP2, "Near a runite rock in the Fremennik Isles", new WorldPoint(2374, 3847, 0)),
	NEAR_A_LADDER_IN_THE_WILDERNESS_LAVA_MAZE(StashTier.ELITE, ObjectID.HH_ELITE_EXP3, "Near a ladder in the Wilderness Lava Maze", new WorldPoint(3069, 3862, 0)),
	ENTRANCE_OF_THE_CAVE_OF_DAMIS(StashTier.ELITE, ObjectID.HH_ELITE_EXP4, "Entrance of the Cave of Damis", new WorldPoint(2629, 5070, 0)),
	WARRIORS_GUILD_BANK_ELITE(StashTier.ELITE, ObjectID.HH_ELITE_EXP5, "Warriors' Guild bank", new WorldPoint(2844, 3537, 0)),
	SOUTHEAST_CORNER_OF_THE_MONASTERY(StashTier.ELITE, ObjectID.HH_ELITE_EXP6, "South-east corner of the Monastery", new WorldPoint(3056, 3482, 0)),
	SOUTHEAST_CORNER_OF_THE_FISHING_PLATFORM(StashTier.ELITE, ObjectID.HH_ELITE_EXP7, "South-east corner of the Fishing Platform", new WorldPoint(2787, 3277, 0)),
	OUTSIDE_THE_SLAYER_TOWER_GARGOYLE_ROOM(StashTier.ELITE, ObjectID.HH_ELITE_EXP8, "Outside the Slayer Tower gargoyle room", new WorldPoint(3423, 3534, 2)),
	ON_TOP_OF_TROLLHEIM_MOUNTAIN(StashTier.ELITE, ObjectID.HH_ELITE_EXP9, "On top of Trollheim mountain", new WorldPoint(2886, 3676, 0)),
	FOUNTAIN_OF_HEROES(StashTier.ELITE, ObjectID.HH_ELITE_EXP10, "Fountain of Heroes", new WorldPoint(2916, 9891, 0)),
	ENTRANCE_OF_THE_CAVERN_UNDER_THE_WHIRLPOOL(StashTier.ELITE, ObjectID.HH_ELITE_EXP11, "Entrance of the cavern under the whirlpool", new WorldPoint(1764, 5367, 1), new WorldPoint(1636, 5367, 1)),
	HALFWAY_DOWN_TROLLWEISS_MOUNTAIN(StashTier.ELITE, ObjectID.HH_ELITE_EXP12, "Halfway down Trollweiss Mountain", new WorldPoint(2782, 3787, 0)),
	SHAYZIEN_WAR_TENT(StashTier.ELITE, ObjectID.HH_ELITE_EXP13, "Shayzien war tent", new WorldPoint(1488, 3637, 0)),
	OUTSIDE_THE_LEGENDS_GUILD_DOOR(StashTier.ELITE, ObjectID.HH_ELITE_EXP14, "Outside the Legends' Guild door", new WorldPoint(2727, 3371, 0)),
	NEAR_THE_GEM_STALL_IN_ARDOUGNE_MARKET(StashTier.ELITE, ObjectID.HH_ELITE_EXP15, "Near the gem stall in Ardougne market", new WorldPoint(2672, 3302, 0)),
	OUTSIDE_THE_BAR_BY_THE_FIGHT_ARENA(StashTier.ELITE, ObjectID.HH_ELITE_EXP16, "Outside the bar by the Fight Arena", new WorldPoint(2571, 3150, 0)),
	CHARCOAL_BURNERS(StashTier.ELITE, ObjectID.HH_ELITE_EXP17, "Charcoal burners", new WorldPoint(1712, 3470, 0)),
	TEMPLE_SOUTHEAST_OF_THE_BAZAAR(StashTier.ELITE, ObjectID.HH_ELITE_VM01, "Temple south-east of the Bazaar", new WorldPoint(1702, 3079, 0)),
	WINTUMBER_ISLAND(StashTier.ELITE, ObjectID.HH_ELITE_SAIL, "Wintumber Island", new WorldPoint(2072, 2608, 0)),

	// ---- Master ----
	SOUTHEAST_CORNER_OF_LAVA_DRAGON_ISLE(StashTier.MASTER, ObjectID.HH_MASTER001, "South-east corner of Lava Dragon Isle", new WorldPoint(3228, 3830, 0)),
	NEAR_THE_PIER_IN_ZULANDRA(StashTier.MASTER, ObjectID.HH_MASTER002, "Near the pier in Zul-Andra", new WorldPoint(2203, 3059, 0)),
	BARROWS_CHEST(StashTier.MASTER, ObjectID.HH_MASTER003, "Barrows chest", new WorldPoint(3547, 9690, 0)),
	WELL_OF_VOYAGE(StashTier.MASTER, ObjectID.HH_MASTER004, "Well of Voyage", new WorldPoint(2006, 4709, 1)),
	NORTHERN_WALL_OF_CASTLE_DRAKAN(StashTier.MASTER, ObjectID.HH_MASTER005, "Northern wall of Castle Drakan", new WorldPoint(3563, 3379, 0)),
	SEVENTH_CHAMBER_OF_JALSAVRAH(StashTier.MASTER, ObjectID.HH_MASTER006, "7th chamber of Jalsavrah (Pyramid Plunder)", new WorldPoint(1951, 4431, 0)),
	SOUL_ALTAR(StashTier.MASTER, ObjectID.HH_MASTER007, "Soul Altar", new WorldPoint(1810, 3855, 0)),
	WARRIORS_GUILD_BANK_MASTER(StashTier.MASTER, ObjectID.HH_MASTER008, "Warriors' Guild bank", new WorldPoint(2845, 3545, 0)),
	ENTRANA_CHAPEL(StashTier.MASTER, ObjectID.HH_MASTER009, "Entrana chapel", new WorldPoint(2851, 3355, 0)),
	TZHAAR_GEM_STORE(StashTier.MASTER, ObjectID.HH_MASTER010, "TzHaar gem store", new WorldPoint(2466, 5150, 0)),
	TENT_IN_LORD_IORWERTHS_ENCAMPMENT(StashTier.MASTER, ObjectID.HH_MASTER011, "Tent in Lord Iorwerth's Encampment", new WorldPoint(2198, 3257, 0)),
	OUTSIDE_MUDKNUCKLES_HUT(StashTier.MASTER, ObjectID.HH_MASTER012, "Outside Mudknuckle's hut", new WorldPoint(2959, 3502, 0)),
	CENTRE_OF_THE_CATACOMBS_OF_KOUREND(StashTier.MASTER, ObjectID.HH_MASTER013, "Centre of the Catacombs of Kourend", new WorldPoint(1661, 10045, 0)),
	KING_BLACK_DRAGONS_LAIR(StashTier.MASTER, ObjectID.HH_MASTER014, "King Black Dragon's lair", new WorldPoint(2286, 4680, 0)),
	OUTSIDE_KRIL_TSUTSAROTHS_ROOM(StashTier.MASTER, ObjectID.HH_MASTER015, "Outside K'ril Tsutsaroth's room", new WorldPoint(2931, 5337, 2)),
	BY_THE_BEAR_CAGE_IN_VARROCK_PALACE_GARDENS(StashTier.MASTER, ObjectID.HH_MASTER016, "By the bear cage in Varrock Palace gardens", new WorldPoint(3232, 3494, 0)),
	OUTSIDE_THE_WILDERNESS_AXE_HUT(StashTier.MASTER, ObjectID.HH_MASTER017, "Outside the Wilderness Axe Hut", new WorldPoint(3186, 3958, 0)),
	TOP_FLOOR_OF_THE_YANILLE_WATCHTOWER(StashTier.MASTER, ObjectID.HH_MASTER018, "Top floor of the Yanille Watchtower", new WorldPoint(2930, 4718, 2)),
	DEATH_ALTAR(StashTier.MASTER, ObjectID.HH_MASTER019, "Death Altar", new WorldPoint(2210, 4842, 0)),
	BEHIND_MISS_SCHISM_IN_DRAYNOR_VILLAGE(StashTier.MASTER, ObjectID.HH_MASTER020, "Behind Miss Schism in Draynor Village", new WorldPoint(3095, 3254, 0)),
	NORTHWESTERN_CORNER_OF_THE_ENCHANTED_VALLEY(StashTier.MASTER, ObjectID.HH_MASTER021, "North-western corner of the Enchanted Valley", new WorldPoint(3022, 4517, 0)),
	CRYSTALLINE_MAPLE_TREES(StashTier.MASTER, ObjectID.HH_MASTER022, "Crystalline maple trees", new WorldPoint(2213, 3427, 0)),
	CAM_TORUM_ENTRANCE(StashTier.MASTER, ObjectID.HH_MASTER_VM01, "Cam Torum entrance", new WorldPoint(1428, 3118, 0)),
	WESTERN_SALVAGER_OVERLOOK(StashTier.MASTER, ObjectID.HH_MASTER_VM02, "Western Salvager Overlook", new WorldPoint(1614, 3296, 0)),
	BRITTLE_ISLE(StashTier.MASTER, ObjectID.HH_MASTER_SAIL, "Brittle Isle", new WorldPoint(1952, 4074, 0)),
	;

	private final StashTier tier;
	private final int objectId;
	private final String displayName;
	private final WorldPoint[] worldPoints;

	StashUnit(StashTier tier, int objectId, String displayName, WorldPoint... worldPoints)
	{
		this.tier = tier;
		this.objectId = objectId;
		this.displayName = displayName;
		this.worldPoints = worldPoints;
	}

	private static final Map<Integer, StashUnit> BY_OBJECT_ID = new HashMap<>();

	static
	{
		for (StashUnit unit : values())
		{
			BY_OBJECT_ID.put(unit.objectId, unit);
		}
	}

	/** Returns the STASH unit whose built object has the given id, or null. */
	public static StashUnit forObjectId(int objectId)
	{
		return BY_OBJECT_ID.get(objectId);
	}

	/**
	 * Returns the closest STASH unit to the given world point within {@code maxDistance} tiles
	 * (same plane), or null if none are that close. Used to attribute a deposit/withdraw chat
	 * message to a unit when the menu interaction did not identify one (e.g. in instances).
	 */
	public static StashUnit nearest(WorldPoint from, int maxDistance)
	{
		if (from == null)
		{
			return null;
		}

		StashUnit best = null;
		int bestDistance = Integer.MAX_VALUE;
		for (StashUnit unit : values())
		{
			for (WorldPoint wp : unit.worldPoints)
			{
				if (wp.getPlane() != from.getPlane())
				{
					continue;
				}
				int distance = wp.distanceTo2D(from);
				if (distance <= maxDistance && distance < bestDistance)
				{
					best = unit;
					bestDistance = distance;
				}
			}
		}
		return best;
	}
}
