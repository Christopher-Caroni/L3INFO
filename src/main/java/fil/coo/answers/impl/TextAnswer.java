package fil.coo.answers.impl;

import fil.coo.answers.InvalidAnswerException;
import fil.coo.gui.AnswerPanel;
import fil.coo.gui.AnswerPanelFactory;

public class TextAnswer extends SingleAnswer {

    private final static String[] yesNoAnswerText = new String[]{"yes", "no", "oui", "non"};

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
            return false;
        } catch (NumberFormatException e) {
            // do nothing
        }
        for (String yesNoText : yesNoAnswerText) {
            if (yesNoText.equalsIgnoreCase(userAnswer)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected AnswerPanel createAnswerPanel(AnswerPanelFactory answerPanelFactory) {
        return answerPanelFactory.createAnswerPanel(this);
    }

}
