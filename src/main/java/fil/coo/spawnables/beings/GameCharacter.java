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
        gold = 0;
        setSpecificAttributes(random);
    }

    abstract void setSpecificAttributes(Random random);

    protected abstract void setRandomStrength(Random random);

    public boolean isAlive() {
        return hp > 0;
    }

    public void changeHP(int changeHP) {
        this.hp = Math.max(0, this.hp + changeHP);
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

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void removeMonsterFromRoom(Monster target) {
        currentRoom.removeMonster(target);
    }

    public void setHP(int HP) {
        this.hp = HP;
    }
}
