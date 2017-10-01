package fil.coo;

import com.google.devtools.common.options.OptionsParser;
import com.rits.cloning.Cloner;
import fil.coo.actions.Action;
import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.gui.ProgressFrame;
import fil.coo.spawnables.beings.GamePlayer;
import fil.coo.structures.Dungeon;
import fil.coo.structures.Room;
import fil.coo.util.AdventureGameOptions;
import fil.coo.util.Menu;
import org.apache.log4j.Logger;

import java.util.List;

import static fil.coo.util.AdventureGameOptions.DEFAULT_PLAYER_NAME;

public class AdventureGame {

    final static Logger logger = Logger.getLogger(AdventureGame.class);

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

    /**
     * @param args the program's options on execution
     * @return an instance of {@link AdventureGameOptions} from the main()'s parameters
     */
    private static AdventureGameOptions parseOptions(String[] args) {
        OptionsParser parser = OptionsParser.newOptionsParser(AdventureGameOptions.class);
        parser.parseAndExitUponError(args);
        return parser.getOptions(AdventureGameOptions.class);
    }

    /**
     * Creates the dungeon and the player.
     */
    private void initializeGame() {
        dungeon = new Dungeon(options);
        dungeon.generateLinks();

        player = new GamePlayer();
        if (options.playerName.equalsIgnoreCase(DEFAULT_PLAYER_NAME)) {
            player.setName(Menu.getInstance().chooseName());
        } else {
            player.setName(options.playerName);
        }
        logger.info("Using \"" + player.getName() + "\" as your player name");
        player.setCurrentRoom(getStartingRoom());
    }

    /**
     * Starts a game.
     */
    private void startGame() {
        ProgressFrame progressFrame = null;
        if (options.displayDungeon) {
            progressFrame = new ProgressFrame(new Cloner().shallowClone(dungeon.getRoomsArray()));
            progressFrame.updateCurrentRoom(player.getCurrentRoom());
        }
        while (player.isAlive() && !player.reachedExit()) {
            executeTurn();
            if (options.displayDungeon && progressFrame != null) {
                progressFrame.updateCurrentRoom(player.getCurrentRoom());
            }
        }
        printEndgame();
        Menu.getInstance().closeScanner(); // the program ends here so close the scanner that the Menu was using.
    }

    /**
     * Main game logic.
     */
    private void executeTurn() {
        List<Action> actions = player.getPossibleActions();
        Action action = Menu.getInstance().chooseElement(actions);
        try {
            action.execute(player);
        } catch (ActionCannotBeExecutedException e) {
//            TODO log this instead
//            e.printStackTrace();
            logger.info("This action cannot be executed. Please choose another action.");
        }
    }

    /**
     * Prints what triggered the end of the game. Death or escape.
     */
    private void printEndgame() {
        if (!player.isAlive()) {
            logger.info("You died!");
        } else if (player.reachedExit()) {
            logger.info("You won!");
        }
    }

    public Room getStartingRoom() {
        return dungeon.getRandomRoom();
    }
}
