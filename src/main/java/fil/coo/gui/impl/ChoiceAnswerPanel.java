package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;

import javax.swing.*;

public class ChoiceAnswerPanel extends AnswerPanel {

    public ChoiceAnswerPanel(IAnswerController answerController) {
        super(answerController);
    }

    @Override
    public String getUserInput() {
        // TODO
        return null;
    }

    @Override
    protected void initCustomView() {
        JRadioButton yesButton = new JRadioButton("yes");
        JRadioButton noButton = new JRadioButton("no");

        rootPanel.add(yesButton);
        rootPanel.add(noButton);

    }

}
