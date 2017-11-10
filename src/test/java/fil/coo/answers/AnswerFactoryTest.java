package fil.coo.answers;

import fil.coo.QuizTest;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

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

        Answer expectAnswerTest = factory.buildAnswer(TEXTANSWER);
        Answer expectAnswerNumerical = factory.buildAnswer(TEXTNUMERICAL);
        Answer expectAnswerYesNo = factory.buildAnswer(TEXTYES);
        Answer expectAnswerMulti = factory.buildAnswer(TEXTMULTI);
        Answer expectAnswerMultipleChoice = factory.buildAnswer(TEXTMULTIPLECHOICE);

        assertThat(expectAnswerTest, instanceOf(TextAnswer.class));
        assertThat(expectAnswerNumerical, instanceOf(NumericalAnswer.class));
        assertThat(expectAnswerYesNo, instanceOf(YesNoAnswer.class));
        assertThat(expectAnswerMulti, instanceOf(MultiAnswer.class));
        assertThat(expectAnswerMultipleChoice, instanceOf(MultipleChoiceAnswer.class));

    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}