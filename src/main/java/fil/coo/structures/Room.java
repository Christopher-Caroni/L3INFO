package fil.coo.structures;

import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.interfaces.Item;

import java.util.*;

public class Room {


    private int x;
    private int y;

    private List<Item> items;

    private List<Monster> monsters;

    private EnumMap<Direction, Room> linkedNeighbour;

    private boolean isExit;
    private boolean revealed;

    protected Room(int column, int row) {
        x = column;
        y = row;


        revealed = false;
        items = new ArrayList<>();
        monsters = new ArrayList<>();
        linkedNeighbour = new EnumMap<>(Direction.class);
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
        return !monsters.isEmpty();
    }


    public boolean isExit() {
        return isExit;
    }


    public List<Monster> getMonsters() {
        return monsters;
    }

    /**
     * @return a list of directions of this room's neighbours
     */
    public List<Direction> getNeighboursDirections() {
        List<Direction> directionList = new ArrayList<>();
        for (Map.Entry<Direction, Room> pair : linkedNeighbour.entrySet()) {
            directionList.add(pair.getKey());
        }
        return directionList;
    }

    public void addSingleItem(Item item) {
        if (item == null) {
            throw new NullPointerException("Do not add a null object to the list of items");
        } else {
            items.add(item);
        }
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
     * @param firstRoom  one of the rooms to link
     * @param secondRoom the other room
     * @throws RoomsAreNotNeighboursException if the two rooms are not next to each other, according to their coordinates
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

    /**
     * @return the directions of this room's neighbours
     */
    public String neighbourDirectionsToString() {
        StringBuilder stringBuilder = new StringBuilder("Neighbours=[\n");
        for (Map.Entry<Direction, Room> pair : linkedNeighbour.entrySet()) {
            stringBuilder
                    .append("\t")
                    .append(pair.getKey())
                    .append(",\n");
        }
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

    /**
     * Removes <b>item</b> from the room
     *
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        items.remove(item);
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

    public boolean hasItems() {
        return !items.isEmpty();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setIsExitRoom(boolean exitRoom) {
        this.isExit = exitRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (x != room.x) return false;
        if (y != room.y) return false;
        if (isExit != room.isExit) return false;
        if (!items.equals(room.items)) return false;
        return monsters.equals(room.monsters);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + items.hashCode();
        result = 31 * result + monsters.hashCode();
        result = 31 * result + (isExit ? 1 : 0);
        return result;
    }

    public void removeMonster(Monster target) {
        monsters.remove(target);
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }
}
