package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class DijkstraNormalIntegerImpl implements Dijkstra<Integer> {

    @Override
    public Path<Integer> find(Integer[][] adjacency, Integer start, Integer end) {
        boolean[] visited = new boolean[adjacency.length];
        String[] paths = new String[adjacency.length];
        int[] dist = new int[adjacency.length];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        paths[start] = String.valueOf(start);

        for (int i = 0; i < adjacency.length; i++) {
            int sVertex = -1, sDist = Integer.MAX_VALUE;

            for (int vertex = 0; vertex < dist.length; vertex++) {
                if (!visited[vertex] && dist[vertex] <= sDist) {
                    sVertex = vertex;
                    sDist = dist[vertex];
                }
            }

            visited[sVertex] = true;

            if (sVertex == end) {
                return new Path<>(start, sVertex, sDist, paths[sVertex]);
            }

            Integer[] weights = adjacency[sVertex];
            for (int dVertex = 0; dVertex < weights.length; dVertex++) {
                if (weights[dVertex] != 0 && !visited[dVertex] && sDist + weights[dVertex] < dist[dVertex]) {
                    dist[dVertex] = sDist + weights[dVertex];
                    paths[dVertex] = String.join(" -> ", paths[sVertex], String.valueOf(dVertex));
                }
            }
        }

        return null;
    }

    @Override
    public Path<Integer> find(List<Edge<Integer>>[] adjacency, Integer start, Integer end) {
        boolean[] visited = new boolean[adjacency.length];
        String[] paths = new String[adjacency.length];
        int[] dist = new int[adjacency.length];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        paths[start] = String.valueOf(start);

        for (int i = 0; i < adjacency.length; i++) {
            int sVertex = -1, sDist = Integer.MAX_VALUE;

            for (int vertex = 0; vertex < dist.length; vertex++) {
                if (!visited[vertex] && dist[vertex] <= sDist) {
                    sVertex = vertex;
                    sDist = dist[vertex];
                }
            }

            visited[sVertex] = true;

            if (sVertex == end) {
                return new Path<>(start, sVertex, sDist, paths[sVertex]);
            }

            for (Edge<Integer> edge : adjacency[sVertex]) {
                if (!visited[edge.getTo()] && sDist + edge.getDistance() < dist[edge.getTo()]) {
                    dist[edge.getTo()] = sDist + edge.getDistance();
                    paths[edge.getTo()] = String.join(" -> ", paths[sVertex], String.valueOf(edge.getTo()));
                }
            }
        }

        return null;
    }

    @Override
    public Path<Integer> find(List<List<Edge<Integer>>> adjacency, Integer start, Integer end) {
        boolean[] visited = new boolean[adjacency.size()];
        String[] paths = new String[adjacency.size()];
        int[] dist = new int[adjacency.size()];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        paths[start] = String.valueOf(start);

        for (int i = 0; i < adjacency.size(); i++) {
            int sVertex = -1, sDist = Integer.MAX_VALUE;

            for (int vertex = 0; vertex < dist.length; vertex++) {
                if (!visited[vertex] && dist[vertex] <= sDist) {
                    sVertex = vertex;
                    sDist = dist[vertex];
                }
            }

            visited[sVertex] = true;

            if (sVertex == end) {
                return new Path<>(start, sVertex, sDist, paths[sVertex]);
            }

            for (Edge<Integer> edge : adjacency.get(sVertex)) {
                if (!visited[edge.getTo()] && sDist + edge.getDistance() < dist[edge.getTo()]) {
                    dist[edge.getTo()] = sDist + edge.getDistance();
                    paths[edge.getTo()] = String.join(" -> ", paths[sVertex], String.valueOf(edge.getTo()));
                }
            }
        }

        return null;
    }

    @Override
    public Path<Integer> find(Map<Integer, List<Edge<Integer>>> adjacency, Integer start, Integer end) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, String> paths = new HashMap<>();
        Map<Integer, Integer> dist = new HashMap<>();

        dist.put(start, 0);
        paths.put(start, String.valueOf(start));

        for (int i = 0; i < adjacency.size(); i++) {
            int sVertex = -1, sDist = Integer.MAX_VALUE;

            for (int vertex : dist.keySet()) {
                if (!visited.contains(vertex) && dist.get(vertex) <= sDist) {
                    sVertex = vertex;
                    sDist = dist.get(vertex);
                }
            }

            visited.add(sVertex);

            if (sVertex == end) {
                return new Path<>(start, sVertex, sDist, paths.get(sVertex));
            }

            if (adjacency.containsKey(sVertex)) {
                for (Edge<Integer> edge : adjacency.get(sVertex)) {
                    int dVertex = edge.getTo(), dWeight = edge.getDistance();
                    if (!visited.contains(dVertex) && (dist.get(dVertex) == null || dist.get(sVertex) + dWeight < dist.get(dVertex))) {
                        dist.put(dVertex, dist.get(sVertex) + dWeight);
                        paths.put(dVertex, String.join(" -> ", paths.get(sVertex), String.valueOf(dVertex)));
                    }
                }
            }
        }

        return null;
    }
}