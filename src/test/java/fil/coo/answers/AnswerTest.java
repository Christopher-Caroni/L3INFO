package fil.coo.answers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AnswerTest {

    protected Answer answer;

    /**
     *
     * @return an implementation of {@link Answer}. By default, this instance should have empty attributes, or null
     * values for non list objects.
     * @throws NotCorrectAnswerException 
     * @throws NullPointerException 
     */
    public abstract Answer getSpecificAnswer() throws NullPointerException, NotCorrectAnswerException;

    @Before
    public void setupAnswer() throws NullPointerException, NotCorrectAnswerException {
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

    @Test
    public void testIsCorrectDoesNotThrowException() {
        try {
            answer.isCorrect("dummy_answer");
        } catch (NullPointerException e) {
            fail("Should not throw with non null param");
        }
    }

}