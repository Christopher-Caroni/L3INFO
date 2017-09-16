package fil.coo.structures;

import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.items.interfaces.Item;

import java.util.List;
import java.util.Map;

public class Room {

    protected Room() {
    }

    private int x;
    private int y;


    private List<? super Item> items;

    private List<Monster> monsters;

    private Map<Direction, Room> neighbours;

    private boolean isExit;
    private int gold;

    public Room getNeighbour(Direction direction) {
        // TODO
        return null;
    }

    /**
     * Adds the room as a neighbour for the direction
     *
     * @param room
     * @param direction
     */
    private void addNeighbourForDirection(Room room, Direction direction) {
        neighbours.put(direction, room);
    }


    public boolean hasMonsters() {
        // TODO
        return false;
    }


    public boolean isExit() {
        // TODO
        return false;
    }


    public List<Monster> getMonsters() {
        return monsters;
    }

    public List<Direction> getNeighboursDirections() {
        // TODO
        return null;
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
            if (currentRoom.getY() == (neighbour.getY() - 1)) {
                return Direction.NORTH;
            } else if (currentRoom.getY() == (neighbour.getY() + 1)) {
                return Direction.SOUTH;
            }
        } else if (currentRoom.getY() == neighbour.getY()) {
            if (currentRoom.getX() == (neighbour.getX() - 1)) {
                return Direction.WEST;
            } else if (currentRoom.getX() == (neighbour.getX() + 1)) {
                return Direction.EAST;
            }
        }
        return null;
    }

    /**
     * Sets these two rooms to have each other as neighbours. Order has no importance.
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
}
