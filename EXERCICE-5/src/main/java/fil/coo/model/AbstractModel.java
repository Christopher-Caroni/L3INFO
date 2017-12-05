package fil.coo.model;

import fil.coo.controller.AbstractController;
import fil.coo.model.plugins.AbstractPluginSupplier;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.model.plugins.PluginListener;
import fil.coo.model.plugins.impl.SimplePluginSupplier;
import org.apache.log4j.Logger;
import plugin.Plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractModel implements PluginListener {

    private static final Logger logger = Logger.getLogger(AbstractModel.class.getSimpleName());

    protected List<Plugin> plugins;
    protected AbstractPluginSupplier pluginSupplier;
    protected AbstractController controller;

    public AbstractModel(String pluginRepository) throws IOException {
        this.plugins = new ArrayList<>();

        pluginSupplier = new SimplePluginSupplier(pluginRepository);
        pluginSupplier.addPluginListener(this);
        pluginSupplier.start();
    }

    public String applyPlugin(int pluginIndex, String source) {
        logger.debug("Applying plugin: " + pluginIndex + ", " + plugins.get(pluginIndex).getLabel());

        return plugins.get(pluginIndex).transform(source);
    }


    @Override
    public void onPluginAdded(PluginEvent pluginEvent) {
        final Plugin plugin = getPluginInstance(pluginEvent);
        if (plugin != null) {
            this.plugins.add(plugin);
            controller.notifyPluginAdded(plugin);
        } else {
            logger.debug("Could not instantiate plugin" + pluginEvent.getSource());
        }
    }

    @Override
    public void onPluginRemoved(PluginEvent pluginEvent) {
        Plugin plugin = getPluginInstance(pluginEvent);
        if (plugin != null) {
            this.plugins.remove(plugin);
            controller.notifyPluginRemoved(plugin);
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

    public void setController(AbstractController controller) {
        this.controller = controller;
    }
}
