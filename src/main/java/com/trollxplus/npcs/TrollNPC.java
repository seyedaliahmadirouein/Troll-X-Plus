package com.trollxplus.npcs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class TrollNPC {
    
    private final UUID uuid;
    private final String name;
    private final Location location;
    private final String skinName;
    private ArmorStand armorStand;
    
    public TrollNPC(UUID uuid, String name, Location location, String skinName) {
        this.uuid = uuid;
        this.name = name;
        this.location = location;
        this.skinName = skinName;
    }
    
    public void spawn(Player viewer) {
        armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setCustomName(name);
        armorStand.setCustomNameVisible(true);
        
        // Set player head as helmet
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        meta.setOwner(skinName);
        head.setItemMeta(meta);
        armorStand.getEquipment().setHelmet(head);
        
        // Make it look more player-like
        armorStand.setArms(true);
        armorStand.setBasePlate(false);
    }
    
    public void despawn(Player viewer) {
        if (armorStand != null && armorStand.isValid()) {
            armorStand.remove();
        }
    }
    
    public void moveTo(Location newLocation) {
        if (armorStand != null && armorStand.isValid()) {
            armorStand.teleport(newLocation);
        }
    }
    
    public void setName(String newName) {
        if (armorStand != null && armorStand.isValid()) {
            armorStand.setCustomName(newName);
        }
    }
    
    public UUID getUUID() { return uuid; }
    public String getName() { return name; }
    public Location getLocation() { return location; }
    public ArmorStand getArmorStand() { return armorStand; }
}