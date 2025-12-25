package com.trollxplus.managers;

import com.trollxplus.TrollXPlus;
import com.trollxplus.trolls.TrollType;
import com.trollxplus.utils.TrollEffects;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TrollManager implements Listener {
    
    private final TrollXPlus plugin;
    private final TrollEffects trollEffects;
    private final Map<UUID, Long> cooldowns = new HashMap<>();
    private final Map<UUID, Map<TrollType, Long>> activeTrolls = new HashMap<>();
    
    public TrollManager(TrollXPlus plugin) {
        this.plugin = plugin;
        this.trollEffects = new TrollEffects(plugin);
    }
    
    public boolean executeTroll(Player executor, Player target, TrollType trollType) {
        // Check if plugin is enabled
        if (!plugin.getConfigManager().isPluginEnabled()) {
            return false;
        }
        
        // Check bypass permission
        if (target.hasPermission("trollxplus.bypass")) {
            executor.sendMessage(ChatColor.RED + target.getName() + " is immune to trolls!");
            return false;
        }
        
        // Check cooldown
        long cooldownTime = plugin.getConfigManager().getCooldown() * 1000L;
        UUID executorId = executor.getUniqueId();
        
        if (cooldowns.containsKey(executorId)) {
            long timeLeft = (cooldowns.get(executorId) + cooldownTime) - System.currentTimeMillis();
            if (timeLeft > 0) {
                executor.sendMessage(ChatColor.RED + "Cooldown: " + (timeLeft / 1000) + " seconds remaining!");
                return false;
            }
        }
        
        // Check if troll is already active on target
        UUID targetId = target.getUniqueId();
        if (activeTrolls.containsKey(targetId) && activeTrolls.get(targetId).containsKey(trollType)) {
            long endTime = activeTrolls.get(targetId).get(trollType);
            if (System.currentTimeMillis() < endTime) {
                executor.sendMessage(ChatColor.RED + "This troll is already active on " + target.getName() + "!");
                return false;
            }
        }
        
        // Execute the troll
        boolean success = trollEffects.executeTroll(target, trollType);
        
        if (success) {
            // Set cooldown
            cooldowns.put(executorId, System.currentTimeMillis());
            
            // Track active troll
            activeTrolls.computeIfAbsent(targetId, k -> new HashMap<>())
                .put(trollType, System.currentTimeMillis() + (trollType.getDuration() * 1000L));
            
            // Log the action
            plugin.getLogger().info(executor.getName() + " used " + trollType.getDisplayName() + " on " + target.getName());
        }
        
        return success;
    }
    
    public boolean isTrollActive(Player player, TrollType trollType) {
        UUID playerId = player.getUniqueId();
        if (!activeTrolls.containsKey(playerId)) return false;
        
        Map<TrollType, Long> playerTrolls = activeTrolls.get(playerId);
        if (!playerTrolls.containsKey(trollType)) return false;
        
        long endTime = playerTrolls.get(trollType);
        if (System.currentTimeMillis() >= endTime) {
            playerTrolls.remove(trollType);
            return false;
        }
        
        return true;
    }
    
    public void removeTroll(Player player, TrollType trollType) {
        UUID playerId = player.getUniqueId();
        if (activeTrolls.containsKey(playerId)) {
            activeTrolls.get(playerId).remove(trollType);
        }
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        UUID playerId = event.getPlayer().getUniqueId();
        activeTrolls.remove(playerId);
        cooldowns.remove(playerId);
    }
    
    public void cleanup() {
        activeTrolls.clear();
        cooldowns.clear();
    }
}