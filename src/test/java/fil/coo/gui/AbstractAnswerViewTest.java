package fil.coo.gui;

import fil.coo.controller.IAnswerController;
import org.junit.Before;
import org.junit.Test;

import javax.swing.border.Border;
import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class AbstractAnswerViewTest {

    protected AbstractAnswerView abstractAnswerView;

    @Before
    public void setupAnswerView() {
        this.abstractAnswerView = getSpecificAnswerView();
    }

    protected abstract AbstractAnswerView getSpecificAnswerView();


    @Test
    public void testGetSetUserInput() {
        final String input = getDummyInput();

        abstractAnswerView.setUserInput(input);
        assertThat(abstractAnswerView.getUserInput(), is(input));
    }

    /**
     * @return a dummy input that could actually be used in this answer view
     */
    protected abstract String getDummyInput();

}