package fil.coo.model;

import fil.coo.gui.factory.AnswerPanelFactory;
import fil.coo.gui.views.AbstractAnswerView;

public interface AnswerModel {

    AbstractAnswerView createAnswerPanel(AnswerPanelFactory answerPanelFactory);

    String getPrompt();

    boolean isValid(String userAnswer);

    boolean isCorrect(String userAnswer);

    String getCorrectAnswer();

}
