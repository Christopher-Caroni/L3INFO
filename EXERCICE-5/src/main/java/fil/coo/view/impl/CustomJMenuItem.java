package fil.coo.view.impl;

import javax.swing.*;

public class CustomJMenuItem extends JMenuItem {

    private int id;

    public CustomJMenuItem(String label, int id) {
        super(label);
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
