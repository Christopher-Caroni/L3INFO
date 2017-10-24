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
     */
    public abstract Answer getSpecificAnswer();

    @Before
    public void setupAnswer() {
        this.answer = getSpecificAnswer();
    }

    @Test
    public void testSetGetPromptWhenNull() {
        assertNull(answer.getPrompt());

        answer.setPrompt(null);
        assertNull(answer.getPrompt());
    }

    @Test
    public void testSetGetWhenOK() {
        assertNull(answer.getPrompt());
        String prompt = "dummy_prompt";

        answer.setPrompt(prompt);
        assertEquals(prompt, answer.getPrompt());
    }

    @Test(expected = NullPointerException.class)
    public void testIsValidThrowsWithNullParam() throws NullPointerException {
        answer.isValid(null);
    }

    @Test(expected = NullPointerException.class)
    public void testIsCorrentWithNullParamThrowsException() throws NullPointerException {
        answer.isCorrect(null);
    }

}