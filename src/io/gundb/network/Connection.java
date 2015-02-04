package io.gundb.network;

import java.io.IOException;

public abstract class Connection {
    
    protected Network network;
    
    public void setNetwork(Network network) {
        this.network = network;
    }
    
    public abstract void connect() throws IOException;
}