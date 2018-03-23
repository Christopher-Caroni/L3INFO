package fil.coo.model.impl;

import fil.coo.model.QuizModel;
import fil.coo.model.QuizModelTest;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.*;

public class QuizTest extends QuizModelTest {

    @Override
    protected QuizModel getQuizModel() {
        return new CLIQuiz();
    }


}