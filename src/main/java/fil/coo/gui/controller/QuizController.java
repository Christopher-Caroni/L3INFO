package fil.coo.gui.controller;

import fil.coo.gui.QuizFrame;
import fil.coo.gui.factory.AnswerPanelFactory;
import fil.coo.gui.panels.QuestionPanel;
import fil.coo.quiz.Question;
import fil.coo.quiz.Quiz;

import javax.swing.*;

public class QuizController {

    private QuizFrame view;
    private Quiz model;

    public QuizController(QuizFrame view, Quiz model) {
        this.view = view;
        this.model = model;

        initView();
    }

    private void initView() {
        for (Question question : model.getQuestions()) {
            QuestionPanel questionPanel = createQuestionPanel(question);
            view.addQuestionPanel(questionPanel, false);
        }
    }

    public void displayFrame() {
        view.setVisible(true);
    }

    public QuestionPanel createQuestionPanel(Question question) {
        JPanel answerPanel = question.getAnswer().createAnswerPanel(AnswerPanelFactory.getInstance());
        return new QuestionPanel(question.getQuestionText(), answerPanel);
    }
}
