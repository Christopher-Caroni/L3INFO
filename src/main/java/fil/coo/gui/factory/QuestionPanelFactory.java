package fil.coo.gui.factory;

import fil.coo.gui.QuestionPanel;
import fil.coo.quiz.Question;

public class QuestionPanelFactory {

    private static final QuestionPanelFactory INSTANCE = new QuestionPanelFactory();

    private QuestionPanelFactory() {
    }

    public static QuestionPanelFactory getInstance() {
        return INSTANCE;
    }

    public QuestionPanel createQuestionPanel(Question question) {
        QuestionPanel questionPanel = new QuestionPanel(question.getQuestionText(), question.getAnswer().createAnswerPanel(AnswerPanelFactory.getInstance()));

        return questionPanel;
    }
}
