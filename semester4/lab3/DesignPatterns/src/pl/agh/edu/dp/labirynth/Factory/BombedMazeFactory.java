package pl.agh.edu.dp.labirynth.Factory;

import pl.agh.edu.dp.labirynth.Rooms.BombedRoom;
import pl.agh.edu.dp.labirynth.Rooms.Room;
import pl.agh.edu.dp.labirynth.Walls.BombedWall;
import pl.agh.edu.dp.labirynth.Walls.Wall;

public class BombedMazeFactory extends MazeFactory{

    public Room makeRoom(int number){
        return new BombedRoom(number);
    }

    public Wall makeWall(){
        return new BombedWall();
    }
}
