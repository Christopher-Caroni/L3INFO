package fil.coo.controller;

import fil.coo.exception.PluginNotFoundException;
import fil.coo.model.AbstractModel;
import fil.coo.view.AbstractView;
import org.apache.log4j.Logger;
import plugin.Plugin;

public abstract class AbstractController {

    private static final Logger logger = Logger.getLogger(AbstractController.class.getSimpleName());

    protected AbstractModel model;

    protected AbstractView view;

    public AbstractController(AbstractModel model, AbstractView view) {
        this.model = model;
        this.view = view;

        this.model.setController(this);
        this.view.setController(this);
    }

    public void onPluginRequest(String pluginID) {
        logger.debug("Got request for plugin: " + pluginID);

        String original = view.getText();
        logger.debug("Original text is: \"" + original + "\"");

        String result = null;
        try {
            result = model.getPluginTransformation(pluginID, original);
        } catch (PluginNotFoundException e) {
            logger.debug(e.getMessage());
        }

        logger.debug("Result of transformation: " + result);

        view.updateText(result);
    }


    public void setModel(AbstractModel model) {
        this.model = model;
    }

    public void setView(AbstractView view) {
        this.view = view;
    }

    public void notifyPluginAdded(String pluginID, Plugin plugin) {
        if (pluginID == null || pluginID.equals("")) {
            throw new RuntimeException("Cannot add a plugin with a bad ID");
        }

        this.view.addPlugin(pluginID, plugin.getLabel());
    }

    public void notifyPluginRemoved(String pluginID)
    {
        if (pluginID == null || pluginID.equals("")) {
            throw new RuntimeException("Cannot remove a plugin with a bad ID");
        }
        this.view.removePlugin(pluginID);
    }
}
