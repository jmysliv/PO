package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CarTest {
    Car v1 = new Car();
    Car v2 = new Car();




    @Test
    public void testtoString() {
        assertEquals("Position: (2, 2); Direction: Północ", v1.toString() );
    }

    @Test
    public void move() {

    }
}