package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import org.apache.log4j.Logger;

import java.util.Random;

public class Rest implements Action {

    final static Logger logger = Logger.getLogger(Rest.class);

    private int cost;
    private int hpRestoration;

    public Rest() {
        Random random = new Random();
        cost = random.nextInt(10) + 1;
        hpRestoration = random.nextInt(5) + 5;
    }

    public boolean isPossible(GamePlayer currentPlayer) {
        return !currentPlayer.getCurrentRoom().hasMonsters() && currentPlayer.hasEnoughStrength(cost) && currentPlayer.isCurrentRoomRevealed();
    }

    /**
     * Restores {@link #hpRestoration} and makes the player use {@link #cost} strength.
     *
     * @param player the player that will rest.
     */
    public void execute(GamePlayer player) throws ActionCannotBeExecutedException {
        if (isPossible(player)) {
            player.changeStrength(cost);
            player.changeHP(hpRestoration);
            logger.info("You used " + Math.abs(cost) + " strength and restored " + hpRestoration + " HP");
            logger.info("You now have " + player.getStrength() + " strength and " + player.getHP() + " HP");
        } else {
            throw new ActionCannotBeExecutedException("Cannot execute " + this.getClass().getSimpleName());
        }
    }

    @Override
    public String getMenuDescription() {
        return "Rest here";
    }
}
