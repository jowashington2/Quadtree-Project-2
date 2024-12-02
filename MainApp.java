package com.quadtree;

public class MainApp {
    public static void main(String[] args) {
        Quadtree quadtree = new Quadtree();

        // Test Insert
        quadtree.insert(new Rectangle(10, 10, 5, 5));
        quadtree.insert(new Rectangle(-20, -20, 10, 10));

        // Test Find
        System.out.println(quadtree.find(10, 10));

        // Test Delete
        quadtree.delete(10, 10);

        // Dump the tree
        quadtree.dump();
    }
}
