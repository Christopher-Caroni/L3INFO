package fil.coo.spawnables.beings;

import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.other.Direction;
import fil.coo.spawnables.items.CoinPouch;
import fil.coo.structures.Room;
import fil.coo.structures.RoomFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static fil.coo.spawnables.beings.GamePlayer.DEFAULT_NAME;
import static fil.coo.spawnables.beings.GamePlayer.MENU_DESC_FORMAT;
import static org.junit.Assert.*;

public class GamePlayerTest extends GameCharacterTest {

    RoomFactory roomFactory;

    @Before
    public void setupRoomFactory() {
        roomFactory = new RoomFactory();
    }

    private GamePlayer getSimplePlayer() {
        return new GamePlayer();
    }

    private GamePlayer getPlayerWithRoom() {
        GamePlayer simplePlayer = getSimplePlayer();
        simplePlayer.setCurrentRoom(roomFactory.generateSimpleRoom(0, 0));
        return simplePlayer;
    }


    @Override
    protected void createCharacter() {
        character = new GamePlayer();
    }

    @Test
    public void testMoveToDirection() {
        GamePlayer simplePlayer = getSimplePlayer();

        Room initialRoom = roomFactory.generateSimpleRoom(0, 0);
        Room eastRoom = roomFactory.generateSimpleRoom(1, 0);
        try {
            Room.setRoomsAsNeighbours(initialRoom, eastRoom);
        } catch (RoomsAreNotNeighboursException e) {
            fail("These rooms should be able to be linked since we created them at (x,y)= (0,0) & (0,1)");
        }

        simplePlayer.setCurrentRoom(initialRoom);
        assertSame(initialRoom, simplePlayer.getCurrentRoom());

        simplePlayer.moveToDirection(Direction.EAST);
        assertNotSame(initialRoom, simplePlayer.getCurrentRoom());
        assertSame(eastRoom, simplePlayer.getCurrentRoom());
    }

    @Test(expected = NullPointerException.class)
    public void testReachedExitWithoutRoomShouldThrowNullPointer() {
        GamePlayer simplePlayer = getSimplePlayer();
        assertFalse(simplePlayer.reachedExit());
    }

    @Test
    public void testReachedExitWithSimpleRoomShouldReturnFalse() {
        GamePlayer simplePlayer = getPlayerWithRoom();
        assertFalse(simplePlayer.reachedExit());
    }

    @Test
    public void testReachedExitRoomIsExitButRoomNotRevealedShouldReturnFalse() {
        GamePlayer simplePlayer = getPlayerWithRoom();
        simplePlayer.getCurrentRoom().setIsExitRoom(true);
        assertFalse(simplePlayer.reachedExit());
    }

    @Test
    public void testReachedExitRoomIsExitButContainsMonstersShouldReturnFalse() {
        GamePlayer simplePlayer = getPlayerWithRoom();
        Room currentRoom = simplePlayer.getCurrentRoom();
        currentRoom.setIsExitRoom(true);
        currentRoom.addMonsters(Arrays.asList(new Monster()));

        assertFalse(simplePlayer.reachedExit());
    }

    @Test
    public void testReachedExitRoomIsExitAndIsRevealedButContainsMonstersShouldReturnFalse() {
        GamePlayer simplePlayer = getPlayerWithRoom();
        Room currentRoom = simplePlayer.getCurrentRoom();
        currentRoom.setRevealed(true);
        currentRoom.setIsExitRoom(true);
        currentRoom.addMonsters(Arrays.asList(new Monster()));

        assertFalse(simplePlayer.reachedExit());
    }

    @Test
    public void testReachedExitRoomIsExitAndIsRevealedDoesNotContainsMonstersShouldReturnTrue() {
        GamePlayer simplePlayer = getPlayerWithRoom();
        Room currentRoom = simplePlayer.getCurrentRoom();
        currentRoom.setRevealed(true);
        currentRoom.setIsExitRoom(true);

        assertTrue(simplePlayer.reachedExit());
    }

    @Test
    public void getPossibleActions() {
        // TODO
    }

    @Test
    public void testGetMenuDescription() {
        GamePlayer simplePlayer = getSimplePlayer();
        String expected = String.format(MENU_DESC_FORMAT, simplePlayer.getName(), simplePlayer.getHP(), simplePlayer.getStrength());
        assertEquals(expected, simplePlayer.getMenuDescription());
    }

    @Test
    public void testConfirmItemUseFromRoom() {
        GamePlayer player = getPlayerWithRoom();
        assertEquals(0, player.getItemsFromRoom().size());

        CoinPouch coinPouch = new CoinPouch()
                .withGoldAmount(20);
        player.getCurrentRoom().addSingleItem(coinPouch);

        assertEquals(1, player.getItemsFromRoom().size());
        assertSame(coinPouch, player.getItemsFromRoom().get(0));

        player.confirmItemUseFromRoom(coinPouch);

        assertEquals(0, player.getItemsFromRoom().size());
    }

    @Test
    public void hasEnoughGold() {
        GamePlayer player = getSimplePlayer();
        player.setGold(0);

        assertFalse(player.hasEnoughGold(10));
        assertFalse(player.hasEnoughGold(-10));
        assertTrue(player.hasEnoughGold(0));
    }

    @Test
    public void testSetGetName() {
        GamePlayer player = getSimplePlayer();
        assertEquals(DEFAULT_NAME, player.getName());

        String newName = "Chris";
        player.setName(newName);
        assertEquals(newName, player.getName());
    }

    @Test
    public void hasItemsInCurrentRoom() {
    }

    @Test
    public void getItemsFromRoom() {
    }

    @Test
    public void revealCurrentRoom() {
    }

    @Test
    public void hideCurrentRoom() {
    }

    @Test
    public void isCurrentRoomRevealed() {
    }

    @Test
    public void getUniqueRoomCount() {
    }

    @Test
    public void getPossibleMoveDirections() {
    }

    @Test
    public void currentRoomHasNeighbour() {
    }

    @Test
    public void hasEnoughStrength() {
    }

    @Test
    public void removeMonsterFromRoom() {
        GamePlayer simplePlayer = getSimplePlayer();

        Room room = new RoomFactory().generateSimpleRoom(0, 0);
        simplePlayer.setCurrentRoom(room);
        assertEquals(0, simplePlayer.getCurrentRoom().getNumberOfMonsters());

        Monster simpleMonster = new Monster();
        room.addMonsters(Arrays.asList(simpleMonster));
        assertEquals(1, simplePlayer.getCurrentRoom().getNumberOfMonsters());
        assertSame(simpleMonster, room.getMonsters().get(0));

        simplePlayer.removeMonsterFromRoom(simpleMonster);
        assertEquals(0, simplePlayer.getCurrentRoom().getNumberOfMonsters());
    }
}