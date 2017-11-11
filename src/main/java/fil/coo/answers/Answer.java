package fil.coo.answers;

import fil.coo.gui.factory.AnswerPanelFactory;

import javax.swing.*;

public abstract class Answer {

    public abstract String getPrompt();

    public abstract String getCorrectAnswer();

    public Answer(String answer) throws NullPointerException, InvalidAnswerException {
        if (answer == null) {
            throw new NullPointerException();
        }
        if (!isQuizTextValid(answer)) {
            throw new InvalidAnswerException();
        }
    }

    /**
     * @param userAnswer
     * @return if the user's answer is in a valid format
     * @throws NullPointerException when userAnswer is null
     */
    public final boolean isValid(String userAnswer) throws NullPointerException {
        verifyUserInputNotNull(userAnswer);
        if ("".equals(userAnswer)) {
            return false;
        }
        return checkUserAnswerIsValid(userAnswer);
    }

    protected abstract boolean isQuizTextValid(String quizText);

    protected abstract boolean checkUserAnswerIsValid(String userAnswer);

    /**
     * @param userAnswer
     * @return if the user's answer is the correct answer
     * @throws NullPointerException when userAnswer is null
     */
    public final boolean isCorrect(String userAnswer) throws NullPointerException {
        verifyUserInputNotNull(userAnswer);
        return checkUserAnswerIsCorrect(userAnswer);
    }

    protected abstract boolean checkUserAnswerIsCorrect(String userAnswer);

    public void verifyUserInputNotNull(String input) throws NullPointerException {
        if (input == null) {
            throw new NullPointerException("User's answer cannot be null");
        }
    }

    /**
     * Creates an {@link AnswerPanel} by calling createAnswerPanel on the answerPanelFactory with this class' instance type.
     *
     * @param answerPanelFactory the factory that will create the {@link AnswerPanel} instance/
     * @return an {@link AnswerPanel} that corresponds to whatever type of {@link Answer} this instance is
     */
    public abstract JPanel createAnswerPanel(AnswerPanelFactory answerPanelFactory);

}
