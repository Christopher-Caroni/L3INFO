package fil.coo.answers;

import static org.junit.Assert.*;

import org.junit.Test;


public class TextAnswerTest extends SingleAnswerTest {

    private final static String DEFAULT_ANSWER = "default_answer";
    private final static String EXPECTED_PROMPT = "(text)";

    protected String getDefaultAnswer() {
        return DEFAULT_ANSWER;
    }
    
	@Override
	protected String getCorrectAnswer() {
		return getDefaultAnswer();
	}

    @Override
    protected SingleAnswer getSpecificSingleAnswer(String answer) throws NullPointerException, NotCorrectAnswerException {
        return new TextAnswer(answer);
    }

    @Test
    public void testPrompt() {
        assertEquals(EXPECTED_PROMPT, singleAnswer.getPrompt());
    }

    @Test
    public void testNumberIsInvalid() {
        assertFalse(singleAnswer.isValid("1"));
        assertFalse(singleAnswer.isValid("-1"));
    }

    @Test
    public void testNonNumberIsValid() {
        assertTrue(singleAnswer.isValid(""));
        assertTrue(singleAnswer.isValid("yes"));
        assertTrue(singleAnswer.isValid("no"));
        assertTrue(singleAnswer.isValid("oui"));
        assertTrue(singleAnswer.isValid("non"));
    }

    @Test
    public void testDoesNotAcceptInCorrectAnswer() throws NullPointerException, NotCorrectAnswerException {
        TextAnswer textAnswer = new TextAnswer(DEFAULT_ANSWER);
        assertFalse(textAnswer.isCorrect(""));
        assertFalse(textAnswer.isCorrect("1"));
        assertFalse(textAnswer.isCorrect("-1"));
        assertFalse(textAnswer.isCorrect("yes"));
        assertFalse(textAnswer.isCorrect("no"));
        assertFalse(textAnswer.isCorrect("oui"));
        assertFalse(textAnswer.isCorrect("non"));
    }

    @Test
    public void testDoesAcceptCorrectAnswer() throws NullPointerException, NotCorrectAnswerException {
        TextAnswer textAnswer = new TextAnswer(DEFAULT_ANSWER);
        assertTrue(textAnswer.isCorrect(DEFAULT_ANSWER));
    }
}