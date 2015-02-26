package io.gundb.network;

import io.gundb.data.Node;
import java.io.IOException;
import java.net.URI;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class WebsocketConnection extends WebSocketClient implements Connection {
    
    Network network;
    
    public WebsocketConnection(Network network, URI remote) {
        super(remote);
        this.network = network;
    }
    
    @Override
    public void request() throws IOException {
        //this.send("request");
    }

    @Override
    public void send(Node n) throws IOException {
        //this.send(n.toString());
    }

    @Override
    public void onOpen(ServerHandshake sh) {
        System.out.println("Connection opened: " + sh.getHttpStatus() + ": " + sh.getHttpStatusMessage());
    }

    @Override
    public void onMessage(String str) {
        System.out.println(str);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Closed: " + code + ": " + reason + (remote?" (Remote)":" (Local)"));
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }
}