package fil.coo.gui;

import javax.swing.border.Border;

/**
 * Defines the behaviour that our answer views must implement
 */
public abstract class AbstractAnswerView implements IView {

    public AbstractAnswerView() {
    }

    /**
     * @return the user's answer
     */
    public abstract String getUserInput();

    public abstract void setUserInput(String input);

    public abstract void setBorder(Border border);

    public abstract Border getBorder();
}
