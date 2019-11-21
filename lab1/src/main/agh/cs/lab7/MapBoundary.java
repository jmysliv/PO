package agh.cs.lab7;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.IWorldMapElement;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private SortedSet<Vector2d> elementsByX =  new TreeSet<>((a, b) ->{
        if(a.x != b.x) return a.x-b.x;
        return a.y - b.y;
    });

    private SortedSet<Vector2d> elementsByY =  new TreeSet<>((a, b) ->{
        if(a.x != b.x) return a.y-b.y;
        return a.x - b.x;
    });

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        elementsByX.remove(oldPosition);
        elementsByX.add(newPosition);
        elementsByY.remove(oldPosition);
        elementsByY.add(newPosition);
    }

    public void addToSet(Vector2d position){
        elementsByY.add(position);
        elementsByX.add(position);
    }

    public void removeFromSet(Vector2d position){
        elementsByX.remove(position);
        elementsByY.remove(position);
    }

    public Vector2d leftCorner(){
        return new Vector2d(elementsByX.first().x, elementsByY.first().y);
    }

    public Vector2d rightCorner(){
        return new Vector2d(elementsByX.last().x, elementsByY.last().y);
    }
}
