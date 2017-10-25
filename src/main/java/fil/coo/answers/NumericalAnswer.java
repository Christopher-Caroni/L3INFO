package fil.coo.answers;

public class NumericalAnswer extends SingleAnswer {

    public NumericalAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        super(answer);
    }

    public String getPrompt() {
        return "(numerical)";
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
