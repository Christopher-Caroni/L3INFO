package fil.coo.answers;

import fil.coo.QuizTest;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AnswerTest extends QuizTest {

    private static final Logger logger = Logger.getLogger(AnswerTest.class.getSimpleName());

    protected Answer answer;

    @Override
    protected Logger getLogger() {
        return logger;
    }

    /**
     * @return an implementation of {@link Answer}. By default, this instance should have empty attributes, or null
     * values for non list objects.
     * @throws InvalidAnswerException
     * @throws NullPointerException
     */
    public abstract Answer getSpecificAnswer() throws NullPointerException, InvalidAnswerException;

    @Before
    public void setupAnswer() throws NullPointerException, InvalidAnswerException {
        this.answer = getSpecificAnswer();
    }

    @Test(expected = NullPointerException.class)
    public void testIsValidThrowsWithNullParam() throws NullPointerException {
        answer.isValid(null);
    }

    @Test
    public void testIsValidDoesNotThrowException() {
        try {
            answer.isValid("dummy_answer");
        } catch (NullPointerException e) {
            fail("Should not throw with non null param");
        }
    }

    @Test(expected = NullPointerException.class)
    public void testIsCorrectWithNullParamThrowsException() throws NullPointerException {
        answer.isCorrect(null);
    }

}