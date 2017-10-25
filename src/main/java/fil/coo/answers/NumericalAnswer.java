package fil.coo.answers;

public class NumericalAnswer extends SingleAnswer {

    public NumericalAnswer(String answer) throws NullPointerException, NotCorrectAnswerException {
        super(answer);
    }

    public String getPrompt() {
        return null;
    }

    protected boolean checkUserAnswerIsValid(String userAnswer) {
        int number;
        try {
            number = Integer.parseInt(userAnswer);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
