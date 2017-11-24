package fil.coo.model.impl;

import fil.coo.exception.InvalidAnswerException;
import fil.coo.model.AnswerModel;

public abstract class Answer implements AnswerModel {

    public Answer(String answer) throws NullPointerException, InvalidAnswerException {
        if (answer == null) {
            throw new NullPointerException();
        }
        if (!isQuizTextValid(answer)) {
            throw new InvalidAnswerException();
        }
    }

    /**
     * Common behaviour to all answer classes:
     * refuses null input or empty strings
     *
     * @param userAnswer the user's attempt at the answer
     * @return if the user's answer is in a valid format
     * @throws NullPointerException when the input is null
     */
    public final boolean isValid(String userAnswer) throws NullPointerException {
        verifyUserInputNotNull(userAnswer);
        if ("".equals(userAnswer)) {
            return false;
        }
        return checkUserAnswerIsValid(userAnswer);
    }

    /**
     * @param quizText the string read from the .quiz file
     * @return if quizText in the correct format for this type of Answer
     */
    protected abstract boolean isQuizTextValid(String quizText);

    /**
     * @param userAnswer the user's answer
     * @return if the userAnswer is in the expected format to be eventually considered as correct
     */
    protected abstract boolean checkUserAnswerIsValid(String userAnswer);

    /**
     * Common behaviour to all concrete answer classes:
     * refuses null input
     *
     * @param userAnswer the user's answer
     * @return if the userAnswer is the correct answer
     * @throws NullPointerException when the user's input is null
     */
    public final boolean isCorrect(String userAnswer) throws NullPointerException {
        verifyUserInputNotNull(userAnswer);
        return checkUserAnswerIsCorrect(userAnswer);
    }

    /**
     *
     * The implementing class' verification if userAnswer is actually the correct answer
     *
     * @param userAnswer the user's answer
     * @return if the userAnswer is the correct answer
     */
    protected abstract boolean checkUserAnswerIsCorrect(String userAnswer);

    protected void verifyUserInputNotNull(String input) throws NullPointerException {
        if (input == null) {
            throw new NullPointerException("User's answer cannot be null");
        }
    }

}
