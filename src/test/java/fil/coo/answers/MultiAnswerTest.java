package fil.coo.answers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MultiAnswerTest extends AnswerTest {

    private static final String DEFAULT_ANSWER = "Frodo ; Pippin ; Merry ; Sam";

    public Answer getSpecificAnswer() throws NullPointerException, InvalidAnswerException {
        return new MultiAnswer(DEFAULT_ANSWER);
    }

    private String createPrompt(int nbAnswers) {
        return "(" + nbAnswers + " possible answers)";
    }

    @Test
    public void testPrompt() throws InvalidAnswerException {
        MultiAnswer multiAnswer = new MultiAnswer(DEFAULT_ANSWER);
        assertEquals(createPrompt(4), multiAnswer.getPrompt());
    }


    @Test
    public void testNumberIsInvalid() {
        assertFalse(answer.isValid("1"));
        assertFalse(answer.isValid("-1"));
    }

    @Test
    public void testNonNumberIsValid() {
        assertTrue(answer.isValid("yes"));
        assertTrue(answer.isValid("no"));
        assertTrue(answer.isValid("oui"));
        assertTrue(answer.isValid("non"));
    }

    @Test
    public void testDoesNotAcceptInCorrectAnswer() throws NullPointerException, InvalidAnswerException {
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
    public void testDoesAcceptCorrectAnswer() throws NullPointerException, InvalidAnswerException {
        TextAnswer textAnswer = new TextAnswer(DEFAULT_ANSWER);
        assertTrue(textAnswer.isCorrect(DEFAULT_ANSWER));
    }
}