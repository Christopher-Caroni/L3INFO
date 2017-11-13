package fil.coo.controller.impl;

import fil.coo.controller.IQuizController;
import fil.coo.gui.AbstractQuizView;
import fil.coo.model.QuizModel;

public class QuizController extends IQuizController {


    public QuizController(QuizModel quizModel, AbstractQuizView quizView) {
        super(quizModel, quizView);
    }

    public void displayFrame() {
        quizView.setVisible(true);
    }

    @Override
    protected void onQuizCompleted() {
        // TODO
    }
}
