package fil.coo.quiz;

import fil.coo.QuizTest;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.NumericalAnswer;
import fil.coo.answers.TextAnswer;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QuestionTest extends QuizTest {

    private static final Logger logger = Logger.getLogger(QuestionTest.class.getSimpleName());

    private int NB_Points2 = 2;
    private int NB_Points5 = 5;
    private String QUESTION1 = "5+5= ?";
    private String QUESTION2 = "Quel est la capital de le France ?";
    private String ANSWER1 = "10";
    private String ANSWER2 = "Paris";

    Question questionWithNumerical;
    Question questionWithText;
    NumericalAnswer numericalAnswer;
    TextAnswer textAnswer;


    @Before
    public void setUp() throws InvalidAnswerException {
        numericalAnswer = new NumericalAnswer(ANSWER1);
        textAnswer = new TextAnswer(ANSWER2, true);
        questionWithNumerical = new Question(QUESTION1, numericalAnswer, NB_Points2);
        questionWithText = new Question(QUESTION2, textAnswer, NB_Points5);
    }

    @Test
    public void testGetNbPts() throws Exception {
        assertEquals(questionWithText.getNbPts(), NB_Points5);
        assertEquals(questionWithNumerical.getNbPts(), NB_Points2);
    }

    @Test
    public void testGetText() throws Exception {
        assertEquals(questionWithNumerical.getQuestionText(), QUESTION1);
        assertEquals(questionWithText.getQuestionText(), QUESTION2);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}