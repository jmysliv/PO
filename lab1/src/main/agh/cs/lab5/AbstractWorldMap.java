package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<IWorldMapElement> mapElements = new ArrayList<>();

    public void run(MoveDirection[] directions) {

        Animal[] animals = mapElements.stream().filter(el -> el instanceof Animal).toArray(Animal[]::new);

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
        for(IWorldMapElement mapElement : mapElements){
            if(mapElement.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public boolean canMoveTo(Vector2d position) {
        if(isOccupied(position) && objectAt(position) instanceof Grass) return true;
        return !isOccupied(position);
    }

    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            mapElements.add(animal);
            return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for(IWorldMapElement mapElement : mapElements){
            if(mapElement.getPosition().equals(position))
                return mapElement;
        }
        return null;
    }

}
