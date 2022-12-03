package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

final class DijkstraEnhancedStringImpl implements Dijkstra<String> {

    private final Comparator<Vertex<String>> comparator = new Comparator<Vertex<String>>() {
        @Override
        public int compare(Vertex<String> o1, Vertex<String> o2) {
            return o1.getDistance() - o2.getDistance();
        }
    };

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
        Map<String, Vertex<String>> vertices = new HashMap<>();
        Queue<Vertex<String>> queue = new PriorityQueue<>(comparator);

        Vertex<String> vertex = new Vertex<>(start, true, 0, start);
        vertices.put(start, vertex);
        queue.offer(vertex);

        while (!queue.isEmpty()) {
            Vertex<String> sVertex = queue.poll();

            if (sVertex.getName().equals(end)) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            if (adjacency.containsKey(sVertex.getName())) {
                for (Edge<String> edge : adjacency.get(sVertex.getName())) {
                    if (!vertices.containsKey(edge.getTo())) {
                        vertices.put(edge.getTo(), new Vertex<>(edge.getTo(), Integer.MAX_VALUE));
                    }

                    Vertex<String> dVertex = vertices.get(edge.getTo());
                    if (!dVertex.isVisited() || sVertex.getDistance() + edge.getDistance() < dVertex.getDistance()) {
                        dVertex.setVisited(true);
                        dVertex.setDistance(sVertex.getDistance() + edge.getDistance());
                        dVertex.setPath(String.join(" -> ", sVertex.getPath(), String.valueOf(edge.getTo())));

                        queue.offer(dVertex);
                    }
                }
            }
        }

        return null;
    }
}