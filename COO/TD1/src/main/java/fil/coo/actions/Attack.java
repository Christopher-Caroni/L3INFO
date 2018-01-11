package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.beings.Monster;
import fil.coo.util.Menu;
import org.apache.log4j.Logger;

import java.util.List;

public class Attack implements Action {

    final static Logger logger = Logger.getLogger(Action.class);

    /**
     *
     * @param currentPlayer the player for whom we want to know if this action is possible
     * @return if the player's room has monsters and the room is revealed.
     */
    public boolean isPossible(GamePlayer currentPlayer) {
        return currentPlayer.getCurrentRoom().hasMonsters() && currentPlayer.isCurrentRoomRevealed();
    }

    /**
     * Asks the player to target a monster in his room and attacks it. If the monster is still alive, it attacks the player in return.
     *
     * @param player the player that will attack
     * @throws ActionCannotBeExecutedException if !{@link #isPossible(GamePlayer)}
     */
    public void execute(GamePlayer player) throws ActionCannotBeExecutedException {

        if (isPossible(player)) {
            // get target
            List<Monster> possibleMonsters = player.getCurrentRoom().getMonsters();
            Monster target = Menu.getInstance().chooseElement(possibleMonsters);

            // apply damage
            target.changeHP(-player.getStrength());
            logger.info(target.getMenuDescription() + " took " + player.getStrength() + " damage!");

            // counter
            if (target.isAlive()) {
                player.changeHP(-target.getStrength());
                logger.info(target.getMenuDescription() + " is still alive and hits back with " + target.getStrength() + " damage!");
                logger.info("You now have " + player.getHP() + " HP.");
            } else {
                int monsterGold = target.getGold();
                player.removeMonsterFromRoom(target);
                player.changeGold(monsterGold);
                target.setGold(0);

                logger.info("You killed the monster and gained " + monsterGold);
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
