package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OptionParser {

    private static MoveDirection fromString(String s){
        switch(s){
            case "f":
            case "forward":
                return MoveDirection.FORWARD;

            case "b":
            case "backward":
                return MoveDirection.BACKWARD;

            case "r":
            case "right":
                return MoveDirection.RIGHT;

            case "l":
            case "left":
                return MoveDirection.LEFT;

                default:
                    throw new IllegalArgumentException( s + " is not legal move specification");

        }
    }
    public static MoveDirection[] parse(String[] args){
        return Arrays.stream(args).map(OptionParser::fromString).filter(Objects::nonNull).toArray(MoveDirection[]::new);
    }


}
