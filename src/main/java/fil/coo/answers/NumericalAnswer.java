package fil.coo.answers;

public class NumericalAnswer extends SingleAnswer {

    public NumericalAnswer(String answer) {
        super(answer);
    }

    public String getPrompt() {
        return null;
    }

    protected boolean checkUserAnswerIsValid(String userAnswer) {
        return false;
    }
}
