package fil.coo.model;

import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.factory.AnswerPanelFactory;
import fil.coo.model.impl.CLIQuiz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;

public abstract class QuizModelTest {

    protected QuizModel quizModel;

    @Before
    public void setupQuiz() {
        this.quizModel = getQuizModel();
    }

    protected abstract QuizModel getQuizModel();

    @Test
    public void testAddQuestion() {
        assertThat(quizModel.getQuestions().isEmpty(), is(true));
        assertThat(quizModel.getQuestions().size(), is(0));
        assertThat(quizModel.getNbQuestions(), is(0));

        MockQuestion mockQuestion = new MockQuestion("mock_text", null, 0);
        quizModel.addQuestion(mockQuestion);

        assertThat(quizModel.getQuestions().isEmpty(), is(false));
        assertThat(quizModel.getQuestions().size(), is(1));
        assertThat(quizModel.getNbQuestions(), is(1));
        assertThat(quizModel.getQuestions().get(0), sameInstance(mockQuestion));
    }

    @Test
    public void testGetPoints() {
        assertThat(quizModel.getPoints().isEmpty(), is(true));

        int nbPoints = 2;
        MockQuestion mockQuestion = new MockQuestion("mock_text", null, nbPoints);
        quizModel.addQuestion(mockQuestion);


        assertThat(quizModel.getPoints().isEmpty(), is(false));
        assertThat(quizModel.getPoints().size(), is(1));
        assertThat(quizModel.getPoints().get(0), is(nbPoints));

    }


    @Test
    public void testValidateAnswerTypeWhenTrue() {
        final String testValidInput = "test";

        // make both params opposite to make sure the calls in this test aren't mixed up
        MockAnswer mockAnswer = new MockAnswer(true, false);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        quizModel.addQuestion(mockQuestion);

        boolean actualAnswerResult = mockAnswer.isValid(testValidInput);
        Assert.assertThat(actualAnswerResult, is(true));
        Assert.assertThat(quizModel.validateAnswerType(0, testValidInput), is(actualAnswerResult));
    }

    @Test
    public void testValidateAnswerTypeWhenFalse() {
        final String testValidInput = "test";

        MockAnswer mockAnswer = new MockAnswer(false, true);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        quizModel.addQuestion(mockQuestion);

        boolean actualAnswerResult = mockAnswer.isValid(testValidInput);
        Assert.assertThat(actualAnswerResult, is(false));
        Assert.assertThat(quizModel.validateAnswerType(0, testValidInput), is(actualAnswerResult));
    }

    @Test
    public void testCorrectAnswerTypeWhenTrue() {
        final String testValidInput = "test";

        // make both params opposite to make sure the calls in this test aren't mixed up
        MockAnswer mockAnswer = new MockAnswer(false, true);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        quizModel.addQuestion(mockQuestion);

        boolean actualAnswerResult = mockAnswer.isCorrect(testValidInput);
        Assert.assertThat(actualAnswerResult, is(true));
        Assert.assertThat(quizModel.checkCorrectAnswer(0, testValidInput), is(actualAnswerResult));
    }

    @Test
    public void testCorrectAnswerTypeWhenFalse() {
        final String testValidInput = "test";

        MockAnswer mockAnswer = new MockAnswer(true, false);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        quizModel.addQuestion(mockQuestion);

        boolean actualAnswerResult = mockAnswer.isCorrect(testValidInput);
        Assert.assertThat(actualAnswerResult, is(false));
        Assert.assertThat(quizModel.checkCorrectAnswer(0, testValidInput), is(actualAnswerResult));
    }

    @Test
    public void testGetAnswer() {
        MockAnswer mockAnswer = new MockAnswer(true, false);
        MockQuestion mockQuestion = new MockQuestion("mock_text", mockAnswer, 0);
        CLIQuiz concreteQuiz = new CLIQuiz();
        concreteQuiz.addQuestion(mockQuestion);

        Assert.assertThat(concreteQuiz.getAnswer(0), sameInstance(mockAnswer));
    }

    protected class MockQuestion extends QuestionModel {

        /**
         * @param text     the question text
         * @param answer   the answer
         * @param nbPoints the number of points
         */
        public MockQuestion(String text, MockAnswer answer, int nbPoints) {
            super(text, answer, nbPoints);
        }

        @Override
        public int ask() {
            return 0;
        }
    }

    protected class MockAnswer implements AnswerModel {

        private final boolean shouldReturnValid;
        private final boolean shouldReturnCorrect;

        public MockAnswer(boolean shouldReturnValid, boolean shouldReturnCorrect) {
            this.shouldReturnValid = shouldReturnValid;
            this.shouldReturnCorrect = shouldReturnCorrect;
        }

        @Override
        public AbstractAnswerView createAnswerPanel(AnswerPanelFactory answerPanelFactory) {
            return null;
        }

        @Override
        public String getPrompt() {
            return null;
        }

        @Override
        public boolean isValid(String userAnswer) {
            return shouldReturnValid;
        }

        @Override
        public boolean isCorrect(String userAnswer) {
            return shouldReturnCorrect;
        }

        @Override
        public String getCorrectAnswer() {
            return null;
        }
    }

}