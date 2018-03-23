package fil.coo.controller;

import fil.coo.gui.AbstractQuizView;
import fil.coo.model.QuizModel;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Interfaces between the view and the model to react to user events in the GUI.
 * Specifically reacts to a user submission. Any extra features may be added by extending this class and binding
 * the view to the new methods
 */
public abstract class IQuizController {

    private static final Logger logger = Logger.getLogger(IQuizController.class.getSimpleName());

    protected final QuizModel quizModel;
    protected final AbstractQuizView quizView;

    public IQuizController(QuizModel quizModel, AbstractQuizView quizView) {
        this.quizModel = quizModel;
        this.quizView = quizView;

        this.quizView.attachController(this);
    }

    /**
     * When the submit button is clicked: validates all user input, checks the correct answers, tells the view
     * to display any error of the user, or whether he won
     */
    public void onSubmit() {
        logger.debug("received onSubmit");

        final List<String> userAnswers = quizView.getUserAnswerInput();
        if (userAnswers.isEmpty()) {
            logger.debug("Received empty user answers");
            return;
        }

        List<Integer> invalidAnswers = getInvalidInputIndexes(userAnswers);

        if (!invalidAnswers.isEmpty()) {
            refuseSubmissionOnInvalidInput(invalidAnswers);
        } else {
            acceptSubmission(userAnswers, quizModel.getPoints());
        }
    }

    /**
     * @param userAnswers the user's input for all the answers
     * @return the indexes of the answers with invalid inputs
     */
    protected List<Integer> getInvalidInputIndexes(final List<String> userAnswers) {
        List<Integer> invalidAnswers = new ArrayList<>();
        for (int i = 0; i < userAnswers.size(); i++) {
            String userAnswer = userAnswers.get(i);
            String message = "Checking valid answer at index " + i + " with answer + \"" + userAnswers.get(i) + "\" ";
            if (quizModel.validateAnswerType(i, userAnswer)) {
                message += "CORRECT";
                logger.debug(message);
            } else {
                invalidAnswers.add(i);
                message += "FALSE";
                logger.debug(message);
            }
        }
        return invalidAnswers;
    }

    /**
     * Prompts the user in the view if any of his inputs are invalid
     *
     * @param invalidInputIndexes the indexes of the answers with invalid inputs
     */

    protected void refuseSubmissionOnInvalidInput(final List<Integer> invalidInputIndexes) {
        quizView.showInvalidInputs(invalidInputIndexes);
    }

    /**
     * Gets the total of points won and asks {@link #quizView} to display it
     *
     * @param userAnswers the user's input for all the answers
     * @param points      the list of points whose indices correspond to the indices of the questions
     */
    protected void acceptSubmission(final List<String> userAnswers, List<Integer> points) {
        int pointsWon = verifyCorrectAnswers(userAnswers, points);
        quizView.onSubmissionFinished(pointsWon);
    }

    /**
     * Verifies userAnswers against the {@link #quizModel} and counts the total of points won
     *
     * @param userAnswers the user's input for all the answers
     * @param points      the list of points whose indices correspond to the indices of the questions
     * @return the number of points won
     */
    protected int verifyCorrectAnswers(final List<String> userAnswers, List<Integer> points) {
        int pointsWon = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            String message = "Checking correct answer at index " + i + " + with answer + \"" + userAnswers.get(i) + "\" ";
            if (quizModel.checkCorrectAnswer(i, userAnswers.get(i))) {
                message += "CORRECT";
                logger.debug(message);
                pointsWon += points.get(i);
            } else {
                message += "FALSE";
                logger.debug(message);
            }
        }
        return pointsWon;
    }

    public void displayFrame() {
        quizView.setVisible(true);
    }
}
