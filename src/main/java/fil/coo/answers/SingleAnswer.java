package fil.coo.answers;

public abstract class SingleAnswer extends Answer {

    protected String answer;

    public SingleAnswer(String answer) {
		this.answer = answer;
	}

    @Override
    protected boolean checkUserAnswerIsCorrect(String userAnswer) {
        return answer.equals(userAnswer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
