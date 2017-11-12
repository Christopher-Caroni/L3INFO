package fil.coo.gui.view;

import fil.coo.gui.controller.IAnswerController;

import java.awt.*;

public abstract class IAnswerView {

    private IAnswerController answerController;

    public IAnswerView(IAnswerController answerController) {
        this.answerController = answerController;
    }

    public abstract void add(Component component);
}
