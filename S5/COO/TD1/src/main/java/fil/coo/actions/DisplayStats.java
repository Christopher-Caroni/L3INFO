package fil.coo.actions;

import fil.coo.spawnables.beings.GamePlayer;
import org.apache.log4j.Logger;

public class DisplayStats implements Action {

    final static Logger logger = Logger.getLogger(DisplayStats.class);

    /**
     * @param currentPlayer the player for whom we want to know if this action is possible
     * @return true: this action is always possible
     */
    @Override
    public boolean isPossible(GamePlayer currentPlayer) {
        return true;
    }

    /**
     * @param player the player who is doing the action, which may affect him.
     */
    @Override
    public void execute(GamePlayer player) {
        logger.info("You have " + player.getHP() + " HP and " + player.getStrength() + " strength.");
        logger.info("You have visited " + player.getUniqueRoomCount() + " separate room(s).");
    }

    @Override
    public String getMenuDescription() {
        return "Show my stats";
    }
}
