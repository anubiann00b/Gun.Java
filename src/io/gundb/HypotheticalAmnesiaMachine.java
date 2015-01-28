package io.gundb;

import org.json.simple.JSONObject;

public class HypotheticalAmnesiaMachine {
    
    Gun gun;
    
    HypotheticalAmnesiaMachine(Gun gun) {
        this.gun = gun;
    }
    
    public void handleIncomingData(long incomingState, JSONObject incomingValue) {
        long machineState = System.currentTimeMillis();
        
        if (incomingState > machineState) {
            // amnesia quarantine
        } else if (incomingState < gun.db.getCurrentState()) {
            // in the past, ignore
        } else if (incomingState == gun.db.getCurrentState()) {
            gun.db.mergeDeterministically(incomingValue, incomingState);
        } else {
            gun.db.merge(incomingValue, incomingState);
        }
    }
}
