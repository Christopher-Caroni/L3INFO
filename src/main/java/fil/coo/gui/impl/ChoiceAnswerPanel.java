package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.util.List;

public abstract class ChoiceAnswerPanel extends AnswerPanel {

    protected ButtonGroup exclusiveButtonGroup;

    public ChoiceAnswerPanel(IAnswerController answerController, List<String> possibleAnswers) {
        super(answerController, possibleAnswers);
    }

    @Override
    protected void initCustomView() {
        exclusiveButtonGroup = new ButtonGroup();
        List<JRadioButton> buttons = initChoices();
        addButtons(buttons);

    }

    /**
     * Adds buttons to the exclusive group {@link #exclusiveButtonGroup} and the {@link #rootPanel}
     *
     * @param buttons
     */
    private void addButtons(List<JRadioButton> buttons) {
        for (JRadioButton button : buttons) {
            exclusiveButtonGroup.add(button);
            rootPanel.add(button);
        }
    }

    /**
     *
     * @return a list of the {@link JRadioButton} to add to the exclusive choice group
     */
    protected abstract List<JRadioButton> initChoices();
}
