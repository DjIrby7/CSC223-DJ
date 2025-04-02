package csc223.dj;

public interface WeightedGraphInterface extends Graph {
    void addEdge(int v1, int v2, double weight);
    double getEdgeWeight(int v1, int v2);
    String shortestPath(int startVertex, int endVertex);
}
