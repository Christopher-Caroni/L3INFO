package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.util.Menu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public abstract class ActionTest {

    /**
     * The action to test that will be instanciated by the implementing Test class.
     */
    private Action action;

    /**
     * Before every test of the action, create the action instance using {@link #getAction()} which is specified by the implementing Test class.
     */
    @Before
    public void setup() {
        this.action = getAction();
    }

    /**
     * Manually creates an {@link InputStream} with <b>choiceNumber</b> as input. This InputStream will replace {@link System#in} which in turn will force {@link Menu#readChoiceInt(int, List)} to read <b>choiceNumber</b>
     *
     * @param choiceNumber the choice we want to force {@link Menu#readChoiceInt(int, List)} to read.
     */
    private void setManualChoice(int choiceNumber) {
        String input = String.valueOf(choiceNumber);
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
    }

    /**
     * After each testing class, close the scanner that the Menu was using. In any case, the testing class has to use {@link #setManualChoice(int)} which changes the Menu's scanner
     */
    @After
    public void close() {
        Menu.getInstance().closeScanner();
    }

    /**
     * @return a {@link GamePlayer} that has the <b>correct</b> attributes and situation to call {@link Action#execute(GamePlayer)} for the specific subclass of {@link Action} that is being testing in a subclass of {@link ActionTest}.
     */
    protected abstract GamePlayer setupPlayerWhenOK();

    /**
     * @return a {@link GamePlayer} that has <b>incorrect</b> attributes and situation to call {@link Action#execute(GamePlayer)} for the specific subclass of {@link Action} that is being testing in a subclass of {@link ActionTest}.
     */
    protected abstract GamePlayer setupPlayerWhenNotOK();

    /**
     * @return the specific sub class of {@link Action} that is created by a subclass of {@link ActionTest}.
     */
    protected abstract Action getAction();

    /**
     * Tests that the subclass of {@link Action}'s {@link Action#isPossible(GamePlayer)} returns true in the correct situations.
     */
    @Test
    public void testIsPossibleWhenOK() {
        GamePlayer player = this.setupPlayerWhenOK();
        assertTrue(action.isPossible(player));
    }

    /**
     * Tests that the subclass of {@link Action}'s {@link Action#isPossible(GamePlayer)} returns false in incorrect situations.
     */
    @Test
    public void testIsPossibleWhenNotOK() {
        GamePlayer player = setupPlayerWhenNotOK();
        assertFalse(action.isPossible(player));
    }

    /**
     * Tests that the subclass of {@link Action}'s {@link Action#execute(GamePlayer)} does not throw {@link ActionCannotBeExecutedException} when it should be able to be executed.
     */
    @Test
    public void testExecuteWhenOK() {
        GamePlayer player = setupPlayerWhenOK();

        setManualChoice(0);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
            fail("This action should have been possible to execute");
        }
    }

    /**
     * Tests that the subclass of {@link Action}'s {@link Action#execute(GamePlayer)} throws {@link ActionCannotBeExecutedException} when it shouldn't be executed.
     */
    @Test(expected = ActionCannotBeExecutedException.class)
    public void testExecuteWhenNotOK() throws ActionCannotBeExecutedException {
        GamePlayer player = setupPlayerWhenNotOK();

        setManualChoice(0);
        action.execute(player);
    }


}