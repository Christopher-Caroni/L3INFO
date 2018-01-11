package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.Item;
import fil.coo.util.Menu;
import org.apache.log4j.Logger;

import java.util.List;

public class PickupItem implements Action {

    final static Logger logger = Logger.getLogger(PickupItem.class);

    /**
     * @param currentPlayer the player for whom we want to know if this action is possible
     * @return if the player's room has items and the room is revealed
     */
    @Override
    public boolean isPossible(GamePlayer currentPlayer) {
        return currentPlayer.hasItemsInCurrentRoom() && currentPlayer.isCurrentRoomRevealed();
    }

    /**
     * Asks the player which item from the room to pickup. This item is then used immediately.
     *
     * @param player the player who is doing the action, which may affect him.
     * @throws ActionCannotBeExecutedException if !{@link #isPossible(GamePlayer)}
     */
    @Override
    public void execute(GamePlayer player) throws ActionCannotBeExecutedException {
        if (isPossible(player)) {
            logger.info("Choose an item from the room:");
            List<Item> itemsInRoom = player.getItemsFromRoom();
            Item choice = Menu.getInstance().chooseElement(itemsInRoom);

            choice.use(player);
        } else {
            throw new ActionCannotBeExecutedException("Cannot choose an item to pick up because there are no items");
        }
    }

    @Override
    public String getMenuDescription() {
        return "Use an item from the room";
    }
}
