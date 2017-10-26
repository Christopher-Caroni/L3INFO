package fil.coo.answers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MultipleChoiceAnswerTest extends SingleAnswerTest {


    private final static String EXPECTED_PROMPT = "( Robert Bourricot Bill Jolly Jumper )";
    private final static String AllChoice = "Robert Bourricot Bill Jolly Jumper";
    private final static int INDEX = 2;
    private final static String correctAnswer = "Bill";
    private final static String falseAnswer = "Robert";


    @Override
    protected String getDefaultAnswer() {
        return AllChoice;
    }

    @Override
    protected String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    protected SingleAnswer getSpecificSingleAnswer(String answer)
            throws NullPointerException, InvalidAnswerException {
        return new MultipleChoiceAnswer(answer, INDEX);
    }

    @Test
    public void testWhenIsValid() {
        assertTrue(singleAnswer.isValid(correctAnswer));
        assertTrue(singleAnswer.isValid(falseAnswer));
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
        MultipleChoiceAnswer answer = new MultipleChoiceAnswer(AllChoice, INDEX);
        assertTrue(answer.isCorrect(correctAnswer));
    }

    @Test
    public void testWhenIsNotCorrect() throws NullPointerException, InvalidAnswerException {
        MultipleChoiceAnswer answer = new MultipleChoiceAnswer(AllChoice, INDEX);
        assertFalse(answer.isCorrect(falseAnswer));
    }
}
