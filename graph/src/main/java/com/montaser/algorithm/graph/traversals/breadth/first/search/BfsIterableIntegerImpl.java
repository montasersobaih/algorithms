package com.montaser.algorithm.graph.traversals.breadth.first.search;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Breadth First Search (BFS)
 * @since 10-11-2022
 */

final class BfsIterableIntegerImpl implements Bfs<Integer> {

    @Override
    public String find(Integer[][] adjacency, Integer start) {
        boolean[] visited = new boolean[adjacency.length];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        StringJoiner joiner = new StringJoiner(" ");

        while (!queue.isEmpty()) {
            int oVertex = queue.poll();
            joiner.add(Integer.toString(oVertex));

            for (int nVertex = 0; nVertex < adjacency[oVertex].length; nVertex++) {
                if (adjacency[oVertex][nVertex] == 1 && !visited[nVertex]) {
                    queue.offer(nVertex);
                    visited[nVertex] = true;
                }
            }
        }

        return joiner.toString();
    }

    @Override
    public String find(List<Integer>[] adjacency, Integer start) {
        boolean[] visited = new boolean[adjacency.length];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        StringJoiner joiner = new StringJoiner(" ");

        while (!queue.isEmpty()) {
            int oVertex = queue.poll();
            joiner.add(Integer.toString(oVertex));

            for (int nVertex : adjacency[oVertex]) {
                if (!visited[nVertex]) {
                    queue.offer(nVertex);
                    visited[nVertex] = true;
                }
            }
        }

        return joiner.toString();
    }

    @Override
    public String find(List<List<Integer>> adjacency, Integer start) {
        boolean[] visited = new boolean[adjacency.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        StringJoiner joiner = new StringJoiner(" ");

        while (!queue.isEmpty()) {
            int oVertex = queue.poll();
            joiner.add(Integer.toString(oVertex));

            for (int nVertex : adjacency.get(oVertex)) {
                if (!visited[nVertex]) {
                    queue.offer(nVertex);
                    visited[nVertex] = true;
                }
            }
        }

        return joiner.toString();
    }

    @Override
    public String find(Map<Integer, List<Integer>> adjacency, Integer start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        StringJoiner joiner = new StringJoiner(" ");

        while (!queue.isEmpty()) {
            Integer oVertex = queue.poll();
            joiner.add(Integer.toString(oVertex));

            if (adjacency.containsKey(oVertex)) {
                for (Integer nVertex : adjacency.get(oVertex)) {
                    if (visited.add(nVertex)) {
                        queue.offer(nVertex);
                    }
                }
            }
        }

        return joiner.toString();
    }
}
