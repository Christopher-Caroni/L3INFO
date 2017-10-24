package fil.coo.answers;

public class YesNoAnswer extends SingleAnswer {
	
	public YesNoAnswer(String answer) {
		super(answer);
	}

	public String getPrompt() {
		return "(oui/non)" + this.getAnswer() ;
	}

	public boolean isValid(String userAnswer) throws NullPointerException {
		return userAnswer.equals("oui") || userAnswer.equals("non");
	}
}
