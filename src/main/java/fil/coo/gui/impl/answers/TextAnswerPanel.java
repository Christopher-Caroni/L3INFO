package fil.coo.gui.impl.answers;

import fil.coo.controller.IAnswerController;
import fil.coo.gui.impl.AnswerPanel;

import java.awt.*;

public class TextAnswerPanel extends AnswerPanel {

	private TextArea textArea; 
	
    public TextAnswerPanel(IAnswerController answerController) {
        super(answerController, null);
    }

    @Override
    public String getUserInput() {
        return textArea.getText();
    }

    @Override
    protected void initCustomView() {
    	textArea = new TextArea();
        textArea.setPreferredSize(new Dimension(200, 40));

        rootPanel.add(textArea);

    }

}
