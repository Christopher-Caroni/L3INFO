package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YesNoAnswerPanel extends ChoiceAnswerPanel {

	private JRadioButton yesButton;
	private JRadioButton noButton;

	public YesNoAnswerPanel(IAnswerController answerController) {
		super(answerController, Arrays.asList("yes", "no"));
	}

	@Override
	protected List<JRadioButton> initChoices() {
		List<JRadioButton> jRadioButtons = new ArrayList<>();

        yesButton = new JRadioButton("yes");
        noButton = new JRadioButton("no");

		jRadioButtons.add(yesButton);
		jRadioButtons.add(noButton);

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
