package fil.coo.view;

import javax.swing.*;

public abstract class AbstractView {


    /**
     * @param text what will be change on the on the ScrollPanel
     */
    public abstract void updateText(String text);

    /**
     * @param visible if this instance should be visible or not
     */
    public abstract void setVisible(boolean visible);
}
