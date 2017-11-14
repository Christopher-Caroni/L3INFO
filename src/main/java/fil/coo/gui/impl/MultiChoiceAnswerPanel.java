package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MultiChoiceAnswerPanel extends ChoiceAnswerPanel {

    private List<JRadioButton> choices;

    public MultiChoiceAnswerPanel(IAnswerController answerController) {
        super(answerController);
    }

    @Override
    protected List<JRadioButton> initChoices() {
        List<JRadioButton> jRadioButtons = new ArrayList<>();

        // TODO get model choices

        return jRadioButtons;
    }

    @Override
    public String getUserInput() {
        //TODO
        return null;
    }


}
