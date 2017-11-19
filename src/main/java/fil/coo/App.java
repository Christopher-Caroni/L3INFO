package fil.coo;

import fil.coo.gui.factory.QuizFrameFactory;
import fil.coo.gui.AbstractQuizView;
import fil.coo.controller.impl.QuizController;
import fil.coo.model.impl.Quiz;
import fil.coo.model.factory.QuizFactory;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class.getSimpleName());


    public static void main(String[] args) {
       /*
        logger.info("Hello World!");

        System.out.print("Hello World with no newline.");
        logger.debug("Hello World with no newline.");

        logger.info("Next line with a newline");
        logger.info("Another line with newline");

        */


        dummyQuizText();
        //dummyQuizGraphic();
    }
    private static void dummyQuizText() {
        try {
            Quiz quiz = new QuizFactory().createQuizFromTextFile("resources/dummy.quiz");
            quiz.askAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dummyQuizGraphic() {
        try {
            Quiz quiz = new QuizFactory().createQuizFromTextFile("resources/dummy.quiz");
            AbstractQuizView quizFrame = QuizFrameFactory.getInstance().createQuizView(quiz);

            QuizController quizController = new QuizController(quiz, quizFrame);
            quizController.displayFrame();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
