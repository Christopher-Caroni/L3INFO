package fil.coo.answers.impl;

import fil.coo.answers.InvalidAnswerException;
import fil.coo.gui.AnswerPanel;
import fil.coo.gui.AnswerPanelFactory;

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
    protected AnswerPanel createAnswerPanel(AnswerPanelFactory answerPanelFactory) {
        return answerPanelFactory.createAnswerPanel(this);
    }

}
