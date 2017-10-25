
package fil.coo.answers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class YesNoAnswerTest extends SingleAnswerTest{


    private final static String DEFAULT_YES = "oui";
    private final static String DEFAULT_NO = "non";
    private final static String EXPECTED_PROMPT = "(oui/non) ";
    private YesNoAnswer answerYes; 
    private YesNoAnswer answerNo;
	
	@Before
	public void setUp() throws NullPointerException, NotCorrectAnswerException{
		answerYes = new YesNoAnswer("oui");
		answerNo = new YesNoAnswer("non");		
	}
    
    @Override
	protected SingleAnswer getSpecificSingleAnswer(String answer) throws NullPointerException, NotCorrectAnswerException {
		return new YesNoAnswer(answer);
	}
	
    @Test
    public void testPromptWhenIsYes() {    	
        assertEquals(EXPECTED_PROMPT+DEFAULT_YES, answerYes.getPrompt());
    }
    
    @Test
    public void testWhenIsNotValid(){
    	singleAnswer.isValid(DEFAULT_YES);
    	singleAnswer.isValid(DEFAULT_NO);
    }
    
}
