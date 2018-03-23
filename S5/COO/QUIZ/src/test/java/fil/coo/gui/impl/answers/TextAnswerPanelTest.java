package fil.coo.gui.impl.answers;

import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.impl.AnswerPanelTest;

import static org.junit.Assert.*;

public class TextAnswerPanelTest extends AnswerPanelTest {

    private static final String DUMMY_INPUT = "dummy_input";

    @Override
    protected AbstractAnswerView getSpecificAnswerView() {
        return new TextAnswerPanel();
    }

    @Override
    protected String getDummyInput() {
        return DUMMY_INPUT;
    }


}