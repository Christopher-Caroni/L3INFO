package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.util.Menu;
import org.apache.log4j.Logger;

import java.util.List;

public class Move implements Action {

    final static Logger logger = org.apache.log4j.Logger.getLogger(Move.class);

    public boolean isPossible(GamePlayer currentPlayer) {
        return !currentPlayer.getCurrentRoom().hasMonsters() && currentPlayer.isCurrentRoomRevealed() && currentPlayer.currentRoomHasNeighbour();
    }

    /**
     * Asks the player to choose a direction and calls {@link GamePlayer#moveToDirection(Direction)}
     *
     * @param player the player that will move
     */
    public void execute(GamePlayer player) throws ActionCannotBeExecutedException {

        List<Direction> possibleDirections = player.getPossibleMoveDirections();
        if (isPossible(player)) {
            Direction direction = Menu.getInstance().chooseElement(possibleDirections);

            player.moveToDirection(direction);
            logger.info("You travel " + direction.getMenuDescription() + " and enter a new room.");
        } else {
            throw new ActionCannotBeExecutedException("Cannot execute " + this.getClass().getSimpleName());
        }
    }

    @Override
    public String getMenuDescription() {
        return "Go to another room";
    }
}
