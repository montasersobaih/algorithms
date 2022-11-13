package com.montaser.algorithm.graph;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @since 12-11-2022
 */

public final class ResourcePath {

    public static final String INPUT = "/input";

    public static final String OUTPUT = "/output";

    /******************************************************************************************************************/

    private static final String GRAPH = "/graph";

    private static final String WEIGHTED_GRAPH = GRAPH.concat("/weighted");

    private static final String UNWEIGHTED_GRAPH = GRAPH.concat("/unweighted");

    public static final String WEIGHTED_DIRECTED_GRAPH = WEIGHTED_GRAPH.concat("/directed");

    public static final String WEIGHTED_UNDIRECTED_GRAPH = WEIGHTED_GRAPH.concat("/undirected");

    public static final String UNWEIGHTED_DIRECTED_GRAPH = UNWEIGHTED_GRAPH.concat("/directed");

    public static final String UNWEIGHTED_UNDIRECTED_GRAPH = UNWEIGHTED_GRAPH.concat("/undirected");

    /******************************************************************************************************************/


}