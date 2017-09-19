package fil.coo.spawnables.beings;

import fil.coo.other.Selectable;
import fil.coo.structures.Room;

public abstract class Character implements Selectable {

    private int hp;

    private int strength;

    private int gold;

    private Room currentRoom;

    public boolean isAlive() {
        // TODO
        return false;
    }

    public void changeHP(int hp) {
        // TODO
    }

    public void changeGold(int change) {
        // TODO
    }

    public void changeStrength(int strength) {
        // TODO
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getStrength() {
        return strength;
    }
}
