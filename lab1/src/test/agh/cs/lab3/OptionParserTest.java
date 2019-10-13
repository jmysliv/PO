package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import org.junit.Test;


import static org.junit.Assert.*;

public class OptionParserTest {

    @Test
    public void parseTest() {
        String args[] = {"f", "a", "left", "r", "backward", "forward", "b", "l", "right"} ;
        MoveDirection expected[] = {
            MoveDirection.FORWARD,
            MoveDirection.LEFT,
            MoveDirection.RIGHT,
            MoveDirection.BACKWARD,
            MoveDirection.FORWARD,
            MoveDirection.BACKWARD,
            MoveDirection.LEFT,
            MoveDirection.RIGHT
        } ;
        assertEquals(expected, OptionParser.parse(args));
    }
}