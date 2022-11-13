package com.montaser.algorithm.graph.traversals.depth.first.search;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Depth First Search (DFS)
 * @since 11-11-2022
 */

abstract class DfsAbstractRecursive<T> implements Dfs<T> {

    @Override
    public final String find(T[][] adjacency, T start) {
        return recursive(adjacency, start, new boolean[adjacency.length]);
    }

    protected abstract String recursive(T[][] adjacency, T start, boolean[] visited);

    @Override
    public final String find(List<T>[] adjacency, T start) {
        return recursive(adjacency, start, new boolean[adjacency.length]);
    }

    protected abstract String recursive(List<T>[] adjacency, T start, boolean[] visited);

    @Override
    public final String find(List<List<T>> adjacency, T start) {
        return recursive(adjacency, start, new boolean[adjacency.size()]);
    }

    protected abstract String recursive(List<List<T>> adjacency, T start, boolean[] visited);

    @Override
    public final String find(Map<T, List<T>> adjacency, T start) {
        return recursive(adjacency, start, new HashSet<>());
    }

    protected abstract String recursive(Map<T, List<T>> adjacency, T start, Set<T> visited);
}
