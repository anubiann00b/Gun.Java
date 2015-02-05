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
        conn.send(n);
    }
    
    void onRecieve(JSONObject data) {
        if (data.has("url")) { // Data request
            send(gun.db.getNodeFromKey(data.getJSONObject("url").getString("pathname")));
        } else if (data.has("body")) { // Data
            gun.ham.handleIncomingData(new Node(data));
        } else { // Key
            gun.db.addKey(data.getString("key"), data.getString("#"));
        }
    }
}