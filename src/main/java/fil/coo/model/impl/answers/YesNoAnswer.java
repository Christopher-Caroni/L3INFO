package fil.coo.model.impl.answers;

import fil.coo.exception.InvalidAnswerException;
import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.factory.AnswerPanelFactory;

import java.util.Arrays;
import java.util.List;

public class YesNoAnswer extends SingleAnswer {

    private static final String[] possibleAnswers = new String[]{"vrai", "faux"};

    public YesNoAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        super(answer);
    }

    @Override
    protected boolean isQuizTextValid(String quizText) {
        return checkUserAnswerIsValid(quizText);
    }

    public String getPrompt() {
        return "(vrai/faux) ";
    }

    protected boolean checkUserAnswerIsValid(String userAnswer) {
        for (String possibleAnswer : possibleAnswers) {
            if (possibleAnswer.equalsIgnoreCase(userAnswer)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractAnswerView createAnswerPanel(AnswerPanelFactory answerPanelFactory) {
        return answerPanelFactory.createAnswerPanel(this);
    }

    public List<String> getPossibleAnswers() {
        return Arrays.asList("yes", "no");
    }
}
