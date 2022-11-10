package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class EnhancedDijkstra implements Dijkstra {

    private Comparator<Vertex> comparator = new Comparator<Vertex>() {
        @Override
        public int compare(Vertex o1, Vertex o2) {
            return Integer.compare(o1.getMindis(), o2.getMindis());
        }
    };

    public Vertex find(Map<Integer, List<Vertex>> adj, int start, int end) {
        Queue<Vertex> queue = new PriorityQueue<Vertex>(comparator);
        boolean[] visited = new boolean[adj.size() + 1];

        Vertex vx = new Vertex(start, 0, 0, start + "");
        visited[vx.getName()] = true;
        queue.offer(vx);

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();

            if (u.getName() == end) {
                return u;
            } else {
                for (Vertex v : adj.get(u.getName())) {
                    if (!visited[vx.getName()] || u.getMindis() + v.getWeight() < v.getMindis()) {
                        visited[vx.getName()] = true;
                        v.setPath(u.getPath() + " -> " + v.getName());
                        v.setMindis(v.getWeight() + u.getMindis());
                        queue.add(v);
                    }
                }
            }
        }

        return null;
    }

    @Override
    public Vertex find(int[][] matrix, int start, int end) {
        Queue<Vertex> queue = new PriorityQueue<Vertex>(comparator);

        Vertex vx = new Vertex(start, 0, 0, start + "");
        queue.offer(vx);

        while (!queue.isEmpty()) {
            Vertex u = queue.poll();

            if (u.getName() == end) {
                return u;
            } else {
                for (int i = 1; i < matrix[u.getName()].length; i++) {
                    Vertex v = new Vertex(i, matrix[u.getName()][i], Integer.MAX_VALUE);
                    if (u.getMindis() + v.getWeight() < v.getMindis()) {
                        v.setPath(u.getPath() + " -> " + v.getName());
                        v.setMindis(v.getWeight() + u.getMindis());
                        queue.add(v);
                    }
                }
            }
        }

        return null;
    }
}