package fil.coo.actions;

import com.rits.cloning.Cloner;
import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.structures.Room;
import fil.coo.structures.RoomFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveTest extends ActionTest {


    @Override
    protected Action getAction() {
        return new Move();
    }


    @Test
    public void testNotPossible() {
        GamePlayer player = this.getSimplePlayer();

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithMonstersInRoom() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithRoomRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.setRoomRevealed(true);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithRoomRevealedAndMonsters() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setRoomRevealed(true);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithNeighbour() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        Room neighbour = new RoomFactory().generateSimpleRoom(0, 1);
        try {
            Room.setRoomsAsNeighbours(player.getCurrentRoom(), neighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("Create rooms that are neighbours for this test to proceed");
        }

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testIsPossibleWithNoMonstersAndRoomRevealedAndNeighbours() {
        GamePlayer player = getSimplePlayer();
        player.setRoomRevealed(true);
        Room neighbour = new RoomFactory().generateSimpleRoom(0, 1);
        try {
            Room.setRoomsAsNeighbours(player.getCurrentRoom(), neighbour);
        } catch (RoomsAreNotNeighboursException e) {
            fail("Create rooms that are neighbours for this test to proceed");
        }

        assertTrue(action.isPossible(player));
    }

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

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithRoomRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.setRoomRevealed(true);

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

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithRoomRevealedAndMonsters() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setRoomRevealed(true);

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

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithNeighbour() throws ActionCannotBeExecutedException {
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

    @Test
    public void testExecuteWithNoMonstersAndRoomRevealedAndNeighbours() {
        GamePlayer player = getSimplePlayer();
        player.setRoomRevealed(true);
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

}