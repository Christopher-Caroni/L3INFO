package fil.coo.gui.factory;

import fil.coo.gui.QuestionPanel;
import fil.coo.gui.QuizFrame;
import fil.coo.quiz.Question;
import fil.coo.quiz.Quiz;

public class QuizFrameFactory {

    private static final QuizFrameFactory INSTANCE = new QuizFrameFactory();

    private QuizFrameFactory() {
    }

    public static QuizFrameFactory getInstance() {
        return INSTANCE;
    }

    public QuizFrame createQuizFrame(Quiz quiz) {
        QuizFrame quizFrame = new QuizFrame(quiz.getNbQuestions());

        for (Question question : quiz.getQuestions()) {
            QuestionPanel questionPanel = QuestionPanelFactory.getInstance().createQuestionPanel(question, question.getAnswer());
            quizFrame.addQuestionPanel(questionPanel, false);
        }

        quizFrame.pack();
        quizFrame.repaint();

        return quizFrame;
    }
}
