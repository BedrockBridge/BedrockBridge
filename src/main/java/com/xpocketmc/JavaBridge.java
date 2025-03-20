package com.xpocketmc.bridge;

import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.mc.protocol.packet.ingame.serverbound.ServerboundChatPacket;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;
import java.net.Proxy;

/**
 * Handles the Java connection.
 */
public class JavaBridge {
    private Client client;

    /**
     * Starts the Java connection.
     */
    public void start() {
        int port = Main.getInstance().getConfig().getInt("server.javaPort");
        client = new Client("localhost", port, new MinecraftProtocol("Bridge"), new TcpSessionFactory(Proxy.NO_PROXY));

        client.getSession().addListener(packet -> {
            if (packet instanceof ServerboundChatPacket chatPacket) {
                Main.getInstance().getLogger().info("Java Chat: " + chatPacket.getMessage());
            }
        });

        client.getSession().connect();
    }

    /**
     * Stops the Java connection.
     */
    public void stop() {
        if (client != null) {
            client.getSession().disconnect("Bridge shutting down.");
        }
    }
}
