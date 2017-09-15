package fil.coo.actions;

import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.beings.Player;
import fil.coo.util.Menu;

import java.util.List;

public class Attack extends Action {

    public boolean isPossible(Player currentPlayer) {
        return currentPlayer.getCurrentRoom().hasMonsters();
    }

    public void execute(Player player) {

        // get target
        List<Monster> possibleMonsters = player.getCurrentRoom().getMonsters();
        Monster target = Menu.getInstance().chooseElement(possibleMonsters);

        // apply damage
        target.changeHP(player.getStrength());

        // counter
        if (target.isAlive()) {
            player.changeHP(-target.getStrength());
        }
    }
}
