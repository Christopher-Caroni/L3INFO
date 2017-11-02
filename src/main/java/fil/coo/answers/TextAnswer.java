package fil.coo.answers;

public class TextAnswer extends SingleAnswer {

    public TextAnswer(String answer, boolean save) throws NullPointerException, InvalidAnswerException {
        super(answer, save);
    }

    @Override
    protected boolean isQuizTextValid(String quizText) {
        return checkUserAnswerIsValid(quizText);
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
