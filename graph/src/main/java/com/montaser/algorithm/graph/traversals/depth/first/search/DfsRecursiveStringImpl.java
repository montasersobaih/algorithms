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

final class DfsRecursiveStringImpl extends DfsAbstractRecursive<String> {

    @Override
    protected String recursive(String[][] adjacency, String start, boolean[] visited) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String recursive(List<String>[] adjacency, String start, boolean[] visited) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String recursive(List<List<String>> adjacency, String start, boolean[] visited) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String recursive(Map<String, List<String>> adjacency, String start, Set<String> visited) {
        StringJoiner joiner = new StringJoiner(" ");

        visited.add(start);
        joiner.add(start);

        if (adjacency.containsKey(start)) {
            for (String nVertex : adjacency.get(start)) {
                if (visited.add(nVertex)) {
                    joiner.add(recursive(adjacency, nVertex, visited));
                }
            }
        }

        return joiner.toString();
    }
}
