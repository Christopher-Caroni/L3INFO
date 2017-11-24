package fil.coo.model.factory;

import fil.coo.QuizTest;
import fil.coo.model.impl.answers.*;
import fil.coo.model.impl.CLIQuiz;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class QuizFactoryTest extends QuizTest {

    private static final Logger logger = Logger.getLogger(QuizFactoryTest.class.getSimpleName());

    @Test
    public void testDummyHasRightAnswerTypes() throws IOException {
        QuizFactory questionFactory = new QuizFactory();
        CLIQuiz questionnaire = questionFactory.createQuizFromTextFile("resources/dummy.quiz");

        assertThat(questionnaire.getNbQuestions(), is(7));

        assertThat(questionnaire.getQuestion(0).getAnswer(), instanceOf(TextAnswer.class));
        assertThat(questionnaire.getQuestion(1).getAnswer(), instanceOf(YesNoAnswer.class));
        assertThat(questionnaire.getQuestion(2).getAnswer(), instanceOf(NumericalAnswer.class));
        assertThat(questionnaire.getQuestion(3).getAnswer(), instanceOf(YesNoAnswer.class));
        assertThat(questionnaire.getQuestion(4).getAnswer(), instanceOf(NumericalAnswer.class));
        assertThat(questionnaire.getQuestion(5).getAnswer(), instanceOf(MultiAnswer.class));
        assertThat(questionnaire.getQuestion(6).getAnswer(), instanceOf(MultipleChoiceAnswer.class));
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}