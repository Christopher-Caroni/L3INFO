package fil.coo.gui.impl.answers;

import fil.coo.controller.IAnswerController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MultiChoiceAnswerPanel extends ChoiceAnswerPanel {


    public MultiChoiceAnswerPanel(IAnswerController answerController, List<String> possibleAnswers) {
        super(answerController, possibleAnswers);
    }

}
