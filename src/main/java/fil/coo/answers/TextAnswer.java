package fil.coo.answers;

public class TextAnswer extends SingleAnswer {

    @Override
    public String getPrompt() {
        return null;
    }

    @Override
    public boolean isValid(String userAnswer) {
        return false;
    }
}
