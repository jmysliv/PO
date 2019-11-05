package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private final Vector2d leftBottom;
    private final Vector2d rightTop;
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int w, int h){
        leftBottom = new Vector2d(0, 0);
        rightTop = new Vector2d(w-1, h-1);
    }

    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(this.leftBottom, this.rightTop);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
       return (!isOccupied(position) && position.follows(leftBottom) && position.precedes(rightTop));
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {

        int n = animals.size();
        for(int i=0; i<directions.length; i++){
            animals.get(i%n).moveInsideMap(directions[i]);
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(!isOccupied(position))
            return null;

        for(Animal animal : animals){
            if(animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }
}
