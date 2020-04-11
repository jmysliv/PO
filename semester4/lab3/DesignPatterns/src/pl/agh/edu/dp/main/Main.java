package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = new MazeGame();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        CountingMazeBuilder countingMazeBuilder = new CountingMazeBuilder();
        mazeGame.createMaze(countingMazeBuilder);

        System.out.println(countingMazeBuilder.getCounts());
    }
}



