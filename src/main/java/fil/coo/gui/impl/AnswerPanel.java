package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;
import fil.coo.gui.AbstractAnswerView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Wrapper for a {@link JPanel} to further customise according to the specific type of answer.
 */
public abstract class AnswerPanel extends AbstractAnswerView {

    protected JPanel rootPanel;

    public AnswerPanel(IAnswerController answerController, boolean initCustomView) {
        super(answerController);
        rootPanel = new JPanel();

        if (initCustomView) {
            initCustomView();
        }
    }

    protected abstract void initCustomView();

    @Override
    public void add(Component component) {
        rootPanel.add(component);
    }

    @Override
    public void setBorder(Border border) {
        rootPanel.setBorder(border);
    }

    @Override
    public Component getView() {
        return rootPanel;
    }
}
