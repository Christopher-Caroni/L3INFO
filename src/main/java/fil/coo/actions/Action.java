package fil.coo.actions;

import fil.coo.spawnables.beings.Player;
import fil.coo.other.Selectable;

public abstract class Action implements Selectable {

    public abstract boolean isPossible(Player currentPlayer);

    public abstract void execute(Player player);


}
