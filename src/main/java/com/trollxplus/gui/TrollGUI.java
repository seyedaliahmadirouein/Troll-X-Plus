package com.trollxplus.gui;

import com.trollxplus.TrollXPlus;
import com.trollxplus.trolls.TrollCategory;
import com.trollxplus.trolls.TrollType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrollGUI implements Listener {
    
    private final TrollXPlus plugin;
    private final Map<Player, Player> playerTargets = new HashMap<>();
    private final Map<Player, TrollCategory> playerCategories = new HashMap<>();
    private final Map<Player, Integer> playerPages = new HashMap<>();
    
    public TrollGUI(TrollXPlus plugin) {
        this.plugin = plugin;
    }
    
    public void openGUI(Player player, Player target) {
        if (!plugin.getConfigManager().isPluginEnabled()) {
            player.sendMessage(ChatColor.RED + "TrollXPlus is currently disabled!");
            return;
        }
        
        playerTargets.put(player, target);
        openCategoryGUI(player);
    }
    
    private void openCategoryGUI(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "TrollXPlus - Categories");
        
        int slot = 10;
        for (TrollCategory category : TrollCategory.values()) {
            gui.setItem(slot, createCategoryItem(category));
            slot++;
        }
        
        Player target = playerTargets.get(player);
        gui.setItem(22, createItem(Material.PLAYER_HEAD, ChatColor.GREEN + "Target: " + target.getName(), "Current target player"));
        gui.setItem(26, createItem(Material.BARRIER, ChatColor.RED + "Close", "Click to close this menu"));
        
        player.openInventory(gui);
        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
    }
    
    private void openTrollGUI(Player player, TrollCategory category) {
        playerCategories.put(player, category);
        int page = playerPages.getOrDefault(player, 0);
        
        Inventory gui = Bukkit.createInventory(null, 54, ChatColor.DARK_RED + category.getDisplayName() + " (Page " + (page + 1) + ")");
        
        // Get trolls for this category
        TrollType[] categoryTrolls = TrollType.values();
        int trollsPerPage = 45;
        int startIndex = page * trollsPerPage;
        int slot = 0;
        
        for (int i = startIndex; i < categoryTrolls.length && slot < trollsPerPage; i++) {
            if (categoryTrolls[i].getCategory() == category) {
                gui.setItem(slot, createTrollItem(categoryTrolls[i]));
                slot++;
            }
        }
        
        // Fill empty slots
        for (int i = slot; i < 45; i++) {
            gui.setItem(i, createItem(Material.GRAY_STAINED_GLASS_PANE, " ", ""));
        }
        
        // Navigation buttons
        gui.setItem(45, createItem(Material.ARROW, ChatColor.YELLOW + "Back to Categories", "Return to category selection"));
        
        // Previous page button
        if (page > 0) {
            gui.setItem(46, createItem(Material.PAPER, ChatColor.GREEN + "Previous Page", "Go to page " + page));
        }
        
        // Next page button
        boolean hasNextPage = false;
        for (int i = (page + 1) * trollsPerPage; i < categoryTrolls.length; i++) {
            if (categoryTrolls[i].getCategory() == category) {
                hasNextPage = true;
                break;
            }
        }
        if (hasNextPage) {
            gui.setItem(52, createItem(Material.PAPER, ChatColor.GREEN + "Next Page", "Go to page " + (page + 2)));
        }
        
        gui.setItem(53, createItem(Material.BARRIER, ChatColor.RED + "Close", "Click to close this menu"));
        
        player.openInventory(gui);
        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
    }
    
    private ItemStack createCategoryItem(TrollCategory category) {
        String[] lore = getCategoryLore(category);
        ItemStack item = new ItemStack(category.getIcon());
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + category.getDisplayName());
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
    
    private String[] getCategoryLore(TrollCategory category) {
        switch (category) {
            case MOVEMENT:
                return new String[]{
                    "§x§f§f§0§0§0§0▰▰▰ §x§f§f§4§4§0§0M§x§f§f§8§8§0§0o§x§f§f§c§c§0§0v§x§f§f§f§f§0§0e§x§c§c§f§f§0§0m§x§8§8§f§f§0§0e§x§4§4§f§f§0§0n§x§0§0§f§f§0§0t §x§f§f§0§0§0§0▰▰▰",
                    "§7Control your target's movement",
                    "§8• Freeze, Speed, Slow, Jump",
                    "",
                    "§a▶ Click to explore!"
                };
            case VISUAL:
                return new String[]{
                    "§x§f§f§0§0§f§f✦ §x§e§e§0§0§e§eV§x§d§d§0§0§d§di§x§c§c§0§0§c§cs§x§b§b§0§0§b§bu§x§a§a§0§0§a§aa§x§9§9§0§0§9§9l §x§8§8§0§0§8§8E§x§7§7§0§0§7§7f§x§6§6§0§0§6§6f§x§5§5§0§0§5§5e§x§4§4§0§0§4§4c§x§3§3§0§0§3§3t§x§2§2§0§0§2§2s §x§f§f§0§0§f§f✦",
                    "§7Mess with what they see",
                    "§8• Fake blocks, explosions, fire",
                    "",
                    "§a▶ Click to explore!"
                };
            case TELEPORT:
                return new String[]{
                    "§x§8§8§0§0§f§f◆ §x§9§9§2§2§e§eT§x§a§a§4§4§d§de§x§b§b§6§6§c§cl§x§c§c§8§8§b§be§x§d§d§a§a§a§ap§x§e§e§c§c§9§9o§x§f§f§e§e§8§8r§x§f§f§f§f§7§7t §x§8§8§0§0§f§f◆",
                    "§7Transport players around",
                    "§8• Random teleports, swaps, loops",
                    "",
                    "§a▶ Click to explore!"
                };
            case INVENTORY:
                return new String[]{
                    "§x§f§f§8§8§0§0▣ §x§e§e§7§7§0§0I§x§d§d§6§6§0§0n§x§c§c§5§5§0§0v§x§b§b§4§4§0§0e§x§a§a§3§3§0§0n§x§9§9§2§2§0§0t§x§8§8§1§1§0§0o§x§7§7§0§0§0§0r§x§8§8§1§1§0§0y §x§f§f§8§8§0§0▣",
                    "§7Mess with their items",
                    "§8• Shuffle, lock, fake items",
                    "",
                    "§a▶ Click to explore!"
                };
            case FAKE:
                return new String[]{
                    "§x§f§f§0§0§0§0⚠ §x§e§e§1§1§1§1F§x§d§d§2§2§2§2a§x§c§c§3§3§3§3k§x§b§b§4§4§4§4e §x§a§a§5§5§5§5M§x§9§9§6§6§6§6e§x§8§8§7§7§7§7s§x§7§7§8§8§8§8s§x§6§6§9§9§9§9a§x§5§5§a§a§a§ag§x§4§4§b§b§b§be§x§3§3§c§c§c§cs §x§f§f§0§0§0§0⚠",
                    "§7Trick them with fake messages",
                    "§8• Fake OP, ban, kick, hacker",
                    "",
                    "§a▶ Click to explore!"
                };
            case CHAOS:
                return new String[]{
                    "§x§f§f§0§0§f§f★ §x§e§e§2§2§e§eC§x§d§d§4§4§d§dh§x§c§c§6§6§c§ca§x§b§b§8§8§b§bo§x§a§a§a§a§a§as §x§9§9§c§c§9§9& §x§8§8§e§e§8§8F§x§7§7§f§f§7§7u§x§6§6§f§f§6§6n §x§f§f§0§0§f§f★",
                    "§7Pure chaos and mayhem",
                    "§8• Random effects, sounds, mobs",
                    "",
                    "§a▶ Click to explore!"
                };
            case EXTREME:
                return new String[]{
                    "§x§f§f§0§0§0§0☢ §x§e§e§1§1§0§0E§x§d§d§2§2§0§0x§x§c§c§3§3§0§0t§x§b§b§4§4§0§0r§x§a§a§5§5§0§0e§x§9§9§6§6§0§0m§x§8§8§7§7§0§0e §x§7§7§8§8§0§0T§x§6§6§9§9§0§0r§x§5§5§a§a§0§0o§x§4§4§b§b§0§0l§x§3§3§c§c§0§0l§x§2§2§d§d§0§0s §x§f§f§0§0§0§0☢",
                    "§c§lWARNING: §7Most intense trolls",
                    "§8• Reality-bending effects",
                    "",
                    "§c▶ Click if you dare!"
                };
            default:
                return new String[]{"§7Click to view trolls", "", "§a▶ Click to open!"};
        }
    }
    
    private ItemStack createTrollItem(TrollType trollType) {
        return createItem(trollType.getMaterial(), 
            ChatColor.YELLOW + trollType.getDisplayName(),
            ChatColor.GRAY + trollType.getDescription(),
            "",
            ChatColor.GREEN + "Click to activate!");
    }
    
    private ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        String title = event.getView().getTitle();
        if (!title.contains("TrollXPlus") && !title.contains("Movement") && !title.contains("Visual") && 
            !title.contains("Teleportation") && !title.contains("Inventory") && !title.contains("Fake") && 
            !title.contains("Chaos") && !title.contains("Extreme")) return;
        
        event.setCancelled(true);
        
        if (!(event.getWhoClicked() instanceof Player)) return;
        
        Player player = (Player) event.getWhoClicked();
        Player target = playerTargets.get(player);
        
        if (target == null) {
            player.closeInventory();
            return;
        }
        
        ItemStack clicked = event.getCurrentItem();
        if (clicked == null || clicked.getType() == Material.AIR) return;
        
        // Handle close button
        if (clicked.getType() == Material.BARRIER) {
            player.closeInventory();
            playerTargets.remove(player);
            playerCategories.remove(player);
            return;
        }
        
        // Handle back button
        if (clicked.getType() == Material.ARROW) {
            playerPages.remove(player);
            openCategoryGUI(player);
            return;
        }
        
        // Handle pagination
        if (clicked.getType() == Material.PAPER) {
            String itemName = clicked.getItemMeta().getDisplayName();
            if (itemName.contains("Next Page")) {
                playerPages.put(player, playerPages.getOrDefault(player, 0) + 1);
                openTrollGUI(player, playerCategories.get(player));
                return;
            } else if (itemName.contains("Previous Page")) {
                playerPages.put(player, Math.max(0, playerPages.getOrDefault(player, 0) - 1));
                openTrollGUI(player, playerCategories.get(player));
                return;
            }
        }
        
        // Handle category selection
        if (title.contains("Categories")) {
            for (TrollCategory category : TrollCategory.values()) {
                if (clicked.getType() == category.getIcon()) {
                    openTrollGUI(player, category);
                    return;
                }
            }
        }
        
        // Handle troll selection
        TrollCategory currentCategory = playerCategories.get(player);
        if (currentCategory != null) {
            // Check by slot position instead of material type
            int slot = event.getSlot();
            if (slot < 45) {
                int trollIndex = 0;
                for (TrollType trollType : TrollType.values()) {
                    if (trollType.getCategory() == currentCategory) {
                        if (trollIndex == slot) {
                            if (plugin.getTrollManager().executeTroll(player, target, trollType)) {
                                player.sendMessage(ChatColor.GREEN + "Troll activated on " + target.getName() + "!");
                                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                            } else {
                                player.sendMessage(ChatColor.RED + "Failed to activate troll!");
                                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                            }
                            return;
                        }
                        trollIndex++;
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void onInventoryDrag(org.bukkit.event.inventory.InventoryDragEvent event) {
        String title = event.getView().getTitle();
        if (title.contains("TrollXPlus") || title.contains("Movement") || title.contains("Visual") || 
            title.contains("Teleportation") || title.contains("Inventory") || title.contains("Fake") || 
            title.contains("Chaos") || title.contains("Extreme")) {
            event.setCancelled(true);
        }
    }
}