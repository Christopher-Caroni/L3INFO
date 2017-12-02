package fil.coo;

import org.apache.log4j.Logger;

public class Exercice3 {

    private static final Logger logger = Logger.getLogger(Exercice3.class.getSimpleName());

    public static void main(String[] args) {

        String dir = null;
        try {
            dir = getResourceDir(args);
        } catch (IllegalArgumentException e) {
            logger.info(e.getMessage());
            System.exit(1);
        }

        FileChecker fileChecker = null;
        try {
            fileChecker = new FileChecker(dir, (dir1, name) -> name.endsWith(".class"));
        } catch (Exception e) {
            logger.info(e.getMessage());
            System.exit(1);
        }

        PrintListener printListener = new PrintListener();
        fileChecker.addFileListener(printListener);

        fileChecker.start();
    }

    private static String getResourceDir(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("This program only accepts one argument which is the directory to watch");
        }
        return args[0];
    }

}
