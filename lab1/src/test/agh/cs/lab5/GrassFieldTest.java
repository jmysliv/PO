package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GrassFieldTest {

    private GrassField map;
    private Animal animal1;
    private Animal animal2;

    @Before
    public void setUp(){
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionParser.parse(args);
        map = new GrassField(10);
        animal1 = new Animal(map);
        animal2 = new Animal(map, new Vector2d(3, 4));
        map.place(animal1);
        map.place(animal2);
        map.run(directions);
    }

    @Test
    public void canMoveTo() {
        assertFalse(map.canMoveTo(animal1.getPosition()));
        assertFalse(map.canMoveTo(animal2.getPosition()));
        assertTrue(map.canMoveTo(new Vector2d(8,4)));
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
        assertTrue(map.place(newAnimal4));
    }

    @Test
    public void run() {
        Vector2d position2 = animal1.getPosition();
        String[] args = {"f", "b", "r", "l", "f", "l", "r", "f", "f", "f"};
        MoveDirection[] directions = OptionParser.parse(args);
        map.run(directions);
        assertEquals("N", map.objectAt(new Vector2d(1, -1)).toString());
        assertEquals("S", map.objectAt(new Vector2d(3, 3)).toString());
        assertFalse(map.isOccupied(new Vector2d(-1, -1)));
        assertFalse(map.isOccupied(position2));
    }

    @Test
    public void isOccupied() {
        IWorldMapElement grass = map.getSomeGrassToTestIt();
        assertTrue(map.isOccupied(animal1.getPosition()));
        assertTrue(map.isOccupied(animal2.getPosition()));
        assertTrue(map.isOccupied(grass.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(1, -3)));
    }

    @Test
    public void objectAt() {
        IWorldMapElement grass = map.getSomeGrassToTestIt();
        assertNull(map.objectAt(new Vector2d(1, -1)));
        assertEquals(animal1, map.objectAt(animal1.getPosition()));
        assertEquals(animal2, map.objectAt(animal2.getPosition()));
        assertEquals(grass, map.objectAt(grass.getPosition()));
    }
}