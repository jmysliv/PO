package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab5.AbstractWorldMap;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private final Vector2d leftBottom;
    private final Vector2d rightTop;

    public RectangularMap(int w, int h){
        leftBottom = new Vector2d(0, 0);
        rightTop = new Vector2d(w-1, h-1);
    }

    protected Vector2d lowerLeft(){
        return leftBottom;
    }

    protected Vector2d upperRight(){
        return rightTop;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
       return (super.canMoveTo(position) && position.follows(leftBottom) && position.precedes(rightTop));
    }

}
