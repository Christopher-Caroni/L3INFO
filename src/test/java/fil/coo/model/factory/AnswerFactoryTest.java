package fil.coo.model.factory;

import fil.coo.model.impl.Answer;
import fil.coo.QuizTest;
import fil.coo.model.impl.answers.*;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class AnswerFactoryTest extends QuizTest {


    private static final Logger logger = Logger.getLogger(AnswerFactoryTest.class.getSimpleName());

    private final String INPUT_TEXT_ANSWER = "Tolkien";
    private final String INPUT_NUMERICAL = "10";
    private final String INPUT_YES_NO = "vrai";
    private final String INPUT_MULTI = "Frodo ; Pippin ; Merry ; Sam";
    private final String INPUT_MULTIPLE = "Bill | Bourricot | Robert | Jolly Jumper";

    @Test
    public void testBuildAnswer() throws Exception {
        AnswerFactory factory = AnswerFactory.getInstance();

        Answer expectAnswerTest = factory.buildAnswer(INPUT_TEXT_ANSWER);
        Answer expectAnswerNumerical = factory.buildAnswer(INPUT_NUMERICAL);
        Answer expectAnswerYesNo = factory.buildAnswer(INPUT_YES_NO);
        Answer expectAnswerMulti = factory.buildAnswer(INPUT_MULTI);
        Answer expectAnswerMultipleChoice = factory.buildAnswer(INPUT_MULTIPLE);

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