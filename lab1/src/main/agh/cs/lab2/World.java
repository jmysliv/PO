package agh.cs.lab2;

import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab5.GrassField;

public class World {

    public static void main(String[] args){
        try {
            MoveDirection[] directions = OptionParser.parse(args);
            IWorldMap map = new GrassField(10);
            Animal animal1 = new Animal(map);
            map.place(animal1);
            Animal animal2 = new Animal(map, new Vector2d(3, 4));
            map.place(animal2);
            map.run(directions);
            System.out.println(animal1.toLongString());
            System.out.println(animal2.toLongString());
            System.out.println(map);
        }catch(IllegalArgumentException ex){
            System.out.println(ex);
        }
    }
}
