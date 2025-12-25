package com.trollxplus.utils;

import com.trollxplus.TrollXPlus;
import com.trollxplus.trolls.TrollType;
import com.trollxplus.utils.VersionUtils;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class TrollEffects {
    
    private final TrollXPlus plugin;
    private final Random random = new Random();
    
    public TrollEffects(TrollXPlus plugin) {
        this.plugin = plugin;
    }
    
    public boolean executeTroll(Player target, TrollType trollType) {
        try {
            switch (trollType) {
                case REVERSE_CONTROLS:
                    return reverseControls(target);
                case INVISIBLE_BLOCKS:
                    return invisibleBlocks(target);
                case JUMP_BOOST:
                    return jumpBoost(target);
                case RANDOM_TELEPORT:
                    return randomTeleport(target);
                case FAKE_LIGHTNING:
                    return fakeLightning(target);
                case FALLING_BLOCKS:
                    return fallingBlocks(target);
                case SLOW_MOTION:
                    return slowMotion(target);
                case SPEED_BOOST:
                    return speedBoost(target);
                case GRAVITY_FLIP:
                    return gravityFlip(target);
                case FREEZE_PLAYER:
                    return freezePlayer(target);
                case FAKE_EXPLOSION:
                    return fakeExplosion(target);
                case FAKE_FIRE:
                    return fakeFire(target);
                case BLOCK_MIRAGE:
                    return blockMirage(target);
                case UPSIDE_DOWN:
                    return upsideDown(target);
                case ENTITY_SWAP:
                    return entitySwap(target);
                case FAKE_VOID:
                    return fakeVoid(target);
                case TELEPORT_LOOP:
                    return teleportLoop(target);
                case ITEM_SHUFFLE:
                    return itemShuffle(target);
                case INVENTORY_LOCK:
                    return inventoryLock(target);
                case ITEM_MAGNET:
                    return itemMagnet(target);
                case FAKE_ITEMS:
                    return fakeItems(target);
                case INVENTORY_BOMB:
                    return inventoryBomb(target);
                case FAKE_OP:
                    return fakeOp(target);
                case FAKE_DEATH:
                    return fakeDeath(target);
                case FAKE_BAN:
                    return fakeBan(target);
                case FAKE_KICK:
                    return fakeKick(target);
                case FAKE_HACKER:
                    return fakeHacker(target);
                case SERVER_CRASH:
                    return serverCrash(target);
                case CHICKEN_RAIN:
                    return chickenRain(target);
                case RANDOM_SOUNDS:
                    return randomSounds(target);
                case POTION_CHAOS:
                    return potionChaos(target);
                case CHAOS_MODE:
                    return chaosMode(target);
                case GRAVITY_REVERSE:
                    return gravityReverse(target);
                case TIME_WARP:
                    return timeWarp(target);
                case FAKE_WORLD_END:
                    return fakeWorldEnd(target);
                case DIMENSION_SHIFT:
                    return dimensionShift(target);
                case SPIDER_CLIMB:
                    return spiderClimb(target);
                case DRUNK_WALK:
                    return drunkWalk(target);
                case RAINBOW_WORLD:
                    return rainbowWorld(target);
                case FAKE_LAVA_FLOOR:
                    return fakeLavaFloor(target);
                case TELEPORT_JAIL:
                    return teleportJail(target);
                case MIRROR_TELEPORT:
                    return mirrorTeleport(target);
                case ITEM_RENAME:
                    return itemRename(target);
                case HOTBAR_SHUFFLE:
                    return hotbarShuffle(target);
                case FAKE_WHITELIST:
                    return fakeWhitelist(target);
                case FAKE_PROMOTION:
                    return fakePromotion(target);
                case MOB_ARMY:
                    return mobArmy(target);
                case BLOCK_PARTY:
                    return blockParty(target);
                case REALITY_BREAK:
                    return realityBreak(target);
                case MATRIX_MODE:
                    return matrixMode(target);
                case FAKE_BIOS:
                    return fakeBios(target);
                case FAKE_ADMIN_VISIT:
                    return fakeAdminVisit(target);
                default:
                    // Default implementation for trolls without specific code
                    return defaultTrollEffect(target, trollType);
            }
        } catch (Exception e) {
            plugin.getLogger().warning("Error executing troll " + trollType.name() + ": " + e.getMessage());
            return false;
        }
    }
    
    private boolean reverseControls(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 200, 2));
        target.sendMessage(ChatColor.RED + "Your controls feel... different!");
        return true;
    }
    
    private boolean invisibleBlocks(Player target) {
        Location loc = target.getLocation();
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                Location blockLoc = loc.clone().add(x, -1, z);
                target.sendBlockChange(blockLoc, Material.AIR.createBlockData());
            }
        }
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = -2; x <= 2; x++) {
                    for (int z = -2; z <= 2; z++) {
                        Location blockLoc = loc.clone().add(x, -1, z);
                        target.sendBlockChange(blockLoc, blockLoc.getBlock().getBlockData());
                    }
                }
            }
        }.runTaskLater(plugin, 100);
        
        return true;
    }
    
    private boolean jumpBoost(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 240, 5));
        target.sendMessage(ChatColor.YELLOW + "You feel incredibly bouncy!");
        return true;
    }
    
    private boolean randomTeleport(Player target) {
        World world = target.getWorld();
        Location spawn = world.getSpawnLocation();
        Location newLoc = spawn.clone().add(
            random.nextInt(200) - 100,
            random.nextInt(50),
            random.nextInt(200) - 100
        );
        
        while (newLoc.getBlock().getType() != Material.AIR || 
               newLoc.clone().add(0, 1, 0).getBlock().getType() != Material.AIR) {
            newLoc.add(0, 1, 0);
            if (newLoc.getY() > 250) break;
        }
        
        target.teleport(newLoc);
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Whoosh! You've been teleported!");
        return true;
    }
    
    private boolean fakeLightning(Player target) {
        Location loc = target.getLocation();
        target.getWorld().strikeLightningEffect(loc);
        target.playSound(loc, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0f, 1.0f);
        target.sendMessage(ChatColor.YELLOW + "⚡ Lightning strikes near you!");
        return true;
    }
    
    private boolean fallingBlocks(Player target) {
        Location loc = target.getLocation().add(0, 10, 0);
        for (int i = 0; i < 5; i++) {
            Location spawnLoc = loc.clone().add(
                random.nextInt(6) - 3, 
                random.nextInt(3), 
                random.nextInt(6) - 3
            );
            
            FallingBlock block = target.getWorld().spawnFallingBlock(
                spawnLoc, 
                Material.SAND.createBlockData()
            );
            block.setDropItem(false);
            
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (block.isValid()) {
                        block.remove();
                    }
                }
            }.runTaskLater(plugin, 60);
        }
        return true;
    }
    
    private boolean slowMotion(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 400, 3));
        target.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 400, 2));
        target.sendMessage(ChatColor.BLUE + "Time slows down around you...");
        return true;
    }
    
    private boolean speedBoost(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 5));
        target.sendMessage(ChatColor.YELLOW + "Gotta go fast!");
        return true;
    }
    
    private boolean gravityFlip(Player target) {
        target.setVelocity(new Vector(0, 3, 0));
        target.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 200, 2));
        target.getWorld().spawnParticle(Particle.PORTAL, target.getLocation(), 50, 1, 1, 1, 0.1);
        target.sendMessage(ChatColor.DARK_PURPLE + "Gravity has been flipped!");
        target.playSound(target.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 0.5f);
        return true;
    }
    
    private boolean fakeExplosion(Player target) {
        Location loc = target.getLocation();
        Particle particle = VersionUtils.getCompatibleParticle("EXPLOSION_EMITTER", "EXPLOSION_HUGE");
        target.getWorld().spawnParticle(particle, loc, 1);
        target.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 2.0f, 0.5f);
        return true;
    }
    
    private boolean fakeFire(Player target) {
        Location loc = target.getLocation();
        for (int i = 0; i < 8; i++) {
            Location fireLoc = loc.clone().add(
                random.nextInt(6) - 3, 0, random.nextInt(6) - 3
            );
            target.sendBlockChange(fireLoc, Material.FIRE.createBlockData());
        }
        
        target.sendMessage(ChatColor.RED + "Fire surrounds you!");
        target.playSound(loc, Sound.BLOCK_FIRE_AMBIENT, 1.0f, 1.0f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int i = 0; i < 8; i++) {
                    Location fireLoc = loc.clone().add(
                        random.nextInt(6) - 3, 0, random.nextInt(6) - 3
                    );
                    target.sendBlockChange(fireLoc, fireLoc.getBlock().getBlockData());
                }
            }
        }.runTaskLater(plugin, 100);
        
        return true;
    }
    
    private boolean entitySwap(Player target) {
        Location loc = target.getLocation();
        Pig pig = (Pig) target.getWorld().spawnEntity(loc.clone().add(5, 0, 0), EntityType.PIG);
        
        target.teleport(pig.getLocation());
        pig.teleport(loc);
        
        target.sendMessage(ChatColor.GREEN + "You've swapped places with a pig!");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                pig.remove();
            }
        }.runTaskLater(plugin, 100);
        
        return true;
    }
    
    private boolean fakeVoid(Player target) {
        Location loc = target.getLocation();
        for (int x = -3; x <= 3; x++) {
            for (int z = -3; z <= 3; z++) {
                for (int y = -5; y <= -1; y++) {
                    Location blockLoc = loc.clone().add(x, y, z);
                    target.sendBlockChange(blockLoc, Material.AIR.createBlockData());
                }
            }
        }
        
        target.sendMessage(ChatColor.DARK_PURPLE + "The void opens beneath you!");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = -3; x <= 3; x++) {
                    for (int z = -3; z <= 3; z++) {
                        for (int y = -5; y <= -1; y++) {
                            Location blockLoc = loc.clone().add(x, y, z);
                            target.sendBlockChange(blockLoc, blockLoc.getBlock().getBlockData());
                        }
                    }
                }
            }
        }.runTaskLater(plugin, 120);
        
        return true;
    }
    
    private boolean itemShuffle(Player target) {
        ItemStack[] contents = target.getInventory().getContents();
        for (int i = 0; i < contents.length; i++) {
            int j = random.nextInt(contents.length);
            ItemStack temp = contents[i];
            contents[i] = contents[j];
            contents[j] = temp;
        }
        target.getInventory().setContents(contents);
        target.sendMessage(ChatColor.GOLD + "Your items have been shuffled!");
        return true;
    }
    
    private boolean inventoryLock(Player target) {
        target.sendMessage(ChatColor.RED + "Your inventory has been locked!");
        
        new BukkitRunnable() {
            int count = 0;
            @Override
            public void run() {
                if (count++ >= 10) {
                    target.sendMessage(ChatColor.GREEN + "Your inventory is now unlocked!");
                    cancel();
                    return;
                }
                target.closeInventory();
            }
        }.runTaskTimer(plugin, 0, 20);
        
        return true;
    }
    
    private boolean itemMagnet(Player target) {
        target.sendMessage(ChatColor.YELLOW + "You've become a magnet!");
        Location loc = target.getLocation();
        
        for (int i = 0; i < 10; i++) {
            Item item = target.getWorld().dropItem(
                loc.clone().add(random.nextInt(10) - 5, 2, random.nextInt(10) - 5),
                new ItemStack(Material.IRON_INGOT)
            );
            
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (item.isValid()) {
                        Vector direction = target.getLocation().toVector().subtract(item.getLocation().toVector()).normalize();
                        item.setVelocity(direction.multiply(0.5));
                    } else {
                        cancel();
                    }
                }
            }.runTaskTimer(plugin, 0, 2);
            
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (item.isValid()) item.remove();
                }
            }.runTaskLater(plugin, 100);
        }
        
        return true;
    }
    
    private boolean fakeOp(Player target) {
        target.sendMessage(ChatColor.GRAY + "[Server] Opped " + target.getName());
        target.sendMessage(ChatColor.YELLOW + "You are now op!");
        target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 2.0f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendMessage(ChatColor.RED + "Just kidding! You're not actually op.");
            }
        }.runTaskLater(plugin, 60);
        
        return true;
    }
    
    private boolean fakeDeath(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
        target.sendTitle(ChatColor.RED + "YOU DIED!", ChatColor.GRAY + "Just kidding!", 10, 40, 10);
        return true;
    }
    
    private boolean fakeBan(Player target) {
        target.sendTitle(ChatColor.DARK_RED + "BANNED", ChatColor.RED + "You have been banned from this server!", 10, 60, 10);
        target.playSound(target.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1.0f, 0.5f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendTitle(ChatColor.GREEN + "JUST KIDDING!", ChatColor.YELLOW + "You're not actually banned!", 10, 40, 10);
            }
        }.runTaskLater(plugin, 80);
        
        return true;
    }
    
    private boolean fakeKick(Player target) {
        target.sendMessage(ChatColor.RED + "You have been kicked from the server!");
        target.sendMessage(ChatColor.GRAY + "Reason: Trolled!");
        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 1));
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendMessage(ChatColor.GREEN + "Haha! You weren't actually kicked!");
            }
        }.runTaskLater(plugin, 60);
        
        return true;
    }
    
    private boolean chickenRain(Player target) {
        Location loc = target.getLocation().add(0, 20, 0);
        for (int i = 0; i < 10; i++) {
            Chicken chicken = (Chicken) target.getWorld().spawnEntity(
                loc.clone().add(random.nextInt(10) - 5, 0, random.nextInt(10) - 5),
                EntityType.CHICKEN
            );
            new BukkitRunnable() {
                @Override
                public void run() {
                    chicken.remove();
                }
            }.runTaskLater(plugin, 200);
        }
        return true;
    }
    
    private boolean randomSounds(Player target) {
        Sound[] sounds = {Sound.ENTITY_CAT_AMBIENT, Sound.ENTITY_COW_MILK, Sound.ENTITY_CHICKEN_EGG,
                         Sound.ENTITY_PIG_AMBIENT, Sound.ENTITY_SHEEP_AMBIENT};
        
        new BukkitRunnable() {
            int count = 0;
            @Override
            public void run() {
                if (count++ >= 10) {
                    cancel();
                    return;
                }
                Sound sound = sounds[random.nextInt(sounds.length)];
                target.playSound(target.getLocation(), sound, 1.0f, 1.0f);
            }
        }.runTaskTimer(plugin, 0, 20);
        
        return true;
    }
    
    private boolean potionChaos(Player target) {
        PotionEffectType[] effects = {
            PotionEffectType.SPEED, PotionEffectType.SLOWNESS, PotionEffectType.JUMP_BOOST,
            PotionEffectType.NAUSEA, PotionEffectType.REGENERATION, PotionEffectType.GLOWING
        };
        
        for (int i = 0; i < 3; i++) {
            PotionEffectType effect = effects[random.nextInt(effects.length)];
            target.addPotionEffect(new PotionEffect(effect, 200, random.nextInt(2)));
        }
        
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Magical chaos surrounds you!");
        return true;
    }
    
    private boolean chaosMode(Player target) {
        TrollType[] types = {TrollType.JUMP_BOOST, TrollType.SPEED_BOOST, TrollType.RANDOM_SOUNDS, TrollType.FAKE_EXPLOSION};
        for (TrollType type : types) {
            if (random.nextBoolean()) {
                executeTroll(target, type);
            }
        }
        target.sendMessage(ChatColor.DARK_RED + "CHAOS MODE ACTIVATED!");
        return true;
    }
    
    private boolean freezePlayer(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 300, 255));
        target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 300, 200));
        
        // Create ice prison effect
        Location loc = target.getLocation();
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int y = 0; y <= 2; y++) {
                    if (x != 0 || z != 0 || y != 1) {
                        Location iceLoc = loc.clone().add(x, y, z);
                        target.sendBlockChange(iceLoc, Material.ICE.createBlockData());
                    }
                }
            }
        }
        
        target.sendMessage(ChatColor.AQUA + "You are frozen in ice!");
        target.playSound(loc, Sound.BLOCK_GLASS_BREAK, 1.0f, 0.5f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = -1; x <= 1; x++) {
                    for (int z = -1; z <= 1; z++) {
                        for (int y = 0; y <= 2; y++) {
                            Location iceLoc = loc.clone().add(x, y, z);
                            target.sendBlockChange(iceLoc, iceLoc.getBlock().getBlockData());
                        }
                    }
                }
                target.sendMessage(ChatColor.GREEN + "The ice melts away!");
            }
        }.runTaskLater(plugin, 300);
        
        return true;
    }
    
    private boolean blockMirage(Player target) {
        Location loc = target.getLocation();
        Material[] valuableBlocks = {Material.DIAMOND_BLOCK, Material.NETHERITE_BLOCK, Material.EMERALD_BLOCK};
        
        // Create expanding ring of valuable blocks
        new BukkitRunnable() {
            int radius = 1;
            @Override
            public void run() {
                if (radius > 8) {
                    cancel();
                    return;
                }
                
                for (int x = -radius; x <= radius; x++) {
                    for (int z = -radius; z <= radius; z++) {
                        if (Math.abs(x) == radius || Math.abs(z) == radius) {
                            Location blockLoc = loc.clone().add(x, 0, z);
                            Material block = valuableBlocks[random.nextInt(valuableBlocks.length)];
                            target.sendBlockChange(blockLoc, block.createBlockData());
                        }
                    }
                }
                radius++;
            }
        }.runTaskTimer(plugin, 0, 10);
        
        target.sendMessage(ChatColor.GOLD + "Treasure appears around you!");
        target.playSound(loc, Sound.BLOCK_BEACON_ACTIVATE, 1.0f, 1.5f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = -8; x <= 8; x++) {
                    for (int z = -8; z <= 8; z++) {
                        Location blockLoc = loc.clone().add(x, 0, z);
                        target.sendBlockChange(blockLoc, blockLoc.getBlock().getBlockData());
                    }
                }
                target.sendMessage(ChatColor.RED + "It was all a mirage!");
                target.playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 0.5f, 2.0f);
            }
        }.runTaskLater(plugin, 200);
        
        return true;
    }
    
    private boolean upsideDown(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 400, 5));
        
        // Flip blocks above and below player
        Location loc = target.getLocation();
        for (int x = -3; x <= 3; x++) {
            for (int z = -3; z <= 3; z++) {
                Location topLoc = loc.clone().add(x, 3, z);
                Location bottomLoc = loc.clone().add(x, -3, z);
                
                // Swap the appearance of top and bottom blocks
                target.sendBlockChange(topLoc, bottomLoc.getBlock().getBlockData());
                target.sendBlockChange(bottomLoc, topLoc.getBlock().getBlockData());
            }
        }
        
        target.sendTitle(ChatColor.DARK_PURPLE + "˙ʇɥƃᴉɹ ǝpᴉsdn", ChatColor.GRAY + "Everything is flipped!", 10, 80, 10);
        target.playSound(loc, Sound.ENTITY_ENDERMAN_SCREAM, 1.0f, 0.1f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = -3; x <= 3; x++) {
                    for (int z = -3; z <= 3; z++) {
                        Location topLoc = loc.clone().add(x, 3, z);
                        Location bottomLoc = loc.clone().add(x, -3, z);
                        target.sendBlockChange(topLoc, topLoc.getBlock().getBlockData());
                        target.sendBlockChange(bottomLoc, bottomLoc.getBlock().getBlockData());
                    }
                }
                target.sendMessage(ChatColor.GREEN + "Reality has been restored!");
            }
        }.runTaskLater(plugin, 400);
        
        return true;
    }
    
    private boolean teleportLoop(Player target) {
        Location originalLoc = target.getLocation().clone();
        
        new BukkitRunnable() {
            int count = 0;
            double angle = 0;
            
            @Override
            public void run() {
                if (count++ >= 8) {
                    target.teleport(originalLoc);
                    target.sendMessage(ChatColor.GREEN + "Teleport loop complete!");
                    cancel();
                    return;
                }
                
                double x = originalLoc.getX() + Math.cos(angle) * 5;
                double z = originalLoc.getZ() + Math.sin(angle) * 5;
                Location newLoc = new Location(originalLoc.getWorld(), x, originalLoc.getY(), z);
                target.teleport(newLoc);
                angle += Math.PI / 4;
            }
        }.runTaskTimer(plugin, 0, 20);
        
        return true;
    }
    
    private boolean fakeItems(Player target) {
        ItemStack[] fakeItems = {
            new ItemStack(Material.DIAMOND, 64),
            new ItemStack(Material.NETHERITE_INGOT, 32),
            new ItemStack(Material.EMERALD, 64)
        };
        
        for (ItemStack item : fakeItems) {
            target.getInventory().addItem(item);
        }
        
        target.sendMessage(ChatColor.GREEN + "You received rare items!");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (ItemStack item : fakeItems) {
                    target.getInventory().remove(item);
                }
                target.sendMessage(ChatColor.RED + "The items were fake and disappeared!");
            }
        }.runTaskLater(plugin, 100);
        
        return true;
    }
    
    private boolean inventoryBomb(Player target) {
        ItemStack junk = new ItemStack(Material.DIRT, 1);
        for (int i = 0; i < 27; i++) {
            target.getInventory().addItem(junk.clone());
        }
        target.sendMessage(ChatColor.YELLOW + "Your inventory has been bombed with junk!");
        return true;
    }
    
    private boolean fakeHacker(Player target) {
        String[] messages = {
            "[ANTICHEAT] " + target.getName() + " is using speed hacks!",
            "[ANTICHEAT] " + target.getName() + " is using fly hacks!",
            "[ANTICHEAT] " + target.getName() + " is using x-ray!",
            "[ANTICHEAT] Banning " + target.getName() + " for hacking...",
            "[ANTICHEAT] Just kidding! " + target.getName() + " is clean!"
        };
        
        new BukkitRunnable() {
            int index = 0;
            
            @Override
            public void run() {
                if (index >= messages.length) {
                    cancel();
                    return;
                }
                
                target.sendMessage(ChatColor.RED + messages[index]);
                index++;
            }
        }.runTaskTimer(plugin, 0, 40);
        
        return true;
    }
    
    private boolean serverCrash(Player target) {
        target.sendTitle(ChatColor.DARK_RED + "SERVER CRASH", ChatColor.RED + "Server shutting down in 5...", 10, 20, 10);
        
        new BukkitRunnable() {
            int countdown = 4;
            
            @Override
            public void run() {
                if (countdown <= 0) {
                    target.sendTitle(ChatColor.GREEN + "JUST KIDDING!", ChatColor.YELLOW + "Server is fine!", 10, 40, 10);
                    cancel();
                    return;
                }
                
                target.sendTitle(ChatColor.DARK_RED + "SERVER CRASH", ChatColor.RED + "Server shutting down in " + countdown + "...", 0, 20, 0);
                countdown--;
            }
        }.runTaskTimer(plugin, 20, 20);
        
        return true;
    }
    
    private boolean gravityReverse(Player target) {
        // Give fall damage immunity
        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 400, 0));
        
        new BukkitRunnable() {
            int count = 0;
            
            @Override
            public void run() {
                if (count++ >= 15) {
                    cancel();
                    return;
                }
                
                target.setVelocity(new Vector(0, 1.5, 0)); // Increased from 0.3 to 1.5
            }
        }.runTaskTimer(plugin, 0, 15);
        
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Gravity has reversed!");
        return true;
    }
    
    private boolean timeWarp(Player target) {
        long[] times = {1000L, 6000L, 12000L, 18000L};
        long newTime = times[random.nextInt(times.length)];
        
        target.setPlayerTime(newTime, false);
        target.sendMessage(ChatColor.YELLOW + "Time has been warped!");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.resetPlayerTime();
            }
        }.runTaskLater(plugin, 1200);
        
        return true;
    }
    
    private boolean fakeWorldEnd(Player target) {
        target.sendMessage(ChatColor.DARK_RED + "[SERVER] World deletion in progress...");
        target.sendMessage(ChatColor.RED + "[SERVER] Deleting player data...");
        target.sendMessage(ChatColor.RED + "[SERVER] Removing world files...");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendMessage(ChatColor.GREEN + "[SERVER] Just kidding! Your world is safe!");
            }
        }.runTaskLater(plugin, 100);
        
        return true;
    }
    
    private boolean dimensionShift(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
        target.playSound(target.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 1.0f, 0.5f);
        
        Location loc = target.getLocation();
        target.getWorld().spawnParticle(Particle.PORTAL, loc, 100, 2, 2, 2, 0.1);
        
        target.sendMessage(ChatColor.DARK_PURPLE + "You feel reality shifting around you...");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendMessage(ChatColor.GREEN + "You're still in the same dimension!");
            }
        }.runTaskLater(plugin, 80);
        
        return true;
    }
    
    private boolean spiderClimb(Player target) {
        // Give fall damage immunity
        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 400, 0));
        target.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 300, 2)); // Increased from 0 to 2
        target.sendMessage(ChatColor.GREEN + "You can now climb walls like a spider!");
        return true;
    }
    
    private boolean drunkWalk(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 300, 3));
        
        // Create spinning particle effect
        new BukkitRunnable() {
            double angle = 0;
            int count = 0;
            @Override
            public void run() {
                if (count++ >= 30) {
                    cancel();
                    return;
                }
                
                Location loc = target.getLocation();
                for (int i = 0; i < 3; i++) {
                    double x = Math.cos(angle + i * Math.PI * 2 / 3) * 2;
                    double z = Math.sin(angle + i * Math.PI * 2 / 3) * 2;
                    loc.add(x, 1, z);
                    target.getWorld().spawnParticle(Particle.HAPPY_VILLAGER, loc, 1);
                    loc.subtract(x, 1, z);
                }
                
                Vector randomVel = new Vector(
                    (random.nextDouble() - 0.5) * 0.3,
                    0,
                    (random.nextDouble() - 0.5) * 0.3
                );
                target.setVelocity(randomVel);
                angle += 0.3;
            }
        }.runTaskTimer(plugin, 0, 10);
        
        target.sendMessage(ChatColor.YELLOW + "*hic* You feel very dizzy! *hic*");
        target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_BURP, 1.0f, 0.8f);
        return true;
    }
    
    private boolean rainbowWorld(Player target) {
        Location loc = target.getLocation();
        Material[] colors = {Material.RED_WOOL, Material.ORANGE_WOOL, Material.YELLOW_WOOL, 
                           Material.LIME_WOOL, Material.BLUE_WOOL, Material.PURPLE_WOOL, Material.PINK_WOOL};
        
        // Create expanding rainbow rings
        new BukkitRunnable() {
            int radius = 1;
            int colorIndex = 0;
            @Override
            public void run() {
                if (radius > 6) {
                    cancel();
                    return;
                }
                
                Material color = colors[colorIndex % colors.length];
                
                // Create ring of blocks
                for (double angle = 0; angle < Math.PI * 2; angle += 0.3) {
                    int x = (int) (Math.cos(angle) * radius);
                    int z = (int) (Math.sin(angle) * radius);
                    Location blockLoc = loc.clone().add(x, 0, z);
                    target.sendBlockChange(blockLoc, color.createBlockData());
                    
                    // Add particles
                    target.getWorld().spawnParticle(Particle.HAPPY_VILLAGER, blockLoc.clone().add(0, 1, 0), 2);
                }
                
                radius++;
                colorIndex++;
            }
        }.runTaskTimer(plugin, 0, 15);
        
        target.sendMessage(ChatColor.LIGHT_PURPLE + "🌈 Rainbow magic surrounds you! 🌈");
        target.playSound(loc, Sound.BLOCK_BEACON_POWER_SELECT, 1.0f, 2.0f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = -6; x <= 6; x++) {
                    for (int z = -6; z <= 6; z++) {
                        Location blockLoc = loc.clone().add(x, 0, z);
                        target.sendBlockChange(blockLoc, blockLoc.getBlock().getBlockData());
                    }
                }
                target.sendMessage(ChatColor.GRAY + "The rainbow fades away...");
            }
        }.runTaskLater(plugin, 400);
        
        return true;
    }
    
    private boolean fakeLavaFloor(Player target) {
        Location loc = target.getLocation();
        for (int x = -3; x <= 3; x++) {
            for (int z = -3; z <= 3; z++) {
                Location lavaLoc = loc.clone().add(x, -1, z);
                target.sendBlockChange(lavaLoc, Material.LAVA.createBlockData());
            }
        }
        
        target.sendMessage(ChatColor.RED + "The floor is lava!");
        target.playSound(target.getLocation(), Sound.BLOCK_LAVA_POP, 1.0f, 1.0f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = -3; x <= 3; x++) {
                    for (int z = -3; z <= 3; z++) {
                        Location lavaLoc = loc.clone().add(x, -1, z);
                        target.sendBlockChange(lavaLoc, lavaLoc.getBlock().getBlockData());
                    }
                }
            }
        }.runTaskLater(plugin, 300);
        
        return true;
    }
    
    private boolean teleportJail(Player target) {
        Location originalLoc = target.getLocation().clone();
        
        for (int x = -2; x <= 2; x++) {
            for (int y = 0; y <= 3; y++) {
                for (int z = -2; z <= 2; z++) {
                    if (x == -2 || x == 2 || z == -2 || z == 2 || y == 0 || y == 3) {
                        Location glassLoc = originalLoc.clone().add(x, y, z);
                        target.sendBlockChange(glassLoc, Material.GLASS.createBlockData());
                    }
                }
            }
        }
        
        target.sendMessage(ChatColor.GRAY + "You've been jailed!");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int x = -2; x <= 2; x++) {
                    for (int y = 0; y <= 3; y++) {
                        for (int z = -2; z <= 2; z++) {
                            if (x == -2 || x == 2 || z == -2 || z == 2 || y == 0 || y == 3) {
                                Location glassLoc = originalLoc.clone().add(x, y, z);
                                target.sendBlockChange(glassLoc, glassLoc.getBlock().getBlockData());
                            }
                        }
                    }
                }
                target.teleport(originalLoc);
            }
        }.runTaskLater(plugin, 400);
        
        return true;
    }
    
    private boolean mirrorTeleport(Player target) {
        Location loc = target.getLocation();
        Location spawn = loc.getWorld().getSpawnLocation();
        
        double deltaX = loc.getX() - spawn.getX();
        double deltaZ = loc.getZ() - spawn.getZ();
        
        Location mirrorLoc = spawn.clone().add(-deltaX, loc.getY(), -deltaZ);
        target.teleport(mirrorLoc);
        
        target.sendMessage(ChatColor.AQUA + "You've been mirrored!");
        return true;
    }
    
    private boolean itemRename(Player target) {
        String[] funnyNames = {"Useless Item", "Broken Thing", "Mystery Object", "Troll Item", "Fake Tool"};
        ItemStack[] originalItems = target.getInventory().getContents().clone();
        
        for (ItemStack item : target.getInventory().getContents()) {
            if (item != null && item.getType() != Material.AIR) {
                ItemMeta meta = item.getItemMeta();
                if (meta != null) {
                    meta.setDisplayName(ChatColor.YELLOW + funnyNames[random.nextInt(funnyNames.length)]);
                    item.setItemMeta(meta);
                }
            }
        }
        
        target.sendMessage(ChatColor.GOLD + "Your items have been renamed!");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.getInventory().setContents(originalItems);
                target.sendMessage(ChatColor.GREEN + "Your items have been restored!");
            }
        }.runTaskLater(plugin, 300);
        
        return true;
    }
    
    private boolean hotbarShuffle(Player target) {
        ItemStack[] originalHotbar = new ItemStack[9];
        for (int i = 0; i < 9; i++) {
            originalHotbar[i] = target.getInventory().getItem(i);
        }
        
        new BukkitRunnable() {
            int count = 0;
            @Override
            public void run() {
                if (count++ >= 10) {
                    target.getInventory().setContents(originalHotbar);
                    target.sendMessage(ChatColor.GREEN + "Your hotbar has been restored!");
                    cancel();
                    return;
                }
                
                ItemStack[] hotbar = new ItemStack[9];
                for (int i = 0; i < 9; i++) {
                    hotbar[i] = target.getInventory().getItem(i);
                }
                
                for (int i = 0; i < 9; i++) {
                    int j = random.nextInt(9);
                    ItemStack temp = hotbar[i];
                    hotbar[i] = hotbar[j];
                    hotbar[j] = temp;
                }
                
                for (int i = 0; i < 9; i++) {
                    target.getInventory().setItem(i, hotbar[i]);
                }
            }
        }.runTaskTimer(plugin, 0, 20);
        
        target.sendMessage(ChatColor.YELLOW + "Your hotbar is going crazy!");
        return true;
    }
    
    private boolean fakeWhitelist(Player target) {
        target.sendMessage(ChatColor.RED + "[SERVER] You are not whitelisted on this server!");
        target.sendMessage(ChatColor.GRAY + "[SERVER] Please contact an admin to be added.");
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendMessage(ChatColor.GREEN + "[SERVER] Just kidding! You're already whitelisted!");
            }
        }.runTaskLater(plugin, 80);
        
        return true;
    }
    
    private boolean fakePromotion(Player target) {
        target.sendMessage(ChatColor.GOLD + "[SERVER] Congratulations! You've been promoted to Admin!");
        target.sendMessage(ChatColor.YELLOW + "[SERVER] You now have access to all commands!");
        target.playSound(target.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendMessage(ChatColor.RED + "[SERVER] Promotion revoked! It was just a troll!");
            }
        }.runTaskLater(plugin, 100);
        
        return true;
    }
    
    private boolean mobArmy(Player target) {
        Location loc = target.getLocation();
        EntityType[] mobs = {EntityType.CHICKEN, EntityType.PIG, EntityType.COW, EntityType.SHEEP};
        
        for (int i = 0; i < 15; i++) {
            EntityType mobType = mobs[random.nextInt(mobs.length)];
            Entity mob = target.getWorld().spawnEntity(
                loc.clone().add(random.nextInt(10) - 5, 0, random.nextInt(10) - 5),
                mobType
            );
            
            // Make mob harmless
            if (mob instanceof LivingEntity) {
                ((LivingEntity) mob).setAI(false);
            }
            
            // Schedule removal
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (mob.isValid()) {
                        mob.remove();
                    }
                }
            }.runTaskLater(plugin, 400);
        }
        
        target.sendMessage(ChatColor.GREEN + "A mob army has appeared!");
        
        // Cleanup message
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendMessage(ChatColor.YELLOW + "The mob army has dispersed!");
            }
        }.runTaskLater(plugin, 400);
        
        return true;
    }
    
    private boolean blockParty(Player target) {
        Location loc = target.getLocation();
        Material[] blocks = {Material.DIAMOND_BLOCK, Material.GOLD_BLOCK, Material.EMERALD_BLOCK, 
                           Material.IRON_BLOCK, Material.REDSTONE_BLOCK};
        
        // Store changed block locations for restoration
        java.util.Set<Location> changedBlocks = new java.util.HashSet<>();
        
        new BukkitRunnable() {
            int count = 0;
            @Override
            public void run() {
                if (count++ >= 20) {
                    cancel();
                    return;
                }
                
                for (int i = 0; i < 5; i++) {
                    Location blockLoc = loc.clone().add(
                        random.nextInt(8) - 4, random.nextInt(4), random.nextInt(8) - 4
                    );
                    Material block = blocks[random.nextInt(blocks.length)];
                    target.sendBlockChange(blockLoc, block.createBlockData());
                    changedBlocks.add(blockLoc.clone());
                }
            }
        }.runTaskTimer(plugin, 0, 10);
        
        // Restore all changed blocks after effect ends
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Location blockLoc : changedBlocks) {
                    target.sendBlockChange(blockLoc, blockLoc.getBlock().getBlockData());
                }
                target.sendMessage(ChatColor.GREEN + "Block party ended!");
            }
        }.runTaskLater(plugin, 220); // 11 seconds (20 cycles * 10 ticks + buffer)
        
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Block party time!");
        return true;
    }
    
    private boolean realityBreak(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 300, 5));
        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
        
        target.sendTitle(ChatColor.DARK_RED + "REALITY.EXE", ChatColor.RED + "HAS STOPPED WORKING", 10, 60, 10);
        target.playSound(target.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1.0f, 0.1f);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendTitle(ChatColor.GREEN + "REALITY RESTORED", ChatColor.YELLOW + "Welcome back!", 10, 40, 10);
            }
        }.runTaskLater(plugin, 120);
        
        return true;
    }
    
    private boolean matrixMode(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 400, 1));
        target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 400, 4));
        target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 400, 1));
        
        Location loc = target.getLocation();
        
        // Create matrix rain effect
        new BukkitRunnable() {
            int count = 0;
            @Override
            public void run() {
                if (count++ >= 40) {
                    cancel();
                    return;
                }
                
                // Spawn green particles falling down
                for (int i = 0; i < 15; i++) {
                    Location particleLoc = loc.clone().add(
                        random.nextInt(20) - 10, 
                        random.nextInt(10) + 10, 
                        random.nextInt(20) - 10
                    );
                    
                    Particle particle = VersionUtils.getCompatibleParticle("HAPPY_VILLAGER", "VILLAGER_HAPPY");
                    target.getWorld().spawnParticle(particle, particleLoc, 1, 0, -1, 0, 0.1);
                }
                
                // Occasional glitch effect
                if (count % 8 == 0) {
                    target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5, 1));
                    target.playSound(loc, Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 0.5f);
                }
            }
        }.runTaskTimer(plugin, 0, 5);
        
        target.sendTitle(ChatColor.GREEN + "MATRIX MODE", ChatColor.DARK_GREEN + "Welcome to the real world", 10, 60, 10);
        target.sendMessage(ChatColor.GREEN + "You can see the code...");
        target.playSound(loc, Sound.BLOCK_PORTAL_AMBIENT, 1.0f, 0.1f);
        
        return true;
    }
    
    private boolean fakeBios(Player target) {
        // Store original game mode and location
        GameMode originalMode = target.getGameMode();
        Location originalLoc = target.getLocation().clone();
        
        // Teleport player 3 blocks down
        Location newLoc = originalLoc.clone().add(0, -3, 0);
        target.teleport(newLoc);
        
        // Create BIOS screen 3 blocks higher than player's new position
        Location biosLoc = newLoc.clone().add(0, 5, -3);
        
        // Create item frames in a grid pattern to simulate BIOS screen
        for (int x = -2; x <= 2; x++) {
            for (int y = 0; y <= 3; y++) {
                Location frameLoc = biosLoc.clone().add(x, y, 0);
                
                // Send fake item frame blocks
                target.sendBlockChange(frameLoc, Material.BLACK_CONCRETE.createBlockData());
                
                // Add some "text" using different colored blocks
                if (y == 3 && x == 0) {
                    target.sendBlockChange(frameLoc, Material.WHITE_CONCRETE.createBlockData());
                } else if (y == 2) {
                    target.sendBlockChange(frameLoc, Material.GRAY_CONCRETE.createBlockData());
                } else if (y == 1 && Math.abs(x) <= 1) {
                    target.sendBlockChange(frameLoc, Material.BLUE_CONCRETE.createBlockData());
                }
            }
        }
        
        // Show BIOS messages but don't freeze player
        target.sendTitle(ChatColor.WHITE + "BIOS", ChatColor.GRAY + "System Starting...", 10, 80, 10);
        target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 0.5f);
        
        // Restore everything after 5 seconds
        new BukkitRunnable() {
            @Override
            public void run() {
                // Restore position
                target.teleport(originalLoc);
                
                // Remove fake BIOS screen
                for (int x = -2; x <= 2; x++) {
                    for (int y = 0; y <= 3; y++) {
                        Location frameLoc = biosLoc.clone().add(x, y, 0);
                        target.sendBlockChange(frameLoc, frameLoc.getBlock().getBlockData());
                    }
                }
                
                target.sendTitle(ChatColor.GREEN + "SYSTEM READY", ChatColor.YELLOW + "Welcome back!", 10, 40, 10);
                target.sendMessage(ChatColor.GREEN + "System boot complete!");
            }
        }.runTaskLater(plugin, 100); // 5 seconds
        
        return true;
    }
    
    private boolean fakeAdminVisit(Player target) {
        Location spawnLoc = target.getLocation().clone().add(3, 0, 0);
        
        // Spawn fake admin NPC
        plugin.getNPCManager().spawnFakeAdmin(target, spawnLoc);
        
        // Send fake admin messages
        target.sendMessage("§c[ADMIN] TrollBot joined the game");
        target.sendMessage("§c[ADMIN] TrollBot: Checking player " + target.getName());
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendMessage("§c[ADMIN] TrollBot: Everything looks good!");
            }
        }.runTaskLater(plugin, 60);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                target.sendMessage("§c[ADMIN] TrollBot left the game");
            }
        }.runTaskLater(plugin, 100);
        
        return true;
    }
    
    private boolean defaultTrollEffect(Player target, TrollType trollType) {
        switch (trollType.getCategory()) {
            case MOVEMENT:
                target.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 100, 1));
                target.sendMessage(ChatColor.YELLOW + "You feel strange!");
                break;
            case VISUAL:
                target.getWorld().spawnParticle(Particle.SMOKE, target.getLocation(), 10);
                target.sendMessage(ChatColor.LIGHT_PURPLE + "Reality shifts around you!");
                break;
            case TELEPORT:
                Location loc = target.getLocation().clone().add(random.nextInt(10) - 5, 0, random.nextInt(10) - 5);
                target.teleport(loc);
                target.sendMessage(ChatColor.AQUA + "You've been moved!");
                break;
            case INVENTORY:
                target.getInventory().addItem(new ItemStack(Material.DIRT, 1));
                target.sendMessage(ChatColor.GOLD + "Your inventory feels different!");
                break;
            case FAKE:
                target.sendMessage(ChatColor.RED + "[SYSTEM] " + trollType.getDisplayName() + " activated!");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        target.sendMessage(ChatColor.GREEN + "[SYSTEM] Just kidding!");
                    }
                }.runTaskLater(plugin, 60);
                break;
            case CHAOS:
                target.playSound(target.getLocation(), Sound.ENTITY_CHICKEN_AMBIENT, 1.0f, 1.0f);
                target.getWorld().spawnParticle(Particle.EXPLOSION, target.getLocation(), 3);
                target.sendMessage(ChatColor.DARK_RED + "Chaos surrounds you!");
                break;
            case EXTREME:
                target.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 200, 3));
                target.sendTitle(ChatColor.DARK_RED + "SYSTEM ERROR", ChatColor.RED + trollType.getDisplayName(), 10, 40, 10);
                break;
        }
        return true;
    }
}