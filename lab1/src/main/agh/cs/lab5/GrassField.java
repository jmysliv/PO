package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField implements IWorldMap{

    private Vector2d leftBottom = null;
    private Vector2d rightTop = null;
    private List<Animal> animals = new ArrayList<>();
    private List<Grass> grasses = new ArrayList<>();

    public GrassField(int grassNumber){
        int x, y;
        Random rand = new Random();
        for(int i=0; i<grassNumber; i++){
            x=rand.nextInt((int)sqrt(grassNumber*10) + 1);
            y=rand.nextInt((int)sqrt(grassNumber*10) + 1);
            Grass grass = new Grass(new Vector2d(x, y));
            leftBottom = grass.getPosition().lowerLeft(leftBottom);
            rightTop = grass.getPosition().upperRight(rightTop);
            grasses.add(grass);
        }
    }

    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(this.leftBottom, this.rightTop);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!isOccupied(position)){
            return true;
        }
        if(objectAt(position) instanceof Grass) return true;
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animals.add(animal);
            leftBottom = animal.getPosition().lowerLeft(leftBottom);
            rightTop = animal.getPosition().upperRight(rightTop);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int n = animals.size();
        for(int i=0; i<directions.length; i++){
            animals.get(i%n).moveInsideMap(directions[i]);
            leftBottom = animals.get(i%n).getPosition().lowerLeft(leftBottom);
            rightTop = animals.get(i%n).getPosition().upperRight(rightTop);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPosition().equals(position))
                return true;
        }
        for(Grass grass : grasses){
            if(grass.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPosition().equals(position))
                return animal;
        }
        for(Grass grass : grasses){
            if(grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }
}
