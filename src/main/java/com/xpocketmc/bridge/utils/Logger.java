package com.xpocketmc.bridge.utils;

import org.bukkit.Bukkit;
import java.util.logging.Level;

/**
 * Custom logger for BedrockBridge.
 */
public class Logger {
    public static void info(String message) {
        Bukkit.getLogger().log(Level.INFO, "[BedrockBridge] " + message);
    }

    public static void warning(String message) {
        Bukkit.getLogger().log(Level.WARNING, "[BedrockBridge] " + message);
    }

    public static void error(String message) {
        Bukkit.getLogger().log(Level.SEVERE, "[BedrockBridge] " + message);
    }
}
