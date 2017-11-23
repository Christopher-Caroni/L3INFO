package fil.coo.model.impl;

import fil.coo.model.QuizModel;
import fil.coo.model.QuizModelTest;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.*;

public class QuizTest extends QuizModelTest {

    @Override
    protected QuizModel getQuizModel() {
        return new Quiz();
    }

    @Test
    public void testValidateAnswerTypeWhenTrue() {
        final String testValidInput = "test";

        // make both params opposite to make sure the calls in this test aren't mixed up
        MockAnswer mockAnswer = new MockAnswer(true, false);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        quizModel.addQuestion(mockQuestion);

        boolean actualAnswerResult = mockAnswer.isValid(testValidInput);
        assertThat(actualAnswerResult, is(true));
        assertThat(quizModel.validateAnswerType(0, testValidInput), is(actualAnswerResult));
    }

    @Test
    public void testValidateAnswerTypeWhenFalse() {
        final String testValidInput = "test";

        MockAnswer mockAnswer = new MockAnswer(false, true);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        quizModel.addQuestion(mockQuestion);

        boolean actualAnswerResult = mockAnswer.isValid(testValidInput);
        assertThat(actualAnswerResult, is(false));
        assertThat(quizModel.validateAnswerType(0, testValidInput), is(actualAnswerResult));
    }

    @Test
    public void testCorrectAnswerTypeWhenTrue() {
        final String testValidInput = "test";

        // make both params opposite to make sure the calls in this test aren't mixed up
        MockAnswer mockAnswer = new MockAnswer(false, true);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        quizModel.addQuestion(mockQuestion);

        boolean actualAnswerResult = mockAnswer.isCorrect(testValidInput);
        assertThat(actualAnswerResult, is(true));
        assertThat(quizModel.checkCorrectAnswer(0, testValidInput), is(actualAnswerResult));
    }

    @Test
    public void testCorrectAnswerTypeWhenFalse() {
        final String testValidInput = "test";

        MockAnswer mockAnswer = new MockAnswer(true, false);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        quizModel.addQuestion(mockQuestion);

        boolean actualAnswerResult = mockAnswer.isCorrect(testValidInput);
        assertThat(actualAnswerResult, is(false));
        assertThat(quizModel.checkCorrectAnswer(0, testValidInput), is(actualAnswerResult));
    }

    @Test
    public void testGetAnswer() {
        MockAnswer mockAnswer = new MockAnswer(true, false);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        Quiz concreteQuiz = new Quiz();
        concreteQuiz.addQuestion(mockQuestion);

        assertThat(concreteQuiz.getAnswer(0), sameInstance(mockAnswer));
    }

}