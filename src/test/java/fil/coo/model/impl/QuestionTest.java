package fil.coo.model.impl;

import fil.coo.QuizTest;
import fil.coo.exception.InvalidAnswerException;
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
    private String INPUT_ANSWER_1 = "10";
    private SimpleQuestion questionWithNumericalAnswer;
    private NumericalAnswer numericalAnswer;
    private int NB_POINTS_NUMERICAL_QUESTION = 2;

    private String INPUT_QUESTION_2 = "Quel est la capital de le France ?";
    private String INPUT_ANSWER_2 = "Paris";
    private SimpleQuestion questionWithTextAnswer;
    private TextAnswer textAnswer;
    private int NB_POINTS_TEXT_QUESTION = 5;


    @Before
    public void setUp() throws InvalidAnswerException {
        numericalAnswer = new NumericalAnswer(INPUT_ANSWER_1);
        questionWithNumericalAnswer = new SimpleQuestion(INPUT_QUESTION_1, numericalAnswer, NB_POINTS_NUMERICAL_QUESTION);

        textAnswer = new TextAnswer(INPUT_ANSWER_2);
        questionWithTextAnswer = new SimpleQuestion(INPUT_QUESTION_2, textAnswer, NB_POINTS_TEXT_QUESTION);
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