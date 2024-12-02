package com.quadtree;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuadtreeTest {

    @Test
    public void testInsertAndFind() {
        Quadtree quadtree = new Quadtree();
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        quadtree.insert(rect);
        assertEquals(rect, quadtree.find(10, 10));
    }

    @Test
    public void testDelete() {
        Quadtree quadtree = new Quadtree();
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        quadtree.insert(rect);
        quadtree.delete(10, 10);
        assertNull(quadtree.find(10, 10));
    }
}
