package fil.coo.spawnables.beings;

import fil.coo.actions.Action;
import fil.coo.other.Direction;
import fil.coo.spawnables.items.interfaces.Item;
import fil.coo.util.Menu;

import java.util.List;

public class Player extends GameCharacter {

    private List actions;

    public void act() {

        List<Action> possibleActions = getPossibleActions();
        Action action = Menu.getInstance().chooseElement(possibleActions);

        action.execute(this);

        // TODO

    }

    public void moveToDirection(Direction direction) {
        // TODO
    }

    public List<Action> getPossibleActions() {
        // TODO
        return null;
    }


    @Override
    public String getMenuDescription() {
        // TODO
        return null;
    }

    /**
     * The <b>item</b> used has finished its {@link Item#use(Player)} method and should now be removed from the game.
     *
     * @param item
     */
    public void confirmItemUseFromRoom(Item item) {
        currentRoom.removeItem(item);
    }

    /**
     * @param cost the cost of whatever needs to be evaluated
     * @return whether the player has enough gold for the <b>cost</b>
     */
    public boolean hasEnoughGold(int cost) {
        return gold >= cost;
    }
}
