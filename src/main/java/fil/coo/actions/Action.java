package fil.coo.actions;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.other.Selectable;

public abstract class Action implements Selectable {

    public abstract boolean isPossible(GamePlayer currentPlayer);

    public abstract void execute(GamePlayer player);


}
