package fil.coo.answers;

import static org.junit.Assert.*;

public class TextAnswerTest extends SingleAnswerTest{

    @Override
    protected SingleAnswer getSpecificSingleAnswer() {
        return new TextAnswer("");
    }
}