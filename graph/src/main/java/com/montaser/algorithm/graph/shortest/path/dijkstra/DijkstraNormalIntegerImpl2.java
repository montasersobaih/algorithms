package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
final class DijkstraNormalIntegerImpl2 implements Dijkstra<Integer> {

    @Override
    public Path<Integer> find(Integer[][] adjacency, Integer start, Integer end) {
        Vertex<Integer>[] vertices = new Vertex[adjacency.length];

        for (int i = 0; i < adjacency.length; i++) {
            vertices[i] = new Vertex<>(i, Integer.MAX_VALUE);
        }

        vertices[start].setDistance(0);
        vertices[start].setPath(String.valueOf(start));

        for (int i = 0; i < adjacency.length; i++) {
            Vertex<Integer> sVertex = new Vertex<>(-1, Integer.MAX_VALUE);
            for (Vertex<Integer> vertex : vertices) {
                if (!vertex.isVisited() && vertex.getDistance() <= sVertex.getDistance()) {
                    sVertex = vertex;
                }
            }

            sVertex.setVisited(true);

            if (sVertex.getName() == end) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            Integer[] weights = adjacency[sVertex.getName()];
            for (int dVertex = 0; dVertex < weights.length; dVertex++) {
                boolean dVisited = vertices[dVertex].isVisited();
                int dDist = vertices[dVertex].getDistance();
                if (weights[dVertex] != 0 && !dVisited && sVertex.getDistance() + weights[dVertex] < dDist) {
                    vertices[dVertex].setDistance(sVertex.getDistance() + weights[dVertex]);
                    vertices[dVertex].setPath(String.join(" -> ", sVertex.getPath(), String.valueOf(dVertex)));
                }
            }
        }

        return null;
    }

    @Override
    public Path<Integer> find(List<Edge<Integer>>[] adjacency, Integer start, Integer end) {
        Vertex<Integer>[] vertices = new Vertex[adjacency.length];

        for (int i = 0; i < adjacency.length; i++) {
            vertices[i] = new Vertex<>(i, Integer.MAX_VALUE);
        }

        vertices[start].setDistance(0);
        vertices[start].setPath(String.valueOf(start));

        for (int i = 0; i < adjacency.length; i++) {
            Vertex<Integer> sVertex = new Vertex<>(-1, Integer.MAX_VALUE);
            for (Vertex<Integer> vertex : vertices) {
                if (!vertex.isVisited() && vertex.getDistance() <= sVertex.getDistance()) {
                    sVertex = vertex;
                }
            }

            sVertex.setVisited(true);

            if (sVertex.getName() == end) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            for (Edge<Integer> edge : adjacency[sVertex.getName()]) {
                Vertex<Integer> dVertex = vertices[edge.getTo()];
                if (!dVertex.isVisited() && sVertex.getDistance() + edge.getDistance() < dVertex.getDistance()) {
                    dVertex.setDistance(sVertex.getDistance() + edge.getDistance());
                    dVertex.setPath(String.join(" -> ", sVertex.getPath(), String.valueOf(edge.getTo())));
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

        vertices[start].setDistance(0);
        vertices[start].setPath(String.valueOf(start));

        for (int i = 0; i < adjacency.size(); i++) {
            Vertex<Integer> sVertex = new Vertex<>(-1, Integer.MAX_VALUE);
            for (Vertex<Integer> vertex : vertices) {
                if (!vertex.isVisited() && vertex.getDistance() <= sVertex.getDistance()) {
                    sVertex = vertex;
                }
            }

            sVertex.setVisited(true);

            if (sVertex.getName() == end) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            for (Edge<Integer> edge : adjacency.get(sVertex.getName())) {
                Vertex<Integer> dVertex = vertices[edge.getTo()];
                if (!dVertex.isVisited() && sVertex.getDistance() + edge.getDistance() < dVertex.getDistance()) {
                    dVertex.setDistance(sVertex.getDistance() + edge.getDistance());
                    dVertex.setPath(String.join(" -> ", sVertex.getPath(), String.valueOf(edge.getTo())));
                }
            }
        }

        return null;
    }

    @Override
    public Path<Integer> find(Map<Integer, List<Edge<Integer>>> adjacency, Integer start, Integer end) {
        Map<Integer, Vertex<Integer>> vertices = new HashMap<>();

        vertices.put(start, new Vertex<>(start, 0, String.valueOf(start)));

        for (int i = 0; i < adjacency.size(); i++) {
            Vertex<Integer> sVertex = new Vertex<>(-1, Integer.MAX_VALUE);
            for (Integer vIndex : vertices.keySet()) {
                Vertex<Integer> vertex = vertices.get(vIndex);
                if (!vertex.isVisited() && vertex.getDistance() <= sVertex.getDistance()) {
                    sVertex = vertex;
                }
            }

            sVertex.setVisited(true);

            if (sVertex.getName() == end) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            if (adjacency.containsKey(sVertex.getName())) {
                for (Edge<Integer> edge : adjacency.get(sVertex.getName())) {
                    if (!vertices.containsKey(edge.getTo())) {
                        vertices.put(edge.getTo(), new Vertex<>(edge.getTo(), Integer.MAX_VALUE));
                    }

                    Vertex<Integer> dVertex = vertices.get(edge.getTo());
                    if (!dVertex.isVisited() && sVertex.getDistance() + edge.getDistance() < dVertex.getDistance()) {
                        dVertex.setDistance(sVertex.getDistance() + edge.getDistance());
                        dVertex.setPath(String.join(" -> ", sVertex.getPath(), String.valueOf(edge.getTo())));
                    }
                }
            }
        }

        return null;
    }
}