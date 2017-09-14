package fil.coo.objects;

import fil.coo.beings.Monster;
import fil.coo.other.Direction;

import java.util.List;
import java.util.Map;

public class Room {

    private List items;

    private List monsters;

    private Map<Direction, Room> neighbours;

    private boolean isExit;
    private int gold;

    public Room getNeighbour(Direction direction) {
        // TODO
        return null;
    }

    public void addNeighbour(Direction direction, Room room) {
        // TODO
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

}
