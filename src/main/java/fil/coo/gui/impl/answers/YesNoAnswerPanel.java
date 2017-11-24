package fil.coo.gui.impl.answers;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.util.List;

public class YesNoAnswerPanel extends ChoiceAnswerPanel {

    public YesNoAnswerPanel(IAnswerController answerController, List<String> possibleAnswers) {
        super(answerController, possibleAnswers);
    }

}
