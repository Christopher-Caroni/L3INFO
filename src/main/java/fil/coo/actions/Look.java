package fil.coo.actions;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.structures.Room;
import fil.coo.util.Menu;

public class Look extends Action {

    public boolean isPossible(GamePlayer currentPlayer) {
        return true;
    }

    /**
     * Calls {@link GamePlayer#revealRoom()} and {@link Menu#printRoomDescription(Room)} for the player's room.
     *
     * @param player the player that will look
     */
    public void execute(GamePlayer player) {
        player.revealRoom();
        Menu.getInstance().printRoomDescription(player.getCurrentRoom());
    }

    @Override
    public String getMenuDescription() {
        return "Look around";
    }
}
