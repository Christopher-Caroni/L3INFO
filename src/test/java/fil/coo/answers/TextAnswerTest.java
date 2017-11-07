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
    protected SingleAnswer getSpecificSingleAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        return new TextAnswer(answer, true);
    }

    @Test
    public void testPrompt() {
        assertEquals(EXPECTED_PROMPT, singleAnswer.getPrompt());
    }

    @Test
    public void testNumberAndYesNoInvalid() {
        assertFalse(singleAnswer.isValid("1"));
        assertFalse(singleAnswer.isValid("-1"));
        assertFalse(answer.isValid("yes"));
        assertFalse(answer.isValid("no"));
        assertFalse(answer.isValid("oui"));
        assertFalse(answer.isValid("non"));
    }

    @Test
    public void testSimpleTextIsValid() {
        assertTrue(answer.isValid("hello"));
        assertTrue(answer.isValid("Tolkien"));
    }

    @Test
    public void testDoesNotAcceptInCorrectAnswer() throws NullPointerException, InvalidAnswerException {
        TextAnswer textAnswer = new TextAnswer(DEFAULT_ANSWER, true);
        assertFalse(textAnswer.isCorrect(""));
        assertFalse(textAnswer.isCorrect("1"));
        assertFalse(textAnswer.isCorrect("-1"));
        assertFalse(textAnswer.isCorrect("yes"));
        assertFalse(textAnswer.isCorrect("no"));
        assertFalse(textAnswer.isCorrect("oui"));
        assertFalse(textAnswer.isCorrect("non"));
    }

    @Test
    public void testDoesAcceptCorrectAnswer() throws NullPointerException, InvalidAnswerException {
        TextAnswer textAnswer = new TextAnswer(DEFAULT_ANSWER, true);
        assertTrue(textAnswer.isCorrect(DEFAULT_ANSWER));
    }
}