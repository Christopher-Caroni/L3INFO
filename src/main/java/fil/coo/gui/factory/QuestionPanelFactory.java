package fil.coo.gui.factory;

import fil.coo.answers.Answer;
import fil.coo.gui.QuestionPanel;
import fil.coo.quiz.Question;

public class QuestionPanelFactory {

    private static final QuestionPanelFactory INSTANCE = new QuestionPanelFactory();

    private QuestionPanelFactory() {
    }

    public static QuestionPanelFactory getInstance() {
        return INSTANCE;
    }

    public QuestionPanel createQuestionPanel(Question question, Answer answer) {
        QuestionPanel questionPanel = new QuestionPanel();
        questionPanel.setAnswerPanel(answer.createAnswerPanel(AnswerPanelFactory.getInstance()));
        return questionPanel;
    }
}
