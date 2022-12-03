package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class DijkstraNormalStringImpl implements Dijkstra<String> {

    @Override
    public Path<String> find(String[][] adjacency, String start, String end) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Path<String> find(List<Edge<String>>[] adjacency, String start, String end) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Path<String> find(List<List<Edge<String>>> adjacency, String start, String end) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Path<String> find(Map<String, List<Edge<String>>> adjacency, String start, String end) {
        Set<String> visited = new HashSet<>();
        Map<String, String> paths = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();

        dist.put(start, 0);
        paths.put(start, start);

        for (int i = 0; i < adjacency.size(); i++) {
            String sVertex = null;
            int sDist = Integer.MAX_VALUE;

            for (String vertex : dist.keySet()) {
                if (!visited.contains(vertex) && dist.get(vertex) <= sDist) {
                    sVertex = vertex;
                    sDist = dist.get(vertex);
                }
            }

            visited.add(sVertex);

            if (sVertex.equals(end)) {
                return new Path<>(start, sVertex, sDist, paths.get(sVertex));
            }

            if (adjacency.containsKey(sVertex)) {
                for (Edge<String> edge : adjacency.get(sVertex)) {
                    String dVertex = edge.getTo();
                    int dWeight = edge.getDistance();
                    if (!visited.contains(dVertex) && (dist.get(dVertex) == null || dist.get(sVertex) + dWeight < dist.get(dVertex))) {
                        dist.put(dVertex, dist.get(sVertex) + dWeight);
                        paths.put(dVertex, String.join(" -> ", paths.get(sVertex), dVertex));
                    }
                }
            }
        }

        return null;
    }
}