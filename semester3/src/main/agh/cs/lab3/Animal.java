package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.AbstractWorldMapElement;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {

    private MapDirection direction;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

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
                    this.position=this.position.add(this.direction.toUnitVector());
                break;
            case BACKWARD:
                if(this.position.substract(this.direction.toUnitVector()).follows(new Vector2d(0, 0)) && this.position.substract(this.direction.toUnitVector()).precedes(new Vector2d(4, 4)))
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
                if(map.canMoveTo(this.position.add(this.direction.toUnitVector()))) {
                    Vector2d oldPosition = new Vector2d(this.position.x, this.position.y);
                    this.position = this.position.add(this.direction.toUnitVector());
                    this.positionChanged(oldPosition, this.position);
                }
                break;
            case BACKWARD:
                if(map.canMoveTo(this.position.substract(this.direction.toUnitVector()))) {
                    Vector2d oldPosition = new Vector2d(this.position.x, this.position.y);
                    this.position = this.position.substract(this.direction.toUnitVector());
                    this.positionChanged(oldPosition, this.position);
                }
                break;
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
