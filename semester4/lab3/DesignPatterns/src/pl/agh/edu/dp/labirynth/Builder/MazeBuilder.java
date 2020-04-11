package pl.agh.edu.dp.labirynth.Builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Rooms.Room;

public interface MazeBuilder {
    Room createRoom();

    void addDoorBetweenRooms(Room r1, Room r2);

    void addWallBetweenRooms(Room r1, Room r2, Direction direction);

}
