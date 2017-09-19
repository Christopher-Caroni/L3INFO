package fil.coo.spawnables.beings;

import fil.coo.exception.NegativeGoldException;
import fil.coo.other.Selectable;
import fil.coo.spawnables.items.interfaces.Item;
import fil.coo.structures.Room;

public abstract class GameCharacter implements Selectable {

    private int hp;

    private int strength;

    protected int gold;

    protected Room currentRoom;

    public boolean isAlive() {
        // TODO
        return false;
    }

    public void changeHP(int hp) {
        // TODO
    }

    public void changeGold(int change) {
        if (gold + change < 0) {
            throw new NegativeGoldException(this + " does not have enough gold for this operation");
        } else {
            gold += change;
        }
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
