package com.xpocketmc.bridge;

import org.geysermc.floodgate.api.FloodgateApi;
import org.bukkit.entity.Player;

/**
 * Manages player authentication.
 */
public class PlayerManager {

    /**
     * Checks if a player is using Bedrock edition.
     * 
     * @param player The player to check.
     * @return True if the player is from Bedrock, false otherwise.
     */
    public static boolean isBedrockPlayer(Player player) {
        return FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId());
    }
}
