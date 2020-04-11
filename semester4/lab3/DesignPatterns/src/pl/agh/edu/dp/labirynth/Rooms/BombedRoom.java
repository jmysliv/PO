package pl.agh.edu.dp.labirynth.Rooms;

import pl.agh.edu.dp.labirynth.Player;

public class BombedRoom extends Room{

    public BombedRoom(int number){
        super(number);
    }

    @Override
    public void Enter(Player player){
        System.out.println("Bombed room, umierasz");
        player.setHealth(0);
    }
}
