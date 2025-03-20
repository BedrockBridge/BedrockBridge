package com.xpocketmc.bridge.config;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

/**
 * Manages configuration and language files.
 */
public class ConfigManager {
    private static YamlConfiguration messages;

    public static void loadConfig() {
        String lang = Main.getInstance().getConfig().getString("language", "en_US");
        File file = new File(Main.getInstance().getDataFolder(), "messages/" + lang + ".yml");
        
        if (!file.exists()) {
            Main.getInstance().saveResource("messages/" + lang + ".yml", false);
        }
        
        messages = YamlConfiguration.loadConfiguration(file);
    }

    public static String getMessage(String key) {
        return messages.getString("messages." + key, key);
    }
}
