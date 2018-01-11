package fil.coo.view;

import javax.swing.*;

public class CustomJMenuItem extends JMenuItem {

    private String id;

    public CustomJMenuItem(String label, String id) {
        super(label);
        this.id = id;
    }

    public String getID() {
        return id;
    }
}
