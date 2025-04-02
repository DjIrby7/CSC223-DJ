package csc223.dj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UnweightedGraph implements Graph {
    private final boolean[][] adjMatrix;
    private final int numVertices;

    public UnweightedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = false;
            }
        }
    }
    @Override
    public void addEdge(int v1, int v2) {
        adjMatrix[v1][v2] = true;
        adjMatrix[v2][v1] = true;
    }
    @Override
    public void removeEdge(int v1, int v2) {
        adjMatrix[v1][v2] = false;
        adjMatrix[v2][v1] = false;
    }
    @Override
    public boolean hasEdge(int v1, int v2) {
        return adjMatrix[v1][v2];
    }
    @Override
    public int[] getNeighbors(int vertex) {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertex][i] == true) {
                count++;
            }
        }

        int[] neighbors = new int[count];
        int index = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertex][i] == true) {
                neighbors[index] = i;
                index++;
            }
        }

        return neighbors;
    }
    @Override
    public int getNumVertices() {
        return numVertices;
    }
    @Override
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            int[] neighbors = getNeighbors(i);
            for (int j = 0; j < neighbors.length; j++) {
                System.out.print(neighbors[j] + " ");
            }
            System.out.println();
        }
    }
    @Override
    public String shortestPath(int startVertex, int endVertex) {
        boolean[] visited = new boolean[numVertices];
        int[] previous = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
            previous[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int current = queue.remove();
            int[] neighbors = getNeighbors(current);
            for (int i = 0; i < neighbors.length; i++) {
                int neighbor = neighbors[i];
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    previous[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        if (!visited[endVertex]) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        int at = endVertex;
        while (at != -1) {
            path.push(at);
            at = previous[at];
        }

        String result = "";
        while (!path.isEmpty()) {
            result += path.pop();
            if (!path.isEmpty()) {
                result += " -> ";
            }
        }
        return result;
    }
}

