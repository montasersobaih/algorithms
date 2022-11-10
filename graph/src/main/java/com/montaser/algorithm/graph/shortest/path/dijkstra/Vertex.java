package com.montaser.algorithm.graph.shortest.path.dijkstra;

class Vertex {

    private int name;

    private int weight, mindis;

    private String path;

    public Vertex(int name, int weight, int mindis) {
        this.name = name;
        this.weight = weight;
        this.mindis = mindis;
        this.path = "";
    }

    public Vertex(int name, int weight, int mindis, String path) {
        this.name = name;
        this.weight = weight;
        this.mindis = mindis;
        this.path = path;
    }

    public int getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getMindis() {
        return mindis;
    }

    public void setMindis(int mindis) {
        this.mindis = mindis;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}