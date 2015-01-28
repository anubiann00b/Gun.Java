package io.gundb;

import org.json.simple.JSONObject;

public class Data {
    
    JSONObject value;
    long state;
    
    Data(JSONObject value, long state) {
        this.value = value;
        this.state = state;
    }
}
