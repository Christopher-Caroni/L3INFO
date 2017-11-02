package fil.coo.factory;

import fil.coo.AnswerFactory;
import fil.coo.answers.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnswerFactoryTest {

    private final String TEXTANSWER = "Tolkien";
    private final String TEXTNUMERICAL = "10";
    private final String TEXTYES = "oui";
    private final String TEXTMULTI = "Frodo ; Pippin ; Merry ; Sam";
    private final String TEXTMULTIPLECHOICE = "Bill | Bourricot | Robert | Jolly Jumper";

    @Test
    public void testBuildAnswer() throws Exception {
        AnswerFactory factory = AnswerFactory.getInstance();
        Answer answerText = factory.buildAnswer(TEXTANSWER);
        Answer answerNumerical = factory.buildAnswer(TEXTNUMERICAL);
        Answer answerYesNo = factory.buildAnswer(TEXTYES);
        Answer answerMulti = factory.buildAnswer(TEXTMULTI);
        Answer answerMultipleChoice = factory.buildAnswer(TEXTMULTIPLECHOICE);

        //assertTrue(answerText instanceof TextAnswer);
        assertTrue(answerNumerical instanceof NumericalAnswer);
        assertTrue(answerYesNo instanceof YesNoAnswer);
        assertTrue(answerMulti instanceof MultiAnswer);
        assertTrue(answerMultipleChoice instanceof MultipleChoiceAnswer);

    }

}