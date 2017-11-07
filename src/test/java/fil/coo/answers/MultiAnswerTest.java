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
    public void testNumberAndYesNoInvalid() {
        assertFalse(answer.isValid("1"));
        assertFalse(answer.isValid("-1"));
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
        assertFalse(answer.isCorrect(""));
        assertFalse(answer.isCorrect("1"));
        assertFalse(answer.isCorrect("-1"));
        assertFalse(answer.isCorrect("yes"));
        assertFalse(answer.isCorrect("no"));
        assertFalse(answer.isCorrect("oui"));
        assertFalse(answer.isCorrect("non"));
    }

    @Test
    public void testDoesAcceptCorrectAnswer() throws NullPointerException, InvalidAnswerException {
        assertFalse(answer.isCorrect(DEFAULT_ANSWER));
        assertTrue(answer.isCorrect("Frodo"));
        assertTrue(answer.isCorrect("Pippin"));
        assertTrue(answer.isCorrect("Merry"));
        assertTrue(answer.isCorrect("Sam"));
    }
}