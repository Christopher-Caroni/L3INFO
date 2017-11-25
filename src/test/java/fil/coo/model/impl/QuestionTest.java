package fil.coo.model.impl;

import fil.coo.QuizTest;
import fil.coo.exception.InvalidAnswerException;
import fil.coo.gui.Mocks;
import fil.coo.gui.Mocks.MockAnswer;
import fil.coo.gui.Mocks.MockQuestion;
import fil.coo.model.impl.answers.NumericalAnswer;
import fil.coo.model.impl.answers.TextAnswer;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;


public class QuestionTest extends QuizTest {

    private static final Logger logger = Logger.getLogger(QuestionTest.class.getSimpleName());


    private String INPUT_QUESTION_1 = "5+5= ?";
    private MockQuestion questionWithNumericalAnswer;
    private MockAnswer numericalAnswer;
    private int NB_POINTS_NUMERICAL_QUESTION = 2;

    private String INPUT_QUESTION_2 = "Quel est la capital de le France ?";
    private MockQuestion questionWithTextAnswer;
    private MockAnswer textAnswer;
    private int NB_POINTS_TEXT_QUESTION = 5;


    @Before
    public void setUp() throws InvalidAnswerException {
        numericalAnswer = new MockAnswer(false, false);
        questionWithNumericalAnswer = new MockQuestion(INPUT_QUESTION_1, numericalAnswer, NB_POINTS_NUMERICAL_QUESTION);

        textAnswer = new MockAnswer(false, false);
        questionWithTextAnswer = new MockQuestion(INPUT_QUESTION_2, textAnswer, NB_POINTS_TEXT_QUESTION);
    }

    @Test
    public void testGetNbPts() {
        assertThat(questionWithTextAnswer.getNbPts(), is(NB_POINTS_TEXT_QUESTION));
        assertThat(questionWithNumericalAnswer.getNbPts(), is(NB_POINTS_NUMERICAL_QUESTION));
    }

    @Test
    public void testGetText() {
        assertThat(questionWithNumericalAnswer.getQuestionText(), is(INPUT_QUESTION_1));
        assertThat(questionWithTextAnswer.getQuestionText(), is(INPUT_QUESTION_2));
    }

    @Test
    public void testGetAnswer() {
        assertThat(questionWithNumericalAnswer.getAnswer(), sameInstance(numericalAnswer));
        assertThat(questionWithTextAnswer.getAnswer(), sameInstance(textAnswer));
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}