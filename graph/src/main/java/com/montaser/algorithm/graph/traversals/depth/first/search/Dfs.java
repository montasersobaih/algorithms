package com.montaser.algorithm.graph.traversals.depth.first.search;

import java.util.List;
import java.util.Map;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Breadth First Search (BFS)
 * @since 10-11-2022
 */

interface Dfs<T> {

    String find(T[][] adjacency, T start);

    String find(List<T>[] adjacency, T start);

    String find(List<List<T>> adjacency, T start);

    String find(Map<T, List<T>> adjacency, T start);
}
