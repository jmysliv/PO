package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {
    private IWorldMap map;
    private Animal animal1;
    private Animal animal2;
    private Vector2d position1;
    private Vector2d position2;


    @Before
    public void setUp(){
        map = new RectangularMap(10, 5);
        animal1 = new Animal(map);
        animal2 = new Animal(map,new Vector2d(3,4));
        position1 = new Vector2d(0, 0);
        position2 = new Vector2d(11, 11);
        map.place(animal1);
    }


    @Test
    public void canMoveTo() {
        assertTrue(map.canMoveTo(position1));
        assertFalse(map.canMoveTo(animal1.getPosition()));
        assertFalse(map.canMoveTo(position2));
    }

    @Test
    public void place() {
        assertFalse(map.place(animal1));
        assertTrue(map.place(animal2));
    }

    @Test
    public void run() {
        map.place(animal2);
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionParser.parse(args);
        map.run(directions);
        assertEquals(new Vector2d(2, 0), animal1.getPosition());
        assertEquals(new Vector2d(3, 4), animal2.getPosition());
    }

    @Test
    public void isOccupied() {
        map.place(animal2);
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(position1));
        assertFalse(map.isOccupied(position2));
    }

    @Test
    public void objectAt() {
        map.place(animal2);
        assertEquals(animal1, map.objectAt(new Vector2d(2, 2)));
        assertEquals(animal2, map.objectAt(new Vector2d(3, 4)));
    }
}