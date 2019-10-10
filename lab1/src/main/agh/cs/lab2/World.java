package agh.cs.lab2;

import agh.cs.lab3.Car;
import agh.cs.lab3.OptionParser;

public class World {

    public static void main(String[] args){
     MoveDirection[] directions = OptionParser.parse(args);
     Car car = new Car();
     for(MoveDirection x :directions){
         car.move(x);
         System.out.println(car);
     }
    }
}
