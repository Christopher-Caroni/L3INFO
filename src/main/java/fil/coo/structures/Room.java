package fil.coo.structures;

import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.items.interfaces.Item;

import java.util.*;

public class Room {


    private int x;
    private int y;

    private List<? super Item> items;

    private List<Monster> monsters;

    private Map<Direction, Room> linkedNeighbour;

    private boolean itemsVisibility;
    private boolean monstersVisibility;
    private boolean neighboursVisibility;

    private boolean isExit;
    private int gold;

    protected Room(int column, int row) {
        x = column;
        y = row;


        items = new ArrayList<>();
        monsters = new ArrayList<>();
        linkedNeighbour = new HashMap<>();
    }

    public Room getNeighbour(Direction direction) {
        return linkedNeighbour.get(direction);
    }

    /**
     * Adds the room as a neighbour for the direction
     *
     * @param room
     * @param direction
     */
    private void addNeighbourForDirection(Room room, Direction direction) {
        linkedNeighbour.put(direction, room);
    }


    public boolean hasMonsters() {
        return monsters.size() > 0;
    }


    public boolean isExit() {
        return isExit;
    }


    public List<Monster> getMonsters() {
        return monsters;
    }

    public List<Direction> getNeighboursDirections() {
        List<Direction> directionList = new ArrayList<>();
        for (Map.Entry<Direction, Room> pair : linkedNeighbour.entrySet()) {
            directionList.add(pair.getKey());
        }
        return directionList;
    }

    public void addItems(List<? extends Item> itemsList) {
        items.addAll(itemsList);
    }

    public void addSingleItem(Item item) {
        items.add(item);
    }

    public void addMonsters(List<Monster> monstersToAdd) {
        this.monsters.addAll(monstersToAdd);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets direction from one room to another.
     *
     * @param currentRoom
     * @param neighbour
     * @return
     */
    public static Direction getDirectionFromRoomToOtherRoom(Room currentRoom, Room neighbour) {
        if (currentRoom.getX() == neighbour.getX()) {
            if (currentRoom.getY() == (neighbour.getY() + 1)) {
                return Direction.NORTH;
            } else if (currentRoom.getY() == (neighbour.getY() - 1)) {
                return Direction.SOUTH;
            }
        } else if (currentRoom.getY() == neighbour.getY()) {
            if (currentRoom.getX() == (neighbour.getX() + 1)) {
                return Direction.WEST;
            } else if (currentRoom.getX() == (neighbour.getX() - 1)) {
                return Direction.EAST;
            }
        }
        return null;
    }

    /**
     * Sets these two rooms to have each other as linkedNeighbour. Order has no importance.
     *
     * @param firstRoom
     * @param secondRoom
     * @throws RoomsAreNotNeighboursException
     */
    public static void setRoomsAsNeighbours(Room firstRoom, Room secondRoom) throws RoomsAreNotNeighboursException {
        Direction initialDirection = Room.getDirectionFromRoomToOtherRoom(firstRoom, secondRoom);

        if (initialDirection != null) {
            firstRoom.addNeighbourForDirection(secondRoom, initialDirection);
            secondRoom.addNeighbourForDirection(firstRoom, Direction.getOppositeDirection(initialDirection));
        } else {
            throw new RoomsAreNotNeighboursException("These rooms are not neighbours");
        }
    }

    public boolean hasLinkedNeighbourForDirection(Direction direction) {
        return linkedNeighbour.get(direction) != null;
    }

    public String coordsToString() {
        return "x=[" + x + "], y=[" + y + "]";
    }

    public String neighboursToString() {
        StringBuilder stringBuilder = new StringBuilder("Neighbours=[\n");
        Iterator it = linkedNeighbour.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Direction, Room> pair = (Map.Entry<Direction, Room>) it.next();
            stringBuilder.append("\t" + pair.getKey() + ",\n");
        }
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

    /**
     * Removes <b>item</b> from the room
     * @param item
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    public void setItemsVisibility(boolean itemsVisibility) {
        this.itemsVisibility = itemsVisibility;
    }

    public void setMonstersVisibility(boolean monstersVisibility) {
        this.monstersVisibility = monstersVisibility;
    }

    public void setNeighboursVisibility(boolean neighboursVisibility) {
        this.neighboursVisibility = neighboursVisibility;
    }

    /**
     * Sets the visibilities for the rooms items, monsters and neighbours to true;
     */
    public void revealContents() {
        setItemsVisibility(true);
        setMonstersVisibility(true);
        setNeighboursVisibility(true);
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public int getNumberOfMonsters() {
        return monsters.size();
    }

    public int getNumberOfNeighbours() {
        return linkedNeighbour.size();
    }
}
