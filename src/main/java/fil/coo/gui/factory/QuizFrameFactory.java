package fil.coo.gui.factory;

import fil.coo.gui.panels.QuestionPanel;
import fil.coo.gui.QuizFrame;
import fil.coo.quiz.Question;
import fil.coo.quiz.Quiz;

import javax.swing.*;

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
            QuestionPanel questionPanel = createQuestionPanel(question);
            quizFrame.addQuestionPanel(questionPanel, false);
        }

        quizFrame.pack();
        quizFrame.repaint();

        return quizFrame;
    }

    public QuestionPanel createQuestionPanel(Question question) {
        JPanel answerPanel = question.getAnswer().createAnswerPanel(AnswerPanelFactory.getInstance());
        return new QuestionPanel(question.getQuestionText(), answerPanel);
    }
}
