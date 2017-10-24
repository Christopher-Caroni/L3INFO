package fil.coo.answers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class SingleAnswerTest extends AnswerTest {

    protected SingleAnswer singleAnswer;

    @Before
    public void setupSingleAnswer() {
        singleAnswer = getSpecificSingleAnswer();
    }

    protected abstract SingleAnswer getSpecificSingleAnswer();

    @Override
    public Answer getSpecificAnswer() {
        return getSpecificSingleAnswer();
    }

    @Test
    public void testGetSetWithNull() {
        assertNull(singleAnswer.getAnswer());

        singleAnswer.setAnswer(null);
        assertNull(singleAnswer.getPrompt());
    }

    @Test
    public void testGetSetWhenOK() {
        assertNull(singleAnswer.getAnswer());

        String dummyAnswer = "dummy_answer";
        singleAnswer.setAnswer(dummyAnswer);
        assertEquals(dummyAnswer, singleAnswer.getAnswer());
    }

}