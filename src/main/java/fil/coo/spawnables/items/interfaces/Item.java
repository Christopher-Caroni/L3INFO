package fil.coo.spawnables.items.interfaces;

import fil.coo.other.Selectable;
import fil.coo.spawnables.beings.GamePlayer;

public abstract class Item implements Selectable {

    /**
     * Any item must be able to be used, but at the end, it disappears from the room.
     * @param player
     */
    public final void use(GamePlayer player) {
        applySpecificEffect(player);
        player.confirmItemUseFromRoom(this);
    }

    protected abstract void applySpecificEffect(GamePlayer player);

}
