package fil.coo.quiz;

import fil.coo.QuizTest;
import fil.coo.answers.*;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuestionFactoryTest extends QuizTest {

    private static final Logger logger = Logger.getLogger(QuestionFactoryTest.class.getSimpleName());

    @Test
    public void testDummyHasRightAnswerTypes() throws IOException {
        QuestionFactory questionFactory = new QuestionFactory();
        Quiz questionnaire = questionFactory.createQuestionnaire("resources/dummy.quiz");

        assertEquals(7, questionnaire.getNbQuestions());
        assertTrue(questionnaire.getQuestion(0).getAnswer() instanceof TextAnswer);
        assertTrue(questionnaire.getQuestion(1).getAnswer() instanceof YesNoAnswer);
        assertTrue(questionnaire.getQuestion(2).getAnswer() instanceof NumericalAnswer);
        assertTrue(questionnaire.getQuestion(3).getAnswer() instanceof YesNoAnswer);
        assertTrue(questionnaire.getQuestion(4).getAnswer() instanceof NumericalAnswer);
        assertTrue(questionnaire.getQuestion(5).getAnswer() instanceof MultiAnswer);
        assertTrue(questionnaire.getQuestion(6).getAnswer() instanceof MultipleChoiceAnswer);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}