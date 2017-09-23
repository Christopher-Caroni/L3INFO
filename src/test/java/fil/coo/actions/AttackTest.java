package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import org.junit.Test;

import static org.junit.Assert.*;

public class AttackTest extends ActionTest {

    /**
     * @return an {@link Attack} action instance to test.
     */
    @Override
    protected Action getAction() {
        return new Attack();
    }

    /**
     * Assert that {@link Attack} is not possible with monster but room not revealed.
     */
    @Test
    public void testNotPossibleWithNoMonstersAndRoomNotRevealed() {
        GamePlayer player = this.getSimplePlayer();

        assertFalse(action.isPossible(player));
    }

    /**
     * Assert that {@link Attack} is not possible with monster but room not revealed.
     */
    @Test
    public void testNotPossibleWithMonstersButRoomNotRevealed() {
        GamePlayer player = getPlayerWithMonsterInRoom();

        assertFalse(action.isPossible(player));
    }

    /**
     * Assert that {@link Attack} is not possible with room revealed but with no monster.
     */
    @Test
    public void testNotPossibleWithRoomRevealedButWithNoMonsters() {
        GamePlayer player = this.getSimplePlayer();
        player.setRoomRevealed(true);

        assertFalse(action.isPossible(player));
    }

    /**
     * Assert that {@link Attack} is possible with a monster and the room is revealed.
     */
    @Test
    public void testIsPossibleWithMonstersAndRoomRevealed() {
        GamePlayer player = getPlayerWithMonsterInRoom();

        player.setRoomRevealed(true);

        assertTrue(action.isPossible(player));
    }


    /**
     * Execute {@link Attack} when there is not monster and the room is not revealed either.
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithNoMonsterAndRoomNotRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();

        setManualChoice(0);
        action.execute(player);
    }

    /**
     * Execute {@link Attack} when there is a monster but the room is not revealed.
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonsterButRoomNotRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();

        setManualChoice(0);
        action.execute(player);
    }

    /**
     * Execute {@link Attack} when the room is revealed but there is no monster.
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWitRoomNotRevealedButNoMonster() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.setRoomRevealed(true);

        setManualChoice(0);
        action.execute(player);
    }

    /**
     * Execute {@link Attack} when there is a monster and the room has already been revealed. This should not throw {@link ActionCannotBeExecutedException}
     */
    @Test
    public void testExecuteWithMonsterAndRoomNotRevealed() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        player.setRoomRevealed(true);

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should have been possible to execute");
        }
    }
}