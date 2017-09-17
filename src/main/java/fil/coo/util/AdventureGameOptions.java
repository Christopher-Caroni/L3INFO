package fil.coo.util;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

/**
 * Command line options definitions for {@link fil.coo.AdventureGame}
 */
public class AdventureGameOptions extends OptionsBase {

    @Option(
            name = "debug",
            abbrev = 'd',
            help = "Opens a swing JFrame to visualize the maze",
            defaultValue = "false"

    )
    public boolean debug;

}
