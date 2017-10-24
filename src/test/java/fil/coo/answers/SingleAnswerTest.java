package fil.coo.answers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class SingleAnswerTest extends AnswerTest {

    protected SingleAnswer singleAnswer;

    @Before
    public void setupSingleAnswer() throws NullPointerException, NotCorrectAnswerException {
        singleAnswer = getSpecificSingleAnswer("answer");
    }

    protected abstract SingleAnswer getSpecificSingleAnswer(String answer) throws NullPointerException, NotCorrectAnswerException;

    @Override
    public Answer getSpecificAnswer() throws NullPointerException, NotCorrectAnswerException {
        return getSpecificSingleAnswer("answer");
    }

    @Test(expected=NullPointerException.class)
    public void testWhenAnwserIsNull() throws NullPointerException, NotCorrectAnswerException {
        SingleAnswer s = getSpecificSingleAnswer(null);
    }

    @Test
    public void testGetSetWhenOK() throws NullPointerException, NotCorrectAnswerException {
        assertNotNull(singleAnswer.getAnswer());
        String dummyAnswer = "dummy_answer";
        SingleAnswer oneAnswer = getSpecificSingleAnswer(dummyAnswer);
        assertEquals(dummyAnswer, oneAnswer.getAnswer());
    }

}