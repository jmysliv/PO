package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.Builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.Builder.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.Factory.MazeFactory;
import pl.agh.edu.dp.labirynth.Rooms.Room;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class MazeGame {

    private Maze maze;

    private void createMaze(MazeFactory mazeFactory){
        StandardBuilderMaze mazeBuilder = new StandardBuilderMaze(mazeFactory);
        Room r1 = mazeBuilder.createRoom();
        Room r2 = mazeBuilder.createRoom();
        Room r3 = mazeBuilder.createRoom();
        Room r4 = mazeBuilder.createRoom();
        mazeBuilder.addWallBetweenRooms(r1, r2, Direction.South);
        mazeBuilder.addWallBetweenRooms(r1, r4, Direction.East);
        mazeBuilder.addWallBetweenRooms(r2, r3, Direction.East);
        mazeBuilder.addWallBetweenRooms(r4, r3, Direction.South);
        mazeBuilder.addDoorBetweenRooms(r1, r2);
        mazeBuilder.addDoorBetweenRooms(r2, r3);
        mazeBuilder.addDoorBetweenRooms(r3, r4);
        this.maze = mazeBuilder.getCurrentMaze();
    }

    public void startGame(){
        this.createMaze(MazeFactory.getInstance());
        Player player = new Player(100, Direction.North, this.maze.getRooms().get(0));
        while(player.getHealth() > 0 && !player.getRoom().equals(this.maze.getRooms().get(this.maze.getRoomNumbers() - 1))){
            cycle(player);
        }
        System.out.println("Koniec gry");
    }

    private void cycle(Player player){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWybierz: \n a - by obrócić się w lewo\nd - by obrócić się w prawo\nw - by iść przed siebie");
        String choice = scan.nextLine();
        switch(choice){
            case "a":
                player.turnLeft();
                break;
            case "d":
                player.turnRight();
                break;
            case "w":
                player.moveAhead();
                break;
            default:
                System.out.println("Zły wybór");
                break;
        }
        System.out.println("Pozostałe życię: " + player.getHealth());
    }
}
