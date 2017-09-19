package fil.coo;

import com.google.devtools.common.options.OptionsParser;
import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.gui.DungeonFrame;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.beings.Player;
import fil.coo.spawnables.items.interfaces.Item;
import fil.coo.structures.Dungeon;
import fil.coo.structures.Room;
import fil.coo.structures.RoomFactory;
import fil.coo.util.AdventureGameOptions;
import fil.coo.util.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Hello world!
 */
public class AdventureGame {

    private static final int WIDTH_DUNGEON = 10;
    private static final int HEIGHT_DUNGEON = 10;


    private Player player;

    private Dungeon dungeon;

    private AdventureGameOptions options;

    private AdventureGame(AdventureGameOptions options) {
        this.options = options;
    }

    public static void main(String[] args) {
        AdventureGameOptions options = parseOptions(args);

        AdventureGame adventureGame = new AdventureGame(options);
        adventureGame.startGame();
    }

    private static AdventureGameOptions parseOptions(String[] args) {
        OptionsParser parser = OptionsParser.newOptionsParser(AdventureGameOptions.class);
        parser.parseAndExitUponError(args);
        return parser.getOptions(AdventureGameOptions.class);
    }

    /**
     * @param player the next player who's turn it is to act
     */
    public void play(Player player) {

    }

    public void addMonster(Monster monster, Room room) {

    }

    public void addItem(Item item, Room room) {

    }

    public boolean isFinished() {
        // TODO
        return false;
    }

    public void playerMoveTo(Direction direction) {

    }


    /**
     * Starts a game
     */
    public void startGame() {

        dungeon = new Dungeon(HEIGHT_DUNGEON, WIDTH_DUNGEON, options);
        dungeon.generate();

        // TODO the game progression
    }

}
