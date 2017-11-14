package fil.coo.gui.impl;

import fil.coo.controller.IAnswerController;

import java.awt.*;

public class TextAnswerPanel extends AnswerPanel {

    public TextAnswerPanel(IAnswerController answerController) {
        super(answerController);
    }

    @Override
    public String getUserInput() {
        // TODO
        return null;
    }

    @Override
    protected void initCustomView() {
        TextArea textArea = new TextArea();
        textArea.setPreferredSize(new Dimension(200, 40));

        rootPanel.add(textArea);

    }

}
