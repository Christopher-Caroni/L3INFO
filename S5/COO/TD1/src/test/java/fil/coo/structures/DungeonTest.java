package fil.coo.structures;

import fil.coo.util.AdventureGameOptions;
import org.junit.Before;
import org.junit.Test;

import static fil.coo.structures.Dungeon.DEFAULT_HEIGHT_DUNGEON;
import static fil.coo.structures.Dungeon.DEFAULT_WIDTH_DUNGEON;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

public class DungeonTest {

    private AdventureGameOptions options;
    private Dungeon dungeon;

    @Before
    public void setupDungeon() {
        options = new AdventureGameOptions();
        dungeon = new Dungeon(options);
    }

    @Test
    public void testSetCustomSizesWithoutOptions() {
        assertEquals(DEFAULT_HEIGHT_DUNGEON, dungeon.getHeight());
        assertEquals(DEFAULT_WIDTH_DUNGEON, dungeon.getWidth());
    }

    @Test
    public void testSetCustomSizesWithOptions() {
        options.customDungeonHeight = DEFAULT_HEIGHT_DUNGEON + 2;
        options.customDungeonWidth = DEFAULT_WIDTH_DUNGEON + 2;
        dungeon = new Dungeon(options);

        assertNotEquals(DEFAULT_HEIGHT_DUNGEON, dungeon.getHeight());
        assertNotEquals(DEFAULT_WIDTH_DUNGEON, dungeon.getWidth());
    }

    @Test
    public void testGetRoomAndGetArray() {
        AdventureGameOptions options = new AdventureGameOptions();
        Dungeon dungeon = new Dungeon(options);

        Room roomWithGet = dungeon.getRoom(0,0);
        Room roomFromArray = dungeon.getRoomsArray()[0][0];

        assertSame(roomFromArray, roomWithGet);
    }

}