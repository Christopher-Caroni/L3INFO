package fil.coo.gui.impl;

import fil.coo.gui.AbstractAnswerViewTest;
import org.junit.Test;

import javax.swing.*;
import javax.swing.border.Border;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public abstract class AnswerPanelTest extends AbstractAnswerViewTest {

    @Test
    public void testSetBorder() {
        Border border = BorderFactory.createTitledBorder("dummy_title");
        assertThat(abstractAnswerView.getBorder(), is(not(sameInstance(border))));

        abstractAnswerView.setBorder(border);
        assertThat(abstractAnswerView.getBorder(), is(sameInstance(border)));

    }

}