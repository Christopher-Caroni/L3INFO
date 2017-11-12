package fil.coo.gui.view;

import fil.coo.model.QuestionModel;

import java.awt.*;

public abstract class AbstractQuestionView {

    protected IAnswerView answerView;
    private QuestionModel questionModel;

    public AbstractQuestionView(QuestionModel questionModel, IAnswerView answerView) {
        this.questionModel = questionModel;
        this.answerView = answerView;
    }

    public abstract String getUserInput();

    public abstract Component getView();

}
