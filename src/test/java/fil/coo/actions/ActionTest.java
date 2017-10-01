package fil.coo.actions;

import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.beings.Monster;
import fil.coo.structures.Room;
import fil.coo.structures.RoomFactory;
import fil.coo.util.Menu;
import org.junit.AfterClass;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the methods necessary to write tests for the "action" package. Actual tests are implemented by subclasses of this class.
 *
 * @see AlwaysAvailableActionTest
 */
public abstract class ActionTest {

    /**
     * The action to test that will be instanciated by the implementing Test class.
     */
    protected Action action;

    /**
     * Before every test of the action, create the action instance using {@link #getAction()} which is specified by the implementing Test class.
     */
    @Before
    public void setupActionToTest() {

        this.action = getAction();
    }

    @AfterClass
    public static void closeMenu() {
        Menu.getInstance().closeScanner();
    }

    /**
     * Manually creates an {@link InputStream} with <b>choiceNumber</b> as input. This InputStream will replace {@link System#in} which in turn will force {@link Menu#readChoiceInt(int, List)} to read <b>choiceNumber</b>
     *
     * @param choiceNumber the choice we want to force {@link Menu#readChoiceInt(int, List)} to read.
     */
    protected void setManualChoice(int choiceNumber) {
        String input = String.valueOf(choiceNumber);
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        Menu.getInstance().initialize();
    }

    /**
     * @return a simple {@link GamePlayer} object with only a currentRoom initialized at coords x[0], y[0].
     */
    protected GamePlayer getSimplePlayerWithRoom() {
        Room currentRoom = new RoomFactory().generateSimpleRoom(0, 0);

        GamePlayer player = new GamePlayer();
        player.setCurrentRoom(currentRoom);
        return player;
    }

    /**
     * Builds on {@link #getSimplePlayerWithRoom()} to create a bare player but adds one monster to the room.
     *
     * @return a {@link GamePlayer} with one monster in his room.
     */
    protected GamePlayer getPlayerWithMonsterInRoom() {
        GamePlayer player = this.getSimplePlayerWithRoom();

        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(new Monster());
        player.getCurrentRoom().addMonsters(monsterList);

        return player;
    }

    /**
     * @return the specific sub class of {@link Action} that is created by a subclass of {@link ActionTest}.
     */
    protected abstract Action getAction();


}