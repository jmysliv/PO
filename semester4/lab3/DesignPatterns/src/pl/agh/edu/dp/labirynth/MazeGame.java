package pl.agh.edu.dp.labirynth;

public class MazeGame {

    public void createMaze(MazeBuilder mazeBuilder){
        Room r1 = mazeBuilder.createRoom();
        Room r2 = mazeBuilder.createRoom();
        mazeBuilder.addWallBetweenRooms(r1, r2, Direction.North);
        mazeBuilder.addDoorBetweenRooms(r1, r2);

    }
}
