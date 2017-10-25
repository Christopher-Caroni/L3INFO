package fil.coo.answers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class SingleAnswerTest extends AnswerTest {

    protected SingleAnswer singleAnswer;

    @Before
    public void setupSingleAnswer() {
        singleAnswer = getSpecificSingleAnswer(getDefaultAnswer());
    }

    protected abstract String getDefaultAnswer();

    protected abstract SingleAnswer getSpecificSingleAnswer(String answer);

    @Override
    public Answer getSpecificAnswer() {
        return getSpecificSingleAnswer("answer");
    }

    @Test(expected=NullPointerException.class)
    public void testWhenAnwserIsNull() {
        SingleAnswer s = getSpecificSingleAnswer(null);
    }

    @Test
    public void testGetSetWhenOK() {
        assertNotNull(singleAnswer.getAnswer());
        String dummyAnswer = "dummy_answer";
        SingleAnswer oneAnswer = getSpecificSingleAnswer(dummyAnswer);
        assertEquals(dummyAnswer, oneAnswer.getAnswer());
    }

}