package csc223.dj;

public interface Graph {
    void addEdge(int v1, int v2);
    void removeEdge(int v1, int v2);
    boolean hasEdge(int v1, int v2);
    int[] getNeighbors(int vertex);
    int getNumVertices();
    void printGraph();
    String shortestPath(int startVertex, int endVertex);
}

