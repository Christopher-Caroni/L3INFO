package fil.coo.gui;

import fil.coo.controller.IAnswerController;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class AbstractQuestionViewTest {

    protected AbstractQuestionView abstractQuestionView;

    @Before
    public void setupQuestionPanel() {
        this.abstractQuestionView = getSpecificQuestionView("", new MockAnswerView(null));
    }

    protected abstract AbstractQuestionView getSpecificQuestionView(String questionText, AbstractAnswerView abstractAnswerView);


    @Test
    public void testSetGetUserInput() {
        assertThat(abstractQuestionView.getUserInput(), is(""));

        String expected = "dummy_input";
        abstractQuestionView.setUserInput(expected);
        assertThat(abstractQuestionView.getUserInput(), is(expected));
    }

    protected class MockAnswerView extends AbstractAnswerView {

        private String input;

        /**
         * @param answerController the controller to which this instance should send events to
         */
        public MockAnswerView(IAnswerController answerController) {
            super(answerController);
            this.input = "";
        }

        @Override
        public String getUserInput() {
            return input;
        }

        @Override
        public void setUserInput(String input) {

            this.input = input;
        }

        @Override
        public void setBorder(Border border) {

        }

        @Override
        public Border getBorder() {
            return null;
        }

        @Override
        public Component getView() {
            return new JPanel();
        }
    }
}