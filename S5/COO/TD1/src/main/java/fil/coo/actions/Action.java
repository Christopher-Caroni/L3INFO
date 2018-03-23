package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.other.Selectable;
import fil.coo.spawnables.beings.GamePlayer;

public interface Action extends Selectable {

    /**
     * @param currentPlayer the player for whom we want to know if this action is possible
     * @return if this action can be executed with the player's current conditions. The conditions vary according to the implementation
     */
    boolean isPossible(GamePlayer currentPlayer);

    /**
     * Executes the implementation of this action
     *
     * @param player the player who is doing the action, which may affect him.
     * @throws ActionCannotBeExecutedException if the action is not supposed to be executed according to the player's conditions
     */
    void execute(GamePlayer player) throws ActionCannotBeExecutedException;


}
