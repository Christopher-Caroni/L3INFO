package fil.coo.gui.impl.answers;

import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.impl.AnswerPanelTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ChoiceAnswerPanelTest extends AnswerPanelTest {


    private static final String DUMMY_INPUT = "dummy_choice_1";
    private static final List<String> DUMMY_POSSIBLE_ANSWERS = Arrays.asList(DUMMY_INPUT, "dummy_choice_2");

    @Override
    protected AbstractAnswerView getSpecificAnswerView() {
        return new ChoiceAnswerPanel(null, DUMMY_POSSIBLE_ANSWERS);
    }

    @Override
    protected String getDummyInput() {
        return DUMMY_INPUT;
    }
}