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

    @Before
    public void setUp(){
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionParser.parse(args);
        map = new RectangularMap(10, 5);
        animal1 = new Animal(map);
        animal2 = new Animal(map, new Vector2d(3, 4));
        map.place(animal1);
        map.place(animal2);
        map.run(directions);
    }

    @Test
    public void objectAt() {
        assertNull(map.objectAt(new Vector2d(1, 1)));
        assertEquals(animal1, map.objectAt(animal1.getPosition()));
        assertEquals(animal2, map.objectAt(animal2.getPosition()));
    }

    @Test
    public void isOccupied() {
        assertTrue(map.isOccupied(animal1.getPosition()));
        assertTrue(map.isOccupied(animal2.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(1, 3)));
    }

    @Test
    public void canMoveTo() {
        assertFalse(map.canMoveTo(animal1.getPosition()));
        assertFalse(map.canMoveTo(animal2.getPosition()));
        assertTrue(map.canMoveTo(new Vector2d(8,4)));
        assertFalse(map.canMoveTo(new Vector2d(3, 11)));
    }


    @Test
    public void place() {
        Animal newAnimal1 = new Animal(map, animal1.getPosition());
        Animal newAnimal2 = new Animal(map, animal2.getPosition());
        Animal newAnimal3 = new Animal(map, new Vector2d(9,3));
        Animal newAnimal4 = new Animal(map, new Vector2d(3,43));
        assertFalse(map.place(newAnimal1));
        assertFalse(map.place(newAnimal2));
        assertTrue(map.place(newAnimal3));
        assertFalse(map.place(newAnimal4));
    }

    @Test
    public void run() {
        Vector2d position2 = animal1.getPosition();
        String[] args = {"f", "b", "r", "l", "f", "l", "r", "f", "f", "f"};
        MoveDirection[] directions = OptionParser.parse(args);
        map.run(directions);
        System.out.println(map);
        assertEquals("N", map.objectAt(new Vector2d(1, 1)).toString());
        assertEquals("S", map.objectAt(new Vector2d(3, 1)).toString());
        assertFalse(map.isOccupied(new Vector2d(3, 4)));
        assertFalse(map.isOccupied(position2));

    }
}