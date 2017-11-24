package fil.coo.model.impl;

import org.apache.log4j.Logger;

import fil.coo.model.QuestionModel;
import fil.coo.model.QuizModel;

public class CLIQuiz extends QuizModel {

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
        for (QuestionModel question : questions) {
            totalPoints += question.ask();
        }
        logger.info("Quiz finished and you won " + getPointsWon() + " points");
    }

}
