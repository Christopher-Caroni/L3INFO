package fil.coo.structures;

import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.items.interfaces.Item;
import fil.coo.other.Direction;

import java.util.List;
import java.util.Map;

public class Room {

    private List<? super Item> items;

    private List<Monster> monsters;

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

    public void addItems(List<? extends Item> itemsList) {
        items.addAll(itemsList);
    }

    public void addSingleItem(Item item) {
        items.add(item);
    }

    public void addMonsters(List<Monster> monstersToAdd) {
        this.monsters.addAll(monstersToAdd);
    }
}
