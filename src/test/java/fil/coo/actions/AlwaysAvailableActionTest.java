package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * This class contains the tests necessary for the actions that are always possible.
 */
public abstract class AlwaysAvailableActionTest extends ActionTest {


    /**
     * Tests that the subclass of {@link Action}'s {@link Action#isPossible(GamePlayer)} returns true in the correct situations.
     */
    @Test
    public void testIsPossibleWhenOK() {
        GamePlayer player = this.getSimplePlayerWithRoom();
        assertTrue(action.isPossible(player));
    }

    @Test
    public void testIsPossibleWithMonsters() {
        GamePlayer player = this.getPlayerWithMonsterInRoom();

        assertTrue(action.isPossible(player));
    }

    /**
     * Tests that the subclass of {@link Action}'s {@link Action#execute(GamePlayer)} does not throw {@link ActionCannotBeExecutedException} with a normal player.
     */
    @Test
    public void testExecuteWithoutMonsters() {
        GamePlayer player = getSimplePlayerWithRoom();

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should have been possible to execute");
        }
    }

    /**
     * Tests that the subclass of {@link Action}'s {@link Action#execute(GamePlayer)} does not throw {@link ActionCannotBeExecutedException} with a normal player but monsters in the room.
     */
    @Test
    public void testExecuteWithMonsters() {
        GamePlayer player = getPlayerWithMonsterInRoom();

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should have been possible to execute");
        }
    }

    /**
     * Tests that the subclass of {@link Action}'s {@link Action#execute(GamePlayer)} does not throw {@link ActionCannotBeExecutedException} with a normal player and 0 gold.
     */
    @Test
    public void testExecuteWithoutGold() {
        GamePlayer player = getPlayerWithMonsterInRoom();
        player.setGold(0);

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should have been possible to execute");
        }
    }
}
