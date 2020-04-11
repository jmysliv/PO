package pl.agh.edu.dp.labirynth.Factory;

import pl.agh.edu.dp.labirynth.Doors.Door;
import pl.agh.edu.dp.labirynth.Doors.EnchantedDoor;
import pl.agh.edu.dp.labirynth.Rooms.EnchantedRoom;
import pl.agh.edu.dp.labirynth.Rooms.Room;
import pl.agh.edu.dp.labirynth.Walls.EnchantedWall;
import pl.agh.edu.dp.labirynth.Walls.Wall;

public class EnchantedMazeFactory extends MazeFactory {

    public Room makeRoom(int number){
        return new EnchantedRoom(number);
    }

    public Wall makeWall(){
        return new EnchantedWall();
    }

    public Door makeDoor(Room r1, Room r2){
        return new EnchantedDoor(r1, r2);
    }
}
