package fil.coo.answers;

public abstract class SingleAnswer implements Answer {

    protected String answer;

    @Override
    public boolean isCorrect(String userAnswer) {
        return answer.equals(userAnswer);
    }

}
