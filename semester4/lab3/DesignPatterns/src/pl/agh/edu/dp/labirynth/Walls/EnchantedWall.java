package pl.agh.edu.dp.labirynth.Walls;

import pl.agh.edu.dp.labirynth.Player;

public class EnchantedWall extends Wall {

    @Override
    public void Enter(Player player){
        System.out.println("Enchanted Wall, zyskujesz 5 życia");
        player.setHealth(player.getHealth() + 5);
    }
}
