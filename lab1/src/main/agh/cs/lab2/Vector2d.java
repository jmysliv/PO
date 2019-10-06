package agh.cs.lab2;

public class Vector2d {

    public final int x, y;

    public Vector2d(int x, int y){
        this.x=x;
        this.y=y;
    }

    public String toString(){
        String result = "(" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")" ;
        return result;
    }

    public boolean smaller(Vector2d other){
        if(this.x<=other.x && this.y<=other.y) return true;
        return false;
    }

    public boolean larger(Vector2d other){
        if(this.x>=other.x && this.y>=other.y) return true;
        return false;
    }

    public Vector2d upperRight(Vector2d other){
        int x, y;
        if(this.x > other.x) x=this.x;
        else x=other.x;

        if(this.y > other.y) y=this.y;
        else y=other.y;

        Vector2d result = new Vector2d(x, y);
        return result;
    }

    public Vector2d lowerLeft(Vector2d other){
        int x, y;
        if(this.x < other.x) x=this.x;
        else x=other.x;

        if(this.y < other.y) y=this.y;
        else y=other.y;

        Vector2d result = new Vector2d(x, y);
        return result;
    }

    public Vector2d add(Vector2d other){
        Vector2d result = new Vector2d(this.x + other.x, this.y + other.y);
        return result;
    }

    public Vector2d substract(Vector2d other){
        Vector2d result = new Vector2d(this.x - other.x, this.y - other.y);
        return result;
    }

    boolean equals(Vector2d other){
        return (this.larger(other) && this.smaller(other));
    }
}
