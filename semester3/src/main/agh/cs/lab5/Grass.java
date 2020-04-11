package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

public class Grass extends AbstractWorldMapElement{

    public Grass(Vector2d position){
        this.position = new Vector2d(position.x, position.y);
    }

    public boolean isMovable(){
        return false;
    }

    public String toString(){
        return "*";
    }

}
