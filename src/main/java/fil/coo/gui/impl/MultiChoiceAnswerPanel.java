package fil.coo.gui.impl;

import java.util.List;

import javax.swing.JRadioButton;

import fil.coo.controller.IAnswerController;

public class MultiChoiceAnswerPanel extends AnswerPanel {

	private List<JRadioButton> choices;
	
    public MultiChoiceAnswerPanel(IAnswerController answerController) {
        super(answerController);
    }

    @Override
    public String getUserInput() {
        //TODO
        return null;
    }

    @Override
    protected void initCustomView() {

    }

}
