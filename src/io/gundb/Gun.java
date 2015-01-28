package io.gundb;

import java.io.IOException;

public class Gun {

    HypotheticalAmnesiaMachine ham;
    Database db;
    
    public Gun() throws IOException {
        this("gun.json");
    }
    
    public Gun(String fileName) throws IOException {
        ham = new HypotheticalAmnesiaMachine(this);
        db = new Database(this, fileName);
    }
}
