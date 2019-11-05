package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

public class Grass {
    private Vector2d position;

    public Grass(Vector2d position){
        this.position = new Vector2d(position.x, position.y);
    }

    public Vector2d getPosition(){
        return new Vector2d(this.position.x, this.position.y);
    }

    public String toString(){
        return "*";
    }

}
