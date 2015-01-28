package io.gundb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class Database {
    
    Gun gun;
    
    private long currentState;
    private JSONObject currentValue;
    private final FileWriter writer;
    
    Database(Gun gun, File file) throws IOException {
        this.gun = gun;
        writer = new FileWriter(file);
    }

    long getCurrentState() {
        return currentState;
    }
    
    JSONObject getCurrentValue() {
        return currentValue;
    }

    void mergeDeterministically(JSONObject incomingValue, long incomingState) {
        // Only merge if alphabetically greater.
        if (getCurrentValue().toJSONString().compareTo(incomingValue.toJSONString()) > 0)
            merge(incomingValue, incomingState);
    }

    void merge(JSONObject value, long state) {
        currentValue = value;
        currentState = state;
        writeToFile();
    }
    
    void writeToFile() {
        try {
            currentValue.writeJSONString(writer);
        } catch (IOException e) {
            Logger.log(e);
        }
    }
}
