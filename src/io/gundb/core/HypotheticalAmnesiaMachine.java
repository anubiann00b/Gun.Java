package io.gundb.core;

import io.gundb.Gun;
import io.gundb.data.Graph;
import io.gundb.data.Node;

public class HypotheticalAmnesiaMachine {
    
    Gun gun;
    
    public HypotheticalAmnesiaMachine(Gun gun) {
        this.gun = gun;
    }
    
    public void handleIncomingData(Graph incomingData) {
        for (Node incomingNode : incomingData) {
            handleIncomingData(incomingNode);
        }
    }
    
    public void handleIncomingData(Node incomingNode) {
        gun.db.mergeNode(incomingNode);
    }
}
