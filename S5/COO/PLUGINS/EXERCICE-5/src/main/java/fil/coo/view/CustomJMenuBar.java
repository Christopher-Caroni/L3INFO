package fil.coo.view;

import fil.coo.controller.AbstractController;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CustomJMenuBar extends JMenuBar {

    private static final Logger logger = Logger.getLogger(CustomJMenuBar.class.getSimpleName());

    private JMenu menuFile;
    private JMenu menuTools;
    private JMenu menuHelp;

    /**
     * The list of the {@link CustomJMenuItem} that correspond to plugins
     */
    private List<CustomJMenuItem> itemsMenu;

    private AbstractController controller;


    public CustomJMenuBar() {
        itemsMenu = new ArrayList<>();
        setupJMenuBar();
    }


    /**
     * Add and set the different {@link JMenu} on the {@link JMenuBar}
     */
    private void setupJMenuBar() {
        initMainMenuItems();
        this.add(menuFile);
        this.add(menuTools);
        this.add(menuHelp);

    }

    /**
     * Initialize the different {@link JMenu}
     */
    private void initMainMenuItems() {
        menuFile = new JMenu("File");
        menuTools = new JMenu("Tools");
        menuHelp = new JMenu("Help");
    }

    public void addPlugin(String pluginID, String label) {
        if (label == null) {
            throw new RuntimeException("Cannot add a plugin with a null label");
        }
        logger.debug("Adding plugin with label: \"" + label + "\"");

        CustomJMenuItem pluginMenuItem = new CustomJMenuItem(label, pluginID);
        itemsMenu.add(pluginMenuItem);

        pluginMenuItem.addActionListener(actionEvent -> this.controller.onPluginRequest(pluginID));
        menuTools.add(pluginMenuItem);
    }

    public void setController(AbstractController controller) {
        this.controller = controller;
    }

    public void removePlugin(String pluginID) {
        int pluginIndex = getPluginIndexFromID(pluginID);
        if (pluginIndex == -1) {
            throw new RuntimeException("Cannot remove plugin because does not exist");
        }

        String labelRemoved = itemsMenu.get(pluginIndex).getText();
        menuTools.remove(itemsMenu.get(pluginIndex));
        itemsMenu.remove(pluginIndex);
        logger.debug("Removed plugin with label: \"" + labelRemoved + "\"");
    }

    private int getPluginIndexFromID(String pluginID) {
        for (int i = 0; i < itemsMenu.size(); i++) {
            CustomJMenuItem item = itemsMenu.get(i);
            if (item.getID().equalsIgnoreCase(pluginID)) {
                return i;
            }
        }
        return -1;
    }
}
