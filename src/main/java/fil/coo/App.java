package fil.coo;

import fil.coo.gui.QuizFrame;
import fil.coo.gui.controller.QuizController;
import fil.coo.quiz.Quiz;
import fil.coo.quiz.QuizFactory;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class.getSimpleName());


    public static void main(String[] args) {
        logger.info("Hello World!");

        System.out.print("Hello World with no newline.");
        logger.debug("Hello World with no newline.");

        logger.info("Next line with a newline");
        logger.info("Another line with newline");

        dummyQuiz();
    }

    private static void dummyQuiz() {
        try {
            Quiz quiz = new QuizFactory().createQuizFromTextFile("resources/dummy.quiz");
            QuizFrame quizFrame = new QuizFrame(quiz.getNbQuestions());
            QuizController quizController = new QuizController(quizFrame, quiz);
            quizController.displayFrame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
