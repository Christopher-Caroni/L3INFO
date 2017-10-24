package fil.coo.answers;

public class MultiAnswer implements Answer {

    public String getPrompt() {
        return null;
    }

    public boolean isValid(String userAnswer) throws NullPointerException {
        return false;
    }

    public boolean isCorrect(String userAnswer) throws NullPointerException {
        return false;
    }
}
