package fil.coo.controller.impl;

import fil.coo.controller.IQuizController;
import fil.coo.gui.AbstractQuizView;
import fil.coo.model.QuizModel;

/**
 * Concrete implementation of {@link IQuizController}. Does not add any specific features
 */
public class QuizController extends IQuizController {

    public QuizController(QuizModel quizModel, AbstractQuizView quizView) {
        super(quizModel, quizView);
    }

}
