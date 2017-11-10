package fil.coo.answers.impl;

import fil.coo.answers.InvalidAnswerException;
import org.junit.Test;

import static org.junit.Assert.*;

public class YesNoAnswerTest extends SingleAnswerTest {


    private final static String DEFAULT_YES = "oui";
    private final static String DEFAULT_NO = "non";
    private final static String EXPECTED_PROMPT = "(oui/non) ";

    private static final String[] correctAnswers = new String[]{"yes", "no", "oui", "non", "vrai", "faux"};


    protected String getDefaultAnswer() {
        return DEFAULT_YES;
    }

    @Override
    protected String getCorrectAnswer() {
        return getDefaultAnswer();
    }

    @Override
    protected SingleAnswer getSpecificSingleAnswer(String anwser) throws NullPointerException, InvalidAnswerException {
        return new YesNoAnswer(anwser);
    }

    @Test
    public void testPromptWhenIsYes() {
        assertEquals(EXPECTED_PROMPT, singleAnswer.getPrompt());
    }

    @Test
    public void testWhenIsValid() {
        assertTrue(singleAnswer.isValid(DEFAULT_YES));
        assertTrue(singleAnswer.isValid(DEFAULT_NO));

        for (String correctAnswer : correctAnswers) {
            assertTrue(singleAnswer.isValid(correctAnswer));
        }
    }

    @Test
    public void testWhenIsNotValid() {
        assertFalse(singleAnswer.isValid(""));
        assertFalse(singleAnswer.isValid("-1"));
        assertFalse(singleAnswer.isValid("1"));
        assertFalse(singleAnswer.isValid("answer"));
    }

    @Test
    public void testWhenIsCorrect() throws NullPointerException, InvalidAnswerException {
        YesNoAnswer yesNoAnswer = new YesNoAnswer(DEFAULT_NO);
        assertTrue(yesNoAnswer.isCorrect(DEFAULT_NO));
    }

    @Test
    public void testWhenIsNotCorrect() throws NullPointerException, InvalidAnswerException {
        YesNoAnswer yesNoAnswer = new YesNoAnswer(DEFAULT_YES);
        assertFalse(yesNoAnswer.isCorrect(DEFAULT_NO));
    }


}
