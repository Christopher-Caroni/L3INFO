package fil.coo.structures;

import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.items.CoinPouch;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static fil.coo.other.Direction.EAST;
import static fil.coo.other.Direction.SOUTH;
import static org.junit.Assert.*;

public class RoomTest {

    private RoomFactory roomFactory;
    private Room room;

    @Before
    public void setup() {
        roomFactory = new RoomFactory();
        room = roomFactory.generateSimpleRoom(0, 0);
    }

    @Test
    public void testHasMonsters() {
        assertFalse(room.hasMonsters());
        room.addMonsters(Arrays.asList(new Monster()));
        assertTrue(room.hasMonsters());
    }

    @Test
    public void testIsExit() {
        assertFalse(room.isExit());
        room.setIsExitRoom(true);
        assertTrue(room.isExit());
    }

    @Test
    public void testGetMonsters() {
        assertEquals(0, room.getNumberOfMonsters());

        Monster monster = new Monster();
        room.addMonsters(Arrays.asList(monster));
        assertEquals(1, room.getNumberOfMonsters());
        assertSame(monster, room.getMonsters().get(0));
    }

    @Test
    public void removeMonster() {
        assertEquals(0, room.getNumberOfMonsters());

        Monster monster = new Monster();
        room.addMonsters(Arrays.asList(monster));
        assertEquals(1, room.getNumberOfMonsters());
        assertSame(monster, room.getMonsters().get(0));

        room.removeMonster(monster);
        assertEquals(0, room.getNumberOfMonsters());
    }

    @Test
    public void testAddSingleItemAndRemove() {
        CoinPouch coinPouch = new CoinPouch();
        assertEquals(0, room.getNumberOfItems());

        room.addSingleItem(coinPouch);
        assertEquals(1, room.getNumberOfItems());
        assertSame(coinPouch, room.getItems().get(0));

        room.removeItem(coinPouch);
        assertEquals(0, room.getNumberOfItems());
    }


    @Test
    public void testGetSetCoords() {
        assertEquals(0, room.getX());
        assertEquals(0, room.getY());

        room.setX(1);
        room.setY(2);
        assertEquals(1, room.getX());
        assertEquals(2, room.getY());
    }


    @Test
    public void hasItems() {
        CoinPouch coinPouch = new CoinPouch();
        assertFalse(room.hasItems());

        room.addSingleItem(coinPouch);
        assertTrue(room.hasItems());
    }

    @Test
    public void testSetIsRevealed() {
        assertFalse(room.isRevealed());

        room.setRevealed(true);
        assertTrue(room.isRevealed());
    }


    @Test
    public void testGetNeighbour() {
        Room eastNeighbour = roomFactory.generateSimpleRoom(1, 0);
        assertNull(room.getNeighbour(EAST));
        assertNull(room.getNeighbour(SOUTH));

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }
        assertNotNull(room.getNeighbour(EAST));
        assertSame(eastNeighbour, room.getNeighbour(EAST));

        Room southNeighbour = roomFactory.generateSimpleRoom(0, 1);
        try {
            Room.setRoomsAsNeighbours(room, southNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (1,0)");
        }
        assertNotNull(room.getNeighbour(SOUTH));
        assertSame(southNeighbour, room.getNeighbour(SOUTH));
    }

    @Test
    public void testGetNeighboursDirections() {
        Room eastNeighbour = roomFactory.generateSimpleRoom(1, 0);
        assertFalse(room.getNeighboursDirections().contains(EAST));

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }
        assertEquals(1, room.getNumberOfNeighbours());

        Room southNeighbour = roomFactory.generateSimpleRoom(0, 1);
        assertFalse(room.getNeighboursDirections().contains(Direction.SOUTH));
        try {
            Room.setRoomsAsNeighbours(room, southNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (1,0)");
        }
        assertTrue(room.getNeighboursDirections().contains(Direction.SOUTH));
    }

    @Test
    public void testGetNumberNeighboursDirections() {
        Room eastNeighbour = roomFactory.generateSimpleRoom(1, 0);
        assertEquals(0, room.getNumberOfNeighbours());

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }
        assertEquals(1, room.getNumberOfNeighbours());

        Room southNeighbour = roomFactory.generateSimpleRoom(0, 1);
        try {
            Room.setRoomsAsNeighbours(room, southNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (1,0)");
        }
        assertEquals(2, room.getNumberOfNeighbours());
    }

    @Test
    public void testHasLinkedNeighbourForDirection() {
        Room eastNeighbour = roomFactory.generateSimpleRoom(1, 0);
        assertFalse(room.hasLinkedNeighbourForDirection(EAST));

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }
        assertTrue(room.hasLinkedNeighbourForDirection(EAST));

        Room southNeighbour = roomFactory.generateSimpleRoom(0, 1);
        assertFalse(room.hasLinkedNeighbourForDirection(SOUTH));
        try {
            Room.setRoomsAsNeighbours(room, southNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (1,0)");
        }
        assertTrue(room.hasLinkedNeighbourForDirection(SOUTH));
    }


    @Test
    public void testGetDirectionFromRoomToOtherRoom() {
        Room eastNeighbour = roomFactory.generateSimpleRoom(1, 0);

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }

        assertEquals(EAST, Room.getDirectionFromRoomToOtherRoom(room, eastNeighbour));
    }

}