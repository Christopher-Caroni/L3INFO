package fil.coo.answers.impl;

import fil.coo.answers.Answer;
import fil.coo.answers.AnswerTest;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.impl.SingleAnswer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class SingleAnswerTest extends AnswerTest {

    protected SingleAnswer singleAnswer;


    @Before
    public void setupSingleAnswer() throws NullPointerException, InvalidAnswerException {
        singleAnswer = getSpecificSingleAnswer(getDefaultAnswer());
    }

    /**
     * @param answer the answer that would be read from the model file
     * @return an instance of the implementing Answer to test
     */
    protected abstract SingleAnswer getSpecificSingleAnswer(String answer) throws NullPointerException, InvalidAnswerException;

    /**
     * @return a default answer for the implementing Answer class. This answer is the one that would be read from the model file.
     */
    protected abstract String getDefaultAnswer();

    @Test(expected = NullPointerException.class)
    public void testWhenAnswerIsNull() throws NullPointerException, InvalidAnswerException {
        SingleAnswer s = getSpecificSingleAnswer(null);
    }


    @Override
    public Answer getSpecificAnswer() throws NullPointerException, InvalidAnswerException {
        return getSpecificSingleAnswer(getDefaultAnswer());
    }

    @Test(expected = NullPointerException.class)
    public void testNullConstructionThrows() throws NullPointerException, InvalidAnswerException {
        SingleAnswer s = getSpecificSingleAnswer(null);
    }

    @Test
    public void testGetSetWhenOK() throws NullPointerException, InvalidAnswerException {
        String dummyAnswer = getDefaultAnswer();
        SingleAnswer oneAnswer = getSpecificSingleAnswer(dummyAnswer);
        assertEquals(getCorrectAnswer(), oneAnswer.getCorrectAnswer());
    }

    protected abstract String getCorrectAnswer();

}