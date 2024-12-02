package com.quadtree;

import java.util.ArrayList;
import java.util.List;

public class LeafNode extends Node {
    private List<Rectangle> rectangles = new ArrayList<>();
    private static final int MAX_CAPACITY = 5;

    public LeafNode(Rectangle bounds) {
        super(bounds);
    }

    @Override
    public void insert(Rectangle rectangle) {
        if (rectangles.size() < MAX_CAPACITY) {
            rectangles.add(rectangle);
        } else {
            throw new IllegalStateException("LeafNode capacity exceeded.");
        }
    }

    @Override
    public void delete(double x, double y) {
        rectangles.removeIf(r -> r.contains(x, y));
    }

    @Override
    public Rectangle find(double x, double y) {
        return rectangles.stream().filter(r -> r.contains(x, y)).findFirst().orElse(null);
    }

    @Override
    public void dump(StringBuilder sb, int level) {
        for (Rectangle rect : rectangles) {
            sb.append("\t".repeat(level)).append(rect).append("\n");
        }
    }
}
