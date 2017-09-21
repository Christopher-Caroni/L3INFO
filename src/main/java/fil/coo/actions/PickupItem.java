package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.items.interfaces.Item;
import fil.coo.util.Menu;

import java.util.List;

public class PickupItem extends Action {
    @Override
    public boolean isPossible(GamePlayer currentPlayer) {
        return currentPlayer.hasItemsInCurrentRoom();
    }

    @Override
    public void execute(GamePlayer player) {
        List<Item> itemInRoom = player.getItemsFromRoom();
        if (itemInRoom.isEmpty()) {
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
