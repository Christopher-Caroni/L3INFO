package fil.coo.gui;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Mocks {

    public static class MockQuestionView extends AbstractQuestionView {

        /**
         * @param questionText the model from which to create this question
         * @param answerView   the specific {@link AbstractAnswerView} that this views should hold
         */
        public MockQuestionView(String questionText, AbstractAnswerView answerView) {
            super(questionText, answerView);
        }

        @Override
        public Component getView() {
            return new JPanel();
        }
    }

    public static class MockAnswerView extends AbstractAnswerView {

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
