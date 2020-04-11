package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.Rooms.Room;

public class Player {
    private int health;
    private Direction direction;
    private Room room;

    public Player(int health, Direction direction, Room room){
        this.health = health;
        this.direction = direction;
        this.room = room;
    }

    public void turnLeft(){
        this.direction = Direction.getPrevious(this.direction);
    }

    public void turnRight(){
        this.direction = Direction.getNext(this.direction);
    }

    public void moveAhead(){
        MapSite mapSite = room.getSide(this.direction);
        mapSite.Enter(this);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
