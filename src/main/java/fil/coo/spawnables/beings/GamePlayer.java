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

    private int uniqueRoomCount;

    protected static final String MENU_DESC_FORMAT = "%s - %d HP, %d strength";
    protected static final String DEFAULT_NAME = "no_name_chosen";

    public GamePlayer() {
        super();

        name = DEFAULT_NAME;
        uniqueRoomCount = 0;
        initActions();
    }

    @Override
    void setSpecificAttributes(Random random) {
        setRandomStrength(random);
    }

    @Override
    protected void setRandomStrength(Random random) {
        strength = random.nextInt(30) + 30;
    }

    /**
     * Calls {@link GameCharacter#setCurrentRoom(Room)} and then {@link #incrementUniqueRoomCountIfNotVisitedYet()} if the room hasn't been revealed yet.
     *
     * @param currentRoom the room to be set as the player's current room.
     */
    @Override
    public void setCurrentRoom(Room currentRoom) {
        super.setCurrentRoom(currentRoom);
        incrementUniqueRoomCountIfNotVisitedYet();
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
        this.setCurrentRoom(currentRoom.getNeighbour(direction));
        revealCurrentRoom();
    }


    /**
     * @return if the player reached the exit: the room is revealed, contains no monsters and room is exit.
     */
    public boolean reachedExit() throws NullPointerException {
        return currentRoom.isExit() && !currentRoom.hasMonsters() && isCurrentRoomRevealed();
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
        return String.format(MENU_DESC_FORMAT, name, getHP(), getStrength());
    }

    /**
     * The <b>item</b> used has finished its {@link Item#use(GamePlayer)} method and should now be removed from the game.
     *
     * @param item the item used
     */
    public void confirmItemUseFromRoom(Item item) {
        currentRoom.removeItem(item);
    }

    /**
     * Whether the player has enough gold for something. If he has 0 gold, it is considered he has enough for something with a 0 cost.
     *
     * @param cost the cost of whatever needs to be evaluated. Can be either negative or positive
     * @return whether the player has enough gold for the absolute value of <b>cost</b>
     */
    public boolean hasEnoughGold(int cost) {
        return gold >= Math.abs(cost);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * @return if the player's room has items
     * @throws NullPointerException if the player doesn't have a room yet
     */
    public boolean hasItemsInCurrentRoom() throws NullPointerException {
        return currentRoom.hasItems();
    }

    /**
     * @return the list of items in the player's room
     * @throws NullPointerException if the player doesn't have a room yet
     */
    public List<Item> getItemsFromRoom() throws NullPointerException {
        return currentRoom.getItems();

    }

    /**
     * Calls {@link Room#setRevealed(boolean)} with true, to {@link #currentRoom}
     */
    public void revealCurrentRoom() {
        currentRoom.setRevealed(true);
    }

    public boolean isCurrentRoomRevealed() {
        return currentRoom.isRevealed();
    }

    public int getUniqueRoomCount() {
        return uniqueRoomCount;
    }

    private boolean incrementUniqueRoomCountIfNotVisitedYet() {
        if (!currentRoom.isRevealed()) {
            uniqueRoomCount++;
            return true;
        }
        return false;
    }

    /**
     * @return a list of directions where the player can move, according to his current room's {@link Room#getNeighboursDirections()}
     * @throws NullPointerException if the player doesn't have a room yet
     */
    public List<Direction> getPossibleMoveDirections() throws NullPointerException {
        return currentRoom.getNeighboursDirections();
    }

    /**
     * @return if {@link #currentRoom} has any neighbours.
     * @throws NullPointerException if the player doesn't have a currentRoom yet.
     */
    public boolean currentRoomHasNeighbour() throws NullPointerException {
        return currentRoom.getNumberOfNeighbours() > 0;
    }

    public boolean hasEnoughStrength(int cost) {
        return strength >= Math.abs(cost);
    }

    public void removeMonsterFromRoom(Monster target) {
        currentRoom.removeMonster(target);
    }
}
