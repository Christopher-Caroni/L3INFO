package fil.coo;

import com.google.devtools.common.options.OptionsParser;
import fil.coo.actions.Action;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.items.interfaces.Item;
import fil.coo.structures.Dungeon;
import fil.coo.structures.Room;
import fil.coo.util.AdventureGameOptions;
import fil.coo.util.Menu;

import java.util.List;

/**
 * Hello world!
 */
public class AdventureGame {

    private static final int WIDTH_DUNGEON = 10;
    private static final int HEIGHT_DUNGEON = 10;


    private GamePlayer player;

    private Dungeon dungeon;

    private AdventureGameOptions options;

    private AdventureGame(AdventureGameOptions options) {
        this.options = options;
    }

    public static void main(String[] args) {
        AdventureGameOptions options = parseOptions(args);

        AdventureGame adventureGame = new AdventureGame(options);
        adventureGame.initializeGame();
        adventureGame.startGame();
    }

    private static AdventureGameOptions parseOptions(String[] args) {
        OptionsParser parser = OptionsParser.newOptionsParser(AdventureGameOptions.class);
        parser.parseAndExitUponError(args);
        return parser.getOptions(AdventureGameOptions.class);
    }

    /**
     * Starts a game. This is the main game progression logic.
     */
    private void startGame() {
        while (player.isAlive() && !player.reachedExit()) {
            List<? extends Action> actions = player.getPossibleActions();
            Action action = Menu.getInstance().chooseElement(actions);
            action.execute(player);


            // TODO the game progression

        }
        Menu.getInstance().closeScanner();
    }

    /**
     * Creates the dungeon and the player.
     */
    private void initializeGame() {
        dungeon = new Dungeon(HEIGHT_DUNGEON, WIDTH_DUNGEON, options);
        dungeon.generate();

        player = new GamePlayer();
        player.setName(Menu.getInstance().chooseName());
        player.setCurrentRoom(dungeon.getStartingRoom());
    }

}
