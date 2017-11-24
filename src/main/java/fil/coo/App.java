package fil.coo;

import fil.coo.controller.impl.QuizController;
import fil.coo.gui.AbstractQuizView;
import fil.coo.gui.factory.QuizFrameFactory;
import fil.coo.model.factory.QuizFactory;
import fil.coo.model.impl.CLIQuiz;
import fil.coo.options.QuizOptions;
import org.apache.log4j.Logger;

import java.io.IOException;

import static fil.coo.options.QuizOptions.DUMMY_ARGS;
import static fil.coo.options.QuizOptions.TEXT_MODE;

/**
 * Hello world!
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class.getSimpleName());

    private QuizOptions quizOptions;

    private CLIQuiz quiz;

    public static void main(String[] args) {
        App app = null;
        try {
            app = new App(args);
        } catch (IOException e) {
            logger.info(e.getMessage());
            return;
        }

        app.run();
    }


    /**
     * Parses the arguments with the options specified in {@link QuizOptions} and loads the quiz.
     *
     * @param args the program arguments
     * @throws IOException if the file could not be loaded
     */
    public App(String[] args) throws IOException {
        parseOptions(args);

        quiz = createQuiz();
    }

    protected void parseOptions(String[] args) {
        quizOptions = new QuizOptions(args);
        quizOptions.checkExclusiveOptions();

        if (quizOptions.hasOption(DUMMY_ARGS)) {
            quizOptions = new QuizOptions(getDummyArgs());
        }
    }


    /**
     * Creates a {@link CLIQuiz} using the path to the quiz file found by {@link QuizOptions#getQuizPath()}
     * {@link QuizFactory}
     *
     * @return a new {@link CLIQuiz}
     * @throws IOException if there was a user error in the quiz path
     */
    protected CLIQuiz createQuiz() throws IOException {
        String quizFile = quizOptions.getQuizPath();
        return new QuizFactory().createQuizFromTextFile(quizFile);
    }

    /**
     * Runs the GUI or text version of the quiz
     */
    private void run() {
        if (quizOptions.hasOption(TEXT_MODE)) {
            runCommandLine();
        } else {
            runGui();
        }
    }

    /**
     * Runs the text version of the quiz.
     *
     * @see CLIQuiz#askAll()
     */
    private void runCommandLine() {
        quiz.askAll();
    }

    /**
     * Runs the GUI version of the quiz using {@link QuizFrameFactory}
     */
    private void runGui() {
        AbstractQuizView quizFrame = QuizFrameFactory.getInstance().createQuizView(quiz);

        QuizController quizController = new QuizController(quiz, quizFrame);
        quizController.displayFrame();
    }

    /**
     * @return a dummy array of arguments that will load the quiz at "resources/dummy.quiz"
     */
    private String[] getDummyArgs() {
        return new String[]{"resources/dummy.quiz"};
    }

}
