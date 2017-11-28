package fil.coo.view.impl;

import fil.coo.controller.AbstractController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CustomJMenuBar extends JMenuBar {

    private JMenu menuFile;
    private JMenu menuTools;
    private JMenu menuHelp;


    private List<CustomJMenuItem> itemsMenu;
    private AbstractController controller;


    public CustomJMenuBar(AbstractController controller) {
        this.controller = controller;
        itemsMenu = new ArrayList<>();
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

    public void addPlugin(String label) {
        CustomJMenuItem pluginItem = new CustomJMenuItem(label);
        itemsMenu.add(pluginItem);

        pluginItem.addActionListener(actionEvent -> this.controller.onPluginRequest(itemsMenu.size()));

        menuTools.add(pluginItem);
    }
}
