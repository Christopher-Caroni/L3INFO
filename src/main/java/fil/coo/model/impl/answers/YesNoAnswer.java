package fil.coo.model.impl.answers;

import fil.coo.exception.InvalidAnswerException;
import fil.coo.gui.factory.AnswerPanelFactory;
import fil.coo.gui.views.impl.AnswerPanel;

public class YesNoAnswer extends SingleAnswer {

    private static final String[] possibleAnswers = new String[]{"yes", "no", "oui", "non", "vrai", "faux"};

    public YesNoAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        super(answer, true);
    }

    @Override
    protected boolean isQuizTextValid(String quizText) {
        return checkUserAnswerIsValid(quizText);
    }

    public String getPrompt() {
        return "(oui/non) ";
    }

    protected boolean checkUserAnswerIsValid(String userAnswer) {
        boolean found;
        for (String possibleAnswer : possibleAnswers) {
            if (possibleAnswer.equalsIgnoreCase(userAnswer)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AnswerPanel createAnswerPanel(AnswerPanelFactory answerPanelFactory) {
        return answerPanelFactory.createAnswerPanel(this);
    }

}
