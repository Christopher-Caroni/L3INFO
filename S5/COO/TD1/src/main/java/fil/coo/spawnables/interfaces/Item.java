package fil.coo.spawnables.interfaces;

import fil.coo.other.Selectable;
import fil.coo.spawnables.beings.GamePlayer;

/**
 * Interface specifying how a {@link GamePlayer} may interact with Items.
 * Implements the {@link ISingleSpawnable} as Items should only be spawned one at a time.
 *
 * @param <T> the type of {@link Item} the implementing class will spawn.
 */
public abstract class Item<T extends Item<T>> implements Selectable, ISingleSpawnable<T> {

    /**
     * Any item must be able to be used, but at the end, it disappears from the room.
     * This use() applies an effect on the player, depending on the Item implementation, through {@link #applySpecificEffect(GamePlayer)}.
     *
     * @param player the player on which to apply the effect on
     */
    public final void use(GamePlayer player) {
        applySpecificEffect(player);
        player.confirmItemUseFromRoom(this);
    }

    /**
     * Apply the effect specific to the implementing class on the player
     *
     * @param player the player on which to apply the effect on
     */
    protected abstract void applySpecificEffect(GamePlayer player);

    /**
     * @return the amount of whatever this Item represents
     */
    public abstract int getAmount();

    /**
     * @param amount the amount of whatever this Item represents
     */
    public abstract void setAmount(int amount);
}
