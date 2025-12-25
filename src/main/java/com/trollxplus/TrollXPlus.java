package com.trollxplus;

import com.trollxplus.commands.TrollCommand;
import com.trollxplus.commands.TrollAdminCommand;
import com.trollxplus.gui.TrollGUI;
import com.trollxplus.managers.TrollManager;
import com.trollxplus.managers.ConfigManager;
import com.trollxplus.npcs.TrollNPCManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TrollXPlus extends JavaPlugin {
    
    private static TrollXPlus instance;
    private TrollManager trollManager;
    private ConfigManager configManager;
    private TrollGUI trollGUI;
    private TrollNPCManager npcManager;
    
    @Override
    public void onEnable() {
        instance = this;
        
        // Initialize managers
        configManager = new ConfigManager(this);
        trollManager = new TrollManager(this);
        trollGUI = new TrollGUI(this);
        npcManager = new TrollNPCManager(this);
        
        // Register commands
        getCommand("troll").setExecutor(new TrollCommand(this));
        getCommand("trolladmin").setExecutor(new TrollAdminCommand(this));
        
        // Register events
        getServer().getPluginManager().registerEvents(trollGUI, this);
        getServer().getPluginManager().registerEvents(trollManager, this);
        
        getLogger().info("TrollXPlus has been enabled!");
    }
    
    @Override
    public void onDisable() {
        if (trollManager != null) {
            trollManager.cleanup();
        }
        getLogger().info("TrollXPlus has been disabled!");
    }
    
    public static TrollXPlus getInstance() {
        return instance;
    }
    
    public TrollManager getTrollManager() {
        return trollManager;
    }
    
    public ConfigManager getConfigManager() {
        return configManager;
    }
    
    public TrollGUI getTrollGUI() {
        return trollGUI;
    }
    
    public TrollNPCManager getNPCManager() {
        return npcManager;
    }
}