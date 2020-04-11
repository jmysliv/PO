package pl.agh.edu.dp.labirynth.Rooms;

import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.Rooms.Room;

public class EnchantedRoom extends Room {

    public EnchantedRoom(int number){
       super(number);
    }

    @Override
    public void Enter(Player player){
        System.out.println("Enchanted room");
    }
}
