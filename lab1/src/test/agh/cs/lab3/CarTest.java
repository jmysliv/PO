package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CarTest {
    private Car v1 = new Car();
    private Car v2 = new Car();

    @Test
    public void testtoString() {
        assertEquals("Position: (2, 2); Direction: Północ", v1.toString() );
    }

    @Test
    public void move() {
        v1.move(MoveDirection.RIGHT); v1.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 2), v1.getPosition());
        v1.move(MoveDirection.LEFT); v1.move(MoveDirection.LEFT); v1.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 2), v1.getPosition());
        v1.move(MoveDirection.RIGHT); v1.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 1), v1.getPosition());
        v1.move(MoveDirection.FORWARD);
        v2.move(MoveDirection.BACKWARD); v2.move(MoveDirection.BACKWARD);v2.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 0), v2.getPosition());
        v2.move(MoveDirection.FORWARD); v2.move(MoveDirection.FORWARD);
    }
}