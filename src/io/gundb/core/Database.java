package io.gundb.core;

import io.gundb.Gun;
import io.gundb.data.Graph;
import io.gundb.data.Node;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class Database {
    
    Gun gun;
    
    Graph data;
    private final FileWriter writer;
    
    public Database(Gun gun, String fileName) throws IOException {
        this(gun, new File("fileName"));
    }
    
    public Database(Gun gun, File file) throws IOException {
        this.gun = gun;
        writer = new FileWriter(file);
    }
    
    void writeToFile() {
        JSONObject obj = new JSONObject();
        for (Node n : data) {
            obj.put(Long.toString(n.soul), n.values);
        }
        obj.write(writer);
    }

    void mergeNode(Node incomingNode) {
        long machineState = System.currentTimeMillis();
        Node currentNode = gun.db.data.getNode(incomingNode.soul);
        
        // New data!
        if (currentNode == null) {
            data.addNode(incomingNode);
            return;
        }
        for (String field : incomingNode.states.keySet()) {
            long incomingState = (Long) incomingNode.states.getLong(field);
            long currentState = currentNode.states.getLong(field);
            Object currentValue = currentNode.values.get(field);
            Object incomingValue = incomingNode.values.get(field);
            
            if (incomingState > machineState) {
                // Quarantine the new node.
                gun.quarantine.addTask(incomingNode, incomingState);
                break;
            } else if (currentValue.equals(incomingValue)) {
                // The value didn't change, don't need to do anything.
            } else if (incomingState < currentState) {
                // There's a newer update we have already.
            } else if (incomingState == currentState) {
                // Only merge if the incoming value is alphanumerically greater.
                if (incomingValue.toString().compareTo(currentValue.toString()) == 1)
                    currentNode.values.put(field, incomingValue);
            } else {
                // Merge away!
                currentNode.values.put(field, incomingValue);
            }
        }
    }

    public Node getNodeFromPath(String path) {
        String[] keys = path.split("/");
        
        Node root = data.getFirstNode();
        for (String key : keys) {
            if (!root.isNode(key))
                return null;
            root = root.getNode(key, data);
        }
        return root;
    }
}
