package fil.coo.view;

import javax.swing.*;
import java.util.List;

public class CustomJMenuBar extends JMenuBar {

    private JMenu menuFile;
    private JMenu menuTools;
    private JMenu menuHelp;

    private List<CustomJMenuItem> itemsMenu;


    public CustomJMenuBar() {
        setupJMenuBar();
    }


    /**
     * Add and set the different {@link JMenu} on the {@link JMenuBar}
     */
    private void setupJMenuBar() {
        setJMenu();
        this.add(menuFile);
        this.add(menuTools);
        this.add(menuHelp);

    }

    /**
     * Initialize the different {@link JMenu}
     */
    private void setJMenu() {
        menuFile = new JMenu("File");
        menuTools = new JMenu("Tools");
        menuHelp = new JMenu("Help");
    }
}
