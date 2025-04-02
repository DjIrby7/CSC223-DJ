package csc223.dj;

public class GraphTest {
    public static void main(String[] args) {
        System.out.println("Testing UnweightedGraph:");
        UnweightedGraph uwg = new UnweightedGraph(5);
        uwg.addEdge(0, 1);
        uwg.addEdge(1, 2);
        uwg.addEdge(2, 3);
        uwg.addEdge(3, 4);
        uwg.printGraph();
        System.out.println("Shortest path from 0 to 4: " + uwg.shortestPath(0, 4));

        System.out.println("\nTesting WeightedGraph:");
        WeightedGraph wg = new WeightedGraph(5);
        wg.addEdge(0, 1, 2);
        wg.addEdge(1, 2, 3);
        wg.addEdge(2, 3, 4);
        wg.addEdge(3, 4, 5);
        wg.printGraph();
        System.out.println("Shortest path from 0 to 4: " + wg.shortestPath(0, 4));
    }
}

