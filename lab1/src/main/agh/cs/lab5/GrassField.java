package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChangeObserver;
import agh.cs.lab7.MapBoundary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private int grassNumber;
    private MapBoundary boundries = new MapBoundary();

    public GrassField(int grassNumber){
        this.grassNumber = grassNumber;
        for(int i=0; i<grassNumber; i++){
           while(!this.placeGrass());
        }
    }

    private boolean placeGrass(){
        int x, y;
        Random rand = new Random();
        x=rand.nextInt((int)sqrt(this.grassNumber*10) + 1);
        y=rand.nextInt((int)sqrt(this.grassNumber*10) + 1);
        Grass grass = new Grass(new Vector2d(x, y));
        if(!isOccupied(grass.getPosition())) {
            hashMapElements.put(grass.getPosition(), grass);
            boundries.addToSet(grass.getPosition());
            return true;
        }
        return false;
    }

    private void animalEatsGrass(Vector2d position){
        hashMapElements.remove(position);
    }

    public Vector2d lowerLeft(){
        return boundries.leftCorner();
    }

    public Vector2d upperRight(){
       return boundries.rightCorner();
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            if(this.isOccupied(animal.getPosition())){
                this.animalEatsGrass(animal.getPosition());
                hashMapElements.put(animal.getPosition(), animal);
                while(!this.placeGrass());
            }
            else  {
                hashMapElements.put(animal.getPosition(), animal);
                boundries.addToSet(animal.getPosition());
            }
            animal.addObserver(this);
            animal.addObserver(boundries);
            return true;
        }
        throw new IllegalArgumentException( animal.getPosition().toString() + " position is already occupied");

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (super.canMoveTo(position)) return true;
        return (objectAt(position) instanceof Grass);

    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IWorldMapElement mapElement = hashMapElements.get(oldPosition);
        Animal animal = (Animal) mapElement;
        hashMapElements.remove(oldPosition);
        if(this.isOccupied(animal.getPosition())){
            this.animalEatsGrass(animal.getPosition());
            boundries.removeFromSet(animal.getPosition());
            hashMapElements.put(newPosition, animal);
            while(!this.placeGrass());
        }
        else  hashMapElements.put(newPosition, animal);
    }

}

