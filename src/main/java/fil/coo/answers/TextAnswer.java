package fil.coo.answers;

public class TextAnswer extends SingleAnswer {

    /**
     * Default constructor to use for subclasses that need to treat the answer in {@link #TextAnswer(String)} before calling {@link #initAnswer(String)}
     */
    protected TextAnswer() {
        super();
    }

    public TextAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        super(answer);
    }

    public String getPrompt() {
        return "(text)";
    }

    protected boolean checkUserAnswerIsValid(String userAnswer) {
        int number;
        try {
            number = Integer.parseInt(userAnswer);
        } catch (NumberFormatException e){
            return true;
        }
        return false;
    }

}
