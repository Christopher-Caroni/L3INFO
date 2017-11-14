package fil.coo.controller.impl;

import fil.coo.controller.IQuizController;
import fil.coo.gui.AbstractQuizView;
import fil.coo.model.QuizModel;

import java.util.List;

public class QuizController extends IQuizController {


    public QuizController(QuizModel quizModel, AbstractQuizView quizView) {
        super(quizModel, quizView);
    }

    public void displayFrame() {
        quizView.setVisible(true);
    }

}
