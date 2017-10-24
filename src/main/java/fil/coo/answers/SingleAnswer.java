package fil.coo.answers;

public abstract class SingleAnswer implements Answer {

    protected String answer;

    @Override
    public boolean isCorrect(String userAnswer) throws NullPointerException {
        return answer.equals(userAnswer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
