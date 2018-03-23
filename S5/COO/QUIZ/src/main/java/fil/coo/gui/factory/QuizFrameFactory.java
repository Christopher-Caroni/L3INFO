package fil.coo.gui.factory;

import fil.coo.gui.AbstractQuizView;
import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.impl.QuestionPanel;
import fil.coo.gui.impl.QuizFrame;
import fil.coo.model.QuestionModel;
import fil.coo.model.QuizModel;
import org.apache.log4j.Logger;

public class QuizFrameFactory {
    private static final Logger logger = Logger.getLogger(QuizFrameFactory.class.getSimpleName());

    private static QuizFrameFactory INSTANCE = new QuizFrameFactory();

    private QuizFrameFactory() {
    }

    public static QuizFrameFactory getInstance() {
        return INSTANCE;
    }

    /**
     * @param quizModel the model to construct the view from
     * @return a {@link QuizFrame}
     */
    public AbstractQuizView createQuizView(QuizModel<? extends QuestionModel> quizModel) {
        AbstractQuizView quizFrame = new QuizFrame(quizModel.getNbQuestions());
        for (QuestionModel question : quizModel.getQuestions()) {
            QuestionPanel questionPanel = createQuestionPanel(question);
            quizFrame.addQuestionView(questionPanel, false);
        }
        return quizFrame;
    }

    public QuestionPanel createQuestionPanel(QuestionModel question) {
        AbstractAnswerView answerPanel = AnswerPanelFactory.getInstance().createAnswerPanel(question.getAnswer());

        return new QuestionPanel(question.getQuestionText(), answerPanel);
    }

}
