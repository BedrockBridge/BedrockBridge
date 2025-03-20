package com.xpocketmc.bridge;

import com.github.steveice10.mc.protocol.packet.ingame.clientbound.ClientboundChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.entity.ClientboundAddEntityPacket;
import com.github.steveice10.mc.protocol.packet.ingame.clientbound.level.ClientboundRespawnPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.level.ServerboundTeleportToEntityPacket;
import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.protocol.bedrock.packet.MovePlayerPacket;
import com.nukkitx.protocol.bedrock.packet.RespawnPacket;
import com.nukkitx.protocol.bedrock.packet.TextPacket;
import com.nukkitx.protocol.bedrock.packet.AddEntityPacket;

/**
 * Translates packets between Bedrock and Java.
 */
public class PacketTranslator {

    /**
     * Translates a Bedrock chat message to Java.
     * 
     * @param packet The Bedrock TextPacket.
     * @return The translated Java chat packet.
     */
    public static ServerboundChatPacket translateBedrockToJava(TextPacket packet) {
        return new ServerboundChatPacket(packet.getMessage());
    }

    /**
     * Translates a Java chat message to Bedrock.
     * 
     * @param packet The Java ClientboundChatPacket.
     * @return The translated Bedrock TextPacket.
     */
    public static TextPacket translateJavaToBedrock(ClientboundChatPacket packet) {
        TextPacket textPacket = new TextPacket();
        textPacket.setMessage(packet.getMessage());
        return textPacket;
    }

    /**
     * Translates a Bedrock respawn packet to Java.
     * 
     * @param packet The Bedrock RespawnPacket.
     * @return The translated Java respawn packet.
     */
    public static ClientboundRespawnPacket translateBedrockRespawn(RespawnPacket packet) {
        return new ClientboundRespawnPacket(0, (byte) 0, 0, (byte) 0, 0, 0, 0, 0);
    }

    /**
     * Translates a Java respawn packet to Bedrock.
     * 
     * @param packet The Java ClientboundRespawnPacket.
     * @return The translated Bedrock RespawnPacket.
     */
    public static RespawnPacket translateJavaRespawn(ClientboundRespawnPacket packet) {
        RespawnPacket respawnPacket = new RespawnPacket();
        respawnPacket.setRuntimeEntityId(0);
        respawnPacket.setPosition(Vector3f.ZERO);
        return respawnPacket;
    }

    /**
     * Translates a Bedrock movement packet to Java.
     * 
     * @param packet The Bedrock MovePlayerPacket.
     * @return The translated Java teleport packet.
     */
    public static ServerboundTeleportToEntityPacket translateBedrockMovement(MovePlayerPacket packet) {
        return new ServerboundTeleportToEntityPacket((int) packet.getRuntimeEntityId());
    }

    /**
     * Translates a Java entity spawn packet to Bedrock.
     * 
     * @param packet The Java ClientboundAddEntityPacket.
     * @return The translated Bedrock AddEntityPacket.
     */
    public static AddEntityPacket translateJavaSpawnEntity(ClientboundAddEntityPacket packet) {
        AddEntityPacket addEntityPacket = new AddEntityPacket();
        addEntityPacket.setRuntimeEntityId(packet.getEntityId());
        addEntityPacket.setPosition(Vector3f.from(packet.getX(), packet.getY(), packet.getZ()));
        return addEntityPacket;
    }
}
