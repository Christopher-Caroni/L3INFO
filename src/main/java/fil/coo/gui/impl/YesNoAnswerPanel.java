package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class YesNoAnswerPanel extends ChoiceAnswerPanel {

	private JRadioButton yesButton;
	private JRadioButton noButton;

	public YesNoAnswerPanel(IAnswerController answerController) {
		super(answerController);
	}

	@Override
	protected List<JRadioButton> initChoices() {
		List<JRadioButton> jRadioButtons = new ArrayList<>();
		jRadioButtons.add(yesButton = new JRadioButton("yes"));
		jRadioButtons.add(noButton = new JRadioButton("no"));
		return jRadioButtons;
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


}
