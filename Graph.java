package Programs;

import java.util.*;

public class Graph {
    private Map<String, Map<String, Integer>> nextToList;

    public Graph() {
    	nextToList = new HashMap<>();
    }

    // Add a connection (edge) between two nodes with a given distance
    public void addEdge(String from, String to, int distance) {
    	
        nextToList.putIfAbsent(from, new HashMap<>());
        nextToList.putIfAbsent(to, new HashMap<>());
        
        nextToList.get(from).put(to, distance);
        nextToList.get(to).put(from, distance); // Undirected graph
    }
    
    // Dijkstra's Algorithm to calculate shortest path from start to target
    public List<String> dijkstra(String start, String target) {
    	
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>(); // To reconstruct the path // use later
        
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        
        Set<String> visited = new HashSet<>();

     // Initialize distances
        nextToList.keySet().forEach(node -> distances.put(node, Integer.MAX_VALUE));
        distances.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();
            if (visited.contains(current)) continue;
            visited.add(current);

            // Stop if the target was reached
            if (current.equals(target)) break;

            for (Map.Entry<String, Integer> neighbor : nextToList.get(current).entrySet()) {
                String closerNode = neighbor.getKey();
                
                int newDist = distances.get(current) + neighbor.getValue();
                
                if (newDist < distances.get(closerNode)) {
                	
                    distances.put(closerNode, newDist); // Distances
                    previous.put(closerNode, current); // Track the path
                    pq.add(closerNode);
                }
            }
        }
        
        // Need to reconstruct the shortest path made
        List<String> path = new ArrayList<>();
        for (String at = target; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
		return path;
    }        
}
