package io.gundb;

import java.io.IOException;

public class Gun {

    HypotheticalAmnesiaMachine ham;
    Database db;
    Quarantine quarantine;
    
    public Gun() throws IOException {
        this("gun.json");
    }
    
    public Gun(String fileName) throws IOException {
        ham = new HypotheticalAmnesiaMachine(this);
        db = new Database(this, fileName);
        quarantine = new Quarantine(this);
    }
}
