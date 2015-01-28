package io.gundb;

public class HypotheticalAmnesiaMachine {
    
    Gun gun;
    
    HypotheticalAmnesiaMachine(Gun gun) {
        this.gun = gun;
    }
    
    public void handleIncomingData(Data incoming) {
        long machineState = System.currentTimeMillis();
        
        if (incoming.state > machineState) {
            // amnesia quarantine
        } else if (incoming.state < gun.db.getData().state) {
            // in the past, ignore
        } else if (incoming.state == gun.db.getData().state) {
            gun.db.mergeDeterministically(incoming);
        } else {
            gun.db.merge(incoming);
        }
    }
}
