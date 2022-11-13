package com.montaser.algorithm.graph.traversals.depth.first.search;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @since 13-11-2022
 */

final class DfsIterableStringImpl implements Dfs<String> {

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
        Stack<String> stack = new Stack<>();

        stack.push(start);
        visited.add(start);

        StringJoiner joiner = new StringJoiner(" ");

        while (!stack.isEmpty()) {
            String oVertex = stack.pop();
            joiner.add(oVertex);

            if (adjacency.containsKey(oVertex)) {
                List<String> vertices = adjacency.get(oVertex);
                for (int i = vertices.size() - 1; i >= 0; i--) {
                    String nVertex = vertices.get(i);
                    if (visited.add(nVertex)) {
                        stack.push(nVertex);
                    }
                }
            }
        }

        return joiner.toString();
    }
}
