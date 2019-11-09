package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

public abstract class AbstractWorldMapElement implements IWorldMapElement{

    protected Vector2d position;

    public Vector2d getPosition(){
        return new Vector2d(this.position.x, this.position.y);
    }

    public boolean isMovable(){
        return true;
    }

}
