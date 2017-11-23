package fil.coo.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class QuizModelTest {

    protected QuizModel quizModel;

    @Before
    public void setupQuiz() {
        this.quizModel = getQuizModel();
    }

    protected abstract QuizModel getQuizModel();

    @Test
    public void testInitialValues() {
        assertThat(quizModel.getQuestions().isEmpty(), is(true));
        assertThat(quizModel.getNbQuestions(), is(0));

        assertThat(quizModel.getPoints().isEmpty(), is(true));
    }

}