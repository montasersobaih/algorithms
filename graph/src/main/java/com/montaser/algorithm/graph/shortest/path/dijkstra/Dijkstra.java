package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.List;
import java.util.Map;

//Greedy Algorithms --> Shortest Path

public interface Dijkstra<T> {

    Path<T> find(T[][] adjacency, T start, T end);

    Path<T> find(List<Edge<T>>[] adjacency, T start, T end);

    Path<T> find(List<List<Edge<T>>> adjacency, T start, T end);

    Path<T> find(Map<T, List<Edge<T>>> adjacency, T start, T end);
}