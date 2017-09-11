package fil.coo.alive;

import fil.coo.objects.Room;

public abstract class Character {

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
