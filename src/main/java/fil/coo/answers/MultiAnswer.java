package fil.coo.answers;

public class MultiAnswer extends Answer {

    public String getPrompt() {
        return null;
    }

    protected boolean checkUserAnswerIsValid(String userAnswer) {
        return false;
    }

    protected boolean checkUserAnswerIsCorrect(String userAnswer) {
        return false;
    }

}
