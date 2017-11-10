package fil.coo;

import fil.coo.gui.QuizFrame;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class.getSimpleName());


    public static void main( String[] args ) {
        logger.info("Hello World!" );

        System.out.print("Hello World with no newline.");
        logger.debug("Hello World with no newline.");

        logger.info("Next line with a newline");
        logger.info("Another line with newline");

        QuizFrame quizFrame = new QuizFrame();
    }
}
