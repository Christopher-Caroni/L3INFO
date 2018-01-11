package fil.coo.model.impl;

import fil.coo.model.QuizModel;
import org.apache.log4j.Logger;

/**
 * Extends {@link QuizModel} with {@link CLIQuestion} to
 * ask the whole quiz to the user in the CLI via {@link CLIQuestion#ask()}
 */
public class CLIQuiz extends QuizModel<CLIQuestion> {

    private static final Logger logger = Logger.getLogger(CLIQuiz.class.getSimpleName());

    private int totalPoints;

    public CLIQuiz() {
        super();
        totalPoints = 0;
    }

    /**
     * @return the amount of points the user won
     */
    public int getPointsWon() {
        return totalPoints;
    }

    /**
     * Asks all the questions in this quiz
     */
    public void askAll() {
        for (CLIQuestion question : questions) {
            totalPoints += question.ask();
        }
        logger.info("Quiz finished and you won " + getPointsWon() + " points");
    }

}
