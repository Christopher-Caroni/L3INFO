package fil.coo.answers;

public abstract class Answer {

    public abstract String getPrompt();

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

    /**
     * @param userAnswer the user's answer
     * @return if the user's answer is in a valid format
     */
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

}
