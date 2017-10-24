package fil.coo.answers;

public class NumericalAnswer extends SingleAnswer {

    public NumericalAnswer(String answer) {
        super(answer);
    }

    public String getPrompt() {
        return null;
    }

    public boolean isValid(String userAnswer) throws NullPointerException {
        return false;
    }
}
