
package fil.coo.answers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
    public void testWhenIsNotValid(){
    	singleAnswer.isValid(DEFAULT_YES);
    	singleAnswer.isValid(DEFAULT_NO);
    }
    
}
