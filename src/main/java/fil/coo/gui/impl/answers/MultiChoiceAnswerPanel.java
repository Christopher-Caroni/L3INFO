package fil.coo.gui.impl.answers;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MultiChoiceAnswerPanel extends ChoiceAnswerPanel {

    private final List<String> possibleAnswers;

    public MultiChoiceAnswerPanel(IAnswerController answerController, List<String> possibleAnswers) {
        super(answerController, false);
        this.possibleAnswers = possibleAnswers;
        initCustomView();
    }

    @Override
    protected List<JRadioButton> initChoices() {
        List<JRadioButton> jRadioButtons = new ArrayList<>();

        for (String possibleAnswer : possibleAnswers) {
            jRadioButtons.add(new JRadioButton(possibleAnswer));
        }

        return jRadioButtons;
    }


}
