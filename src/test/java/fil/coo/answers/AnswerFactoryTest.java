package fil.coo.answers;

import fil.coo.QuizTest;
import fil.coo.answers.impl.*;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnswerFactoryTest extends QuizTest {


    private static final Logger logger = Logger.getLogger(AnswerFactoryTest.class.getSimpleName());

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

        logger.debug(answerText.getClass());
        boolean isInstance = answerText instanceof TextAnswer;
        assertTrue(isInstance);
        assertTrue(answerNumerical instanceof NumericalAnswer);
        assertTrue(answerYesNo instanceof YesNoAnswer);
        assertTrue(answerMulti instanceof MultiAnswer);
        assertTrue(answerMultipleChoice instanceof MultipleChoiceAnswer);

    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}