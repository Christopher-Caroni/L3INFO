package fil.coo.options;

import fil.coo.App;
import org.apache.commons.cli.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Specific options that may be used in conjunction with {@link App}.
 * The presence of options may be verified with {@link #hasOption(String)} using the global Strings prefixed with "OPTION"
 */
public class QuizOptions {

    private static Logger logger = Logger.getLogger(QuizOptions.class.getSimpleName());

    public static final String OPTION_TEXT_MODE = "text";
    public static final String OPTION_DUMMY_ARGS = "dummy";
    private static final String OPTION_HELP = "help";

    private ArrayList<Option> optionList;
    private CommandLine commandLine;
    private Options options;

    public QuizOptions(String[] args) {
        optionList = new ArrayList<>();
        optionList.add(Option.builder("t")
                .desc("Use terminal instead of GUI")
                .longOpt(OPTION_TEXT_MODE)
                .build()
        );

        optionList.add(Option.builder("d")
                .desc("Use dummy arguments: opens the quiz in resources/dummy.quiz in the GUI")
                .longOpt(OPTION_DUMMY_ARGS)
                .build()
        );

        optionList.add(Option.builder("h")
                .desc("Show help")
                .longOpt(OPTION_HELP)
                .build()
        );

        generateOptions();
        generateCommandLine(args);
    }

    private void generateCommandLine(String[] args) {
        CommandLineParser parser = new DefaultParser();
        commandLine = null;
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException e) {
            logger.debug(e);
        }
    }

    private void generateOptions() {
        options = new Options();
        for (Option option : optionList) {
            options.addOption(option);
        }
    }


    public void displayHelp() {
        logger.info("Usage: java -jar COO-QUIZ-VERSION.jar <quiz_file> [-t | d] [-h]");
        String argsDesc = String.format("%-12s \t %-15s \t %-30s", "short option", "long option", "description");
        logger.info(argsDesc);
        for (Option option : optionList) {
            String optionDesc = String.format("-%-12s \t --%-15s \t %-30s", option.getOpt(), option.getLongOpt(), option.getDescription());
            logger.info(optionDesc);
        }
    }

    /**
     * Checks for any options that prevent and must be treated before the program runs. Exits with {@link System#exit(int)} after
     * any processing
     */
    public void checkPreExecutionOptions() {
        if (commandLine.hasOption(OPTION_HELP)) {
            displayHelp();
            System.exit(0);
        }

        if (hasOption(OPTION_DUMMY_ARGS) && hasOption(OPTION_TEXT_MODE)) {
            logger.info("Cannot use use dummy arguments and use text mode at the same time.");
            System.exit(1);
        }

    }

    /**
     * @param optionName the name of the option to check for
     * @return if the command line has the option optionName
     */
    public boolean hasOption(String optionName) {
        return commandLine.hasOption(optionName);
    }

    /**
     * @return the path to the quiz file from the command line options
     * @throws IOException if the user did not correctly call this program relating to how the quiz file should be specified
     */
    public String getQuizPath() throws IOException {
        if (commandLine.getArgList().size() > 1) {
            throw new IOException("Ambiguous quiz file specified. This program only accepts one non-option argument as the quiz file");
        } else if (commandLine.getArgList().size() != 1) {
            throw new IOException("No quiz file specified");
        }
        return commandLine.getArgList().get(0);
    }
}
