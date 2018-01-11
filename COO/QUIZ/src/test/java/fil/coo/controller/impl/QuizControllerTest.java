package fil.coo.controller.impl;

import fil.coo.controller.IQuizController;
import fil.coo.controller.IQuizControllerTest;
import fil.coo.gui.AbstractQuizView;
import fil.coo.model.QuizModel;

import static org.junit.Assert.*;

public class QuizControllerTest extends IQuizControllerTest {

    @Override
    protected IQuizController getSpecificQuizController(QuizModel quizModel, AbstractQuizView abstractQuizView) {
        return new QuizController(quizModel, abstractQuizView);
    }
}