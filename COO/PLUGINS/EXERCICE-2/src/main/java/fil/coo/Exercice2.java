package fil.coo;

import org.apache.log4j.Logger;

public class Exercice2 {

    private static final Logger logger = Logger.getLogger(Exercice2.class.getSimpleName());

    public static void main(String[] args) {

        String dir = null;
        try {
            dir = getResourceDir(args);
        } catch (IllegalArgumentException e) {
            logger.info(e.getMessage());
            System.exit(1);
        }

        DirectoryInspector directoryInspector = null;
        try {
            directoryInspector = new DirectoryInspector(dir);
        } catch (Exception e) {
            logger.info(e.getMessage());
            System.exit(1);
        }

        logger.info("-------- Printing files that start with \"C\" or \"c\" -----------");
        directoryInspector.getFilesThatStartWithC()
                .forEach(logger::info);

        logger.info("-------- Printing files that start end with \".class\" -----------");
        directoryInspector.getClassFiles()
                .forEach(logger::info);
    }

    private static String getResourceDir(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("This program only accepts one argument which is the directory to watch");
        }
        return args[0];
    }

}
