package pl.agh.edu.dp.labirynth.Walls;

import pl.agh.edu.dp.labirynth.Player;

public class BombedWall extends Wall {

    @Override
    public void Enter(Player player){
        System.out.println("Bombed Wall, tracisz 10 życia");
        player.setHealth(player.getHealth() - 10);
    }
}
