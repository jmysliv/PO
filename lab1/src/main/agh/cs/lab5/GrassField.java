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

public class GrassField extends AbstractWorldMap{


    public GrassField(int grassNumber){
        int x, y;
        Random rand = new Random();
        for(int i=0; i<grassNumber; i++){
            boolean isEmpty = false;
            while(!isEmpty){
                x=rand.nextInt((int)sqrt(grassNumber*10) + 1);
                y=rand.nextInt((int)sqrt(grassNumber*10) + 1);
                Grass grass = new Grass(new Vector2d(x, y));
                if(!isOccupied(grass.getPosition())){
                    mapElements.add(grass);
                    isEmpty = true;
                }
            }
        }
    }

    public IWorldMapElement getSomeGrassToTestIt(){
        int i=0;
        while(!(mapElements.get(i) instanceof Grass)) i++;
        return mapElements.get(i);

    }

    public Vector2d lowerLeft(){
        Vector2d leftBottom = null;
        for(IWorldMapElement mapElement : mapElements){
            leftBottom = mapElement.getPosition().lowerLeft(leftBottom);
        }
        return leftBottom;
    }

    public Vector2d upperRight(){
        Vector2d rightTop = null;
        for(IWorldMapElement mapElement : mapElements){
            rightTop = mapElement.getPosition().upperRight(rightTop);
        }
        return rightTop;
    }

}
