package io.gundb.network;

import io.gundb.data.Node;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection extends Connection {
    
    public HttpConnection() {
        
    }
    
    @Override
    public void send(Node n) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) network.gun.url.openConnection();
        conn.setRequestMethod("PUT");
    }
    
    @Override
    public void request() throws IOException {
        HttpURLConnection conn = (HttpURLConnection) network.gun.url.openConnection();
        conn.setRequestMethod("GET");
    }
    
    class HttpConnectionHandler implements Runnable {
        
        Network network;
        URL url;
        
        public HttpConnectionHandler(Network network, URL url) {
            this.network = network;
            this.url = url;
        }

        @Override
        public void run() {
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}