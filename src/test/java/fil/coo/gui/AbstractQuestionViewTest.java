package fil.coo.gui;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class AbstractQuestionViewTest {

    protected AbstractQuestionView abstractQuestionView;

    @Before
    public void setupQuestionPanel() {
        this.abstractQuestionView = getSpecificQuestionView("", new Mocks.MockAnswerView(null));
    }

    protected abstract AbstractQuestionView getSpecificQuestionView(String questionText, AbstractAnswerView abstractAnswerView);


    @Test
    public void testSetGetUserInput() {
        assertThat(abstractQuestionView.getUserInput(), is(""));

        String expected = "dummy_input";
        abstractQuestionView.setUserInput(expected);
        assertThat(abstractQuestionView.getUserInput(), is(expected));
    }

}