package fil.coo.controller;

import fil.coo.gui.AbstractQuizView;
import fil.coo.model.QuizModel;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

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
     * When the submit button is clicked: validates all user input
     */
    public void onSubmit() {
        logger.debug("received onSubmit");

        List<String> userAnswers = quizView.getUserAnswerInput();
        if (userAnswers.isEmpty()) {
            logger.debug("Received empty user answers");
            return;
        }

        List<Integer> invalidAnswers = verifyInvalidInput(userAnswers);

        if (!invalidAnswers.isEmpty()) {
            refuseSubmissionOnInvalidInput(invalidAnswers);
        } else {
            acceptSubmission(userAnswers);
        }
    }

    /**
     * @param userAnswers the user's input for all the answers
     * @return the indexes of the answers with invalid inputs
     */
    private List<Integer> verifyInvalidInput(List<String> userAnswers) {
        List<Integer> invalidAnswers = new ArrayList<>();
        for (int i = 0; i < userAnswers.size(); i++) {
            String userAnswer = userAnswers.get(i);
            String message = "Checking valid answer at index " + i + " + with answer + \"" + userAnswers.get(i) + "\" ";
            if (quizModel.validateAnswerType(i, userAnswer)) {
                invalidAnswers.add(i);
                message += "CORRECT";
                logger.debug(message);
            } else {
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

    protected void refuseSubmissionOnInvalidInput(List<Integer> invalidInputIndexes) {
        quizView.showInvalidInputs(invalidInputIndexes);
    }

    /**
     * Gets the total of points won and asks {@link #quizView} to display it
     *
     * @param userAnswers the user's input for all the answers
     */
    protected void acceptSubmission(List<String> userAnswers) {
        int pointsWon = verifyCorrectAnswers(userAnswers);
        quizView.onSubmissionFinished(pointsWon);
    }

    /**
     * Verifies userAnswers against the {@link #quizModel} and counts the total of points won
     *
     * @param userAnswers the user's input for all the answers
     * @return the number of points won
     */
    protected int verifyCorrectAnswers(List<String> userAnswers) {
        int pointsWon = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            String message = "Checking correct answer at index " + i + " + with answer + \"" + userAnswers.get(i) + "\" ";
            if (quizModel.checkCorrectAnswer(i, userAnswers.get(i))) {
                message += "CORRECT";
                logger.debug(message);
                i++;
            } else {
                message += "FALSE";
                logger.debug(message);
            }
        }
        return pointsWon;
    }
}
