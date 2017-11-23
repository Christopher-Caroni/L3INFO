package fil.coo.model.impl;

import fil.coo.model.QuizModel;
import fil.coo.model.QuizModelTest;

import static org.junit.Assert.*;

public class QuizTest extends QuizModelTest {

    @Override
    protected QuizModel getQuizModel() {
        return new Quiz();
    }
}