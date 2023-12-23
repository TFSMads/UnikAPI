package ml.volder.unikapi.types;

public enum Material {



    //legacy items
    @Deprecated
    AIR(true, 0, "minecraft", "air"),
    @Deprecated
    LEGACY_STONE(true, 1, "minecraft", "stone"),
    @Deprecated
    LEGACY_GRASS(true, 2, "minecraft", "grass"),
    @Deprecated
    LEGACY_DIRT(true, 3, "minecraft", "dirt"),
    @Deprecated
    LEGACY_COBBLESTONE(true, 4, "minecraft", "cobblestone"),
    @Deprecated
    WOOD(true, 5, "minecraft", "planks"),
    @Deprecated
    LEGACY_SAPLING(true, 6, "minecraft", "sapling"),
    @Deprecated
    BEDROCK(true, 7, "minecraft", "bedrock"),
    @Deprecated
    WATER(true, 8, "minecraft", "flowing_water"),
    @Deprecated
    STATIONARY_WATER(true, 9, "minecraft", "water"),
    @Deprecated
    LAVA(true, 10, "minecraft", "flowing_lava"),
    @Deprecated
    STATIONARY_LAVA(true, 11, "minecraft", "lava"),
    @Deprecated
    LEGACY_SAND(true, 12, "minecraft", "sand"),
    @Deprecated
    GRAVEL(true, 13, "minecraft", "gravel"),
    @Deprecated
    LEGACY_GOLD_ORE(true, 14, "minecraft", "gold_ore"),
    @Deprecated
    LEGACY_IRON_ORE(true, 15, "minecraft", "iron_ore"),
    @Deprecated
    COAL_ORE(true, 16, "minecraft", "coal_ore"),
    @Deprecated
    LOG(true, 17, "minecraft", "log"),
    @Deprecated
    LEAVES(true, 18, "minecraft", "leaves"),
    @Deprecated
    SPONGE(true, 19, "minecraft", "sponge"),
    @Deprecated
    LEGACY_GLASS(true, 20, "minecraft", "glass"),
    @Deprecated
    LAPIS_ORE(true, 21, "minecraft", "lapis_ore"),
    @Deprecated
    LAPIS_BLOCK(true, 22, "minecraft", "lapis_block"),
    @Deprecated
    DISPENSER(true, 23, "minecraft", "dispenser"),
    @Deprecated
    SANDSTONE(true, 24, "minecraft", "sandstone"),
    @Deprecated
    NOTE_BLOCK(true, 25, "minecraft", "noteblock"),
    @Deprecated
    BED_BLOCK(true, 26, "minecraft", "bed"),
    @Deprecated
    POWERED_RAIL(true, 27, "minecraft", "golden_rail"),
    @Deprecated
    DETECTOR_RAIL(true, 28, "minecraft", "detector_rail"),
    @Deprecated
    PISTON_STICKY_BASE(true, 29, "minecraft", "sticky_piston"),
    @Deprecated
    WEB(true, 30, "minecraft", "web"),
    @Deprecated
    LONG_GRASS(true, 31, "minecraft", "tallgrass"),
    @Deprecated
    DEAD_BUSH(true, 32, "minecraft", "deadbush"),
    @Deprecated
    PISTON_BASE(true, 33, "minecraft", "piston"),
    @Deprecated
    PISTON_EXTENSION(true, 34, "minecraft", "piston_head"),
    @Deprecated
    WOOL(true, 35, "minecraft", "wool"),
    @Deprecated
    PISTON_MOVING_PIECE(true, 36, "minecraft", ""),
    @Deprecated
    YELLOW_FLOWER(true, 37, "minecraft", "yellow_flower"),
    @Deprecated
    RED_ROSE(true, 38, "minecraft", "red_flower"),
    @Deprecated
    BROWN_MUSHROOM(true, 39, "minecraft", "brown_mushroom"),
    @Deprecated
    RED_MUSHROOM(true, 40, "minecraft", "red_mushroom"),
    @Deprecated
    GOLD_BLOCK(true, 41, "minecraft", "gold_block"),
    @Deprecated
    IRON_BLOCK(true, 42, "minecraft", "iron_block"),
    @Deprecated
    DOUBLE_STEP(true, 43, "minecraft", "double_stone_slab"),
    @Deprecated
    STEP(true, 44, "minecraft", "stone_slab"),
    @Deprecated
    BRICK(true, 45, "minecraft", "brick_block"),
    @Deprecated
    TNT(true, 46, "minecraft", "tnt"),
    @Deprecated
    BOOKSHELF(true, 47, "minecraft", "bookshelf"),
    @Deprecated
    MOSSY_COBBLESTONE(true, 48, "minecraft", "mossy_cobblestone"),
    @Deprecated
    LEGACY_OBSIDIAN(true, 49, "minecraft", "obsidian"),
    @Deprecated
    TORCH(true, 50, "minecraft", "torch"),
    @Deprecated
    FIRE(true, 51, "minecraft", "fire"),
    @Deprecated
    MOB_SPAWNER(true, 52, "minecraft", "mob_spawner"),
    @Deprecated
    WOOD_STAIRS(true, 53, "minecraft", "oak_stairs"),
    @Deprecated
    LEGACY_CHEST(true, 54, "minecraft", "chest"),
    @Deprecated
    REDSTONE_WIRE(true, 55, "minecraft", "redstone_wire"),
    @Deprecated
    DIAMOND_ORE(true, 56, "minecraft", "diamond_ore"),
    @Deprecated
    DIAMOND_BLOCK(true, 57, "minecraft", "diamond_block"),
    @Deprecated
    WORKBENCH(true, 58, "minecraft", "crafting_table"),
    @Deprecated
    CROPS(true, 59, "minecraft", "wheat"),
    @Deprecated
    SOIL(true, 60, "minecraft", "farmland"),
    @Deprecated
    FURNACE(true, 61, "minecraft", "furnace"),
    @Deprecated
    BURNING_FURNACE(true, 62, "minecraft", "lit_furnace"),
    @Deprecated
    SIGN_POST(true, 63, "minecraft", "standing_sign"),
    @Deprecated
    WOODEN_DOOR(true, 64, "minecraft", "wooden_door"),
    @Deprecated
    LADDER(true, 65, "minecraft", "ladder"),
    @Deprecated
    RAILS(true, 66, "minecraft", "rail"),
    @Deprecated
    COBBLESTONE_STAIRS(true, 67, "minecraft", "stone_stairs"),
    @Deprecated
    WALL_SIGN(true, 68, "minecraft", "wall_sign"),
    @Deprecated
    LEVER(true, 69, "minecraft", "lever"),
    @Deprecated
    STONE_PLATE(true, 70, "minecraft", "stone_pressure_plate"),
    @Deprecated
    IRON_DOOR_BLOCK(true, 71, "minecraft", "iron_door"),
    @Deprecated
    WOOD_PLATE(true, 72, "minecraft", "wooden_pressure_plate"),
    @Deprecated
    REDSTONE_ORE(true, 73, "minecraft", "redstone_ore"),
    @Deprecated
    GLOWING_REDSTONE_ORE(true, 74, "minecraft", "lit_redstone_ore"),
    @Deprecated
    REDSTONE_TORCH_OFF(true, 75, "minecraft", "unlit_redstone_torch"),
    @Deprecated
    REDSTONE_TORCH_ON(true, 76, "minecraft", "redstone_torch"),
    @Deprecated
    STONE_BUTTON(true, 77, "minecraft", "stone_button"),
    @Deprecated
    SNOW(true, 78, "minecraft", "snow_layer"),
    @Deprecated
    ICE(true, 79, "minecraft", "ice"),
    @Deprecated
    SNOW_BLOCK(true, 80, "minecraft", "snow"),
    @Deprecated
    CACTUS(true, 81, "minecraft", "cactus"),
    @Deprecated
    CLAY(true, 82, "minecraft", "clay"),
    @Deprecated
    SUGAR_CANE_BLOCK(true, 83, "minecraft", "reeds"),
    @Deprecated
    JUKEBOX(true, 84, "minecraft", "jukebox"),
    @Deprecated
    FENCE(true, 85, "minecraft", "fence"),
    @Deprecated
    PUMPKIN(true, 86, "minecraft", "pumpkin"),
    @Deprecated
    NETHERRACK(true, 87, "minecraft", "netherrack"),
    @Deprecated
    SOUL_SAND(true, 88, "minecraft", "soul_sand"),
    @Deprecated
    LEGACY_GLOWSTONE(true, 89, "minecraft", "glowstone"),
    @Deprecated
    PORTAL(true, 90, "minecraft", "portal"),
    @Deprecated
    JACK_O_LANTERN(true, 91, "minecraft", "lit_pumpkin"),
    @Deprecated
    CAKE_BLOCK(true, 92, "minecraft", "cake"),
    @Deprecated
    DIODE_BLOCK_OFF(true, 93, "minecraft", "unpowered_repeater"),
    @Deprecated
    DIODE_BLOCK_ON(true, 94, "minecraft", "powered_repeater"),
    @Deprecated
    STAINED_GLASS(true, 95, "minecraft", "stained_glass"),
    @Deprecated
    TRAP_DOOR(true, 96, "minecraft", "trapdoor"),
    @Deprecated
    MONSTER_EGGS(true, 97, "minecraft", "monster_egg"),
    @Deprecated
    SMOOTH_BRICK(true, 98, "minecraft", "stonebrick"),
    @Deprecated
    HUGE_MUSHROOM_1(true, 99, "minecraft", "brown_mushroom_block"),
    @Deprecated
    HUGE_MUSHROOM_2(true, 100, "minecraft", "red_mushroom_block"),
    @Deprecated
    IRON_FENCE(true, 101, "minecraft", "iron_bars"),
    @Deprecated
    THIN_GLASS(true, 102, "minecraft", "glass_pane"),
    @Deprecated
    MELON_BLOCK(true, 103, "minecraft", "melon_block"),
    @Deprecated
    PUMPKIN_STEM(true, 104, "minecraft", "pumpkin_stem"),
    @Deprecated
    MELON_STEM(true, 105, "minecraft", "melon_stem"),
    @Deprecated
    VINE(true, 106, "minecraft", "vine"),
    @Deprecated
    FENCE_GATE(true, 107, "minecraft", "fence_gate"),
    @Deprecated
    BRICK_STAIRS(true, 108, "minecraft", "brick_stairs"),
    @Deprecated
    SMOOTH_STAIRS(true, 109, "minecraft", "stone_brick_stairs"),
    @Deprecated
    MYCEL(true, 110, "minecraft", "mycelium"),
    @Deprecated
    WATER_LILY(true, 111, "minecraft", "waterlily"),
    @Deprecated
    NETHER_BRICK(true, 112, "minecraft", "nether_brick"),
    @Deprecated
    NETHER_FENCE(true, 113, "minecraft", "nether_brick_fence"),
    @Deprecated
    NETHER_BRICK_STAIRS(true, 114, "minecraft", "nether_brick_stairs"),
    @Deprecated
    NETHER_WARTS(true, 115, "minecraft", "nether_wart"),
    @Deprecated
    ENCHANTMENT_TABLE(true, 116, "minecraft", "enchanting_table"),
    @Deprecated
    BREWING_STAND_BLOCK(true, 117, "minecraft", "brewing_stand"),
    @Deprecated
    CAULDRON(true, 118, "minecraft", "cauldron"),
    @Deprecated
    ENDER_PORTAL(true, 119, "minecraft", "end_portal"),
    @Deprecated
    ENDER_PORTAL_FRAME(true, 120, "minecraft", "end_portal_frame"),
    @Deprecated
    ENDER_STONE(true, 121, "minecraft", "end_stone"),
    @Deprecated
    DRAGON_EGG(true, 122, "minecraft", "dragon_egg"),
    @Deprecated
    REDSTONE_LAMP_OFF(true, 123, "minecraft", "redstone_lamp"),
    @Deprecated
    REDSTONE_LAMP_ON(true, 124, "minecraft", "lit_redstone_lamp"),
    @Deprecated
    WOOD_DOUBLE_STEP(true, 125, "minecraft", "double_wooden_slab"),
    @Deprecated
    WOOD_STEP(true, 126, "minecraft", "wooden_slab"),
    @Deprecated
    COCOA(true, 127, "minecraft", "cocoa"),
    @Deprecated
    SANDSTONE_STAIRS(true, 128, "minecraft", "sandstone_stairs"),
    @Deprecated
    EMERALD_ORE(true, 129, "minecraft", "emerald_ore"),
    @Deprecated
    ENDER_CHEST(true, 130, "minecraft", "ender_chest"),
    @Deprecated
    TRIPWIRE_HOOK(true, 131, "minecraft", "tripwire_hook"),
    @Deprecated
    TRIPWIRE(true, 132, "minecraft", "tripwire_hook"),
    @Deprecated
    EMERALD_BLOCK(true, 133, "minecraft", "emerald_block"),
    @Deprecated
    SPRUCE_WOOD_STAIRS(true, 134, "minecraft", "spruce_stairs"),
    @Deprecated
    BIRCH_WOOD_STAIRS(true, 135, "minecraft", "birch_stairs"),
    @Deprecated
    JUNGLE_WOOD_STAIRS(true, 136, "minecraft", "jungle_stairs"),
    @Deprecated
    COMMAND(true, 137, "minecraft", "command_block"),
    @Deprecated
    BEACON(true, 138, "minecraft", "beacon"),
    @Deprecated
    COBBLE_WALL(true, 139, "minecraft", "cobblestone_wall"),
    @Deprecated
    FLOWER_POT(true, 140, "minecraft", "flower_pot"),
    @Deprecated
    CARROT(true, 141, "minecraft", "carrots"),
    @Deprecated
    POTATO(true, 142, "minecraft", "potatoes"),
    @Deprecated
    WOOD_BUTTON(true, 143, "minecraft", "wooden_button"),
    @Deprecated
    SKULL(true, 144, "minecraft", "skull"),
    @Deprecated
    LEGACY_ANVIL(true, 145, "minecraft", "anvil"),
    @Deprecated
    LEGACY_TRAPPED_CHEST(true, 146, "minecraft", "trapped_chest"),
    @Deprecated
    GOLD_PLATE(true, 147, "minecraft", "light_weighted_pressure_plate"),
    @Deprecated
    IRON_PLATE(true, 148, "minecraft", "heavy_weighted_pressure_plate"),
    @Deprecated
    REDSTONE_COMPARATOR_OFF(true, 149, "minecraft", "unpowered_comparator"),
    @Deprecated
    REDSTONE_COMPARATOR_ON(true, 150, "minecraft", "powered_comparator"),
    @Deprecated
    DAYLIGHT_DETECTOR(true, 151, "minecraft", "daylight_detector"),
    @Deprecated
    REDSTONE_BLOCK(true, 152, "minecraft", "redstone_block"),
    @Deprecated
    QUARTZ_ORE(true, 153, "minecraft", "quartz_ore"),
    @Deprecated
    LEGACY_HOPPER(true, 154, "minecraft", "hopper"),
    @Deprecated
    QUARTZ_BLOCK(true, 155, "minecraft", "quartz_block"),
    @Deprecated
    QUARTZ_STAIRS(true, 156, "minecraft", "quartz_stairs"),
    @Deprecated
    ACTIVATOR_RAIL(true, 157, "minecraft", "activator_rail"),
    @Deprecated
    DROPPER(true, 158, "minecraft", "dropper"),
    @Deprecated
    STAINED_CLAY(true, 159, "minecraft", "stained_hardened_clay"),
    @Deprecated
    STAINED_GLASS_PANE(true, 160, "minecraft", "stained_glass_pane"),
    @Deprecated
    LEAVES_2(true, 161, "minecraft", "leaves2"),
    @Deprecated
    LOG_2(true, 162, "minecraft", "log2"),
    @Deprecated
    ACACIA_STAIRS(true, 163, "minecraft", "acacia_stairs"),
    @Deprecated
    DARK_OAK_STAIRS(true, 164, "minecraft", "dark_oak_stairs"),
    @Deprecated
    LEGACY_BARRIER(true, 166, "minecraft", "barrier"),
    @Deprecated
    HAY_BLOCK(true, 170, "minecraft", "hay_block"),
    @Deprecated
    CARPET(true, 171, "minecraft", "carpet"),
    @Deprecated
    HARD_CLAY(true, 172, "minecraft", "hardened_clay"),
    @Deprecated
    COAL_BLOCK(true, 173, "minecraft", "coal_block"),
    @Deprecated
    PACKED_ICE(true, 174, "minecraft", "packed_ice"),
    @Deprecated
    DOUBLE_PLANT(true, 175, "minecraft", "double_plant"),
    @Deprecated
    IRON_SPADE(true, 256, "minecraft", "iron_shovel"),
    @Deprecated
    IRON_PICKAXE(true, 257, "minecraft", "iron_pickaxe"),
    @Deprecated
    IRON_AXE(true, 258, "minecraft", "iron_axe"),
    @Deprecated
    FLINT_AND_STEEL(true, 259, "minecraft", "flint_and_steel"),
    @Deprecated
    APPLE(true, 260, "minecraft", "apple"),
    @Deprecated
    LEGACY_BOW(true, 261, "minecraft", "bow"),
    @Deprecated
    ARROW(true, 262, "minecraft", "arrow"),
    @Deprecated
    LEGACY_COAL(true, 263, "minecraft", "coal"),
    @Deprecated
    LEGACY_DIAMOND(true, 264, "minecraft", "diamond"),
    @Deprecated
    LEGACY_IRON_INGOT(true, 265, "minecraft", "iron_ingot"),
    @Deprecated
    LEGACY_GOLD_INGOT(true, 266, "minecraft", "gold_ingot"),
    @Deprecated
    IRON_SWORD(true, 267, "minecraft", "iron_sword"),
    @Deprecated
    WOOD_SWORD(true, 268, "minecraft", "wooden_sword"),
    @Deprecated
    WOOD_SPADE(true, 269, "minecraft", "wooden_shovel"),
    @Deprecated
    WOOD_PICKAXE(true, 270, "minecraft", "wooden_pickaxe"),
    @Deprecated
    WOOD_AXE(true, 271, "minecraft", "wooden_axe"),
    @Deprecated
    STONE_SWORD(true, 272, "minecraft", "stone_sword"),
    @Deprecated
    STONE_SPADE(true, 273, "minecraft", "stone_shovel"),
    @Deprecated
    STONE_PICKAXE(true, 274, "minecraft", "stone_pickaxe"),
    @Deprecated
    STONE_AXE(true, 275, "minecraft", "stone_axe"),
    @Deprecated
    LEGACY_DIAMOND_SWORD(true, 276, "minecraft", "diamond_sword"),
    @Deprecated
    LEGACY_DIAMOND_SPADE(true, 277, "minecraft", "diamond_shovel"),
    @Deprecated
    LEGACY_DIAMOND_PICKAXE(true, 278, "minecraft", "diamond_pickaxe"),
    @Deprecated
    LEGACY_DIAMOND_AXE(true, 279, "minecraft", "diamond_axe"),
    @Deprecated
    LEGACY_STICK(true, 280, "minecraft", "stick"),
    @Deprecated
    BOWL(true, 281, "minecraft", "bowl"),
    @Deprecated
    MUSHROOM_SOUP(true, 282, "minecraft", "mushroom_stew"),
    @Deprecated
    GOLD_SWORD(true, 283, "minecraft", "golden_sword"),
    @Deprecated
    GOLD_SPADE(true, 284, "minecraft", "golden_shovel"),
    @Deprecated
    GOLD_PICKAXE(true, 285, "minecraft", "golden_pickaxe"),
    @Deprecated
    GOLD_AXE(true, 286, "minecraft", "golden_axe"),
    @Deprecated
    STRING(true, 287, "minecraft", "string"),
    @Deprecated
    FEATHER(true, 288, "minecraft", "feather"),
    @Deprecated
    SULPHUR(true, 289, "minecraft", "gunpowder"),
    @Deprecated
    WOOD_HOE(true, 290, "minecraft", "wooden_hoe"),
    @Deprecated
    STONE_HOE(true, 291, "minecraft", "stone_hoe"),
    @Deprecated
    IRON_HOE(true, 292, "minecraft", "iron_hoe"),
    @Deprecated
    DIAMOND_HOE(true, 293, "minecraft", "diamond_hoe"),
    @Deprecated
    GOLD_HOE(true, 294, "minecraft", "golden_hoe"),
    @Deprecated
    SEEDS(true, 295, "minecraft", "wheat_seeds"),
    @Deprecated
    WHEAT(true, 296, "minecraft", "wheat"),
    @Deprecated
    BREAD(true, 297, "minecraft", "bread"),
    @Deprecated
    LEATHER_HELMET(true, 298, "minecraft", "leather_helmet"),
    @Deprecated
    LEATHER_CHESTPLATE(true, 299, "minecraft", "leather_chestplate"),
    @Deprecated
    LEATHER_LEGGINGS(true, 300, "minecraft", "leather_leggings"),
    @Deprecated
    LEGACY_LEATHER_BOOTS(true, 301, "minecraft", "leather_boots"),
    @Deprecated
    CHAINMAIL_HELMET(true, 302, "minecraft", "chainmail_helmet"),
    @Deprecated
    CHAINMAIL_CHESTPLATE(true, 303, "minecraft", "chainmail_chestplate"),
    @Deprecated
    CHAINMAIL_LEGGINGS(true, 304, "minecraft", "chainmail_leggings"),
    @Deprecated
    CHAINMAIL_BOOTS(true, 305, "minecraft", "chainmail_boots"),
    @Deprecated
    IRON_HELMET(true, 306, "minecraft", "iron_helmet"),
    @Deprecated
    IRON_CHESTPLATE(true, 307, "minecraft", "iron_chestplate"),
    @Deprecated
    IRON_LEGGINGS(true, 308, "minecraft", "iron_leggings"),
    @Deprecated
    IRON_BOOTS(true, 309, "minecraft", "iron_boots"),
    @Deprecated
    DIAMOND_HELMET(true, 310, "minecraft", "diamond_helmet"),
    @Deprecated
    DIAMOND_CHESTPLATE(true, 311, "minecraft", "diamond_chestplate"),
    @Deprecated
    DIAMOND_LEGGINGS(true, 312, "minecraft", "diamond_leggings"),
    @Deprecated
    DIAMOND_BOOTS(true, 313, "minecraft", "diamond_boots"),
    @Deprecated
    GOLD_HELMET(true, 314, "minecraft", "golden_helmet"),
    @Deprecated
    GOLD_CHESTPLATE(true, 315, "minecraft", "golden_chestplate"),
    @Deprecated
    GOLD_LEGGINGS(true, 316, "minecraft", "golden_leggings"),
    @Deprecated
    GOLD_BOOTS(true, 317, "minecraft", "golden_boots"),
    @Deprecated
    FLINT(true, 318, "minecraft", "flint"),
    @Deprecated
    PORK(true, 319, "minecraft", "porkchop"),
    @Deprecated
    GRILLED_PORK(true, 320, "minecraft", "cooked_porkchop"),
    @Deprecated
    LEGACY_PAINTING(true, 321, "minecraft", "painting"),
    @Deprecated
    GOLDEN_APPLE(true, 322, "minecraft", "golden_apple"),
    @Deprecated
    SIGN(true, 323, "minecraft", "sign"),
    @Deprecated
    WOOD_DOOR(true, 324, "minecraft", "wooden_door"),
    @Deprecated
    BUCKET(true, 325, "minecraft", "bucket"),
    @Deprecated
    WATER_BUCKET(true, 326, "minecraft", "water_bucket"),
    @Deprecated
    LAVA_BUCKET(true, 327, "minecraft", "lava_bucket"),
    @Deprecated
    MINECART(true, 328, "minecraft", "minecart"),
    @Deprecated
    LEGACY_SADDLE(true, 329, "minecraft", "saddle"),
    @Deprecated
    IRON_DOOR(true, 330, "minecraft", "iron_door"),
    @Deprecated
    LEGACY_REDSTONE(true, 331, "minecraft", "redstone"),
    @Deprecated
    SNOW_BALL(true, 332, "minecraft", "snowball"),
    @Deprecated
    BOAT(true, 333, "minecraft", "boat"),
    @Deprecated
    LEGACY_LEATHER(true, 334, "minecraft", "leather"),
    @Deprecated
    MILK_BUCKET(true, 335, "minecraft", "milk_bucket"),
    @Deprecated
    CLAY_BRICK(true, 336, "minecraft", "brick"),
    @Deprecated
    CLAY_BALL(true, 337, "minecraft", "clay_ball"),
    @Deprecated
    LEGACY_SUGAR_CANE(true, 338, "minecraft", "reeds"),
    @Deprecated
    LEGACY_PAPER(true, 339, "minecraft", "paper"),
    @Deprecated
    LEGACY_BOOK(true, 340, "minecraft", "book"),
    @Deprecated
    LEGACY_SLIME_BALL(true, 341, "minecraft", "slime_ball"),
    @Deprecated
    STORAGE_MINECART(true, 342, "minecraft", "chest_minecart"),
    @Deprecated
    POWERED_MINECART(true, 343, "minecraft", "furnace_minecart"),
    @Deprecated
    EGG(true, 344, "minecraft", "egg"),
    @Deprecated
    COMPASS(true, 345, "minecraft", "compass"),
    @Deprecated
    LEGACY_FISHING_ROD(true, 346, "minecraft", "fishing_rod"),
    @Deprecated
    LEGACY_WATCH(true, 347, "minecraft", "clock"),
    @Deprecated
    LEGACY_GLOWSTONE_DUST(true, 348, "minecraft", "glowstone_dust"),
    @Deprecated
    RAW_FISH(true, 349, "minecraft", "fish"),
    @Deprecated
    COOKED_FISH(true, 350, "minecraft", "cooked_fish"),
    @Deprecated
    LEGACY_INK_SACK(true, 351, "minecraft", "dye"),
    @Deprecated
    LEGACY_BONE(true, 352, "minecraft", "bone"),
    @Deprecated
    SUGAR(true, 353, "minecraft", "sugar"),
    @Deprecated
    CAKE(true, 354, "minecraft", "cake"),
    @Deprecated
    BED(true, 355, "minecraft", "bed"),
    @Deprecated
    LEGACY_DIODE(true, 356, "minecraft", "repeater"),
    @Deprecated
    COOKIE(true, 357, "minecraft", "cookie"),
    @Deprecated
    MAP(true, 358, "minecraft", "filled_map"),
    @Deprecated
    SHEARS(true, 359, "minecraft", "shears"),
    @Deprecated
    MELON(true, 360, "minecraft", "melon"),
    @Deprecated
    PUMPKIN_SEEDS(true, 361, "minecraft", "pumpkin_seeds"),
    @Deprecated
    MELON_SEEDS(true, 362, "minecraft", "melon_seeds"),
    @Deprecated
    RAW_BEEF(true, 363, "minecraft", "beef"),
    @Deprecated
    COOKED_BEEF(true, 364, "minecraft", "cooked_beef"),
    @Deprecated
    RAW_CHICKEN(true, 365, "minecraft", "chicken"),
    @Deprecated
    COOKED_CHICKEN(true, 366, "minecraft", "cooked_chicken"),
    @Deprecated
    ROTTEN_FLESH(true, 367, "minecraft", "rotten_flesh"),
    @Deprecated
    LEGACY_ENDER_PEARL(true, 368, "minecraft", "ender_pearl"),
    @Deprecated
    LEGACY_BLAZE_ROD(true, 369, "minecraft", "blaze_rod"),
    @Deprecated
    GHAST_TEAR(true, 370, "minecraft", "ghast_tear"),
    @Deprecated
    GOLD_NUGGET(true, 371, "minecraft", "gold_nugget"),
    @Deprecated
    NETHER_STALK(true, 372, "minecraft", "nether_wart"),
    @Deprecated
    POTION(true, 373, "minecraft", "potion"),
    @Deprecated
    GLASS_BOTTLE(true, 374, "minecraft", "glass_bottle"),
    @Deprecated
    LEGACY_SPIDER_EYE(true, 375, "minecraft", "spider_eye"),
    @Deprecated
    FERMENTED_SPIDER_EYE(true, 376, "minecraft", "fermented_spider_eye"),
    @Deprecated
    BLAZE_POWDER(true, 377, "minecraft", "blaze_powder"),
    @Deprecated
    MAGMA_CREAM(true, 378, "minecraft", "magma_cream"),
    @Deprecated
    LEGACY_BREWING_STAND_ITEM(true, 379, "minecraft", "brewing_stand"),
    @Deprecated
    CAULDRON_ITEM(true, 380, "minecraft", "cauldron"),
    @Deprecated
    EYE_OF_ENDER(true, 381, "minecraft", "ender_eye"),
    @Deprecated
    SPECKLED_MELON(true, 382, "minecraft", "speckled_melon"),
    @Deprecated
    MONSTER_EGG(true, 383, "minecraft", "spawn_egg"),
    @Deprecated
    EXP_BOTTLE(true, 384, "minecraft", "experience_bottle"),
    @Deprecated
    FIREBALL(true, 385, "minecraft", "fire_charge"),
    @Deprecated
    BOOK_AND_QUILL(true, 386, "minecraft", "writable_book"),
    @Deprecated
    WRITTEN_BOOK(true, 387, "minecraft", "written_book"),
    @Deprecated
    LEGACY_EMERALD(true, 388, "minecraft", "emerald"),
    @Deprecated
    ITEM_FRAME(true, 389, "minecraft", "item_frame"),
    @Deprecated
    FLOWER_POT_ITEM(true, 390, "minecraft", "flower_pot"),
    @Deprecated
    CARROT_ITEM(true, 391, "minecraft", "carrot"),
    @Deprecated
    POTATO_ITEM(true, 392, "minecraft", "potato"),
    @Deprecated
    BAKED_POTATO(true, 393, "minecraft", "baked_potato"),
    @Deprecated
    POISONOUS_POTATO(true, 394, "minecraft", "poisonous_potato"),
    @Deprecated
    EMPTY_MAP(true, 395, "minecraft", "map"),
    @Deprecated
    GOLDEN_CARROT(true, 396, "minecraft", "golden_carrot"),
    @Deprecated
    SKULL_ITEM(true, 397, "minecraft", "skull"),
    @Deprecated
    CARROT_STICK(true, 398, "minecraft", "carrot_on_a_stick"),
    @Deprecated
    NETHER_STAR(true, 399, "minecraft", "nether_star"),
    @Deprecated
    PUMPKIN_PIE(true, 400, "minecraft", "pumpkin_pie"),
    @Deprecated
    FIREWORK(true, 401, "minecraft", "fireworks"),
    @Deprecated
    FIREWORK_CHARGE(true, 402, "minecraft", "firework_charge"),
    @Deprecated
    ENCHANTED_BOOK(true, 403, "minecraft", "enchanted_book"),
    @Deprecated
    REDSTONE_COMPARATOR(true, 404, "minecraft", "comparator"),
    @Deprecated
    NETHER_BRICK_ITEM(true, 405, "minecraft", "netherbrick"),
    @Deprecated
    LEGACY_QUARTZ(true, 406, "minecraft", "quartz"),
    @Deprecated
    EXPLOSIVE_MINECART(true, 407, "minecraft", "tnt_minecart"),
    @Deprecated
    HOPPER_MINECART(true, 408, "minecraft", "hopper_minecart"),
    @Deprecated
    IRON_BARDING(true, 417, "minecraft", "iron_horse_armor"),
    @Deprecated
    GOLD_BARDING(true, 418, "minecraft", "golden_horse_armor"),
    @Deprecated
    DIAMOND_BARDING(true, 419, "minecraft", "diamond_horse_armor"),
    @Deprecated
    LEASH(true, 420, "minecraft", "lead"),
    @Deprecated
    NAME_TAG(true, 421, "minecraft", "name_tag"),
    @Deprecated
    COMMAND_MINECART(true, 422, "minecraft", "command_block_minecart"),
    @Deprecated
    BANNER(true, 425, "minecraft", "banner"),
    @Deprecated
    GOLD_RECORD(true, 2256, "minecraft", "record_13"),
    @Deprecated
    GREEN_RECORD(true, 2257, "minecraft", "record_cat"),
    @Deprecated
    RECORD_3(true, 2258, "minecraft", "record_blocks"),
    @Deprecated
    RECORD_4(true, 2259, "minecraft", "record_chirp"),
    @Deprecated
    RECORD_5(true, 2260, "minecraft", "record_far"),
    @Deprecated
    RECORD_6(true, 2261, "minecraft", "record_mall"),
    @Deprecated
    RECORD_7(true, 2262, "minecraft", "record_mellohi"),
    @Deprecated
    RECORD_8(true, 2263, "minecraft", "record_stal"),
    @Deprecated
    RECORD_9(true, 2264, "minecraft", "record_strad"),
    @Deprecated
    RECORD_10(true, 2265, "minecraft", "record_ward"),
    @Deprecated
    RECORD_11(true, 2266, "minecraft", "record_11"),
    @Deprecated
    RECORD_12(true, 2267, "minecraft", "record_wait"),

    //modern items
    REDSTONE_TORCH(false, -1, "minecraft", "redstone_torch", REDSTONE_TORCH_ON, 0),
    DIODE(false, -1, "minecraft", "repeater", LEGACY_DIODE, 0),
    WATCH(false, -1, "minecraft", "clock", LEGACY_WATCH, 0),
    EMERALD(false, -1, "minecraft", "emerald", LEGACY_EMERALD, 0),
    PAINTING(false, -1, "minecraft", "painting", LEGACY_PAINTING , 0),
    PAPER(false, -1, "minecraft", "paper", LEGACY_PAPER , 0),
    REDSTONE_LAMP(false, -1, "minecraft", "redstone_lamp", REDSTONE_LAMP_OFF, 0),
    OAK_BUTTON(false, -1, "minecraft", "oak_button", WOOD_BUTTON, 0),
    OAK_SIGN(false, -1, "minecraft", "oak_sign", SIGN, 0),
    BARRIER(false, -1, "minecraft", "barrier", LEGACY_BARRIER, 0),
    SAND(false, -1, "minecraft", "sand", LEGACY_SAND, 0),
    RED_SAND(false, -1, "minecraft", "red_sand", LEGACY_SAND, 1),
    STONE(false, -1, "minecraft", "stone", LEGACY_STONE, 0),
    COBBLESTONE(false, -1, "minecraft", "cobblestone", LEGACY_COBBLESTONE, 0),
    STONE_BRICK(false, -1, "minecraft", "stone_bricks", SMOOTH_BRICK, 0),
    DIRT(false, -1, "minecraft", "dirt", LEGACY_DIRT, 0),
    GRASS(false, -1, "minecraft", "grass_block", LEGACY_GRASS, 0),
    COAL(false, -1, "minecraft", "coal", LEGACY_COAL, 0),
    CHARCOAL(false, -1, "minecraft", "charcoal", LEGACY_COAL, 1),
    IRON_ORE(false, -1, "minecraft", "iron_ore", LEGACY_IRON_ORE, 0),
    GOLD_ORE(false, -1, "minecraft", "gold_ore", LEGACY_GOLD_ORE, 0),
    IRON_INGOT(false, -1, "minecraft", "iron_ingot", LEGACY_IRON_INGOT, 0),
    GOLD_INGOT(false, -1, "minecraft", "gold_ingot", LEGACY_GOLD_INGOT, 0),
    BONE(false, -1, "minecraft", "bone", LEGACY_BONE, 0),
    GLOWSTONE_DUST(false, -1, "minecraft", "glowstone_dust", LEGACY_GLOWSTONE_DUST, 0),
    GLOWSTONE(false, -1, "minecraft", "glowstone", LEGACY_GLOWSTONE, 0),
    LAPIS_LAZULI(false, -1, "minecraft", "lapis_lazuli", LEGACY_INK_SACK, 4),
    QUARTZ(false, -1, "minecraft", "quartz", LEGACY_QUARTZ, 0),
    REDSTONE(false, -1, "minecraft", "redstone", LEGACY_REDSTONE, 0),
    DIAMOND(false, -1, "minecraft", "diamond", LEGACY_DIAMOND, 0),
    OBSIDIAN(false, -1, "minecraft", "obsidian", LEGACY_OBSIDIAN, 0),
    BLAZE_ROD(false, -1, "minecraft", "blaze_rod", LEGACY_BLAZE_ROD, 0),
    ENDER_PEARL(false, -1, "minecraft", "ender_pearl", LEGACY_ENDER_PEARL, 0),
    BOOK(false, -1, "minecraft", "book", LEGACY_BOOK, 0),
    SUGAR_CANE(false, -1, "minecraft", "sugar_cane", LEGACY_SUGAR_CANE, 0),
    LEATHER(false, -1, "minecraft", "leather", LEGACY_LEATHER, 0),
    OAK_LOG(false, -1, "minecraft", "oak_log", LOG, 0),
    SPRUCE_LOG(false, -1, "minecraft", "spruce_log", LOG, 1),
    BIRCH_LOG(false, -1, "minecraft", "birch_log", LOG, 2),
    JUNGLE_LOG(false, -1, "minecraft", "jungle_log", LOG, 3),
    SLIME_BALL(false, -1, "minecraft", "slime_ball", LEGACY_SLIME_BALL, 0),
    CHEST(false, -1, "minecraft", "chest", LEGACY_CHEST, 0),
    TRAPPED_CHEST(false, -1, "minecraft", "trapped_chest", LEGACY_TRAPPED_CHEST, 0),
    HOPPER(false, -1, "minecraft", "hopper", LEGACY_HOPPER, 0),



    WHITE_WOOL(false, -1, "minecraft", "white_wool", WOOL, 0),
    ORANGE_WOOL(false, -1, "minecraft", "orange_wool", WOOL, 1),
    MAGENTA_WOOL(false, -1, "minecraft", "magenta_wool", WOOL, 2),
    LIGHT_BLUE_WOOL(false, -1, "minecraft", "light_blue_wool", WOOL, 3),
    YELLOW_WOOL(false, -1, "minecraft", "yellow_wool", WOOL, 4),
    LIME_WOOL(false, -1, "minecraft", "lime_wool", WOOL, 5),
    PINK_WOOL(false, -1, "minecraft", "pink_wool", WOOL, 6),
    GRAY_WOOL(false, -1, "minecraft", "gray_wool", WOOL, 7),
    LIGHT_GRAY_WOOL(false, -1, "minecraft", "light_gray_wool", WOOL, 8),
    CYAN_WOOL(false, -1, "minecraft", "cyan_wool", WOOL, 9),
    PURPLE_WOOL(false, -1, "minecraft", "purple_wool", WOOL, 10),
    BLUE_WOOL(false, -1, "minecraft", "blue_wool", WOOL, 11),
    BROWN_WOOL(false, -1, "minecraft", "brown_wool", WOOL, 12),
    GREEN_WOOL(false, -1, "minecraft", "green_wool", WOOL, 13),
    RED_WOOL(false, -1, "minecraft", "red_wool", WOOL, 14),
    BLACK_WOOL(false, -1, "minecraft", "black_wool", WOOL, 15),


    WHITE_GLASS(false, -1, "minecraft", "white_stained_glass", STAINED_GLASS, 0),
    ORANGE_GLASS(false, -1, "minecraft", "orange_stained_glass", STAINED_GLASS, 1),
    MAGENTA_GLASS(false, -1, "minecraft", "magenta_stained_glass", STAINED_GLASS, 2),
    LIGHT_BLUE_GLASS(false, -1, "minecraft", "light_blue_stained_glass", STAINED_GLASS, 3),
    YELLOW_GLASS(false, -1, "minecraft", "yellow_stained_glass", STAINED_GLASS, 4),
    LIME_GLASS(false, -1, "minecraft", "lime_stained_glass", STAINED_GLASS, 5),
    PINK_GLASS(false, -1, "minecraft", "pink_stained_glass", STAINED_GLASS, 6),
    GRAY_GLASS(false, -1, "minecraft", "gray_stained_glass", STAINED_GLASS, 7),
    LIGHT_GRAY_GLASS(false, -1, "minecraft", "light_gray_stained_glass", STAINED_GLASS, 8),
    CYAN_GLASS(false, -1, "minecraft", "cyan_stained_glass", STAINED_GLASS, 9),
    PURPLE_GLASS(false, -1, "minecraft", "purple_stained_glass", STAINED_GLASS, 10),
    BLUE_GLASS(false, -1, "minecraft", "blue_stained_glass", STAINED_GLASS, 11),
    BROWN_GLASS(false, -1, "minecraft", "brown_stained_glass", STAINED_GLASS, 12),
    GREEN_GLASS(false, -1, "minecraft", "green_stained_glass", STAINED_GLASS, 13),
    RED_GLASS(false, -1, "minecraft", "red_stained_glass", STAINED_GLASS, 14),
    BLACK_GLASS(false, -1, "minecraft", "black_stained_glass", STAINED_GLASS, 15),

    DIAMOND_SHOVEL(false, -1, "minecraft", "diamond_shovel", LEGACY_DIAMOND_SPADE, 0),
    DIAMOND_AXE(false, -1, "minecraft", "diamond_axe", LEGACY_DIAMOND_AXE, 0),
    ANVIL(false, -1, "minecraft", "anvil", LEGACY_ANVIL, 0),
    LEATHER_BOOTS(false, -1, "minecraft", "leather_boots", LEGACY_LEATHER_BOOTS, 0),
    BREWING_STAND(false, -1, "minecraft", "brewing_stand", LEGACY_BREWING_STAND_ITEM, 0),
    BOW(false, -1, "minecraft", "bow", LEGACY_BOW, 0),
    FISHING_ROD(false, -1, "minecraft", "fishing_rod", LEGACY_FISHING_ROD, 0),
    SPIDER_EYE(false, -1, "minecraft", "spider_eye", LEGACY_SPIDER_EYE, 0),
    DIAMOND_PICKAXE(false, -1, "minecraft", "diamond_pickaxe", LEGACY_DIAMOND_PICKAXE, 0),
    DIAMOND_SWORD(false, -1, "minecraft", "diamond_sword", LEGACY_DIAMOND_SWORD, 0),
    SADDLE(false, -1, "minecraft", "saddle", LEGACY_SADDLE, 0),
    STICK(false, -1, "minecraft", "stick", LEGACY_STICK, 0),

    SPRUCE_SAPLING(false, -1, "minecraft", "spruce_sapling", LEGACY_SAPLING, 1),
    COCAO_BEANS(false, -1, "minecraft", "cocao_beans", LEGACY_INK_SACK, 3),

    GLASS(false, -1, "minecraft", "glass", LEGACY_GLASS, 0);


    private int id = 0;
    private String namespace;
    private String path;

    public boolean isLegacy() {
        return isLegacy;
    }

    private int legacyItemDamage;
    private boolean isLegacy;
    private Material legacyReplacement;

    Material(boolean isLegacy, int id, String namespace, String path) {
        this.isLegacy = isLegacy;
        this.id = id;
        this.namespace = namespace;
        this.path = path;
    }

    Material(boolean isLegacy, int id, String namespace, String path, Material legacyReplacement, int legacyItemDamage) {
        this.isLegacy = isLegacy;
        this.legacyReplacement = legacyReplacement;
        this.legacyItemDamage = legacyItemDamage;
        this.id = id;
        this.namespace = namespace;
        this.path = path;
    }

    public String getPath(boolean isLegacy) {
        if(this.isLegacy == isLegacy)
            return getPath();
        if(!isLegacy || (isLegacy && legacyReplacement == null))
            throw new NotSupportedItemException(this);
        return legacyReplacement.getPath();
    }

    /**
     * @param defaultItemDamage The itemDamage that should be returned if the material is legacy
     *
     * @return returns the item damage to recreate the modern item with legacy minecraft.
     */
    public int getItemDamage(int defaultItemDamage) {
        if(!isLegacy)
            return 0;
        if(legacyItemDamage < 0)
            return defaultItemDamage;
        return legacyItemDamage;
    }

    public int getId() {
        return this.id;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }
}

