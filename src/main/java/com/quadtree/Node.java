package com.quadtree;

public abstract class Node {
    protected Rectangle bounds;

    public Node(Rectangle bounds) {
        this.bounds = bounds;
    }

    public abstract void insert(Rectangle rectangle);
    public abstract void delete(double x, double y);
    public abstract Rectangle find(double x, double y);
    public abstract void dump(StringBuilder sb, int level);
}
