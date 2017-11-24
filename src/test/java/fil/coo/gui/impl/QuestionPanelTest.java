package fil.coo.gui.impl;

import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.AbstractQuestionView;
import fil.coo.gui.AbstractQuestionViewTest;

import static org.junit.Assert.*;

public class QuestionPanelTest extends AbstractQuestionViewTest {

    @Override
    protected AbstractQuestionView getSpecificQuestionView(String questionText, AbstractAnswerView abstractAnswerView) {
        return new QuestionPanel(questionText, abstractAnswerView);
    }
}