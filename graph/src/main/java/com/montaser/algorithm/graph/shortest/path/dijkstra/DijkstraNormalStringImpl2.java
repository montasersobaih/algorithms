package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class DijkstraNormalStringImpl2 implements Dijkstra<String> {

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

        vertices.put(start, new Vertex<>(start, 0, start));

        for (int i = 0; i < adjacency.size(); i++) {
            Vertex<String> sVertex = new Vertex<>(null, Integer.MAX_VALUE);
            for (String vIndex : vertices.keySet()) {
                Vertex<String> vertex = vertices.get(vIndex);
                if (!vertex.isVisited() && vertex.getDistance() <= sVertex.getDistance()) {
                    sVertex = vertex;
                }
            }

            sVertex.setVisited(true);

            if (sVertex.getName().equals(end)) {
                return new Path<>(start, sVertex.getName(), sVertex.getDistance(), sVertex.getPath());
            }

            if (adjacency.containsKey(sVertex.getName())) {
                for (Edge<String> edge : adjacency.get(sVertex.getName())) {
                    if (!vertices.containsKey(edge.getTo())) {
                        vertices.put(edge.getTo(), new Vertex<>(edge.getTo(), Integer.MAX_VALUE));
                    }

                    Vertex<String> dVertex = vertices.get(edge.getTo());
                    if (!dVertex.isVisited() && sVertex.getDistance() + edge.getDistance() < dVertex.getDistance()) {
                        dVertex.setDistance(sVertex.getDistance() + edge.getDistance());
                        dVertex.setPath(String.join(" -> ", sVertex.getPath(), edge.getTo()));
                    }
                }
            }
        }

        return null;
    }
}