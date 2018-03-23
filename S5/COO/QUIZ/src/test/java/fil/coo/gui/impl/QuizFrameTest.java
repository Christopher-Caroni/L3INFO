package fil.coo.gui.impl;

import fil.coo.gui.AbstractQuizView;
import fil.coo.gui.AbstractQuizViewTest;

import static org.junit.Assert.*;

public class QuizFrameTest extends AbstractQuizViewTest {

    @Override
    protected AbstractQuizView getSpecificQuestionView() {
        return new QuizFrame(0);
    }
}