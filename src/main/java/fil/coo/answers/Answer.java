package fil.coo.answers;

public interface Answer {

	public String getPrompt();

    /**
     *
     * @param userAnswer
     * @return
     * @throws NullPointerException when userAnswer is null
     */
	public boolean isValid(String userAnswer) throws NullPointerException;


    /**
     *
     * @param userAnswer
     * @return
     * @throws NullPointerException when userAnswer is null
     */
	public boolean isCorrect(String userAnswer) throws NullPointerException;

}
