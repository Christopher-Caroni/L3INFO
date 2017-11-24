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
    protected Mocks.MockQuizView abstractQuizView;
    protected IQuizController quizController;

    @Before
    public void setDependencies() {
        this.quizModel = new Mocks.MockQuizModel(points, true);
        this.abstractQuizView = new Mocks.MockQuizView(inputs);
        this.quizController = getSpecificQuizController(quizModel, abstractQuizView);
    }

    protected abstract IQuizController getSpecificQuizController(QuizModel quizModel, AbstractQuizView abstractQuizView);

    @Test
    public void testCorrectAnswersWhenOK() {
        int pointsWon = quizController.verifyCorrectAnswers(abstractQuizView.getUserAnswerInput(), quizModel.getPoints());
        assertThat(pointsWon, is(total));


        this.quizModel = new Mocks.MockQuizModel(points, false);
        this.abstractQuizView = new Mocks.MockQuizView(inputs);
        this.quizController = getSpecificQuizController(quizModel, abstractQuizView);
        pointsWon = quizController.verifyCorrectAnswers(abstractQuizView.getUserAnswerInput(), quizModel.getPoints());
        assertThat(pointsWon, is(0));
    }

    @Test
    public void testCorrectAnswersWhenNotOK() {
        this.quizModel = new Mocks.MockQuizModel(points, false);
        this.abstractQuizView = new Mocks.MockQuizView(inputs);
        this.quizController = getSpecificQuizController(quizModel, abstractQuizView);

        int pointsWon = quizController.verifyCorrectAnswers(abstractQuizView.getUserAnswerInput(), quizModel.getPoints());
        assertThat(pointsWon, is(0));
    }

    @Test
    public void testAcceptSubmissionCallsOnSubmissionFinishedInView() {
        assertThat(abstractQuizView.onSubmissionFinishedCallCount, is(0));
        quizController.acceptSubmission(abstractQuizView.getUserAnswerInput(), quizModel.getPoints());

        assertThat(abstractQuizView.onSubmissionFinishedCallCount, is(1));
    }

    @Test
    public void testRefuseSubmissionCallsShowInvalidInputsInView() {
        assertThat(abstractQuizView.showInValidInputsCallCount, is(0));

        quizController.refuseSubmissionOnInvalidInput(null);
        assertThat(abstractQuizView.showInValidInputsCallCount, is(1));
    }

    @Test
    public void testVerifyInvalidInputWithNone() {
        List<Integer> invalidInputIndexes = quizController.getInvalidInputIndexes(abstractQuizView.getUserAnswerInput());
        assertThat(invalidInputIndexes.isEmpty(), is(true));
    }

    @Test
    public void testVerifyInvalidInputWithAll() {
        this.quizModel = new Mocks.MockQuizModel(points, false);
        this.quizController = getSpecificQuizController(quizModel, abstractQuizView);

        List<Integer> invalidInputIndexes = quizController.getInvalidInputIndexes(abstractQuizView.getUserAnswerInput());
        assertThat(invalidInputIndexes.size(), is(inputs.size()));
        for (int indexCount = 0; indexCount < inputs.size(); indexCount++) {
            assertThat(invalidInputIndexes.get(indexCount), is(indexCount));
        }
    }

    @Test
    public void testOnSubmitWhenOK() {
        assertThat(abstractQuizView.onSubmissionFinishedCallCount, is(0));
        assertThat(abstractQuizView.showInValidInputsCallCount, is(0));

        quizController.onSubmit();
        assertThat(abstractQuizView.onSubmissionFinishedCallCount, is(1));
        assertThat(abstractQuizView.showInValidInputsCallCount, is(0));

    }

    @Test
    public void testOnSubmitWhenNotOK() {
        this.quizModel = new Mocks.MockQuizModel(points, false);
        this.quizController = getSpecificQuizController(quizModel, abstractQuizView);

        assertThat(abstractQuizView.onSubmissionFinishedCallCount, is(0));
        assertThat(abstractQuizView.showInValidInputsCallCount, is(0));

        quizController.onSubmit();
        assertThat(abstractQuizView.onSubmissionFinishedCallCount, is(0));
        assertThat(abstractQuizView.showInValidInputsCallCount, is(1));

    }
}