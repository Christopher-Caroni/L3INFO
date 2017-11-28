package fil.coo.view.impl;

import javax.swing.*;

public class CustomJMenuItem extends JMenuItem {

    private String id;

    public CustomJMenuItem(String label, String id) {
        super(label);
        this.id = id;
    }

    public CustomJMenuItem(String label) {
        super(label);
    }

    public String getID() {
        return id;
    }
}
