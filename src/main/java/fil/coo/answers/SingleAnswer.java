package fil.coo.answers;

public abstract class SingleAnswer extends Answer {

    protected String answer;

    public SingleAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        if(answer == null){
    		throw new NullPointerException();
    	}
    	if(this.isValid(answer)){
    		this.answer = answer;
    	}else{
    		throw new InvalidAnswerException();
    	}
	}

    @Override
    protected boolean checkUserAnswerIsCorrect(String userAnswer) {
        return answer.equals(userAnswer);
    }

    public String getAnswer() {
        return answer;
    }
}
