package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.other.Selectable;
import fil.coo.spawnables.beings.GamePlayer;

public interface Action extends Selectable {

    boolean isPossible(GamePlayer currentPlayer);

    /**
     * Execute this action
     *
     * @param player the player who is doing the action, which may affect him.
     * @throws ActionCannotBeExecutedException if the action is not supposed to be executed according to the player's conditions
     */
    void execute(GamePlayer player) throws ActionCannotBeExecutedException;


}
