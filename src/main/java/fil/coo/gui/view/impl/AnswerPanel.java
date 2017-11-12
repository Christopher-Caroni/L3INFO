package fil.coo.gui.view.impl;

import fil.coo.gui.controller.IAnswerController;
import fil.coo.gui.view.AbstractAnswerView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AnswerPanel extends AbstractAnswerView {

    private JPanel answerPanel;

    public AnswerPanel(IAnswerController answerController) {
        super(answerController);

        answerPanel = new JPanel();
    }

    @Override
    public void add(Component component) {
        answerPanel.add(component);
    }

    @Override
    public String getUserInput() {
        // TODO
        return null;
    }

    @Override
    public void setBorder(Border border) {
        answerPanel.setBorder(border);
    }

    @Override
    public Component getView() {
        return answerPanel;
    }
}
