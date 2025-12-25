package com.trollxplus.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class VersionUtils {
    
    private static final String VERSION = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    private static final int MAJOR_VERSION = Integer.parseInt(VERSION.split("_")[1]);
    private static final int MINOR_VERSION = Integer.parseInt(VERSION.split("_")[2].substring(1));
    
    public static boolean isVersion(int major, int minor) {
        return MAJOR_VERSION == major && MINOR_VERSION >= minor;
    }
    
    public static boolean isVersionOrHigher(int major, int minor) {
        return MAJOR_VERSION > major || (MAJOR_VERSION == major && MINOR_VERSION >= minor);
    }
    
    public static Material getCompatibleMaterial(String modern, String legacy) {
        try {
            return Material.valueOf(modern);
        } catch (IllegalArgumentException e) {
            try {
                return Material.valueOf(legacy);
            } catch (IllegalArgumentException ex) {
                return Material.STONE; // Fallback
            }
        }
    }
    
    public static Sound getCompatibleSound(String modern, String legacy) {
        try {
            return Sound.valueOf(modern);
        } catch (IllegalArgumentException e) {
            try {
                return Sound.valueOf(legacy);
            } catch (IllegalArgumentException ex) {
                return Sound.BLOCK_STONE_BREAK; // Fallback
            }
        }
    }
    
    public static Particle getCompatibleParticle(String modern, String legacy) {
        try {
            return Particle.valueOf(modern);
        } catch (IllegalArgumentException e) {
            try {
                return Particle.valueOf(legacy);
            } catch (IllegalArgumentException ex) {
                return Particle.SMOKE; // Fallback
            }
        }
    }
}