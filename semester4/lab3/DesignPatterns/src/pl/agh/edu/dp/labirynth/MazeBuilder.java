package pl.agh.edu.dp.labirynth;

import java.util.List;

public interface MazeBuilder {
    Room createRoom();

    void addDoorBetweenRooms(Room r1, Room r2);

    void addWallBetweenRooms(Room r1, Room r2, Direction direction);

}
