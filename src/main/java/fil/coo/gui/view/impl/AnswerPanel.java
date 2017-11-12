package fil.coo.gui.view.impl;

import fil.coo.gui.controller.IAnswerController;
import fil.coo.gui.view.AbstractAnswerView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AnswerPanel extends AbstractAnswerView {

    private JPanel rootPanel;

    public AnswerPanel(IAnswerController answerController) {
        super(answerController);

        rootPanel = new JPanel();
    }

    @Override
    public void add(Component component) {
        rootPanel.add(component);
    }

    @Override
    public String getUserInput() {
        // TODO
        return null;
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
