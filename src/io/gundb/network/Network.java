package io.gundb.network;

import io.gundb.Gun;
import io.gundb.data.Node;
import java.io.IOException;
import org.json.JSONObject;

public class Network {
    
    private final Connection conn;
    Gun gun;
    
    private Network(Gun gun, Connection conn) {
        this.gun = gun;
        conn.setNetwork(this);
        this.conn = conn;
    }
    
    public void connect() throws IOException {
        conn.connect();
    }
    
    public void send(Node n) {
        
    }
    
    void onRecieve(JSONObject data) {
        if (data.has("url")) { // Requesting data
            Node n = gun.db.getNodeFromPath(data.getJSONObject("url").getString("pathname"));
            send(n);
        } else { // Sending data
            gun.ham.handleIncomingData(new Node(data));
        }
    }
}