package com.xpocketmc.bridge;

import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundSetBlockPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateBlockPacket;
import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 * Handles block and item synchronization.
 */
public class BlockItemSync {

    /**
     * Converts a Java block update packet to Bedrock.
     * 
     * @param packet The Java block update packet.
     * @return The translated Bedrock block update packet.
     */
    public static UpdateBlockPacket translateBlockJavaToBedrock(ClientboundSetBlockPacket packet) {
        UpdateBlockPacket updateBlockPacket = new UpdateBlockPacket();
        updateBlockPacket.setBlockRuntimeId(packet.getBlockState());
        return updateBlockPacket;
    }

    /**
     * Converts a Bedrock block update packet to Java.
     * 
     * @param block The Bukkit block.
     * @return The translated Java block state.
     */
    public static int translateBlockBedrockToJava(Block block) {
        Material material = block.getType();
        return material.getId();
    }
}
