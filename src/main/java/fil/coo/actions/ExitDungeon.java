package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;

public class ExitDungeon extends Action {
    @Override
    public boolean isPossible(GamePlayer currentPlayer) {
        return currentPlayer.isInExitRoom() && !currentPlayer.getCurrentRoom().hasMonsters() && currentPlayer.hasRoomRevealed();
    }

    /**
     * Sets {@link GamePlayer#reachedExit()} with true.
     * @param player
     */
    @Override
    public void execute(GamePlayer player) {
        if (!isPossible(player)) {
            throw new ActionCannotBeExecutedException("This room is not the exit or there are still monsters");
        }
        player.setReachedExit(true);
    }

    @Override
    public String getMenuDescription() {
        return "Exit the dungeon";
    }
}
