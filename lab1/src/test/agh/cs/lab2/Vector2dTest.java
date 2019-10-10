package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2dTest {

    private Vector2d v_1_1 = new Vector2d(1, 1);
    private Vector2d v_1_2  = new Vector2d(0, 0);

    @Test
    public void testToString() {
        assertEquals(v_1_1.toString(), "(1, 1)");
        assertEquals(v_1_2.toString(), "(0, 0)");
    }

    @Test
    public void precedes() {
        assertTrue( v_1_1.precedes(new Vector2d(1, 1)));
        assertTrue( v_1_1.precedes(new Vector2d(2, 2)));
        assertFalse(v_1_1.precedes(new Vector2d(1, 0)));
        assertFalse(v_1_1.precedes(new Vector2d(0, 1)));
    }

    @Test
    public void follows() {
        assertTrue( v_1_1.follows(new Vector2d(1, 1)));
        assertTrue( v_1_1.follows(new Vector2d(0, 0)));
        assertFalse(v_1_1.follows(new Vector2d(1, 2)));
        assertFalse(v_1_1.follows(new Vector2d(2, 1)));
    }

    @Test
    public void upperRight() {
        assertEquals(v_1_1.upperRight(new Vector2d(2, 0)), new Vector2d(2, 1));
        assertEquals(v_1_2.upperRight(v_1_1), v_1_1);
    }

    @Test
    public void lowerLeft() {
        assertEquals(v_1_1.lowerLeft(new Vector2d(2, 0)), new Vector2d(1, 0));
        assertEquals(v_1_2.lowerLeft(v_1_1), v_1_2);
    }

    @Test
    public void add() {
        assertEquals(v_1_1.add(v_1_1), new Vector2d(2, 2));
        assertEquals(v_1_2.add(v_1_1), v_1_1);
    }

    @Test
    public void substract() {
        assertEquals(v_1_1.substract(v_1_1), new Vector2d(0, 0));
        assertEquals(v_1_2.substract(v_1_1), new Vector2d(-1, -1));
    }

    @Test
    public void testEquals() {
        assertTrue( v_1_1.equals(new Vector2d(1, 1)));
        assertFalse(v_1_1.equals(new Vector2d(1, 2)));
        assertFalse(v_1_1.equals(new Vector2d(2, 1)));
    }

    @Test
    public void oposite() {
        assertEquals(v_1_1.oposite(), new Vector2d(-1, -1));
    }
}