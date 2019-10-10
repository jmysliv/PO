package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

public class Car {

    private MapDirection direction;
    private Vector2d position;

    public Car(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public String toString(){
        return String.format("Position: %s ; Direction: %s", this.position.toString(), this.direction.toString());
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
}
