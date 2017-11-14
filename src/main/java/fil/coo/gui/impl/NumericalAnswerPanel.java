package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.awt.*;

public class NumericalAnswerPanel extends AnswerPanel {

	private JSpinner spinner;
	
    public NumericalAnswerPanel(IAnswerController answerController) {
        super(answerController);
    }

    @Override
    public String getUserInput() {
        return spinner.getToolTipText();
    }

    @Override
    protected void initCustomView() {

        spinner = new JSpinner();
        spinner.setPreferredSize(new Dimension(100, 40));

        rootPanel.add(spinner);

    }

}
