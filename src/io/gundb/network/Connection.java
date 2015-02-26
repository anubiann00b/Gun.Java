package io.gundb.network;

import io.gundb.data.Node;
import java.io.IOException;

public interface Connection {
    
    public abstract void request() throws IOException;
    public abstract void send(Node n) throws IOException;
}