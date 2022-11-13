package com.montaser.algorithm.graph.traversals.depth.first.search;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Depth First Search (DFS)
 * @since 12-11-2022
 */

final class DfsRecursiveIntegerImpl extends DfsAbstractRecursive<Integer> {

    @Override
    protected String recursive(Integer[][] adjacency, Integer start, boolean[] visited) {
        StringJoiner joiner = new StringJoiner(" ");

        visited[start] = true;
        joiner.add(Integer.toString(start));

        for (int nVertex = 0; nVertex < adjacency[start].length; nVertex++) {
            if (adjacency[start][nVertex] == 1 && !visited[nVertex]) {
                joiner.add(recursive(adjacency, nVertex, visited));
            }
        }

        return joiner.toString();
    }

    @Override
    protected String recursive(List<Integer>[] adjacency, Integer start, boolean[] visited) {
        StringJoiner joiner = new StringJoiner(" ");

        visited[start] = true;
        joiner.add(Integer.toString(start));

        for (Integer nVertex : adjacency[start]) {
            if (!visited[nVertex]) {
                joiner.add(recursive(adjacency, nVertex, visited));
            }
        }

        return joiner.toString();
    }

    @Override
    protected String recursive(List<List<Integer>> adjacency, Integer start, boolean[] visited) {
        StringJoiner joiner = new StringJoiner(" ");

        visited[start] = true;
        joiner.add(Integer.toString(start));

        for (Integer nVertex : adjacency.get(start)) {
            if (!visited[nVertex]) {
                joiner.add(recursive(adjacency, nVertex, visited));
            }
        }

        return joiner.toString();
    }

    @Override
    protected String recursive(Map<Integer, List<Integer>> adjacency, Integer start, Set<Integer> visited) {
        StringJoiner joiner = new StringJoiner(" ");

        visited.add(start);
        joiner.add(Integer.toString(start));

        if (adjacency.containsKey(start)) {
            for (Integer nVertex : adjacency.get(start)) {
                if (visited.add(nVertex)) {
                    joiner.add(recursive(adjacency, nVertex, visited));
                }
            }
        }

        return joiner.toString();
    }
}
