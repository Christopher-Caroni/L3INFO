package fil.coo.run;

import fil.coo.FileChecker;
import org.apache.log4j.Logger;

import static fil.coo.SingleDirArg.getResourceDir;

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

        while (true) ;
    }

}
