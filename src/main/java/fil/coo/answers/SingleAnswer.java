package fil.coo.answers;

public abstract class SingleAnswer extends Answer {

    protected String answer;

    public SingleAnswer(String answer) throws NullPointerException, NotCorrectAnswerException{
        if(answer == null){
    		throw new NullPointerException();
    	}
    	if(this.checkUserAnswerIsValid(answer)){
    		this.answer = answer;
    	}else{
    		throw new NotCorrectAnswerException();
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
