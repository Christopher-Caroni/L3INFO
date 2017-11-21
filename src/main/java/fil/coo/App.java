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



    public App(String[] args) throws IOException {
        lineOptions = QuizOptions.generateCommandLine(args);
        if (lineOptions.hasOption(DUMMY_ARGS)) {
            lineOptions = QuizOptions.generateCommandLine(getDummyArgs());
        }
        quiz = createQuiz();
    }

    protected Quiz createQuiz() throws IOException {
        String quizFile = getQuizPath();
        return new QuizFactory().createQuizFromTextFile(quizFile);
    }

    private String getQuizPath() throws IOException {
        if (lineOptions.getArgList().size() > 1) {
            throw new IOException("Ambiguous quiz file specified");
        } else if (lineOptions.getArgList().size() != 1) {
            throw new IOException("No file specified");
        }
        return lineOptions.getArgList().get(0);
    }

    private void run() {
        if (lineOptions.hasOption(NO_GUI)) {
            runCommandLine();
        } else {
            runGui();
        }
    }

    private void runCommandLine() {
        quiz.askAll();
    }

    private void runGui() {
        AbstractQuizView quizFrame = QuizFrameFactory.getInstance().createQuizView(quiz);

        QuizController quizController = new QuizController(quiz, quizFrame);
        quizController.displayFrame();
    }


    private String[] getDummyArgs() {
        return new String[]{"resources/dummy.quiz"};
    }

}
