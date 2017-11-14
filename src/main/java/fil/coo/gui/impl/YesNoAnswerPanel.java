package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;

import javax.swing.*;

public class YesNoAnswerPanel extends AnswerPanel {

	private ButtonGroup group;
	private JRadioButton yesButton;
	private JRadioButton noButton;

	public YesNoAnswerPanel(IAnswerController answerController) {
		super(answerController);
	}

	@Override
	public String getUserInput() {
		if (yesButton.isSelected()) {
			return yesButton.getText();
		}
		if (noButton.isSelected()) {
			return noButton.getText();
		}
		return null;
	}

	@Override
	protected void initCustomView() {
		group = new ButtonGroup();
		yesButton = new JRadioButton("yes");
		noButton = new JRadioButton("no");
		
		group.add(yesButton);
		group.add(noButton);
		
		rootPanel.add(yesButton);
		rootPanel.add(noButton);

	}

}
