package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChangeObserver;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected HashMap<Vector2d, IWorldMapElement>  hashMapElements= new HashMap<>();

    public void run(MoveDirection[] directions) {

        IWorldMapElement[] mapElements = hashMapElements.values().toArray(new IWorldMapElement[0]);
        Animal[] animals = Arrays.stream(mapElements).filter(el -> el instanceof Animal).toArray(Animal[]::new);

        int n = animals.length;
        for(int i=0; i<directions.length; i++){
            animals[i%n].moveInsideMap(directions[i]);
        }
    }

    protected abstract Vector2d lowerLeft();

    protected abstract Vector2d upperRight();

    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        Vector2d leftBottom = this.lowerLeft();
        Vector2d rightTop = this.upperRight();
        return map.draw(leftBottom, rightTop);
    }

    public boolean isOccupied(Vector2d position) {
        return hashMapElements.get(position) != null;
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            hashMapElements.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        throw new IllegalArgumentException( animal.getPosition().toString() + " position is already occupied");

    }

    public Object objectAt(Vector2d position) {
        return hashMapElements.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IWorldMapElement mapElement = hashMapElements.get(oldPosition);
        Animal animal = (Animal) mapElement;
        hashMapElements.remove(oldPosition);
        hashMapElements.put(newPosition, animal);
    }

}
