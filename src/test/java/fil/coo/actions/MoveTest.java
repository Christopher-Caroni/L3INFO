package fil.coo.actions;

import com.rits.cloning.Cloner;
import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.structures.Room;
import fil.coo.structures.RoomFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link Move}
 */
public class MoveTest extends ActionTest {


    /**
     * @return a {@link Move} instance to test against.
     */
    @Override
    protected Action getAction() {
        return new Move();
    }


    /**
     * Assert that {@link Move} is NOT possible if the player did not reveal the room and does not have any neighbours.
     */
    @Test
    public void testNotPossibleWithoutRoomRevealedAndWithoutNeighbour() {
        GamePlayer player = this.getSimplePlayer();

        assertFalse(action.isPossible(player));
    }

    /**
     * Assert that {@link Move} is NOT possible if there are monsters in the player's room.
     */
    @Test
    public void testNotPossibleWithMonstersInRoom() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();

        assertFalse(action.isPossible(player));
    }

    /**
     * Assert that {@link Move} is NOT possible if the room is revealed but has no neighbours.
     */
    @Test
    public void testNotPossibleWithRoomRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.revealCurrentRoom();

        assertFalse(action.isPossible(player));
    }

    /**
     * Assert that {@link Move} is NOT possible if the room is revealed but has monsters.
     */
    @Test
    public void testNotPossibleWithRoomRevealedAndMonstersButNoNeighbour() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.revealCurrentRoom();

        assertFalse(action.isPossible(player));
    }

    /**
     * Assert that {@link Move} is NOT possible if the room has a neighbour but has not been revealed and has monsters.
     */
    @Test
    public void testNotPossibleWithNeighbourButWithMonters() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        Room neighbour = new RoomFactory().generateSimpleRoom(0, 1);
        try {
            Room.setRoomsAsNeighbours(player.getCurrentRoom(), neighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("Create rooms that are neighbours for this test to proceed");
        }

        assertFalse(action.isPossible(player));
    }

    /**
     * Assert that {@link Move} IS possible if the room has a neighbour, room is revealed and has no monsters.
     */
    @Test
    public void testIsPossibleWithNoMonstersAndRoomRevealedAndNeighbours() {
        GamePlayer player = getSimplePlayer();
        player.revealCurrentRoom();
        Room neighbour = new RoomFactory().generateSimpleRoom(0, 1);
        try {
            Room.setRoomsAsNeighbours(player.getCurrentRoom(), neighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("Create rooms that are neighbours for this test to proceed");
        }

        assertTrue(action.isPossible(player));
    }

    /**
     * Tests that the exception is thrown and that the player's room is not changed if he tries to move but his room
     * has not been revealed.
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithRoomNotRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();

        // Create a shallow clone of the instance of the player's initial Room so we can use equals() on the Room's fields.
        Room initialRoomCopy = new Cloner().shallowClone(player.getCurrentRoom());

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            assertEquals(initialRoomCopy, player.getCurrentRoom());
            throw e;
        }
    }

    /**
     * Tests that the exception is thrown and that the player's room is not changed if he tries to move but his room
     * has monsters
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonstersInRoom() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();

        // Create a shallow clone of the instance of the player's initial Room so we can use equals() on the Room's fields.
        Room initialRoomCopy = new Cloner().shallowClone(player.getCurrentRoom());

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            assertEquals(initialRoomCopy, player.getCurrentRoom());
            throw e;
        }
    }

    /**
     * Tests that the exception is thrown and that the player's room is not changed if he tries to move but his room
     * has no neighbours.
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithRoomRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.revealCurrentRoom();

        // Create a shallow clone of the instance of the player's initial Room so we can use equals() on the Room's fields.
        Room initialRoomCopy = new Cloner().shallowClone(player.getCurrentRoom());

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            assertEquals(initialRoomCopy, player.getCurrentRoom());
            throw e;
        }
    }

    /**
     * Tests that the exception is thrown and that the player's room is not changed if he tries to move with monsters
     * in the room, even with room revealed
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithRoomRevealedAndMonsters() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.revealCurrentRoom();

        // Create a shallow clone of the instance of the player's initial Room so we can use equals() on the Room's fields.
        Room initialRoomCopy = new Cloner().shallowClone(player.getCurrentRoom());

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            assertEquals(initialRoomCopy, player.getCurrentRoom());
            throw e;
        }
    }

    /**
     * Tests that the exception is thrown and that the player's room is not changed if he tries to move with monsters
     * in the room, even if it has a neighbour.
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithNeighbourButWithMonsters() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        Room neighbour = new RoomFactory().generateSimpleRoom(0, 1);

        try {
            Room.setRoomsAsNeighbours(player.getCurrentRoom(), neighbour);
        } catch (RoomsAreNotNeighboursException e) {
            // We need these rooms to be neighbours to be able to test that execute() throws
            // ActionCannotBeExecutedException even if they are neighbours.
            fail("Create rooms that are neighbours for this test to proceed");
        }


        // Create a shallow clone of the instance of the player's initial Room so we can use equals() on the Room's
        // fields.
        Room initialRoomCopy = new Cloner().shallowClone(player.getCurrentRoom());

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            assertEquals(initialRoomCopy, player.getCurrentRoom());
            throw e;
        }
    }


    /**
     * Tests that the player's room is changed to the correct neighbour when the room has only one neighbour.
     */
    @Test
    public void testExecuteWithNoMonstersAndRoomRevealedAndSingleNeighbour() {
        GamePlayer player = getSimplePlayer();
        player.revealCurrentRoom();
        Room neighbour = new RoomFactory().generateSimpleRoom(0, 1);
        try {
            Room.setRoomsAsNeighbours(player.getCurrentRoom(), neighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("Create rooms that are neighbours for this test to proceed");
        }

        setManualChoice(0);

        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should have been possible");
        }
        // Should be same object instance
        assertSame(neighbour, player.getCurrentRoom());
    }


    /**
     * Tests that the player's room is changed to the correct neighbour when the room has multiple neighbours.
     */
    @Test
    public void testExecuteWithNoMonstersAndRoomRevealedAndMultipleNeighbours() {
        GamePlayer player = getSimplePlayer();
        player.revealCurrentRoom();
        Room firstNeighbour = new RoomFactory().generateSimpleRoom(0, 1); // SOUTH
        Room secondNeighbour = new RoomFactory().generateSimpleRoom(1, 0); // EAST
        try {
            Room.setRoomsAsNeighbours(player.getCurrentRoom(), firstNeighbour);
            Room.setRoomsAsNeighbours(player.getCurrentRoom(), secondNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("Create rooms that are neighbours for this test to proceed");
        }

        setManualChoice(0);

        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should have been possible");
        }

        /* Should be same object instance

         We called setManualChoice(0) which will choose the first neighbour. But the neighbours are stored in an
         EnumMap which orders based on the declaration order of the enums in the Enum class. In the class,
         'EAST' is declared before 'SOUTH' so secondNeighbour should be first in the map even if we added it after
         firstNeighbour.
         */
        assertSame(secondNeighbour, player.getCurrentRoom());
    }

}