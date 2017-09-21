package fil.coo.spawnables.beings;

import fil.coo.actions.*;
import fil.coo.other.Direction;
import fil.coo.spawnables.items.interfaces.Item;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer extends GameCharacter {

    private List<Action> actions;
    private String name;
    private boolean reachedExit;

    public GamePlayer() {
        super();

        name = "no_name";
        initActions();
    }

    private void initActions() {
        actions = new ArrayList<>();
        actions.add(new Attack());
        actions.add(new Look());
        actions.add(new Move());
        actions.add(new Rest());
        actions.add(new ExitDungeon());
        actions.add(new PickupItem());
    }

    /**
     * Moves the player to the room in the <b>direction</b>
     *
     * @param direction the direction from the player's current room to the neighbour
     */
    public void moveToDirection(Direction direction) {
        this.currentRoom = this.currentRoom.getNeighbour(direction);
    }

    public List<? extends Action> getPossibleActions() {
        List<Action> possibleActions = new ArrayList<>();
        for (Action checkAction : actions) {
            if (checkAction.isPossible(this)) {
                possibleActions.add(checkAction);
            }
        }
        return possibleActions;
    }


    @Override
    public String getMenuDescription() {
        return name + " - " + getHP() + " HP, " + getStrength() + " strength";
    }

    /**
     * The <b>item</b> used has finished its {@link Item#use(GamePlayer)} method and should now be removed from the game.
     *
     * @param item
     */
    public void confirmItemUseFromRoom(Item item) {
        currentRoom.removeItem(item);
    }

    /**
     * @param cost the cost of whatever needs to be evaluated. Can be either negative or positive
     * @return whether the player has enough gold for the absolute value of <b>cost</b>
     */
    public boolean hasEnoughGold(int cost) {
        return gold >= Math.abs(cost);
    }

    public void revealRoom() {
        currentRoom.revealContents();
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean reachedExit() {
        return reachedExit;
    }

    public boolean isInExitRoom() {
        return currentRoom.isExit();
    }

    public void setReachedExit(boolean reachedExit) {
        this.reachedExit = reachedExit;
    }

    public String getName() {
        return name;
    }

    public boolean hasItemsInCurrentRoom() {
        return currentRoom.hasItems();
    }

    public List<Item> getItemsFromRoom() {
        return currentRoom.getItems();

    }

    public int getGold() {
        return gold;
    }
}
