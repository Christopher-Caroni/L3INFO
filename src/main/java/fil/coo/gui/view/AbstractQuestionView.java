package fil.coo.gui.view;

import fil.coo.model.QuestionModel;

import java.awt.*;

/**
 * Defines the behaviour that our question views must implement
 */
public abstract class AbstractQuestionView {

    protected AbstractAnswerView answerView;
    private QuestionModel questionModel;

    /**
     * @param questionModel the model from which to create this question
     * @param answerView    the specific {@link AbstractAnswerView} that this view should hold
     */
    public AbstractQuestionView(QuestionModel questionModel, AbstractAnswerView answerView) {
        this.questionModel = questionModel;
        this.answerView = answerView;
    }

    /**
     * @return the user's input for this question's answer
     */
    public final String getUserInput() {
        return answerView.getUserInput();
    }

    /**
     * @return the view that this instance represents
     */
    public abstract Component getView();

}
