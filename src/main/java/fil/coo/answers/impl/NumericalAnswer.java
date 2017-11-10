package fil.coo.answers.impl;

import fil.coo.answers.InvalidAnswerException;
import fil.coo.gui.AnswerPanel;
import fil.coo.gui.factory.AnswerPanelFactory;

public class NumericalAnswer extends SingleAnswer {

    public NumericalAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        super(answer, true);
    }

    @Override
    protected boolean isQuizTextValid(String quizText) {
        return checkUserAnswerIsValid(quizText);
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

    @Override
    public AnswerPanel createAnswerPanel(AnswerPanelFactory answerPanelFactory) {
        return answerPanelFactory.createAnswerPanel(this);
    }
}
