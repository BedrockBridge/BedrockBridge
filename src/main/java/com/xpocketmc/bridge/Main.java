package com.xpocketmc.bridge;

import com.xpocketmc.bridge.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class for BedrockBridge.
 */
public class Main extends JavaPlugin {
    private static Main instance;
    private BedrockBridge bedrockBridge;
    private JavaBridge javaBridge;
    
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        ConfigManager.loadConfig();

        bedrockBridge = new BedrockBridge();
        javaBridge = new JavaBridge();
        bedrockBridge.start();
        javaBridge.start();
        
        getLogger().info("Enable connection.");
    }

    @Override
    public void onDisable() {
        bedrockBridge.stop();
        javaBridge.stop();
        getLogger().info("Disable connection.");
    }

    public static Main getInstance() {
        return instance;
    }
}
