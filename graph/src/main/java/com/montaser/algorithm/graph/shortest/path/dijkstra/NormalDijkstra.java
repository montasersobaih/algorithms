package com.montaser.algorithm.graph.shortest.path.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class NormalDijkstra implements Dijkstra {

    public Vertex find(Map<Integer, List<Vertex>> adj, int start, int end) {
        boolean[] visited = new boolean[adj.size() + 1];
        List<Vertex> list = new LinkedList<Vertex>();

        Vertex vx = new Vertex(start, 0, 0, start + "");
        visited[vx.getName()] = true;

        list.add(vx);

        while (!list.isEmpty()) {
            list.sort(new Comparator<Vertex>() {
                @Override
                public int compare(Vertex o1, Vertex o2) {
                    return o1.getMindis() - o2.getMindis();
                }
            });

            Vertex u = list.remove(0);
            if (u.getName() == end) {
                return u;
            } else {
                for (Vertex v : adj.get(u.getName())) {
                    if (!visited[vx.getName()] || v.getWeight() + u.getMindis() < v.getMindis()) {
                        visited[vx.getName()] = true;
                        v.setPath(String.join(" -> ", u.getPath(), String.valueOf(v.getName())));
                        v.setMindis(v.getWeight() + u.getMindis());
                        list.add(v);
                    }
                }
            }
        }

        return null;
    }

    public Vertex find(int[][] matrix, int start, int end) {
        String[] paths = new String[matrix.length];
        boolean[] visited = new boolean[matrix.length];

        int[] dist = new int[matrix.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        paths[start] = "" + start;

        for (int i = 1; i < matrix.length; i++) {
            int vertex = -1;
            int vDist = Integer.MAX_VALUE;
            for (int j = 1; j < dist.length; j++) {
                if (!visited[j] && dist[j] <= vDist) {
                    vertex = j;
                    vDist = dist[j];
                }
            }

            visited[vertex] = true;

            if (vertex == end) {
                return new Vertex(vertex, 0, vDist, paths[vertex]);
            } else {
                for (int k = 1; k < matrix[vertex].length; k++) {
                    if (matrix[vertex][k] != 0 && !visited[k] && dist[vertex] + matrix[vertex][k] < dist[k]) {
                        dist[k] = vDist + matrix[vertex][k];
                        paths[k] = String.join(" -> ", paths[vertex], String.valueOf(k));
                    }
                }
            }
        }

        return null;
    }
}