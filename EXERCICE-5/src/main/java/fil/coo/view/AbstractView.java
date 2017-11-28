package fil.coo.view;

import fil.coo.controller.AbstractController;

import javax.swing.*;

public abstract class AbstractView {


    protected AbstractController controller;

    /**
     * @param text what will be change on the on the ScrollPanel
     */
    public abstract void updateText(String text);

    /**
     * @param visible if this instance should be visible or not
     */
    public abstract void setVisible(boolean visible);

    public abstract String getText();

    public void attachController(AbstractController abstractController) {
        this.controller = abstractController;
    }
}
