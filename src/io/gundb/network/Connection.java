package io.gundb.network;

import io.gundb.data.Node;
import java.io.IOException;

public abstract class Connection {
    
    protected Network network;
    
    public void setNetwork(Network network) {
        this.network = network;
    }
    
    public abstract void connect() throws IOException;

    public abstract void send(Node n);
}