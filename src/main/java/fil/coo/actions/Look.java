package fil.coo.actions;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.structures.Room;
import fil.coo.util.Menu;

public class Look implements Action {

    /**
     *
     * @param currentPlayer the player for whom we want to know if this action is possible
     * @return true: this action is always possible
     */
    public boolean isPossible(GamePlayer currentPlayer) {
        return true;
    }

    /**
     * Calls {@link GamePlayer#revealCurrentRoom()} and {@link Menu#printRoomDescription(Room)} for the player's room.
     *
     * @param player the player that will look
     */
    public void execute(GamePlayer player) {
        player.revealCurrentRoom();
        Menu.getInstance().printRoomDescription(player.getCurrentRoom());
    }

    @Override
    public String getMenuDescription() {
        return "Look around";
    }
}
