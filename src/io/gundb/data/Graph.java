package io.gundb.data;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class Graph implements Iterable<Node> {
    
    private final List<Node> nodes;
    
    public Graph(JSONObject source) {
        nodes = new LinkedList<Node>();
        
        for (String soul : source.keySet())
            nodes.add(new Node(source.getJSONObject(soul)));
    }

    public Node getNode(long soul) {
        int index = Collections.binarySearch(nodes, soul, null);
        if (index < 0)
            return null;
        return nodes.get(index);
    }

    public void addNode(Node incomingNode) {
        nodes.add(incomingNode);
        Collections.sort(nodes);
    }

    @Override
    public Iterator<Node> iterator() {
        return nodes.iterator();
    }
}
