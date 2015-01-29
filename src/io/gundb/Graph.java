package io.gundb;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;

public class Graph {
    
    List<Node> nodes;
    
    public Graph(JSONObject source) {
        nodes = new LinkedList<Node>();
        
        for (Object o : source.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            String soul = (String) entry.getKey();
            JSONObject node = (JSONObject) entry.getValue();
            
            nodes.add(new Node(node));
        }
    }

    Node getNode(long soul) {
        int index = Collections.binarySearch(nodes, soul, null);
        if (index < 0)
            return null;
        return nodes.get(index);
    }

    void addNode(Node incomingNode) {
        nodes.add(incomingNode);
        Collections.sort(nodes);
    }
}
