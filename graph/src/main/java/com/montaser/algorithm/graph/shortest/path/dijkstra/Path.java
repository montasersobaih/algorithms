package com.montaser.algorithm.graph.shortest.path.dijkstra;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @since 16-11-2022
 */

final class Path<T> {

    private final T source;

    private final T destination;

    private final int distance;

    private final String path;

    public Path(T destination, int distance, String path) {
        this.source = null;
        this.destination = destination;
        this.distance = distance;
        this.path = path;
    }

    public Path(T source, T destination, int distance, String path) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.path = path;
    }

    public T getSource() {
        return source;
    }

    public T getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public String getPath() {
        return path;
    }
}
