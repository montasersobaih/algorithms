package com.montaser.algorithm.graph.shortest.path.dijkstra;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @since 12-11-2022
 */

final class Edge<T> {

    private T to;

    private int distance;

    public Edge(T to, int distance) {
        this.to = to;
        this.distance = distance;
    }

    public T getTo() {
        return to;
    }

    public void setTo(T to) {
        this.to = to;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
