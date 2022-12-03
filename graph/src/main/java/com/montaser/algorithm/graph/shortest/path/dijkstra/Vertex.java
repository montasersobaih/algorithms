package com.montaser.algorithm.graph.shortest.path.dijkstra;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @since 12-11-2022
 */

final class Vertex<T> {

    private final T name;

    private boolean visited;

    private int distance;

    private String path;

    public Vertex(T name, int distance) {
        this.name = name;
        this.visited = false;
        this.distance = distance;
        this.path = "";
    }

    public Vertex(T name, int distance, String path) {
        this.name = name;
        this.distance = distance;
        this.path = path;
    }

    public Vertex(T name, boolean visited, int distance, String path) {
        this.name = name;
        this.visited = visited;
        this.distance = distance;
        this.path = path;
    }

    public T getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}