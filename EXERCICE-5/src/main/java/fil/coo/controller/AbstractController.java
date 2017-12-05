package fil.coo.controller;

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

    public void onPluginRequest(int pluginIndex) {
        logger.debug("Got request for plugin: " + pluginIndex);

        String original = view.getText();
        logger.debug("Original text is: \"" + original + "\"");

        String result = model.applyPlugin(pluginIndex, original);
        logger.debug("Result of transformation: " + result);

        view.updateText(result);
    }


    public void setModel(AbstractModel model) {
        this.model = model;
    }

    public void setView(AbstractView view) {
        this.view = view;
    }

    public void notifyPluginAdded(Plugin plugin) {
        if (plugin.getLabel() == null) {
            throw new RuntimeException("Cannot add a plugin with a null label");
        }

        this.view.addPlugin(plugin.getLabel());
    }

    public void notifyPluginRemoved(Plugin plugin)
    {
        this.view.removePlugin(plugin.getLabel());
    }
}
