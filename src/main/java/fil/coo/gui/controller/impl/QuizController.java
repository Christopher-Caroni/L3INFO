package fil.coo.gui.controller.impl;

import fil.coo.gui.view.AbstractQuizView;
import fil.coo.model.QuizModel;

public class QuizController {

    private AbstractQuizView view;
    private QuizModel model;

    public QuizController(AbstractQuizView quizView, QuizModel model) {
        this.view = quizView;
        this.model = model;
    }

    public void displayFrame() {
        view.setVisible(true);
    }
}
