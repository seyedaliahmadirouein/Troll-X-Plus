package com.trollxplus.trolls;

import org.bukkit.Material;

public enum TrollType {
    // Movement Category (20 trolls)
    REVERSE_CONTROLS(0, "Reverse Controls", "Reverses player movement", Material.COMPASS, 10, TrollCategory.MOVEMENT),
    JUMP_BOOST(1, "Jump Boost", "Gives extreme jump boost", Material.RABBIT_FOOT, 12, TrollCategory.MOVEMENT),
    SLOW_MOTION(2, "Slow Motion", "Slows player movement", Material.COBWEB, 20, TrollCategory.MOVEMENT),
    SPEED_BOOST(3, "Speed Boost", "Extreme speed effect", Material.SUGAR, 8, TrollCategory.MOVEMENT),
    GRAVITY_FLIP(4, "Gravity Flip", "Flips player gravity", Material.FEATHER, 12, TrollCategory.MOVEMENT),
    FREEZE_PLAYER(5, "Freeze Player", "Completely freezes player movement", Material.ICE, 15, TrollCategory.MOVEMENT),
    SPIDER_CLIMB(6, "Spider Climb", "Makes player stick to walls", Material.SPIDER_EYE, 20, TrollCategory.MOVEMENT),
    DRUNK_WALK(7, "Drunk Walk", "Makes player walk randomly", Material.POTION, 25, TrollCategory.MOVEMENT),
    MOON_WALK(8, "Moon Walk", "Low gravity walking", Material.END_STONE, 30, TrollCategory.MOVEMENT),
    STICKY_FEET(9, "Sticky Feet", "Player moves very slowly", Material.HONEY_BLOCK, 20, TrollCategory.MOVEMENT),
    BOUNCY_PLAYER(10, "Bouncy Player", "Player bounces constantly", Material.SLIME_BLOCK, 25, TrollCategory.MOVEMENT),
    DIZZY_SPIN(11, "Dizzy Spin", "Player spins uncontrollably", Material.COMPASS, 15, TrollCategory.MOVEMENT),
    ROCKET_BOOST(12, "Rocket Boost", "Launches player forward", Material.FIREWORK_ROCKET, 5, TrollCategory.MOVEMENT),
    INVISIBLE_PLAYER(13, "Invisible Player", "Makes player invisible", Material.GLASS_BOTTLE, 30, TrollCategory.MOVEMENT),
    GIANT_STEPS(14, "Giant Steps", "Each step is huge", Material.LEATHER_BOOTS, 20, TrollCategory.MOVEMENT),
    TINY_STEPS(15, "Tiny Steps", "Very small movement", Material.RABBIT_FOOT, 25, TrollCategory.MOVEMENT),
    BACKWARDS_ONLY(16, "Backwards Only", "Can only move backwards", Material.PISTON, 30, TrollCategory.MOVEMENT),
    SIDEWAYS_WALK(17, "Sideways Walk", "Only sideways movement", Material.RAIL, 20, TrollCategory.MOVEMENT),
    FLOAT_MODE(18, "Float Mode", "Player floats slightly", Material.PHANTOM_MEMBRANE, 40, TrollCategory.MOVEMENT),
    EARTHQUAKE_WALK(19, "Earthquake Walk", "Ground shakes when walking", Material.STONE, 25, TrollCategory.MOVEMENT),
    
    // Visual Category (25 trolls)
    INVISIBLE_BLOCKS(20, "Invisible Blocks", "Makes blocks around player invisible", Material.GLASS, 8, TrollCategory.VISUAL),
    FAKE_LIGHTNING(21, "Fake Lightning", "Creates fake lightning strike", Material.LIGHTNING_ROD, 7, TrollCategory.VISUAL),
    FALLING_BLOCKS(22, "Falling Blocks", "Fake falling blocks around player", Material.SAND, 6, TrollCategory.VISUAL),
    FAKE_EXPLOSION(23, "Fake Explosion", "Harmless explosion visuals", Material.TNT, 5, TrollCategory.VISUAL),
    FAKE_FIRE(24, "Fake Fire", "Harmless fire effects", Material.FLINT_AND_STEEL, 8, TrollCategory.VISUAL),
    BLOCK_MIRAGE(25, "Block Mirage", "Shows fake diamond blocks", Material.DIAMOND_BLOCK, 30, TrollCategory.VISUAL),
    UPSIDE_DOWN(26, "Upside Down", "Flips player's view upside down", Material.FERMENTED_SPIDER_EYE, 20, TrollCategory.VISUAL),
    RAINBOW_WORLD(27, "Rainbow World", "Makes world colorful", Material.PRISMARINE_CRYSTALS, 30, TrollCategory.VISUAL),
    FAKE_LAVA_FLOOR(28, "Fake Lava Floor", "Shows lava beneath player", Material.LAVA_BUCKET, 15, TrollCategory.VISUAL),
    DISCO_LIGHTS(29, "Disco Lights", "Flashing colored lights", Material.REDSTONE_LAMP, 25, TrollCategory.VISUAL),
    FAKE_WATER(30, "Fake Water", "Shows water everywhere", Material.WATER_BUCKET, 20, TrollCategory.VISUAL),
    MIRROR_BLOCKS(31, "Mirror Blocks", "Everything becomes glass", Material.GLASS, 15, TrollCategory.VISUAL),
    NEON_WORLD(32, "Neon World", "Glowing block effects", Material.GLOWSTONE, 35, TrollCategory.VISUAL),
    FAKE_BEDROCK(33, "Fake Bedrock", "Shows bedrock walls", Material.BEDROCK, 10, TrollCategory.VISUAL),
    HOLOGRAM_BLOCKS(34, "Hologram Blocks", "Transparent block effects", Material.BARRIER, 20, TrollCategory.VISUAL),
    FAKE_PORTAL(35, "Fake Portal", "Shows fake nether portals", Material.OBSIDIAN, 15, TrollCategory.VISUAL),
    GLITCH_WORLD(36, "Glitch World", "Random block flickering", Material.OBSERVER, 30, TrollCategory.VISUAL),
    FAKE_TREASURE(37, "Fake Treasure", "Shows fake treasure chests", Material.CHEST, 25, TrollCategory.VISUAL),
    LASER_SHOW(38, "Laser Show", "Colored beam effects", Material.BEACON, 20, TrollCategory.VISUAL),
    FAKE_MONSTERS(39, "Fake Monsters", "Shows scary block faces", Material.JACK_O_LANTERN, 15, TrollCategory.VISUAL),
    CRYSTAL_WORLD(40, "Crystal World", "Everything becomes crystals", Material.AMETHYST_BLOCK, 40, TrollCategory.VISUAL),
    FAKE_STRUCTURES(41, "Fake Structures", "Shows fake buildings", Material.BRICKS, 30, TrollCategory.VISUAL),
    PARTICLE_STORM(42, "Particle Storm", "Massive particle effects", Material.FIREWORK_STAR, 25, TrollCategory.VISUAL),
    FAKE_BIOME(43, "Fake Biome", "Changes biome appearance", Material.GRASS_BLOCK, 45, TrollCategory.VISUAL),
    SHADOW_WORLD(44, "Shadow World", "Everything becomes dark", Material.BLACK_CONCRETE, 20, TrollCategory.VISUAL),
    
    // Teleport Category (10 trolls)
    RANDOM_TELEPORT(45, "Random Teleport", "Teleports to random location", Material.ENDER_PEARL, 3, TrollCategory.TELEPORT),
    ENTITY_SWAP(46, "Entity Swap", "Swaps player with nearby entity", Material.LEAD, 12, TrollCategory.TELEPORT),
    FAKE_VOID(47, "Fake Void", "Shows fake void beneath", Material.OBSIDIAN, 6, TrollCategory.TELEPORT),
    TELEPORT_LOOP(48, "Teleport Loop", "Teleports player in circles", Material.CHORUS_FRUIT, 25, TrollCategory.TELEPORT),
    TELEPORT_JAIL(49, "Teleport Jail", "Traps player in glass box", Material.GLASS_PANE, 20, TrollCategory.TELEPORT),
    MIRROR_TELEPORT(50, "Mirror Teleport", "Teleports to mirrored location", Material.AMETHYST_SHARD, 10, TrollCategory.TELEPORT),
    SKY_TELEPORT(51, "Sky Teleport", "Teleports high in the sky", Material.ELYTRA, 8, TrollCategory.TELEPORT),
    UNDERGROUND_TP(52, "Underground TP", "Teleports deep underground", Material.DEEPSLATE, 12, TrollCategory.TELEPORT),
    OCEAN_TELEPORT(53, "Ocean Teleport", "Teleports to middle of ocean", Material.PRISMARINE, 10, TrollCategory.TELEPORT),
    NETHER_FAKE_TP(54, "Nether Fake TP", "Shows fake nether teleport", Material.NETHERRACK, 15, TrollCategory.TELEPORT),
    
    // Inventory Category (15 trolls)
    ITEM_SHUFFLE(55, "Item Shuffle", "Shuffles player inventory", Material.CHEST, 5, TrollCategory.INVENTORY),
    INVENTORY_LOCK(56, "Inventory Lock", "Temporarily locks inventory", Material.IRON_BARS, 20, TrollCategory.INVENTORY),
    ITEM_MAGNET(57, "Item Magnet", "Items fly toward player", Material.MAGMA_CREAM, 14, TrollCategory.INVENTORY),
    FAKE_ITEMS(58, "Fake Items", "Gives fake items that disappear", Material.GOLDEN_APPLE, 10, TrollCategory.INVENTORY),
    INVENTORY_BOMB(59, "Inventory Bomb", "Fills inventory with junk", Material.DIRT, 8, TrollCategory.INVENTORY),
    ITEM_RENAME(60, "Item Rename", "Renames all player items", Material.NAME_TAG, 12, TrollCategory.INVENTORY),
    HOTBAR_SHUFFLE(61, "Hotbar Shuffle", "Constantly shuffles hotbar", Material.DISPENSER, 15, TrollCategory.INVENTORY),
    ITEM_MULTIPLIER(62, "Item Multiplier", "Shows fake item duplication", Material.HOPPER, 10, TrollCategory.INVENTORY),
    INVENTORY_FLIP(63, "Inventory Flip", "Flips entire inventory", Material.PISTON, 8, TrollCategory.INVENTORY),
    FAKE_ENCHANTS(64, "Fake Enchants", "Shows fake enchantments", Material.ENCHANTING_TABLE, 20, TrollCategory.INVENTORY),
    ITEM_VANISH(65, "Item Vanish", "Makes items disappear temporarily", Material.GLASS_BOTTLE, 15, TrollCategory.INVENTORY),
    INVENTORY_CHAOS(66, "Inventory Chaos", "Random inventory effects", Material.SHULKER_BOX, 25, TrollCategory.INVENTORY),
    FAKE_REPAIR(67, "Fake Repair", "Shows fake item repair", Material.ANVIL, 12, TrollCategory.INVENTORY),
    ITEM_GRAVITY(68, "Item Gravity", "Items fall out of inventory", Material.DROPPER, 18, TrollCategory.INVENTORY),
    INVENTORY_MIRROR(69, "Inventory Mirror", "Mirrors another player's inventory", Material.ENDER_CHEST, 30, TrollCategory.INVENTORY),
    
    // Fake Category (20 trolls)
    FAKE_OP(70, "Fake OP", "Shows fake OP message", Material.COMMAND_BLOCK, 5, TrollCategory.FAKE),
    FAKE_DEATH(71, "Fake Death", "Shows fake death screen", Material.SKELETON_SKULL, 3, TrollCategory.FAKE),
    FAKE_BAN(72, "Fake Ban", "Shows fake ban message", Material.BARRIER, 8, TrollCategory.FAKE),
    FAKE_KICK(73, "Fake Kick", "Shows fake kick message", Material.IRON_DOOR, 5, TrollCategory.FAKE),
    FAKE_HACKER(74, "Fake Hacker", "Shows fake hacker accusations", Material.REDSTONE, 20, TrollCategory.FAKE),
    SERVER_CRASH(75, "Server Crash", "Shows fake server crash", Material.BEDROCK, 10, TrollCategory.FAKE),
    FAKE_WHITELIST(76, "Fake Whitelist", "Shows fake whitelist message", Material.PAPER, 8, TrollCategory.FAKE),
    FAKE_PROMOTION(77, "Fake Promotion", "Shows fake rank promotion", Material.GOLD_INGOT, 6, TrollCategory.FAKE),
    FAKE_ADMIN_VISIT(78, "Admin Visit", "Spawns fake admin near player", Material.COMMAND_BLOCK_MINECART, 15, TrollCategory.FAKE),
    FAKE_LOTTERY(79, "Fake Lottery", "Won fake lottery message", Material.EMERALD, 10, TrollCategory.FAKE),
    FAKE_DONATION(80, "Fake Donation", "Someone donated to you", Material.GOLD_BLOCK, 8, TrollCategory.FAKE),
    FAKE_FRIEND_JOIN(81, "Fake Friend Join", "Fake friend joined message", Material.PLAYER_HEAD, 12, TrollCategory.FAKE),
    FAKE_ACHIEVEMENT(82, "Fake Achievement", "Unlocked fake achievement", Material.EXPERIENCE_BOTTLE, 6, TrollCategory.FAKE),
    FAKE_VIRUS(83, "Fake Virus", "Computer virus detected", Material.REDSTONE_BLOCK, 15, TrollCategory.FAKE),
    FAKE_UPDATE(84, "Fake Update", "Minecraft update required", Material.BOOK, 20, TrollCategory.FAKE),
    FAKE_PREMIUM(85, "Fake Premium", "Upgraded to premium account", Material.DIAMOND, 10, TrollCategory.FAKE),
    FAKE_STREAMER(86, "Fake Streamer", "Famous streamer joined", Material.OBSERVER, 18, TrollCategory.FAKE),
    FAKE_CONTEST(87, "Fake Contest", "Won building contest", Material.GOLDEN_PICKAXE, 12, TrollCategory.FAKE),
    FAKE_STAFF_APP(88, "Fake Staff App", "Staff application accepted", Material.WRITABLE_BOOK, 15, TrollCategory.FAKE),
    FAKE_BETA_ACCESS(89, "Fake Beta Access", "Beta tester invitation", Material.ENDER_EYE, 10, TrollCategory.FAKE),
    
    // Chaos Category (10 trolls)
    CHICKEN_RAIN(90, "Chicken Rain", "Spawns falling chickens", Material.CHICKEN_SPAWN_EGG, 12, TrollCategory.CHAOS),
    RANDOM_SOUNDS(91, "Random Sounds", "Plays random sounds", Material.NOTE_BLOCK, 25, TrollCategory.CHAOS),
    POTION_CHAOS(92, "Potion Chaos", "Random potion effects", Material.BREWING_STAND, 15, TrollCategory.CHAOS),
    CHAOS_MODE(93, "Chaos Mode", "Random multiple effects", Material.NETHER_STAR, 30, TrollCategory.CHAOS),
    MOB_ARMY(94, "Mob Army", "Spawns army of harmless mobs", Material.ZOMBIE_SPAWN_EGG, 20, TrollCategory.CHAOS),
    BLOCK_PARTY(95, "Block Party", "Spawns random blocks everywhere", Material.JUKEBOX, 25, TrollCategory.CHAOS),
    WEATHER_CHAOS(96, "Weather Chaos", "Rapid weather changes", Material.LIGHTNING_ROD, 30, TrollCategory.CHAOS),
    TIME_CHAOS(97, "Time Chaos", "Rapid time changes", Material.CLOCK, 25, TrollCategory.CHAOS),
    SOUND_CHAOS(98, "Sound Chaos", "Overlapping random sounds", Material.JUKEBOX, 20, TrollCategory.CHAOS),
    EFFECT_CHAOS(99, "Effect Chaos", "Multiple random troll effects", Material.DRAGON_BREATH, 35, TrollCategory.CHAOS),
    
    // Extreme Category (10 trolls)
    GRAVITY_REVERSE(100, "Gravity Reverse", "Makes player fall upward", Material.ELYTRA, 15, TrollCategory.EXTREME),
    TIME_WARP(101, "Time Warp", "Changes player's time of day", Material.CLOCK, 60, TrollCategory.EXTREME),
    FAKE_WORLD_END(102, "World End", "Shows fake world deletion", Material.END_CRYSTAL, 20, TrollCategory.EXTREME),
    DIMENSION_SHIFT(103, "Dimension Shift", "Fake dimension change effects", Material.NETHER_PORTAL, 25, TrollCategory.EXTREME),
    REALITY_BREAK(104, "Reality Break", "Breaks player's reality", Material.DRAGON_EGG, 30, TrollCategory.EXTREME),
    MATRIX_MODE(105, "Matrix Mode", "Shows matrix-like effects", Material.LIME_DYE, 40, TrollCategory.EXTREME),
    FAKE_BIOS(106, "Fake BIOS", "Shows fake computer BIOS screen", Material.ITEM_FRAME, 5, TrollCategory.EXTREME),
    SYSTEM_OVERLOAD(107, "System Overload", "Fake system crash effects", Material.REDSTONE_BLOCK, 25, TrollCategory.EXTREME),
    GLITCH_PLAYER(108, "Glitch Player", "Player becomes glitchy", Material.OBSERVER, 20, TrollCategory.EXTREME),
    SIMULATION_END(109, "Simulation End", "Shows simulation ending", Material.END_PORTAL_FRAME, 30, TrollCategory.EXTREME);
    
    private final int id;
    private final String displayName;
    private final String description;
    private final Material material;
    private final int duration;
    private final TrollCategory category;
    
    TrollType(int id, String displayName, String description, Material material, int duration, TrollCategory category) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
        this.material = material;
        this.duration = duration;
        this.category = category;
    }
    
    public int getId() { return id; }
    public String getDisplayName() { return displayName; }
    public String getDescription() { return description; }
    public Material getMaterial() { return material; }
    public int getDuration() { return duration; }
    public TrollCategory getCategory() { return category; }
}