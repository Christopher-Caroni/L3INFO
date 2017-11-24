package fil.coo.gui.impl.answers;

import fil.coo.gui.impl.AnswerPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ChoiceAnswerPanel extends AnswerPanel {

    private final List<String> possibleAnswers;
    protected ButtonGroup exclusiveButtonGroup;
    protected List<JRadioButton> jRadioButtons;

    public ChoiceAnswerPanel(List<String> possibleAnswers) {
        super();
        this.possibleAnswers = possibleAnswers;
        initCustomView();
    }

    @Override
    protected void initCustomView() {
        exclusiveButtonGroup = new ButtonGroup();
        jRadioButtons = new ArrayList<>();
        addChoices();
        addButtons();

    }

    /**
     * Adds buttons to the exclusive group {@link #exclusiveButtonGroup} and the {@link #rootPanel}
     */
    private void addButtons() {
        for (JRadioButton button : jRadioButtons) {
            exclusiveButtonGroup.add(button);
            rootPanel.add(button);
        }
    }

    @Override
    public final void setUserInput(String input) {
        for (JRadioButton jRadioButton : jRadioButtons) {
            boolean matches = input.equalsIgnoreCase(jRadioButton.getText());
            jRadioButton.setSelected(matches);
        }
    }

    protected void addChoices() {
        for (String possibleAnswer : possibleAnswers) {
            jRadioButtons.add(new JRadioButton(possibleAnswer));
        }
    }

    @Override
    public String getUserInput() {
        return getSelectedButtonText(exclusiveButtonGroup);
    }

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }
}
