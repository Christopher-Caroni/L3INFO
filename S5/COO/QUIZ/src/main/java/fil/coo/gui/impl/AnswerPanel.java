package fil.coo.gui.impl;

import fil.coo.gui.AbstractAnswerView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Wrapper for a {@link JPanel} to further customise according to the specific type of answer.
 */
public abstract class AnswerPanel extends AbstractAnswerView {

    protected JPanel rootPanel;

    public AnswerPanel() {
        super();
        rootPanel = new JPanel();
    }

    protected abstract void initCustomView();

    @Override
    public void setBorder(Border border) {
        rootPanel.setBorder(border);
    }

    @Override
    public Border getBorder() {
        return rootPanel.getBorder();
    }

    @Override
    public Component getView() {
        return rootPanel;
    }
}
