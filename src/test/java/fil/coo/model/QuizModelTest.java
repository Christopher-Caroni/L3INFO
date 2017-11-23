package fil.coo.model;

import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.factory.AnswerPanelFactory;
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