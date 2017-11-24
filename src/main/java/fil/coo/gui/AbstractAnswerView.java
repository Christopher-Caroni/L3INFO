package fil.coo.gui;

import fil.coo.controller.IAnswerController;

import javax.swing.border.Border;
import java.awt.*;

/**
 * Defines the behaviour that our answer views must implement
 */
public abstract class AbstractAnswerView implements IView {

    private IAnswerController answerController;

    /**
     * @param answerController the controller to which this instance should send events to
     */
    public AbstractAnswerView(IAnswerController answerController) {
        this.answerController = answerController;
    }


    /**
     * @return the user's answer
     */
    public abstract String getUserInput();

    public abstract void setUserInput(String input);

    public abstract void setBorder(Border border);

    public abstract Border getBorder();
}
