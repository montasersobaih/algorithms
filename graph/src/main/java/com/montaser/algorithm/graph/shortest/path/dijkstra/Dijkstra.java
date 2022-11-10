package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.List;
import java.util.Map;

//Greedy Algorithms --> Shortest Path

public interface Dijkstra {

    Vertex find(Map<Integer, List<Vertex>> adj, int start, int end);

    Vertex find(int[][] matrix, int start, int end);
}