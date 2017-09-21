package fil.coo.structures;

import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.items.CoinPouch;
import fil.coo.spawnables.items.HealthPotion;
import fil.coo.spawnables.items.OneArmedBandit;
import fil.coo.spawnables.items.StrengthPotion;

import java.util.List;
import java.util.Optional;

public class RoomFactory {

    /**
     * Default constructor
     */
    public RoomFactory() {
    }

    public Room generateRoom(int column, int row) {
        Room room = new Room(column, row);
        addSpawnables(room);
        return room;
    }

    /**
     * Spawns all spawnables and adds them to the room.
     *
     * @param room the room to add them to.
     */
    private void addSpawnables(Room room) {
        // generate items
        spawnItemsForRoom(room);

        // generate beings
        spawnBeingsForRoom(room);
    }

    /**
     * Adds all spawnable items to the room
     *
     * @param room
     */
    private void spawnItemsForRoom(Room room) {
        // GOLD
        Optional<CoinPouch> coinPouch = new CoinPouch().getRandomSpawn();
        coinPouch.ifPresent(room::addSingleItem);

        // HealthPotion
        Optional<HealthPotion> healthPotion = new HealthPotion().getRandomSpawn();
        healthPotion.ifPresent(room::addSingleItem);

        // StrengthPotion
        Optional<StrengthPotion> strengthPotion = new StrengthPotion().getRandomSpawn();
        strengthPotion.ifPresent(room::addSingleItem);

        // OneArmedBandit
        Optional<OneArmedBandit> oneArmedBandit = new OneArmedBandit().getRandomSpawn();
        oneArmedBandit.ifPresent(room::addSingleItem);


        // OTHER FUTURE ITEMS
    }

    /**
     * Generates all living beings and adds them to the room.
     *
     * @param room the room to add them to.
     */
    private void spawnBeingsForRoom(Room room) {
        List<Monster> monsters = new Monster().getRandomSpawn();
        room.addMonsters(monsters);

        // OTHER FUTURE ITEMS
    }

}
