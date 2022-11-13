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
 * @algorithm Depth First Search (DFS)
 * @since 12-11-2022
 */

final class DfsIterableIntegerImpl implements Dfs<Integer> {

    @Override
    public String find(Integer[][] adjacency, Integer start) {
        boolean[] visited = new boolean[adjacency.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        StringJoiner joiner = new StringJoiner(" ");

        while (!stack.isEmpty()) {
            int oVertex = stack.pop();
            joiner.add(Integer.toString(oVertex));

            Integer[] vertices = adjacency[oVertex];
            for (int nVertex = vertices.length - 1; nVertex >= 0; nVertex--) {
                if (vertices[nVertex] == 1 && !visited[nVertex]) {
                    stack.push(nVertex);
                }
            }
        }

        return joiner.toString();
    }

    @Override
    public String find(List<Integer>[] adjacency, Integer start) {
        boolean[] visited = new boolean[adjacency.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        StringJoiner joiner = new StringJoiner(" ");

        while (!stack.isEmpty()) {
            int oVertex = stack.pop();
            joiner.add(Integer.toString(oVertex));

            List<Integer> vertices = adjacency[oVertex];
            for (int i = vertices.size() - 1; i >= 0; i--) {
                int nVertex = vertices.get(i);
                if (!visited[nVertex]) {
                    stack.push(nVertex);
                }
            }
        }

        return joiner.toString();
    }

    @Override
    public String find(List<List<Integer>> adjacency, Integer start) {
        boolean[] visited = new boolean[adjacency.size()];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        StringJoiner joiner = new StringJoiner(" ");

        while (!stack.isEmpty()) {
            int oVertex = stack.pop();
            joiner.add(Integer.toString(oVertex));

            List<Integer> vertices = adjacency.get(oVertex);
            for (int i = vertices.size() - 1; i >= 0; i--) {
                int nVertex = vertices.get(i);
                if (!visited[nVertex]) {
                    stack.push(nVertex);
                }
            }
        }

        return joiner.toString();
    }

    @Override
    public String find(Map<Integer, List<Integer>> adjacency, Integer start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited.add(start);

        StringJoiner joiner = new StringJoiner(" ");

        while (!stack.isEmpty()) {
            int oVertex = stack.pop();
            joiner.add(Integer.toString(oVertex));

            if (adjacency.containsKey(oVertex)) {
                List<Integer> vertices = adjacency.get(oVertex);
                for (int i = vertices.size() - 1; i >= 0; i--) {
                    int nVertex = vertices.get(i);
                    if (visited.add(nVertex)) {
                        stack.push(nVertex);
                    }
                }
            }
        }

        return joiner.toString();
    }
}
