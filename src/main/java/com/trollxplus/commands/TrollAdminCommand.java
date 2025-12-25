package com.trollxplus.commands;

import com.trollxplus.TrollXPlus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TrollAdminCommand implements CommandExecutor {
    
    private final TrollXPlus plugin;
    
    public TrollAdminCommand(TrollXPlus plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("trollxplus.admin")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }
        
        if (args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "Usage: /trolladmin <reload|toggle>");
            return true;
        }
        
        switch (args[0].toLowerCase()) {
            case "reload":
                plugin.getConfigManager().reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "TrollXPlus configuration reloaded!");
                break;
            case "toggle":
                boolean enabled = plugin.getConfigManager().togglePlugin();
                sender.sendMessage(ChatColor.GREEN + "TrollXPlus " + (enabled ? "enabled" : "disabled") + "!");
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Unknown subcommand!");
                break;
        }
        
        return true;
    }
}