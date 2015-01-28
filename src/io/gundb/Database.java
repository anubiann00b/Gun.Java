package io.gundb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Database {
    
    Gun gun;
    
    private Data data;
    private final FileWriter writer;
    
    Database(Gun gun, String fileName) throws IOException {
        this(gun, new File("fileName"));
    }
    
    Database(Gun gun, File file) throws IOException {
        this.gun = gun;
        writer = new FileWriter(file);
    }
    
    Data getData() {
        return data;
    }

    void mergeDeterministically(Data incoming) {
        // Only merge if alphabetically greater.
        if (data.value.toJSONString().compareTo(incoming.value.toJSONString()) > 0)
            merge(incoming);
    }

    void merge(Data data) {
        this.data = data;
        writeToFile();
    }
    
    void writeToFile() {
        try {
            data.value.writeJSONString(writer);
        } catch (IOException e) {
            Logger.log(e);
        }
    }
}
