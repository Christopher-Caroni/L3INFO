package fil.coo.gui.impl.answers;

import fil.coo.gui.AbstractAnswerView;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MultiChoiceAnswerPanelTest extends ChoiceAnswerPanelTest {

    private static final String DUMMY_INPUT = "dummy_input";
    private static final List<String> DUMMY_POSSIBLE_ANSWERS = Arrays.asList(DUMMY_INPUT, "another_dummy");

    @Override
    protected AbstractAnswerView getSpecificAnswerView() {
        return new MultiChoiceAnswerPanel(null, DUMMY_POSSIBLE_ANSWERS);
    }

    @Override
    protected String getDummyInput() {
        return DUMMY_INPUT;
    }
}