package com.montaser.algorithm.graph.traversals.breadth.first.search;

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

final class BfsIterableStringImpl implements Bfs<String> {

    @Override
    public String find(String[][] adjacency, String start) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String find(List<String>[] adjacency, String start) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String find(List<List<String>> adjacency, String start) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String find(Map<String, List<String>> adjacency, String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        StringJoiner joiner = new StringJoiner(" ");

        while (!queue.isEmpty()) {
            String oVertex = queue.poll();
            joiner.add(oVertex);

            if (adjacency.containsKey(oVertex)) {
                for (String nVertex : adjacency.get(oVertex)) {
                    if (visited.add(nVertex)) {
                        queue.offer(nVertex);
                    }
                }
            }
        }

        return joiner.toString();
    }
}
