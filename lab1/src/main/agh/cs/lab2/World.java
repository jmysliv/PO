package agh.cs.lab2;

import agh.cs.lab3.Car;

public class World {

    public static void main(String[] args){
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        //lab3

        Car car=new Car();
        System.out.println(car);
        car.move(MoveDirection.RIGHT);
        car.move(MoveDirection.FORWARD);
        car.move(MoveDirection.FORWARD);
        car.move(MoveDirection.FORWARD);
        System.out.println(car);
    }
}
