package Programs;

import java.util.List;

public class Dijkstra_Algorithm {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add edges with distances
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 6);
        graph.addEdge("B", "D", 4);
        graph.addEdge("B", "E", 6);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "G", 12);
        graph.addEdge("E", "F", 5);
        graph.addEdge("E", "C", 7);
        graph.addEdge("E", "G", 6);
        graph.addEdge("C", "F", 6);
        graph.addEdge("F", "G", 8);

        // Calculate shortest path from A to G
        String startNode = "A";
        String targetNode = "E";
        List<String> path = graph.dijkstra(startNode, targetNode);

        // Print the shortest path
        System.out.println("Shortest path from " + startNode + " to " + targetNode + ": " + path);
    }
}
