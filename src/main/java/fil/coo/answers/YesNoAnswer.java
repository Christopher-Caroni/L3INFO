package fil.coo.answers;

public class YesNoAnswer extends SingleAnswer {
	
	public YesNoAnswer(String answer) throws NullPointerException, NotCorrectAnswerException {
		super(answer);
	}

	public String getPrompt() {
		return "(oui/non) " + this.getAnswer() ;
	}

	protected boolean checkUserAnswerIsValid(String userAnswer) {
		return userAnswer.equals("oui") || userAnswer.equals("non");
	}

}
