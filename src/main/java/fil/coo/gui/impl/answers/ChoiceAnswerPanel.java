package fil.coo.gui.impl.answers;

import fil.coo.controller.IAnswerController;
import fil.coo.gui.impl.AnswerPanel;

import javax.swing.*;
import java.util.List;

public abstract class ChoiceAnswerPanel extends AnswerPanel {

    protected ButtonGroup exclusiveButtonGroup;

    public ChoiceAnswerPanel(IAnswerController answerController, boolean initCustomView) {
        super(answerController, initCustomView);
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

    @Override
    public String getUserInput() {
        JRadioButton selectedButton = (JRadioButton) exclusiveButtonGroup.getSelection();
        if (selectedButton == null) {
            return "";
        }
        return selectedButton.getText();
    }
}
