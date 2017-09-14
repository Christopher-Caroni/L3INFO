package fil.coo.factory;

import fil.coo.objects.GoldItem;
import fil.coo.objects.Room;
import fil.coo.other.Spawnable;

import java.util.List;

public class RoomFactory {

    /**
     * Default constructor
     */
    public RoomFactory() {
    }

    public Room generateRoom() {
        Room room = new Room();

        // generate items
        generateItemsForRoom(room);

        generateMonstersForRoom(room);

        // generate monsters

        // generate neighbours
        // TODO >> delegate to AdventureGame which has the full view

        return room;
    }

    /**
     * Adds all spawnable items to the room
     * @param room
     */
    private void generateItemsForRoom(Room room) {
        // GOLD
        spawnGold(room);

        // OTHER ITEMS
    }

    /**
     * Adds only gold to the room
     * @param room
     */
    private void spawnGold(Room room) {
//        List<GoldItem> gold = Spawnable.generateRandomSpawn(Spawnable.Types.GOLD);
        List<? extends Spawnable> randomSpawn = new GoldItem().getRandomSpawn();
    }

    private void generateMonstersForRoom(Room room) {
        // TODO
    }

}
