package pl.agh.edu.dp.labirynth.Doors;

import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.Rooms.Room;

public class EnchantedDoor extends Door {

    public EnchantedDoor(Room r1, Room r2){
        super(r1, r2);
    }
    @Override
    public void Enter(Player player){
        System.out.println("Enchanted Door");
        if(player.getRoom().equals(super.getRoom1())){
            player.setRoom(super.getRoom2());
            super.getRoom2().Enter(player);
        } else{
            player.setRoom(super.getRoom1());
            super.getRoom1().Enter(player);
        }
    }
}
