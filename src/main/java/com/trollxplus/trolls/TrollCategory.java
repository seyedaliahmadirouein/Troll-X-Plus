package com.trollxplus.trolls;

import org.bukkit.Material;

public enum TrollCategory {
    MOVEMENT("Movement", Material.LEATHER_BOOTS),
    VISUAL("Visual Effects", Material.ENDER_EYE),
    TELEPORT("Teleportation", Material.ENDER_PEARL),
    INVENTORY("Inventory", Material.CHEST),
    FAKE("Fake Messages", Material.COMMAND_BLOCK),
    CHAOS("Chaos & Fun", Material.NETHER_STAR),
    EXTREME("Extreme Trolls", Material.TNT);
    
    private final String displayName;
    private final Material icon;
    
    TrollCategory(String displayName, Material icon) {
        this.displayName = displayName;
        this.icon = icon;
    }
    
    public String getDisplayName() { return displayName; }
    public Material getIcon() { return icon; }
}