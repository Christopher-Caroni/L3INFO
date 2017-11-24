package fil.coo.gui;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public abstract class AbstractQuizViewTest {

    protected AbstractQuizView abstractQuizView;

    @Before
    public void setupQuizView() {
        this.abstractQuizView = getSpecificQuestionView();
    }

    protected abstract AbstractQuizView getSpecificQuestionView();

    @Test
    public void testGetUserAnswerInput() {
        List<String> inputs = abstractQuizView.getUserAnswerInput();
        assertThat(inputs.size(), is(0));

        Mocks.MockAnswerView mockAnswerView = new Mocks.MockAnswerView();
        Mocks.MockQuestionView mockQuestionView = new Mocks.MockQuestionView("", mockAnswerView);
        abstractQuizView.addQuestionView(mockQuestionView, false);

        inputs = abstractQuizView.getUserAnswerInput();
        assertThat(inputs.size(), is(1));
        assertThat(inputs.get(0), is(""));

        String expected = "dummy_input";
        mockAnswerView.setUserInput(expected);
        inputs = abstractQuizView.getUserAnswerInput();
        assertThat(inputs.size(), is(1));
        assertThat(inputs.get(0), is(expected));
    }

}