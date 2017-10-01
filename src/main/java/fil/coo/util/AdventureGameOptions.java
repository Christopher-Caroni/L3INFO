package fil.coo.util;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

/**
 * Command line options definitions for {@link fil.coo.AdventureGame}
 */
public class AdventureGameOptions extends OptionsBase {

    public static final String DEFAULT_PLAYER_NAME = "default";


    @Option(
            name = "display-dungeon-generation",
            abbrev = 'g',
            help = "Initializes a JFrame before the dungeon generation to show the creation of neighbours",
            defaultValue = "false"
    )
    public boolean displayGeneration;

    @Option(
            name = "display-dungeon-progress",
            abbrev = 'd',
            help = "Shows the dungeon in a JFrame with the player's position",
            defaultValue = "false"
    )
    public boolean displayDungeon;

    @Option(
            name = "dungeon-generation-wait-time",
            abbrev = 't',
            help = "The time between each refresh when the dungeon generates the neighbours",
            defaultValue = "50"
    )
    public int generationWaitTime;

    @Option(
            name = "debug-room-x-coord",
            abbrev = 'x',
            help = "prints the state of one room specified by its coordinates x",
            defaultValue = "-1"
    )
    public int debugRoomX;

    @Option(
            name = "debug-room-y-coord",
            abbrev = 'y',
            help = "prints the state of one room specified by its coordinates y",
            defaultValue = "-1"
    )
    public int debugRoomY;

    @Option(
            name = "playername",
            abbrev = 'p',
            help = "Choose a default player name",
            defaultValue = DEFAULT_PLAYER_NAME
    )
    public String playerName;

    @Option(
            name = "dungeon-height",
            abbrev = 'h',
            help = "the height for the dungeon",
            defaultValue = "5"
    )
    public int customDungeonHeight;

    @Option(
            name = "dungeon-width",
            abbrev = 'w',
            help = "the height for the dungeon",
            defaultValue = "5"
    )
    public int customDungeonWidth;

}
