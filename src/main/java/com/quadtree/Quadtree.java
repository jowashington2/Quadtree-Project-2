package com.quadtree;

public class Quadtree {
    private Node root;

    public Quadtree() {
        root = new LeafNode(new Rectangle(-50, -50, 100, 100));
    }

    public void insert(Rectangle rectangle) {
        root.insert(rectangle);
    }

    public void delete(double x, double y) {
        root.delete(x, y);
    }

    public Rectangle find(double x, double y) {
        return root.find(x, y);
    }

    public void dump() {
        StringBuilder sb = new StringBuilder();
        root.dump(sb, 0);
        System.out.print(sb.toString());
    }
}
