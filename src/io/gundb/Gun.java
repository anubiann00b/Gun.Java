package io.gundb;

import io.gundb.core.Database;
import io.gundb.core.HypotheticalAmnesiaMachine;
import io.gundb.core.Quarantine;
import java.io.IOException;

public class Gun {

    public HypotheticalAmnesiaMachine ham;
    public Database db;
    public Quarantine quarantine;
    
    public Gun() throws IOException {
        this("gun.json");
    }
    
    public Gun(String fileName) throws IOException {
        ham = new HypotheticalAmnesiaMachine(this);
        db = new Database(this, fileName);
        quarantine = new Quarantine(this);
    }
}
