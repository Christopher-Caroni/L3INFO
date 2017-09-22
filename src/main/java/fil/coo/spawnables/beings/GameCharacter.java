package fil.coo.spawnables.beings;

import fil.coo.exception.NegativeGoldException;
import fil.coo.other.Selectable;
import fil.coo.structures.Room;

import java.util.Random;

public abstract class GameCharacter implements Selectable {

    protected int hp;

    protected int strength;

    protected int gold;

    protected Room currentRoom;

    public GameCharacter() {
        Random random = new Random();

        hp = 100;
        setRandomStrength(random);
        gold = random.nextInt(21) + 40;
    }

    protected abstract void setRandomStrength(Random random);

    public boolean isAlive() {
        return hp > 0;
    }

    public void changeHP(int hp) {
        this.hp += hp;
    }

    public void changeGold(int change) {
        if (gold + change < 0) {
            throw new NegativeGoldException(this + " does not have enough gold for this operation");
        } else {
            gold += change;
        }
    }

    public void changeStrength(int strengthChange) {
        this.strength += strengthChange;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getStrength() {
        return strength;
    }

    public int getHP() {
        return hp;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
