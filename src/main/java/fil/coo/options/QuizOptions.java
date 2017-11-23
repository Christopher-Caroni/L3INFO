package fil.coo.options;

import org.apache.commons.cli.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class QuizOptions {

    private static Logger logger = Logger.getLogger(QuizOptions.class.getSimpleName());

    public static final String NO_GUI = "text";
    public static final String DUMMY_ARGS = "dummy";
    public static final String HELP = "help";

    private ArrayList<Option> optionList;

    public QuizOptions() {
        optionList = new ArrayList<>();
        optionList.add(Option.builder("t")
                .desc("Use terminal instead of GUI")
                .longOpt(NO_GUI)
                .build()
        );

        optionList.add(Option.builder("d")
                .desc("Use dummy arguments")
                .longOpt(DUMMY_ARGS)
                .build()
        );

        optionList.add(Option.builder("h")
                .desc("Show help")
                .longOpt(HELP)
                .build()
        );
    }

    public CommandLine generateCommandLine(String[] args) {
        CommandLineParser parser = new DefaultParser();
        CommandLine line = null;
        try {
            line = parser.parse(generateOptions(), args);
        } catch (ParseException e) {
            logger.debug(e);
        }
        return line;
    }

    private Options generateOptions() {
        Options options = new Options();
        for (Option option : optionList) {
            options.addOption(option);
        }
        return options;
    }

    public void displayHelp() {
        logger.info("Usage: java -jar COO-QUIZ-VERSION.jar <quiz_file> [-td] [-h]");
        String argsDesc = String.format("%-12s \t %-15s \t %-30s", "short option", "long option", "description");
        logger.info(argsDesc);
        for (Option option : optionList) {
            String optionDesc = String.format("-%-12s \t --%-15s \t %-30s", option.getOpt(), option.getLongOpt(), option.getDescription());
            logger.info(optionDesc);
        }
    }
}
