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
    public void testNotPossibleWithNotEnoughStrength() {
        GamePlayer player = this.getSimplePlayer();
        player.setStrength(0);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithEnoughStrengthButRoomNotRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.setStrength(100);
        player.hideCurrentRoom();

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithNotEnoughStrengthAndRoomRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.setStrength(0);
        player.revealCurrentRoom();

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithMonstersAndNotEnoughStrength() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setStrength(0);

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithMonstersButRoomRevealed() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.revealCurrentRoom();

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testNotPossibleWithMonstersButEnoughStrengthAndRoomRevealed() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setStrength(100);
        player.revealCurrentRoom();

        assertFalse(action.isPossible(player));
    }

    @Test
    public void testIsPossibleWithNoMonstersAndEnoughStrengthAndRoomRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.setStrength(100);
        player.revealCurrentRoom();

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
    public void testExecuteWithNotEnoughStrength() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.setStrength(0);

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithEnoughStrengthButRoomNotRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.setStrength(100);
        player.hideCurrentRoom();

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithNotEnoughStrengthAndRoomRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.setStrength(0);
        player.revealCurrentRoom();

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonstersAndNotEnoughStrength() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setStrength(0);

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonstersButRoomRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.revealCurrentRoom();

        setManualChoice(0);
        action.execute(player);
    }

    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonstersButEnoughStrengthAndRoomRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setStrength(100);
        player.revealCurrentRoom();

        setManualChoice(0);
        action.execute(player);
    }

    @Test
    public void testExecuteWithNoMonstersAndEnoughStrengthAndRoomRevealed() {
        GamePlayer player = this.getSimplePlayer();
        player.setStrength(100);
        player.revealCurrentRoom();

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should've been possible");
        }
    }
}