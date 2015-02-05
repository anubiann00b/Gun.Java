package io.gundb;

import io.gundb.core.Database;
import io.gundb.core.HypotheticalAmnesiaMachine;
import io.gundb.core.Quarantine;
import java.io.IOException;
import java.net.URL;

public class Gun {

    public HypotheticalAmnesiaMachine ham;
    public Database db;
    public Quarantine quarantine;
    
    public final URL url;
    
    public Gun(String urlStr) throws IOException {
        this(urlStr, "gun.json");
    }
    
    public Gun(String urlStr, String fileName) throws IOException {
        url = new URL(urlStr);
        ham = new HypotheticalAmnesiaMachine(this);
        db = new Database(this, fileName);
        quarantine = new Quarantine(this);
    }
}
