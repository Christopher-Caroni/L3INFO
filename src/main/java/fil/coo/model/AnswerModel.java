package fil.coo.model;

import fil.coo.gui.factory.AnswerPanelFactory;
import fil.coo.gui.view.AbstractAnswerView;

public abstract class AnswerModel {

    public abstract AbstractAnswerView createAnswerPanel(AnswerPanelFactory answerPanelFactory);

    public abstract String getPrompt();

    public abstract boolean isValid(String userAnswer);

    public abstract boolean isCorrect(String userAnswer);

    public abstract String getCorrectAnswer();
    
}
