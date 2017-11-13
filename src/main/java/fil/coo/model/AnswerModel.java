package fil.coo.model;

import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.factory.AnswerPanelFactory;
import fil.coo.gui.impl.AnswerPanel;
import fil.coo.model.impl.Answer;

public interface AnswerModel {

    /**
     * Creates an {@link AnswerPanel} by calling createAnswerPanel on the answerPanelFactory with this class' instance type.
     *
     * @param answerPanelFactory the factory that will create the {@link AnswerPanel} instance/
     * @return an {@link AnswerPanel} that corresponds to whatever type of {@link Answer} this instance is
     */
    AbstractAnswerView createAnswerPanel(AnswerPanelFactory answerPanelFactory);

    /**
     * @return the prompt that will be displayed to help the user answer this question
     */
    String getPrompt();


    /**
     * @param userAnswer the user's attempt at the answer
     * @return if the user's answer is in a valid format
     */
    boolean isValid(String userAnswer);

    /**
     * @param userAnswer the user's answer
     * @return if the userAnswer is the correct answer
     */
    boolean isCorrect(String userAnswer);

    /**
     * @return the actual correct answer as a String
     */
    String getCorrectAnswer();

}
