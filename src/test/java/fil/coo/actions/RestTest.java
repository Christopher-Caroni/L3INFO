package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RestTest extends ActionTest {


    @Override
    protected Action getAction() {
        return new Rest();
    }

    @Test
    public void testNotPossibleWithMonstersInRoom() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithNotEnoughGold() {
        GamePlayer player = this.getSimplePlayer();
        player.setGold(0);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithEnoughGoldButRoomNotRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.setGold(100);
        player.setRoomRevealed(false);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithNotEnoughGoldAndRoomRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.setGold(0);
        player.setRoomRevealed(true);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithMonstersAndNotEnoughGold() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setGold(0);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithMonstersButRoomRevealed() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setRoomRevealed(true);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithMonstersButEnoughGoldAndRoomRevealed() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setGold(100);
        player.setRoomRevealed(true);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testIsPossibleWithNoMonstersAndEnoughGoldAndRoomRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.setGold(100);
        player.setRoomRevealed(true);

        assertTrue(action.isPossible(player));
    }

    /* EXECUTE */


    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonstersInRoom() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithNotEnoughGold() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.setGold(0);

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithEnoughGoldButRoomNotRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.setGold(100);
        player.setRoomRevealed(false);

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithNotEnoughGoldAndRoomRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.setGold(0);
        player.setRoomRevealed(true);

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonstersAndNotEnoughGold() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setGold(0);

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonstersButRoomRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setRoomRevealed(true);

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonstersButEnoughGoldAndRoomRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setGold(100);
        player.setRoomRevealed(true);

        setManualChoice(0);
        action.execute(player);
    }

    @Test
    public void testExecuteWithNoMonstersAndEnoughGoldAndRoomRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.setGold(100);
        player.setRoomRevealed(true);

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should've been possible");
        }
    }
}