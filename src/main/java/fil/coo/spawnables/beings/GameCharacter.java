package fil.coo.spawnables.beings;

import fil.coo.exception.NotEnoughGoldException;
import fil.coo.exception.NotEnoughStrengthException;
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

    /**
     * Adds <b>changeHP</b> to the {@link GameCharacter}'s HP. Will set to 0 if the change would induce negative HP.
     *
     * @param changeHP the change of hp, either positive or negative. Applied as an addition.
     */
    public void changeHP(int changeHP) {
        this.hp = Math.max(0, this.hp + changeHP);
    }

    /**
     * Adds <b>change</b> if {@link GameCharacter} has enough gold.
     *
     * @param change the change of gold to apply. Can be either positive or negative.
     */
    public void changeGold(int change) {
        if (gold + change < 0) {
            throw new NotEnoughGoldException(this + " does not have enough gold for this operation");
        } else {
            gold += change;
        }
    }

    /**
     * Adds <b>change</b> if {@link GameCharacter} has enough strength.
     *
     * @param strengthChange the change of strength to apply. Can be either positive or negative.
     */
    public void changeStrength(int strengthChange) {
        if (this.strength + strengthChange < 0) {
            throw new NotEnoughStrengthException(this + " does not have enough strength for this operation");
        } else {
            this.strength += strengthChange;
        }
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

    public void setHP(int HP) {
        this.hp = HP;
    }
}
