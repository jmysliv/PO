package pl.agh.edu.dp.labirynth.Builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Doors.Door;
import pl.agh.edu.dp.labirynth.Factory.MazeFactory;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.Rooms.Room;
import pl.agh.edu.dp.labirynth.Walls.Wall;

public class StandardBuilderMaze implements MazeBuilder {

    private Maze currentMaze;
    private MazeFactory factory;

    public StandardBuilderMaze(MazeFactory factory){
        this.currentMaze = new Maze();
        this.factory = factory;
    }

    @Override
    public Room createRoom() {
        Room room = factory.makeRoom(currentMaze.getRoomNumbers());
        for(Direction direction : Direction.values()){
            room.setSide(direction, factory.makeWall());
        }
        currentMaze.addRoom(room);
        return room;
    }

    @Override
    public void addDoorBetweenRooms(Room r1, Room r2) {
        Direction direction = commonWall(r1, r2);
        if(direction == null){
            return;
        }
        Door door = factory.makeDoor(r1, r2);
        r1.setSide(direction, door);
        r2.setSide(Direction.getOpposite(direction), door);
    }

    @Override
    public void addWallBetweenRooms(Room r1, Room r2, Direction direction) {
        Wall wall = factory.makeWall();
        r1.setSide(direction, wall);
        r2.setSide(Direction.getOpposite(direction), wall);
    }


    private Direction commonWall(Room r1, Room r2){
        for(Direction direction : Direction.values()){
            if(r1.getSide(direction).equals(r2.getSide(Direction.getOpposite(direction)))){
                return direction;
            }
        }
        return null;
    }

    public Maze getCurrentMaze() {
        return currentMaze;
    }
}
