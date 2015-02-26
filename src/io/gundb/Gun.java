package io.gundb;

import io.gundb.core.Database;
import io.gundb.core.HypotheticalAmnesiaMachine;
import io.gundb.core.Quarantine;
import io.gundb.network.Network;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Gun {

    public HypotheticalAmnesiaMachine ham;
    public Database db;
    public Quarantine quarantine;
    public Network network;
    
    public final URI url;
    
    public Gun(String urlStr) throws IOException, URISyntaxException {
        this(urlStr, "gun.json");
    }
    
    public Gun(String urlStr, String fileName) throws IOException, URISyntaxException {
        url = new URI(urlStr);
        ham = new HypotheticalAmnesiaMachine(this);
        db = new Database(this, fileName);
        quarantine = new Quarantine(this);
        network = Network.createNetwork(this, url);
    }
}
