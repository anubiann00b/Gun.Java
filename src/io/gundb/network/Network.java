package io.gundb.network;

import java.io.IOException;

public class Network {
    
    private final Connection conn;
    
    private Network(Connection conn) {
        conn.setNetwork(this);
        this.conn = conn;
    }
    
    public void connect() throws IOException {
        conn.connect();
    }
    
    public void send() {
        
    }
    
    void onRecieve() {
        
    }
}