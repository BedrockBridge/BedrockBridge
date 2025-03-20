package com.xpocketmc.bridge;

import com.nukkitx.protocol.bedrock.BedrockServer;
import com.nukkitx.protocol.bedrock.BedrockServerEventHandler;
import com.nukkitx.protocol.bedrock.BedrockServerSession;
import java.net.InetSocketAddress;

/**
 * Handles the Bedrock connection.
 */
public class BedrockBridge {
    private BedrockServer server;

    /**
     * Starts the Bedrock server.
     */
    public void start() {
        int port = Main.getInstance().getConfig().getInt("server.bedrockPort");
        server = new BedrockServer(new InetSocketAddress("0.0.0.0", port));
        server.setHandler(new BedrockServerEventHandler() {
            @Override
            public boolean onConnectionRequest(InetSocketAddress address) {
                return true;
            }

            @Override
            public void onSessionCreation(BedrockServerSession session) {
                session.addDisconnectHandler(reason ->
                    Main.getInstance().getLogger().info("Bedrock player disconnected: " + reason)
                );
            }
        });

        new Thread(server::bind).start();
    }

    /**
     * Stops the Bedrock server.
     */
    public void stop() {
        if (server != null) {
            server.close();
        }
    }
}
