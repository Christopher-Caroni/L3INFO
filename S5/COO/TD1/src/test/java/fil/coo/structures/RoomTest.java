package fil.coo.structures;

import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.items.CoinPouch;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static fil.coo.other.Direction.*;
import static org.junit.Assert.*;

public class RoomTest {

    private static Room.Builder roomBuilder;
    private Room room;

    @BeforeClass
    public static void setupRoomBuilder() {
        roomBuilder = new Room.Builder();
    }

    @Before
    public void setupRoom() {
        room = roomBuilder.createSimpleRoom(0, 0).build();
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
        Room eastNeighbour = roomBuilder.createSimpleRoom(1, 0).build();
        assertNull(room.getNeighbour(EAST));
        assertNull(room.getNeighbour(SOUTH));

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }
        assertNotNull(room.getNeighbour(EAST));
        assertSame(eastNeighbour, room.getNeighbour(EAST));

        Room southNeighbour = roomBuilder.createSimpleRoom(0, 1).build();
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
        Room eastNeighbour = roomBuilder.createSimpleRoom(1, 0).build();
        assertFalse(room.getNeighboursDirections().contains(EAST));

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }
        assertEquals(1, room.getNumberOfNeighbours());

        Room southNeighbour = roomBuilder.createSimpleRoom(0, 1).build();
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
        Room eastNeighbour = roomBuilder.createSimpleRoom(1, 0).build();
        assertEquals(0, room.getNumberOfNeighbours());

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }
        assertEquals(1, room.getNumberOfNeighbours());

        Room southNeighbour = roomBuilder.createSimpleRoom(0, 1).build();
        try {
            Room.setRoomsAsNeighbours(room, southNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (1,0)");
        }
        assertEquals(2, room.getNumberOfNeighbours());
    }

    @Test
    public void testHasLinkedNeighbourForDirection() {
        Room eastNeighbour = roomBuilder.createSimpleRoom(1, 0).build();
        assertFalse(room.hasLinkedNeighbourForDirection(EAST));

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }
        assertTrue(room.hasLinkedNeighbourForDirection(EAST));

        Room southNeighbour = roomBuilder.createSimpleRoom(0, 1).build();
        assertFalse(room.hasLinkedNeighbourForDirection(SOUTH));
        try {
            Room.setRoomsAsNeighbours(room, southNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (1,0)");
        }
        assertTrue(room.hasLinkedNeighbourForDirection(SOUTH));
    }


    @Test(expected = RoomsAreNotNeighboursException.class)
    public void testGetDirectionFromRoomToOtherRoom() throws RoomsAreNotNeighboursException {
        room.setX(1);
        room.setY(1);

        Room eastNeighbour = roomBuilder.createSimpleRoom(2, 1).build();
        Room southNeighbour = roomBuilder.createSimpleRoom(1, 2).build();
        Room westNeighbour = roomBuilder.createSimpleRoom(0, 1).build();
        Room northNeighbour = roomBuilder.createSimpleRoom(1, 0).build();


        Direction expectEast = null;
        Direction expectSouth = null;
        Direction expectWest = null;
        Direction expectNorth = null;
        try {
            expectEast = Room.getDirectionFromRoomToOtherRoom(room, eastNeighbour);
            expectSouth = Room.getDirectionFromRoomToOtherRoom(room, southNeighbour);
            expectWest = Room.getDirectionFromRoomToOtherRoom(room, westNeighbour);
            expectNorth = Room.getDirectionFromRoomToOtherRoom(room, northNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms are neighbours and the above calculation should've been possible");
        }
        assertEquals(EAST, expectEast);
        assertEquals(SOUTH, expectSouth);
        assertEquals(WEST, expectWest);
        assertEquals(NORTH, expectNorth);

        Room badNeighbour = roomBuilder.createSimpleRoom(5, 5).build();
        Direction badDirection = Room.getDirectionFromRoomToOtherRoom(room, badNeighbour);
        fail("The line above should've thrown an exception");
    }

    @Test(expected = RoomsAreNotNeighboursException.class)
    public void testSetRoomsAsNeighbours() throws RoomsAreNotNeighboursException {
        Room eastNeighbour = roomBuilder.createSimpleRoom(1, 0).build();
        assertFalse(room.hasLinkedNeighbourForDirection(EAST));

        try {
            Room.setRoomsAsNeighbours(room, eastNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }
        assertTrue(room.hasLinkedNeighbourForDirection(EAST));

        Room southNeighbour = roomBuilder.createSimpleRoom(0, 1).build();
        assertFalse(room.hasLinkedNeighbourForDirection(SOUTH));
        try {
            Room.setRoomsAsNeighbours(room, southNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (1,0)");
        }
        assertTrue(room.hasLinkedNeighbourForDirection(SOUTH));

        Room badNeighbour = roomBuilder.createSimpleRoom(5, 5).build();
        Room.setRoomsAsNeighbours(room, badNeighbour);
    }

}