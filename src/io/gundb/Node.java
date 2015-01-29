package io.gundb;

import net.sf.json.JSONObject;

public class Node implements Comparable<Node> {
    
    JSONObject values;
    JSONObject states;
    long soul;
    
    /**
     * Create a Node from a string.
     * 
     * @param rawData 
     */
    Node(JSONObject rawData) {
        this.values = rawData;
        this.states = values.getJSONObject("_").getJSONObject(">");
        this.soul = values.getJSONObject("_").getLong("#");
        values.remove("_");
    }

    @Override
    public int compareTo(Node other) {
        return Long.compare(soul, other.soul);
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof Long)
            return ((Long) other) == soul;
        if (other instanceof Node)
            return compareTo((Node) other) == 0;
        return false;
    }

    @Override
    public int hashCode() {
        return (int) soul;
    }
}
