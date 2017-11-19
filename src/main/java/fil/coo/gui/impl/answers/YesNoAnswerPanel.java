package fil.coo.gui.impl.answers;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YesNoAnswerPanel extends ChoiceAnswerPanel {

	private JRadioButton yesButton;
	private JRadioButton noButton;

	public YesNoAnswerPanel(IAnswerController answerController) {
		super(answerController, Arrays.asList("vrai", "faux"));
	}

	@Override
	protected List<JRadioButton> initChoices() {
		List<JRadioButton> jRadioButtons = new ArrayList<>();

        yesButton = new JRadioButton("vrai");
        noButton = new JRadioButton("faux");

		jRadioButtons.add(yesButton);
		jRadioButtons.add(noButton);

		return jRadioButtons;
	}

}
