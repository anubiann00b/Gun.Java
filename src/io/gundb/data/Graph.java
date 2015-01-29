package io.gundb.data;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;

public class Graph implements Iterable<Node> {
    
    private final List<Node> nodes;
    
    public Graph(JSONObject source) {
        nodes = new LinkedList<Node>();
        
        for (Object o : source.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            String soul = (String) entry.getKey();
            JSONObject node = (JSONObject) entry.getValue();
            
            nodes.add(new Node(node));
        }
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
