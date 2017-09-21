package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.util.Menu;

import java.util.List;

public class Move extends Action {

    public boolean isPossible(GamePlayer currentPlayer) {
        return !currentPlayer.getCurrentRoom().hasMonsters();
    }

    /**
     * Asks the player to choose a direction and calls {@link GamePlayer#moveToDirection(Direction)}
     *
     * @param player the player that will move
     */
    public void execute(GamePlayer player) {

        List<Direction> possibleDirections = player.getCurrentRoom().getNeighboursDirections();
        if (!possibleDirections.isEmpty()) {
            Direction direction = Menu.getInstance().chooseElement(possibleDirections);

            player.moveToDirection(direction);
        } else {
            throw new ActionCannotBeExecutedException("Cannot execute " + this.getClass().getSimpleName());
        }
    }

    @Override
    public String getMenuDescription() {
        return "Go to another room";
    }
}
