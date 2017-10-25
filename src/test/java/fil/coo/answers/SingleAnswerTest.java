package fil.coo.answers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class SingleAnswerTest extends AnswerTest {

    protected SingleAnswer singleAnswer;

    
   
    @Before
    public void setupSingleAnswer() throws NullPointerException, NotCorrectAnswerException {
        singleAnswer = getSpecificSingleAnswer(getDefaultAnswer());
    }

    /**
     * @param answer the correct answer
     * @return an instance of the implementing Answer to test
     */
    protected abstract SingleAnswer getSpecificSingleAnswer(String answer) throws NullPointerException, NotCorrectAnswerException;


    @Test(expected=NullPointerException.class)
    public void testWhenAnwserIsNull() throws NullPointerException, NotCorrectAnswerException {
        SingleAnswer s = getSpecificSingleAnswer(null);
    }
  

    /**
     * @return a default answer for the implementing Answer class
     */
    protected abstract String getDefaultAnswer();

   
    @Override
    public Answer getSpecificAnswer() throws NullPointerException, NotCorrectAnswerException {
        return getSpecificSingleAnswer(getDefaultAnswer());
    }

    @Test(expected = NullPointerException.class)
    public void testNullConstructionThrows() throws NullPointerException, NotCorrectAnswerException {
        SingleAnswer s = getSpecificSingleAnswer(null);
    }

    @Test
    public void testGetSetWhenOK() throws NullPointerException, NotCorrectAnswerException {
        String dummyAnswer = "dummy_answer";
        SingleAnswer oneAnswer = getSpecificSingleAnswer(dummyAnswer);
        assertEquals(dummyAnswer, oneAnswer.getAnswer());
    }

}