package fil.coo.controller;

import fil.coo.gui.AbstractQuizView;
import fil.coo.model.QuizModel;

import java.util.ArrayList;
import java.util.List;

public abstract class IQuizController {

    protected final QuizModel quizModel;
    protected final AbstractQuizView quizView;

    public IQuizController(QuizModel quizModel, AbstractQuizView quizView) {
        this.quizModel = quizModel;
        this.quizView = quizView;
    }

    /**
     * When the submit button is clicked: validates all user input
     */
    public void onSubmit() {
        List<String> userAnswers = quizView.getUserAnswerInput();

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
            if (quizModel.validateAnswerType(i, userAnswer)) {
                invalidAnswers.add(i);
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
            if (quizModel.checkCorrectAnswer(i, userAnswers.get(i))) {
                i++;
            }
        }
        return pointsWon;
    }
}
