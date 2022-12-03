package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

@SuppressWarnings("unchecked")
final class DijkstraEnhancedIntegerImpl implements Dijkstra<Integer> {

    private final Comparator<Vertex<Integer>> comparator = new Comparator<Vertex<Integer>>() {
        @Override
        public int compare(Vertex<Integer> o1, Vertex<Integer> o2) {
            return o1.getDistance() - o2.getDistance();
        }
    };

    @Override
    public Path<Integer> find(Integer[][] adjacency, Integer start, Integer end) {
        Vertex<Integer>[] vertices = new Vertex[adjacency.length];

        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex<>(i, Integer.MAX_VALUE);
        }

        Queue<Vertex<Integer>> queue = new PriorityQueue<>(comparator);

        vertices[start].setDistance(0);
        vertices[start].setVisited(true);
        vertices[start].setPath(String.valueOf(start));
        queue.offer(vertices[start]);

        while (!queue.isEmpty()) {
            Vertex<Integer> sVertex = queue.poll();

            if (sVertex.getName() == end) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            Integer[] weights = adjacency[sVertex.getName()];
            for (int dVertex = 0; dVertex < weights.length; dVertex++) {
                if (weights[dVertex] != 0) {
                    int dDistance = sVertex.getDistance() + weights[dVertex];
                    if (!vertices[dVertex].isVisited() || dDistance < vertices[dVertex].getDistance()) {
                        vertices[dVertex].setVisited(true);
                        vertices[dVertex].setDistance(dDistance);
                        vertices[dVertex].setPath(String.join(" -> ", sVertex.getPath(), String.valueOf(dVertex)));

                        queue.offer(vertices[dVertex]);
                    }
                }
            }
        }

        return null;
    }

    @Override
    public Path<Integer> find(List<Edge<Integer>>[] adjacency, Integer start, Integer end) {
        Vertex<Integer>[] vertices = new Vertex[adjacency.length];

        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex<>(i, Integer.MAX_VALUE);
        }

        Queue<Vertex<Integer>> queue = new PriorityQueue<>(comparator);

        vertices[start].setDistance(0);
        vertices[start].setVisited(true);
        vertices[start].setPath(String.valueOf(start));
        queue.offer(vertices[start]);

        while (!queue.isEmpty()) {
            Vertex<Integer> sVertex = queue.poll();

            if (sVertex.getName() == end) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            for (Edge<Integer> edge : adjacency[sVertex.getName()]) {
                Vertex<Integer> dVertex = vertices[edge.getTo()];
                if (!dVertex.isVisited() || sVertex.getDistance() + edge.getDistance() < dVertex.getDistance()) {
                    dVertex.setVisited(true);
                    dVertex.setDistance(sVertex.getDistance() + edge.getDistance());
                    dVertex.setPath(String.join(" -> ", sVertex.getPath(), String.valueOf(edge.getTo())));

                    queue.offer(dVertex);
                }
            }
        }

        return null;
    }

    @Override
    public Path<Integer> find(List<List<Edge<Integer>>> adjacency, Integer start, Integer end) {
        Vertex<Integer>[] vertices = new Vertex[adjacency.size()];

        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex<>(i, Integer.MAX_VALUE);
        }

        Queue<Vertex<Integer>> queue = new PriorityQueue<>(comparator);

        vertices[start].setDistance(0);
        vertices[start].setVisited(true);
        vertices[start].setPath(String.valueOf(start));
        queue.offer(vertices[start]);

        while (!queue.isEmpty()) {
            Vertex<Integer> sVertex = queue.poll();

            if (sVertex.getName() == end) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            for (Edge<Integer> edge : adjacency.get(sVertex.getName())) {
                Vertex<Integer> dVertex = vertices[edge.getTo()];
                if (!dVertex.isVisited() || sVertex.getDistance() + edge.getDistance() < dVertex.getDistance()) {
                    dVertex.setVisited(true);
                    dVertex.setDistance(sVertex.getDistance() + edge.getDistance());
                    dVertex.setPath(String.join(" -> ", sVertex.getPath(), String.valueOf(edge.getTo())));

                    queue.offer(dVertex);
                }
            }
        }

        return null;
    }

    @Override
    public Path<Integer> find(Map<Integer, List<Edge<Integer>>> adjacency, Integer start, Integer end) {
        Map<Integer, Vertex<Integer>> vertices = new HashMap<>();
        Queue<Vertex<Integer>> queue = new PriorityQueue<>(comparator);

        Vertex<Integer> vertex = new Vertex<>(start, true, 0, String.valueOf(start));
        vertices.put(start, vertex);
        queue.offer(vertex);

        while (!queue.isEmpty()) {
            Vertex<Integer> sVertex = queue.poll();

            if (sVertex.getName() == end) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            if (adjacency.containsKey(sVertex.getName())) {
                for (Edge<Integer> edge : adjacency.get(sVertex.getName())) {
                    if (!vertices.containsKey(edge.getTo())) {
                        vertices.put(edge.getTo(), new Vertex<>(edge.getTo(), Integer.MAX_VALUE));
                    }

                    Vertex<Integer> dVertex = vertices.get(edge.getTo());
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