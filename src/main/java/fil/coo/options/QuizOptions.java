package fil.coo.options;

import org.apache.commons.cli.*;
import org.apache.log4j.Logger;

public class QuizOptions {

    private static Logger logger = Logger.getLogger(QuizOptions.class.getSimpleName());

    public static final String NO_GUI = "text";

    private QuizOptions() {
    }

    public static CommandLine generateCommandLine(String[] args) {
        CommandLineParser parser = new DefaultParser();
        CommandLine line = null;
        try {
            line = parser.parse(generateOptions(), args);
        } catch (ParseException e) {
            logger.debug(e);
        }
        return line;
    }

    private static Options generateOptions() {
        Option noGui = Option.builder("t")
                .desc("Use terminal instead of GUI")
                .longOpt(NO_GUI)
                .build();

        Options options = new Options();
        options.addOption(noGui);

        return options;
    }
}
