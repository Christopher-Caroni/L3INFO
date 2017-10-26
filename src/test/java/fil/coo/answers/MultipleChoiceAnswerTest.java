package fil.coo.answers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MultipleChoiceAnswerTest extends SingleAnswerTest {


    private final static String DEFAULT_ANSWER_VALUE = "Robert Bourricot Bill Jolly Jumper";
    private final static String CORRECT_ANSWER = "Robert";
    private final static String INCORRECT_ANSWER = "Bill";


    @Override
    protected String getDefaultAnswer() {
        return DEFAULT_ANSWER_VALUE;
    }

    @Override
    protected String getCorrectAnswer() {
        return CORRECT_ANSWER;
    }

    @Override
    protected SingleAnswer getSpecificSingleAnswer(String answer)
            throws NullPointerException, InvalidAnswerException {
        return new MultipleChoiceAnswer(answer);
    }

    @Test
    public void testWhenIsValid() {
        assertTrue(singleAnswer.isValid(CORRECT_ANSWER));
        assertTrue(singleAnswer.isValid(INCORRECT_ANSWER));
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
        MultipleChoiceAnswer answer = new MultipleChoiceAnswer(DEFAULT_ANSWER_VALUE);
        assertTrue(answer.isCorrect(CORRECT_ANSWER));
    }

    @Test
    public void testWhenIsNotCorrect() throws NullPointerException, InvalidAnswerException {
        MultipleChoiceAnswer answer = new MultipleChoiceAnswer(DEFAULT_ANSWER_VALUE);
        assertFalse(answer.isCorrect(INCORRECT_ANSWER));
    }
}
