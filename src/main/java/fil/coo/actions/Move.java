package fil.coo.actions;

import fil.coo.beings.Player;
import fil.coo.other.Direction;
import fil.coo.util.Menu;

import java.util.List;

public class Move extends Action {

    public boolean isPossible(Player currentPlayer) {
        return !currentPlayer.getCurrentRoom().hasMonsters();
    }

    public void execute(Player player) {

        List<Direction> possibleDirections = player.getCurrentRoom().getNeighboursDirections();
        Direction direction = Menu.getInstance().chooseElement(possibleDirections);

        player.moveToDirection(direction);
    }
}
