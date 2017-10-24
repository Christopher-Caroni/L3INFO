package fil.coo.answers;

public interface Answer {
	
	public String getPrompt();
	public boolean isValid(String userAnswer);
	public boolean isCorrect(String userAnswer);
}
