package fil.coo.spawnables.items;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.interfaces.Item;
import fil.coo.structures.Room;
import fil.coo.structures.RoomFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class ItemTest {

    protected Item item;
    protected GamePlayer player;

    @Before
    public void setup() {
        item = getItemToTest();

        initPlayer();
    }

    protected void initPlayer() {
        player = new GamePlayer();
        Room room = new RoomFactory().generateSimpleRoom(0, 0);
        player.setCurrentRoom(room);
    }

    protected abstract Item getItemToTest();

    @Test
    public void testSetGetAmount() {
        assertEquals(0, item.getAmount());

        item.setAmount(20);
        assertEquals(20, item.getAmount());

        item.setAmount(-20);
        assertEquals(-20, item.getAmount());
    }

}
