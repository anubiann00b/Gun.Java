package io.gundb.data;

import org.json.JSONObject;

public class Node implements Comparable<Node> {
    
    public final JSONObject values;
    public final JSONObject states;
    public final long soul;
    
    /**
     * Create a Node from a string.
     * 
     * @param rawData 
     */
    public Node(JSONObject rawData) {
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

    public boolean isNode(String key) {
        return values.optJSONObject(key) != null;
    }

    public Node getNode(String key, Graph g) {
        long soulRef = values.getJSONObject(key).getLong("#");
        Node n = g.getNode(soulRef);
        return n;
    }
}
