package fil.coo.answers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class SingleAnswerTest extends AnswerTest {

    protected SingleAnswer singleAnswer;

    @Before
    public void setupSingleAnswer() {
        singleAnswer = getSpecificSingleAnswer(getDefaultAnswer());
    }

    /**
     * @return a default answer for the implementing Answer class
     */
    protected abstract String getDefaultAnswer();

    /**
     * @param answer the correct answer
     * @return an instance of the implementing Answer to test
     */
    protected abstract SingleAnswer getSpecificSingleAnswer(String answer);

    @Override
    public Answer getSpecificAnswer() {
        return getSpecificSingleAnswer(getDefaultAnswer());
    }

    @Test(expected = NullPointerException.class)
    public void testNullConstructionThrows() {
        SingleAnswer s = getSpecificSingleAnswer(null);
    }

    @Test
    public void testGetSetWhenOK() {
        String dummyAnswer = "dummy_answer";
        SingleAnswer oneAnswer = getSpecificSingleAnswer(dummyAnswer);
        assertEquals(dummyAnswer, oneAnswer.getAnswer());
    }

}