package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.Item;
import fil.coo.util.Menu;
import org.apache.log4j.Logger;

import java.util.List;

public class PickupItem implements Action {

    final static Logger logger = Logger.getLogger(PickupItem.class);

    @Override
    public boolean isPossible(GamePlayer currentPlayer) {
        return currentPlayer.hasItemsInCurrentRoom() && currentPlayer.isCurrentRoomRevealed();
    }

    @Override
    public void execute(GamePlayer player) throws ActionCannotBeExecutedException {
        List<Item> itemInRoom = player.getItemsFromRoom();
        if (isPossible(player)) {
            logger.info("Choose an item from the room:");
            Item choice = Menu.getInstance().chooseElement(itemInRoom);

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
