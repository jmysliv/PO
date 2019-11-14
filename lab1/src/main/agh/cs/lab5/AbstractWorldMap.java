package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<IWorldMapElement> mapElements = new ArrayList<>();
    protected HashMap<Vector2d, IWorldMapElement>  hashMapElements= new HashMap<>();

    public void run(MoveDirection[] directions) {

        Animal[] animals = mapElements.stream().filter(el -> el instanceof Animal).toArray(Animal[]::new);

        int n = animals.length;
        Animal animalThatMoves;
        for(int i=0; i<directions.length; i++){
            hashMapElements.remove(animals[i%n].getPosition());
            animals[i%n].moveInsideMap(directions[i]);
            hashMapElements.put(animals[i%n].getPosition(), animals[i%n]);
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
//        for(IWorldMapElement mapElement : mapElements){
//            if(mapElement.getPosition().equals(position))
//                return true;
//        }
//        return false;
        return hashMapElements.get(position) != null;
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            mapElements.add(animal);
            hashMapElements.put(animal.getPosition(), animal);
            return true;
        }
        return false;
        //throw new IllegalArgumentException( animal.getPosition().toString() + " position is already occupied");

    }

    public Object objectAt(Vector2d position) {
//        Object grassUnderAnimal = null;
//        for(IWorldMapElement mapElement : mapElements){
//            if(mapElement.getPosition().equals(position)){
//                if(mapElement instanceof Grass) grassUnderAnimal = mapElement;
//                else return mapElement;
//            }
//
//        }
//        return grassUnderAnimal;
        return hashMapElements.get(position);
    }

}
