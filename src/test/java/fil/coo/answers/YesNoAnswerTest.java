
package fil.coo.answers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class YesNoAnswerTest extends SingleAnswerTest{


    private final static String DEFAULT_YES = "oui";
    private final static String DEFAULT_NO = "non";
    private final static String EXPECTED_PROMPT = "(oui/non) ";
    

	protected String getDefaultAnswer() {
		return DEFAULT_YES;
	}

	@Override
	protected SingleAnswer getSpecificSingleAnswer(String anwser) throws NullPointerException, NotCorrectAnswerException {
		return new YesNoAnswer(anwser);
	}
	
    @Test
    public void testPromptWhenIsYes() {    	
        assertEquals(EXPECTED_PROMPT, singleAnswer.getPrompt());
    }
    
    @Test
    public void testWhenIsValid(){
    	assertTrue(singleAnswer.isValid(DEFAULT_YES));
    	assertTrue(singleAnswer.isValid(DEFAULT_NO));
    }
    
    @Test
    public void testWhenIsNotValid(){
    	assertFalse(singleAnswer.isValid(""));
    	assertFalse(singleAnswer.isValid("-1"));
    	assertFalse(singleAnswer.isValid("1"));
    	assertFalse(singleAnswer.isValid("answer"));
    }
    
    @Test
    public void testWhenIsCorrect() throws NullPointerException, NotCorrectAnswerException{
    	YesNoAnswer yesNoAnswer = new YesNoAnswer(DEFAULT_NO);
    	assertTrue(yesNoAnswer.isCorrect(DEFAULT_NO));
    }
    
    @Test
    public void testWhenIsNotCorrect() throws NullPointerException, NotCorrectAnswerException{
    	YesNoAnswer yesNoAnswer = new YesNoAnswer(DEFAULT_YES);
    	assertFalse(yesNoAnswer.isCorrect(DEFAULT_NO));
    }
    
}
