package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.awt.*;

public class NumericalAnswerPanel extends AnswerPanel {

    public NumericalAnswerPanel(IAnswerController answerController) {
        super(answerController);
    }

    @Override
    public String getUserInput() {
        // TODO
        return null;
    }

    @Override
    protected void initCustomView() {

        JSpinner spinner = new JSpinner();
        spinner.setPreferredSize(new Dimension(100, 40));

        rootPanel.add(spinner);

    }

}
