package fil.coo.util;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

import java.util.List;

/**
 * Command line options definitions for {@link fil.coo.AdventureGame}
 */
public class AdventureGameOptions extends OptionsBase {

    public static final String DEFAULT_PLAYER_NAME = "default";


    @Option(
            name = "display-generation",
            abbrev = 'g',
            help = "Initializes a JFrame before the dungeon generation to show the creation of neighbours",
            defaultValue = "false"
    )
    public boolean displayGeneration;

    @Option(
            name = "display-generation-wait-time",
            abbrev = 'w',
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
    public int xCoord;

    @Option(
            name = "debug-room-y-coord",
            abbrev = 'y',
            help = "prints the state of one room specified by its coordinates y",
            defaultValue = "-1"
    )
    public int yCoord;

    @Option(
            name = "playername",
            abbrev = 'p',
            help = "Choose a default playe rname",
            defaultValue = DEFAULT_PLAYER_NAME
    )
    public String playerName;

}
