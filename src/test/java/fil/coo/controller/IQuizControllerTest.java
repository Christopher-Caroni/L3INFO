package fil.coo.controller;

import fil.coo.gui.AbstractQuizView;
import fil.coo.gui.Mocks;
import fil.coo.model.QuizModel;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class IQuizControllerTest {

    private static final List<String> inputs = Arrays.asList("test", "one", "two");
    private static final List<Integer> points = Arrays.asList(1, 2, 3);
    private static final int total = points.stream()
            .mapToInt(Integer::intValue)
            .sum();

    protected QuizModel quizModel;
    protected AbstractQuizView abstractQuizView;
    protected IQuizController quizController;

    @Before
    public void setDependencies() {
        this.quizModel = new Mocks.MockQuizModel(points, true);
        this.abstractQuizView = new Mocks.MockQuizView(inputs);
        this.quizController = getSpecificQuizController(quizModel, abstractQuizView);
    }

    protected abstract IQuizController getSpecificQuizController(QuizModel quizModel, AbstractQuizView abstractQuizView);

    @Test
    public void testCorrectAnswers() {
        int pointsWon = quizController.verifyCorrectAnswers(abstractQuizView.getUserAnswerInput(), quizModel.getPoints());
        assertThat(pointsWon, is(total));


        this.quizModel = new Mocks.MockQuizModel(points, false);
        this.abstractQuizView = new Mocks.MockQuizView(inputs);
        this.quizController = getSpecificQuizController(quizModel, abstractQuizView);
        pointsWon = quizController.verifyCorrectAnswers(abstractQuizView.getUserAnswerInput(), quizModel.getPoints());
        assertThat(pointsWon, is(0));
    }

}