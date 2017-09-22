package fil.coo.spawnables.beings;

import fil.coo.actions.*;
import fil.coo.other.Direction;
import fil.coo.spawnables.interfaces.Item;
import fil.coo.structures.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePlayer extends GameCharacter {

    private List<Action> actions;
    private String name;
    private boolean reachedExit;

    private boolean roomRevealed;
    private int uniqueRoomCount;

    public GamePlayer() {
        super();

        name = "no_name";
        roomRevealed = false;
        uniqueRoomCount = 1; // starting room
        initActions();
    }

    @Override
    protected void setRandomStrength(Random random) {
        strength = random.nextInt(30) + 30;
    }

    private void initActions() {
        actions = new ArrayList<>();
        actions.add(new Attack());
        actions.add(new Look());
        actions.add(new Move());
        actions.add(new Rest());
        actions.add(new PickupItem());
        actions.add(new DisplayStats());
    }

    /**
     * Moves the player to the room in the <b>direction</b>
     *
     * @param direction the direction from the player's current room to the neighbour
     */
    public void moveToDirection(Direction direction) {
        this.currentRoom = this.currentRoom.getNeighbour(direction);
        setRoomRevealed(false);
        setUniqueRoomCount(uniqueRoomCount + 1);

        System.out.println("\nYou travel " + direction.getMenuDescription() + " and enter a new room.");

        verifyExit();
    }

    public void verifyExit() {
        reachedExit = currentRoom.isExit() && !currentRoom.hasMonsters() && roomRevealed;
    }

    /**
     * Goes through the player's actions, and returns only those that are possible in his current situation.
     *
     * @return a List of the only possible actions
     */
    public List<Action> getPossibleActions() {
        List<Action> possibleActions = new ArrayList<>(actions.size());
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
        setRoomRevealed(true);
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

    public void setRoomRevealed(boolean roomRevealed) {
        this.roomRevealed = roomRevealed;
    }

    public boolean hasRoomRevealed() {
        return roomRevealed;
    }

    public int getUniqueRoomCount() {
        return uniqueRoomCount;
    }

    public void setUniqueRoomCount(int uniqueRoomCount) {
        this.uniqueRoomCount = uniqueRoomCount;
    }

    /**
     * @return a list of directions where the player can move, according to his current room's {@link Room#getNeighboursDirections()}
     */
    public List<Direction> getPossibleMoveDirections() {
        return currentRoom.getNeighboursDirections();
    }

    public boolean canChangeRoom() {
        return currentRoom.getNumberOfNeighbours() > 0;
    }
}
