package fil.coo.gui.view;

import fil.coo.gui.controller.IAnswerController;

import java.awt.*;

/**
 * Defines the behaviour that our answer views must implement
 */
public abstract class AbstractAnswerView {

    private IAnswerController answerController;

    /**
     * @param answerController the controller to which this instance should send events to
     */
    public AbstractAnswerView(IAnswerController answerController) {
        this.answerController = answerController;
    }

    /**
     * Adds a view to this view instance
     *
     * @param component the component to add
     */
    public abstract void add(Component component);

    /**
     * @return the user's answer
     */
    public abstract String getUserInput();
}
