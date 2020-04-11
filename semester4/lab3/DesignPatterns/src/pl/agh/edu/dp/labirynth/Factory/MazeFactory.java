package pl.agh.edu.dp.labirynth.Factory;

import pl.agh.edu.dp.labirynth.Doors.Door;
import pl.agh.edu.dp.labirynth.Rooms.Room;
import pl.agh.edu.dp.labirynth.Walls.Wall;

public class MazeFactory {

    private static MazeFactory instance;

    public static MazeFactory getInstance(){
        if(instance == null){
            instance = new MazeFactory();
        }
        return instance;
    }

    public Room makeRoom(int number){
        return new Room(number);
    }

    public Wall makeWall(){
        return new Wall();
    }

    public Door makeDoor(Room r1, Room r2){
        return new Door(r1, r2);
    }
}
