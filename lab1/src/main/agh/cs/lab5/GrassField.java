package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private int grassNumber;

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
            return true;
        }
        return false;
    }

    private void animalEatsGrass(Vector2d position){
        hashMapElements.remove(position);
    }

    public Vector2d lowerLeft(){
        Vector2d leftBottom = null;
        IWorldMapElement[] mapElements = hashMapElements.values().toArray(new IWorldMapElement[0]);
        for(IWorldMapElement mapElement : mapElements){
            leftBottom = mapElement.getPosition().lowerLeft(leftBottom);
        }
        return leftBottom;
    }

    public Vector2d upperRight(){
        Vector2d rightTop = null;
        IWorldMapElement[] mapElements = hashMapElements.values().toArray(new IWorldMapElement[0]);
        for(IWorldMapElement mapElement : mapElements){
            rightTop = mapElement.getPosition().upperRight(rightTop);
        }
        return rightTop;
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            if(this.isOccupied(animal.getPosition())){
                this.animalEatsGrass(animal.getPosition());
                hashMapElements.put(animal.getPosition(), animal);
                while(!this.placeGrass());
            }
            else  hashMapElements.put(animal.getPosition(), animal);
            return true;
        }
        return false;
        //throw new IllegalArgumentException( animal.getPosition().toString() + " position is already occupied");

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (super.canMoveTo(position)) return true;
        return (objectAt(position) instanceof Grass);

    }
}
