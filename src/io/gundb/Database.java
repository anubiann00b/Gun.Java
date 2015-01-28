package io.gundb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class Database {
    
    Gun gun;
    
    private long currentState;
    private JSONObject currentValue;
    private FileWriter writer;
    
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

    void chooseAndMerge(JSONObject incomingValue) {
        if (getCurrentValue().equals(incomingValue))
            return;
        
        // Only merge if alphabetically greater.
        if (getCurrentValue().toJSONString().compareTo(incomingValue.toJSONString()) > 0)
            write(incomingValue);
    }

    void write(JSONObject value) {
        currentValue = value;
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
