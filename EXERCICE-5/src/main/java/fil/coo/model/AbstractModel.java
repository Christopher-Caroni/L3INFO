package fil.coo.model;

import fil.coo.controller.AbstractController;
import fil.coo.model.plugins.AbstractPluginSupplier;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.model.plugins.PluginListener;
import fil.coo.model.plugins.impl.SimplePluginSupplier;
import org.apache.log4j.Logger;
import plugin.Plugin;

import java.util.List;

public abstract class AbstractModel implements PluginListener {

    private static final Logger logger = Logger.getLogger(AbstractModel.class.getSimpleName());
    private static final String REPO_DIR = "repository";

    protected List<Plugin> plugins;
    protected AbstractPluginSupplier pluginSupplier;
    protected AbstractController abstractController;

    public AbstractModel(AbstractController controller) {
        this.abstractController = controller;

        pluginSupplier = new SimplePluginSupplier(REPO_DIR);
        pluginSupplier.addPluginListener(this);
        pluginSupplier.start();
    }

    public String applyPlugin(int pluginIndex, String source) {
        return plugins.get(pluginIndex).transform(source);
    }


    @Override
    public void onPluginAdded(PluginEvent pluginEvent) {
        Plugin plugin = getPluginInstance(pluginEvent);
        if (plugin != null) {
            this.plugins.add(plugin);
            abstractController.notifyPluginAdded(plugin);
        } else {
            logger.debug("Could not instantiate plugin" + pluginEvent.getSource());
        }
    }

    @Override
    public void onPluginRemoved(PluginEvent pluginEvent) {
        Plugin plugin = getPluginInstance(pluginEvent);
        if (plugin != null) {
            this.plugins.remove(plugin);
        } else {
            logger.debug("Could not instantiate plugin" + pluginEvent.getSource());
        }
    }

    private Plugin getPluginInstance(PluginEvent pluginEvent) {
        Class<Plugin> pluginClass = (Class<Plugin>) pluginEvent.getSource();
        try {
            return pluginClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
