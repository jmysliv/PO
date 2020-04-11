package pl.agh.edu.dp.labirynth.Doors;

import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.Player;
import pl.agh.edu.dp.labirynth.Rooms.Room;

public class Door extends MapSite {
    private Room room1;
    private Room room2;

    public Door(Room r1, Room r2){
        this.room1 = r1;
        this.room2 = r2;
    }


    @Override
    public void Enter(Player player){
        System.out.println("Przechodzisz przez drzwi");
        if(player.getRoom().equals(room1)){
            player.setRoom(room2);
            room2.Enter(player);
        } else{
            player.setRoom(room1);
            room1.Enter(player);
        }
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }
}
