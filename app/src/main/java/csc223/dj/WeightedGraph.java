package csc223.dj;

import java.util.Stack;

public class WeightedGraph implements WeightedGraphInterface {
    private final double[][] adjMatrix;
    private final int numVertices;

    public WeightedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new double[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = -1;
            }
        }
    }
    @Override
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, 1);
    }
    @Override
    public void addEdge(int v1, int v2, double weight) {
        adjMatrix[v1][v2] = weight;
        adjMatrix[v2][v1] = weight;
    }
    @Override
    public void removeEdge(int v1, int v2) {
        adjMatrix[v1][v2] = -1;
        adjMatrix[v2][v1] = -1;
    }
    @Override
    public boolean hasEdge(int v1, int v2) {
        return adjMatrix[v1][v2] != -1;
    }
    @Override
    public double getEdgeWeight(int v1, int v2) {
        return adjMatrix[v1][v2];
    }
    @Override
    public int[] getNeighbors(int vertex) {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertex][i] != -1) {
                count++;
            }
        }

        int[] neighbors = new int[count];
        int index = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertex][i] != -1) {
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
                System.out.print(neighbors[j] + "(" + adjMatrix[i][neighbors[j]] + ") ");
            }
            System.out.println();
        }
    }
    @Override
    public String shortestPath(int startVertex, int endVertex) {
        double[] dist = new double[numVertices];
        boolean[] visited = new boolean[numVertices];
        int[] previous = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            dist[i] = Double.MAX_VALUE;
            visited[i] = false;
            previous[i] = -1;
        }

        dist[startVertex] = 0;

        for (int i = 0; i < numVertices; i++) {
            int minVertex = -1;
            double minDist = Double.MAX_VALUE;
            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minVertex = j;
                }
            }

            if (minVertex == -1) {
                break;
            }

            visited[minVertex] = true;

            int[] neighbors = getNeighbors(minVertex);
            for (int j = 0; j < neighbors.length; j++) {
                int neighbor = neighbors[j];
                double weight = adjMatrix[minVertex][neighbor];
                if (dist[minVertex] + weight < dist[neighbor]) {
                    dist[neighbor] = dist[minVertex] + weight;
                    previous[neighbor] = minVertex;
                }
            }
        }

        if (dist[endVertex] == Double.MAX_VALUE) {
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

        result += " | Distance: " + dist[endVertex];
        return result;
    }
}

