package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.util.Menu;

import java.util.List;

public class Attack implements Action {

    public boolean isPossible(GamePlayer currentPlayer) {
        return currentPlayer.getCurrentRoom().hasMonsters() && currentPlayer.hasRoomRevealed();
    }

    /**
     * Asks the player to target a monster in his room and attacks it. If the monster is still alive, it attacks the player in return.
     *
     * @param player the player that will attack
     */
    public void execute(GamePlayer player) throws ActionCannotBeExecutedException {

        List<Monster> possibleMonsters = player.getCurrentRoom().getMonsters();
        if (isPossible(player)) {
            // get target
            Monster target = Menu.getInstance().chooseElement(possibleMonsters);

            // apply damage
            target.changeHP(-player.getStrength());
            System.out.println(target.getMenuDescription() + " took " + player.getStrength() + " damage!");

            // counter
            if (target.isAlive()) {
                player.changeHP(-target.getStrength());
                System.out.println(target.getMenuDescription() + " is still alive and hits back with " + target.getStrength() + " damage!");
                System.out.println("You now have " + player.getHP() + " HP.");
            }
        } else {
            throw new ActionCannotBeExecutedException("Cannot execute " + this.getClass().getSimpleName());
        }
    }

    @Override
    public String getMenuDescription() {
        return "Attack a monster";
    }
}
