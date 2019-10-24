package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal {

    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map){
        this.map = map;
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(initialPosition.x, initialPosition.y);
    }

    public String toLongString(){
        return String.format("Position: %s; Direction: %s", this.position.toString(), this.direction.toString());
    }

    public String toString(){

        switch(this.direction){
            case WEST:
                return "W";
            case EAST:
                return "E";
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
                default:
                    return null;
        }
    }

    public Vector2d getPosition(){
        return new Vector2d(this.position.x, this.position.y);
    }

    public MapDirection getDirection(){
        return this.direction;
    }

    public void move(MoveDirection instruction){
        switch(instruction){
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case FORWARD:
                if(this.position.add(this.direction.toUnitVector()).follows(new Vector2d(0, 0)) && this.position.add(this.direction.toUnitVector()).precedes(new Vector2d(4, 4)))
                //if(map.canMoveTo(this.position.add(this.direction.toUnitVector())))
                    this.position=this.position.add(this.direction.toUnitVector());
                break;
            case BACKWARD:
                if(this.position.substract(this.direction.toUnitVector()).follows(new Vector2d(0, 0)) && this.position.substract(this.direction.toUnitVector()).precedes(new Vector2d(4, 4)))
               // if(map.canMoveTo(this.position.substract(this.direction.toUnitVector())))
                    this.position=this.position.substract(this.direction.toUnitVector());
                break;
        }
    }

    public void moveInsideMap(MoveDirection instruction){
        switch(instruction){
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case FORWARD:
                if(map.canMoveTo(this.position.add(this.direction.toUnitVector())))
                    this.position=this.position.add(this.direction.toUnitVector());
                break;
            case BACKWARD:
                if(map.canMoveTo(this.position.substract(this.direction.toUnitVector())))
                    this.position=this.position.substract(this.direction.toUnitVector());
                break;
        }
    }
}
