package com.quadtree;

public class InternalNode extends Node {
    private Node[] children = new Node[4];

    public InternalNode(Rectangle bounds) {
        super(bounds);
        double midX = bounds.getX() + bounds.getWidth() / 2;
        double midY = bounds.getY() + bounds.getHeight() / 2;
        double halfWidth = bounds.getWidth() / 2;
        double halfHeight = bounds.getHeight() / 2;

        children[0] = new LeafNode(new Rectangle(bounds.getX(), midY, halfWidth, halfHeight)); // Top Left
        children[1] = new LeafNode(new Rectangle(midX, midY, halfWidth, halfHeight)); // Top Right
        children[2] = new LeafNode(new Rectangle(bounds.getX(), bounds.getY(), halfWidth, halfHeight)); // Bottom Left
        children[3] = new LeafNode(new Rectangle(midX, bounds.getY(), halfWidth, halfHeight)); // Bottom Right
    }

    @Override
    public void insert(Rectangle rectangle) {
        for (Node child : children) {
            if (child.bounds.contains(rectangle.getX(), rectangle.getY())) {
                child.insert(rectangle);
                return;
            }
        }
    }

    @Override
    public void delete(double x, double y) {
        for (Node child : children) {
            if (child.bounds.contains(x, y)) {
                child.delete(x, y);
                return;
            }
        }
    }

    @Override
    public Rectangle find(double x, double y) {
        for (Node child : children) {
            if (child.bounds.contains(x, y)) {
                return child.find(x, y);
            }
        }
        return null;
    }

    @Override
    public void dump(StringBuilder sb, int level) {
        sb.append("\t".repeat(level)).append("InternalNode: ").append(bounds).append("\n");
        for (Node child : children) {
            child.dump(sb, level + 1);
        }
    }
}
