package com.trollxplus.npcs;

import com.trollxplus.TrollXPlus;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TrollNPCManager {
    
    private final TrollXPlus plugin;
    private final Map<UUID, TrollNPC> activeNPCs = new HashMap<>();
    
    public TrollNPCManager(TrollXPlus plugin) {
        this.plugin = plugin;
    }
    
    public TrollNPC spawnFakePlayer(Player viewer, Location location, String name, String skinOwner) {
        TrollNPC npc = new TrollNPC(UUID.randomUUID(), name, location, skinOwner);
        activeNPCs.put(npc.getUUID(), npc);
        
        npc.spawn(viewer);
        
        // Auto-remove after 20 seconds
        new BukkitRunnable() {
            @Override
            public void run() {
                removeNPC(npc.getUUID(), viewer);
            }
        }.runTaskLater(plugin, 400);
        
        return npc;
    }
    
    public TrollNPC spawnFakeAdmin(Player viewer, Location location) {
        return spawnFakePlayer(viewer, location, "§c[ADMIN] TrollBot", "Notch");
    }
    
    public TrollNPC spawnFakeHacker(Player viewer, Location location) {
        return spawnFakePlayer(viewer, location, "§4[HACKER] xX_Pro_Xx", "Herobrine");
    }
    
    public void removeNPC(UUID npcId, Player viewer) {
        TrollNPC npc = activeNPCs.remove(npcId);
        if (npc != null) {
            npc.despawn(viewer);
        }
    }
    
    public void removeAllNPCs(Player viewer) {
        for (TrollNPC npc : activeNPCs.values()) {
            npc.despawn(viewer);
        }
        activeNPCs.clear();
    }
    
    public void cleanup() {
        for (TrollNPC npc : activeNPCs.values()) {
            if (npc.getArmorStand() != null) {
                npc.getArmorStand().remove();
            }
        }
        activeNPCs.clear();
    }
}