package fil.coo.answers;

public abstract class Answer {

	public abstract String getPrompt();

    /**
     * @param userAnswer
     * @return
     * @throws NullPointerException when userAnswer is null
     */
    public final boolean isValid(String userAnswer) throws NullPointerException {
        verifyUserInputNotNull(userAnswer);
        return checkUserAnswerIsValid(userAnswer);
    }

    protected abstract boolean checkUserAnswerIsValid(String userAnswer);


    /**
     * @param userAnswer
     * @return
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
