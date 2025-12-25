package com.trollxplus.managers;

import com.trollxplus.TrollXPlus;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    
    private final TrollXPlus plugin;
    private FileConfiguration config;
    
    public ConfigManager(TrollXPlus plugin) {
        this.plugin = plugin;
        loadConfig();
    }
    
    private void loadConfig() {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
        
        // Set default values if not present
        if (!config.contains("plugin.enabled")) {
            config.set("plugin.enabled", true);
        }
        if (!config.contains("cooldown.seconds")) {
            config.set("cooldown.seconds", 5);
        }
        if (!config.contains("effects.duration-multiplier")) {
            config.set("effects.duration-multiplier", 1.0);
        }
        if (!config.contains("gui.sound-effects")) {
            config.set("gui.sound-effects", true);
        }
        if (!config.contains("logging.enabled")) {
            config.set("logging.enabled", true);
        }
        
        plugin.saveConfig();
    }
    
    public void reloadConfig() {
        plugin.reloadConfig();
        config = plugin.getConfig();
    }
    
    public boolean isPluginEnabled() {
        return config.getBoolean("plugin.enabled", true);
    }
    
    public boolean togglePlugin() {
        boolean current = isPluginEnabled();
        config.set("plugin.enabled", !current);
        plugin.saveConfig();
        return !current;
    }
    
    public int getCooldown() {
        return config.getInt("cooldown.seconds", 5);
    }
    
    public double getDurationMultiplier() {
        return config.getDouble("effects.duration-multiplier", 1.0);
    }
    
    public boolean isSoundEffectsEnabled() {
        return config.getBoolean("gui.sound-effects", true);
    }
    
    public boolean isLoggingEnabled() {
        return config.getBoolean("logging.enabled", true);
    }
}