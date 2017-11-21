package fil.coo;

import fil.coo.controller.impl.QuizController;
import fil.coo.gui.AbstractQuizView;
import fil.coo.gui.factory.QuizFrameFactory;
import fil.coo.model.factory.QuizFactory;
import fil.coo.model.impl.Quiz;
import fil.coo.options.QuizOptions;
import org.apache.commons.cli.CommandLine;
import org.apache.log4j.Logger;

import java.io.IOException;

import static fil.coo.options.QuizOptions.DUMMY_ARGS;
import static fil.coo.options.QuizOptions.NO_GUI;

/**
 * Hello world!
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class.getSimpleName());

    private CommandLine lineOptions;
    private Quiz quiz;

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
        lineOptions = QuizOptions.generateCommandLine(args);
        if (lineOptions.hasOption(DUMMY_ARGS)) {
            lineOptions = QuizOptions.generateCommandLine(getDummyArgs());
        }
        quiz = createQuiz();
    }


    /**
     * Finds the appropriate argument that specifies the path to the quiz file and creates a {@link Quiz} using
     * {@link QuizFactory}
     *
     * @return a {@link Quiz}
     * @throws IOException
     */
    protected Quiz createQuiz() throws IOException {
        String quizFile = getQuizPath();
        return new QuizFactory().createQuizFromTextFile(quizFile);
    }

    /**
     * Looks at the leftover arguments from {@link #lineOptions} and if there is only one, uses it as the path
     *
     * @return the path to the quiz
     * @throws IOException if it could not determine the path
     */
    private String getQuizPath() throws IOException {
        if (lineOptions.getArgList().size() > 1) {
            throw new IOException("Ambiguous quiz file specified");
        } else if (lineOptions.getArgList().size() != 1) {
            throw new IOException("No file specified");
        }
        return lineOptions.getArgList().get(0);
    }

    /**
     * Runs the GUI or text version of the quiz
     */
    private void run() {
        if (lineOptions.hasOption(NO_GUI)) {
            runCommandLine();
        } else {
            runGui();
        }
    }

    /**
     * Runs the text version of the quiz.
     *
     * @see Quiz#askAll()
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
