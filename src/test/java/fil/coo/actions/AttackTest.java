package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.beings.Monster;
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
        player.revealCurrentRoom();

        assertFalse(action.isPossible(player));
    }

    /**
     * Assert that {@link Attack} is possible with a monster and the room is revealed.
     */
    @Test
    public void testIsPossibleWithMonstersAndRoomRevealed() {
        GamePlayer player = getPlayerWithMonsterInRoom();

        player.revealCurrentRoom();

        assertTrue(action.isPossible(player));
    }


    /**
     * Execute {@link Attack} when there is not monster and the room is not revealed either.
     * Tests that the exception is throw and that the player's HP does NOT change.
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithNoMonsterAndRoomNotRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();

        int expectedInitialHealth = 100;
        assertEquals(expectedInitialHealth, player.getHP());

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            // Verify that player's HP did not change
            assertEquals(expectedInitialHealth, player.getHP());
            throw e;

        }
        fail("Should've thrown ActionCannotBeExecutedException");
    }

    /**
     * Execute {@link Attack} when there is a monster but the room is not revealed.
     * Tests that the exception is thrown and that the player's and monster's HP does NOT change.
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWithMonsterButRoomNotRevealed() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        Monster singleMonster = player.getCurrentRoom().getMonsters().get(0);

        // At the beginning, both have the initial amount of HP.
        int expectedInitialHealth = 100;
        assertEquals(expectedInitialHealth, singleMonster.getHP());
        assertEquals(expectedInitialHealth, player.getHP());

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            // Verify that their health did not change
            assertEquals(expectedInitialHealth, singleMonster.getHP());
            assertEquals(expectedInitialHealth, player.getHP());
            throw e;

        }
        fail("Should've thrown ActionCannotBeExecutedException");
    }

    /**
     * Execute {@link Attack} when the room is revealed but there is no monster.
     * Tests that the exception is thrown and that the player's HP does not change.
     *
     * @throws ActionCannotBeExecutedException the exception that should be thrown
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWitRoomNotRevealedButNoMonster() throws ActionCannotBeExecutedException {
        GamePlayer player = this.getSimplePlayer();
        player.revealCurrentRoom();

        int expectedInitialHealth = 100;
        assertEquals(expectedInitialHealth, player.getHP());

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            // Verify that player's HP did not change
            assertEquals(expectedInitialHealth, player.getHP());
            throw e;

        }
        fail("Should've thrown ActionCannotBeExecutedException");
    }

    /**
     * Execute {@link Attack} when there is a monster and the room has already been revealed. This should not throw {@link ActionCannotBeExecutedException}.
     * Tests that the action executes properly and that the player's and monster's HP IS reduced appropriately.
     */
    @Test
    public void testExecuteWithMonsterAndRoomNotRevealed() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        Monster singleMonster = player.getCurrentRoom().getMonsters().get(0);
        player.revealCurrentRoom();

        int expectedInitialHealth = 100;
        int initialMonsterStrength = singleMonster.getStrength();
        int initialPlayerStrength = player.getStrength();

        assertEquals(expectedInitialHealth, player.getHP());
        assertEquals(expectedInitialHealth, singleMonster.getHP());

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should have been possible to execute");
        }
        // Verify that player's HP did not change
        assertEquals(expectedInitialHealth - initialMonsterStrength, player.getHP());
        assertEquals(expectedInitialHealth - initialPlayerStrength, singleMonster.getHP());
    }

    /**
     * Execute {@link Attack} when there is a monster and the room has already been revealed. This should not throw {@link ActionCannotBeExecutedException}.
     * Tests that the action executes properly, that the player receives the monster's gold and the monster's gold is set to 0.
     */
    @Test
    public void testExecuteAndKillMonster() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();
        Monster singleMonster = player.getCurrentRoom().getMonsters().get(0);
        singleMonster.setHP(player.getStrength() - 1);
        player.revealCurrentRoom();

        int initialPlayerGold = player.getGold();
        int initialMonsterGold = singleMonster.getGold();

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should have been possible to execute");
        }
        assertEquals(initialPlayerGold + initialMonsterGold, player.getGold());
        assertEquals(0, singleMonster.getGold());
    }
}