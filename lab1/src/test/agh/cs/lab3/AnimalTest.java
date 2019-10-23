package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AnimalTest {
    Animal animal1 = new Animal();

    @Test
    public void toStringTest() {
        Assert.assertEquals("Position: (2, 2); Direction: Północ", animal1.toString());
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        Assert.assertEquals("Position: (4, 2); Direction: Wschód", animal1.toString());
    }

    Animal animal2 = new Animal();
    @Test
    public void moveRotate() {
        animal2.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal2.getDirection());
        animal2.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal2.getDirection());
    }
    @Test
    public void moveWalking() {
        animal2.move(MoveDirection.FORWARD);
        Assert.assertEquals(new Vector2d(2, 3), animal2.getPosition());
        animal2.move(MoveDirection.LEFT);
        animal2.move(MoveDirection.BACKWARD);
        Assert.assertEquals(new Vector2d(3, 3), animal2.getPosition());
    }

    @Test
    public void moveInsideMap() {
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.LEFT);
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.BACKWARD);
        Assert.assertEquals(new Vector2d(4, 3), animal2.getPosition());
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        Assert.assertEquals(new Vector2d(0, 3), animal2.getPosition());
        animal2.move(MoveDirection.RIGHT);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        Assert.assertEquals(new Vector2d(0, 4), animal2.getPosition());
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.BACKWARD);
        animal2.move(MoveDirection.BACKWARD);
        Assert.assertEquals(new Vector2d(0, 0), animal2.getPosition());
    }

    @Test
    public void controlAnimalTest(){
        String[] instruction={"f", "a", "left", "b", "backward", "r", "b", "l", "forward", "ret"};
        MoveDirection[] directions = OptionParser.parse(instruction);
        Animal animal3 = new Animal();
        for(MoveDirection x :directions){
            animal3.move(x);
        }

        assertEquals(new Vector2d(3, 2), animal3.getPosition());
    }
}