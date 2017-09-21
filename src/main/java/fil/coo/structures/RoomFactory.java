package fil.coo.structures;

import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.items.GoldPurse;

import java.util.List;

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
        GoldPurse goldPurse = new GoldPurse().getRandomSpawn();
        room.addSingleItem(goldPurse);

        // OTHER FUTURE ITEMS
        // TODO POTIONS
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
