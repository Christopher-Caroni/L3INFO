package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;

public class Rest extends Action {

    private int cost = -1;
    private int hpRestoration = 10;

    public boolean isPossible(GamePlayer currentPlayer) {
        return !currentPlayer.getCurrentRoom().hasMonsters() && currentPlayer.hasEnoughGold(1);
    }

    /**
     * Restores {@link #hpRestoration} and makes the player use {@link #cost} gold.
     *
     * @param player the player that will rest.
     */
    public void execute(GamePlayer player) {
        if (player.hasEnoughGold(cost)) {
            player.changeGold(cost);
            player.changeHP(hpRestoration);
        } else {
            throw new ActionCannotBeExecutedException("Cannot execute " + this.getClass().getSimpleName());
        }
    }

    @Override
    public String getMenuDescription() {
        return "Rest here";
    }
}
