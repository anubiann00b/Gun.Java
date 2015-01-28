package io.gundb;

import org.json.simple.JSONObject;

public class Data implements Comparable<Data> {
    
    JSONObject value;
    long state;
    
    Data(JSONObject value, long state) {
        this.value = value;
        this.state = state;
    }

    @Override
    public int compareTo(Data other) {
        return Long.compare(state, other.state);
    }
}
