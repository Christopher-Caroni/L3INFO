package fil.coo.answers;

import org.junit.Test;

import static org.junit.Assert.*;

public class TextAnswerTest extends SingleAnswerTest{

    private final static String DEFAULT_ANSWER = "default_answer";
    private final static String EXPECTED_PROMPT = "(text)";

    @Override
    protected SingleAnswer getSpecificSingleAnswer(String answer) {
        return new TextAnswer(answer);
    }

    @Test
    public void testPrompt() {
        assertEquals(EXPECTED_PROMPT, singleAnswer.getPrompt());
    }
}