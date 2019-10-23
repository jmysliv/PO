package agh.cs.lab2;

import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;

public class World {

    public static void main(String[] args){
     MoveDirection[] directions = OptionParser.parse(args);
     Animal animal = new Animal();
     for(MoveDirection x :directions){
         animal.move(x);
         System.out.println(animal);
     }
    }
}
