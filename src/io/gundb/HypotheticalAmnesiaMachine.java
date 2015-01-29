package io.gundb;

class HypotheticalAmnesiaMachine {
    
    Gun gun;
    
    HypotheticalAmnesiaMachine(Gun gun) {
        this.gun = gun;
    }
    
    public void handleIncomingData(Graph incoming) {
        for (Node incomingNode : incoming.nodes) {
            handleIncomingData(incomingNode);
        }
    }
    
    public void handleIncomingData(Node incomingNode) {
        gun.db.mergeNode(incomingNode);
    }
}
