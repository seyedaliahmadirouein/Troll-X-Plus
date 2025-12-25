package com.trollxplus.trolls;

import org.bukkit.Material;

public enum TrollType {
    // Movement Category
    REVERSE_CONTROLS(0, "Reverse Controls", "Reverses player movement", Material.COMPASS, 10, TrollCategory.MOVEMENT),
    JUMP_BOOST(1, "Jump Boost", "Gives extreme jump boost", Material.RABBIT_FOOT, 12, TrollCategory.MOVEMENT),
    SLOW_MOTION(2, "Slow Motion", "Slows player movement", Material.COBWEB, 20, TrollCategory.MOVEMENT),
    SPEED_BOOST(3, "Speed Boost", "Extreme speed effect", Material.SUGAR, 8, TrollCategory.MOVEMENT),
    GRAVITY_FLIP(4, "Gravity Flip", "Flips player gravity", Material.FEATHER, 12, TrollCategory.MOVEMENT),
    FREEZE_PLAYER(5, "Freeze Player", "Completely freezes player movement", Material.ICE, 15, TrollCategory.MOVEMENT),
    SPIDER_CLIMB(6, "Spider Climb", "Makes player stick to walls", Material.SPIDER_EYE, 20, TrollCategory.MOVEMENT),
    DRUNK_WALK(7, "Drunk Walk", "Makes player walk randomly", Material.POTION, 25, TrollCategory.MOVEMENT),
    
    // Visual Category
    INVISIBLE_BLOCKS(8, "Invisible Blocks", "Makes blocks around player invisible", Material.GLASS, 8, TrollCategory.VISUAL),
    FAKE_LIGHTNING(9, "Fake Lightning", "Creates fake lightning strike", Material.LIGHTNING_ROD, 7, TrollCategory.VISUAL),
    FALLING_BLOCKS(10, "Falling Blocks", "Fake falling blocks around player", Material.SAND, 6, TrollCategory.VISUAL),
    FAKE_EXPLOSION(11, "Fake Explosion", "Harmless explosion visuals", Material.TNT, 5, TrollCategory.VISUAL),
    FAKE_FIRE(12, "Fake Fire", "Harmless fire effects", Material.FLINT_AND_STEEL, 8, TrollCategory.VISUAL),
    BLOCK_MIRAGE(13, "Block Mirage", "Shows fake diamond blocks", Material.DIAMOND_BLOCK, 30, TrollCategory.VISUAL),
    UPSIDE_DOWN(14, "Upside Down", "Flips player's view upside down", Material.FERMENTED_SPIDER_EYE, 20, TrollCategory.VISUAL),
    RAINBOW_WORLD(15, "Rainbow World", "Makes world colorful", Material.PRISMARINE_CRYSTALS, 30, TrollCategory.VISUAL),
    FAKE_LAVA_FLOOR(16, "Fake Lava Floor", "Shows lava beneath player", Material.LAVA_BUCKET, 15, TrollCategory.VISUAL),
    
    // Teleport Category
    RANDOM_TELEPORT(17, "Random Teleport", "Teleports to random location", Material.ENDER_PEARL, 3, TrollCategory.TELEPORT),
    ENTITY_SWAP(18, "Entity Swap", "Swaps player with nearby entity", Material.LEAD, 12, TrollCategory.TELEPORT),
    FAKE_VOID(19, "Fake Void", "Shows fake void beneath", Material.OBSIDIAN, 6, TrollCategory.TELEPORT),
    TELEPORT_LOOP(20, "Teleport Loop", "Teleports player in circles", Material.CHORUS_FRUIT, 25, TrollCategory.TELEPORT),
    TELEPORT_JAIL(21, "Teleport Jail", "Traps player in glass box", Material.GLASS_PANE, 20, TrollCategory.TELEPORT),
    MIRROR_TELEPORT(22, "Mirror Teleport", "Teleports to mirrored location", Material.AMETHYST_SHARD, 10, TrollCategory.TELEPORT),
    
    // Inventory Category
    ITEM_SHUFFLE(23, "Item Shuffle", "Shuffles player inventory", Material.CHEST, 5, TrollCategory.INVENTORY),
    INVENTORY_LOCK(24, "Inventory Lock", "Temporarily locks inventory", Material.IRON_BARS, 20, TrollCategory.INVENTORY),
    ITEM_MAGNET(25, "Item Magnet", "Items fly toward player", Material.MAGMA_CREAM, 14, TrollCategory.INVENTORY),
    FAKE_ITEMS(26, "Fake Items", "Gives fake items that disappear", Material.GOLDEN_APPLE, 10, TrollCategory.INVENTORY),
    INVENTORY_BOMB(27, "Inventory Bomb", "Fills inventory with junk", Material.DIRT, 8, TrollCategory.INVENTORY),
    ITEM_RENAME(28, "Item Rename", "Renames all player items", Material.NAME_TAG, 12, TrollCategory.INVENTORY),
    HOTBAR_SHUFFLE(29, "Hotbar Shuffle", "Constantly shuffles hotbar", Material.DISPENSER, 15, TrollCategory.INVENTORY),
    
    // Fake Category
    FAKE_OP(30, "Fake OP", "Shows fake OP message", Material.COMMAND_BLOCK, 5, TrollCategory.FAKE),
    FAKE_DEATH(31, "Fake Death", "Shows fake death screen", Material.SKELETON_SKULL, 3, TrollCategory.FAKE),
    FAKE_BAN(32, "Fake Ban", "Shows fake ban message", Material.BARRIER, 8, TrollCategory.FAKE),
    FAKE_KICK(33, "Fake Kick", "Shows fake kick message", Material.IRON_DOOR, 5, TrollCategory.FAKE),
    FAKE_HACKER(34, "Fake Hacker", "Shows fake hacker accusations", Material.REDSTONE, 20, TrollCategory.FAKE),
    SERVER_CRASH(35, "Server Crash", "Shows fake server crash", Material.BEDROCK, 10, TrollCategory.FAKE),
    FAKE_WHITELIST(36, "Fake Whitelist", "Shows fake whitelist message", Material.PAPER, 8, TrollCategory.FAKE),
    FAKE_PROMOTION(37, "Fake Promotion", "Shows fake rank promotion", Material.GOLD_INGOT, 6, TrollCategory.FAKE),
    
    // Chaos Category
    CHICKEN_RAIN(38, "Chicken Rain", "Spawns falling chickens", Material.CHICKEN_SPAWN_EGG, 12, TrollCategory.CHAOS),
    RANDOM_SOUNDS(39, "Random Sounds", "Plays random sounds", Material.NOTE_BLOCK, 25, TrollCategory.CHAOS),
    POTION_CHAOS(40, "Potion Chaos", "Random potion effects", Material.BREWING_STAND, 15, TrollCategory.CHAOS),
    CHAOS_MODE(41, "Chaos Mode", "Random multiple effects", Material.NETHER_STAR, 30, TrollCategory.CHAOS),
    MOB_ARMY(42, "Mob Army", "Spawns army of harmless mobs", Material.ZOMBIE_SPAWN_EGG, 20, TrollCategory.CHAOS),
    BLOCK_PARTY(43, "Block Party", "Spawns random blocks everywhere", Material.JUKEBOX, 25, TrollCategory.CHAOS),
    
    // Extreme Category
    GRAVITY_REVERSE(44, "Gravity Reverse", "Makes player fall upward", Material.ELYTRA, 15, TrollCategory.EXTREME),
    TIME_WARP(45, "Time Warp", "Changes player's time of day", Material.CLOCK, 60, TrollCategory.EXTREME),
    FAKE_WORLD_END(46, "World End", "Shows fake world deletion", Material.END_CRYSTAL, 20, TrollCategory.EXTREME),
    DIMENSION_SHIFT(47, "Dimension Shift", "Fake dimension change effects", Material.NETHER_PORTAL, 25, TrollCategory.EXTREME),
    REALITY_BREAK(48, "Reality Break", "Breaks player's reality", Material.DRAGON_EGG, 30, TrollCategory.EXTREME),
    MATRIX_MODE(49, "Matrix Mode", "Shows matrix-like effects", Material.LIME_DYE, 40, TrollCategory.EXTREME);
    
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