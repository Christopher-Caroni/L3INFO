package fil.coo.gui.view.impl;

import fil.coo.gui.controller.IAnswerController;
import fil.coo.gui.view.IAnswerView;

import javax.swing.*;
import java.awt.*;

public class AnswerPanel extends IAnswerView {

    private JPanel answerPanel;

    public AnswerPanel(IAnswerController answerController) {
        super(answerController);

        answerPanel = new JPanel();
    }

    @Override
    public void add(Component component) {
        answerPanel.add(component);
    }
}
