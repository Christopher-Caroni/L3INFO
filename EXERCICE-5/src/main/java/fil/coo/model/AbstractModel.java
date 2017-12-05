package fil.coo.model;

import fil.coo.controller.AbstractController;
import fil.coo.model.plugins.AbstractPluginSupplier;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.model.plugins.PluginListener;
import fil.coo.model.plugins.impl.SimplePluginSupplier;
import org.apache.log4j.Logger;
import plugin.Plugin;

import java.io.IOException;
import java.util.*;

public abstract class AbstractModel implements PluginListener {

    private static final Logger logger = Logger.getLogger(AbstractModel.class.getSimpleName());

    protected Map<String, Plugin> pluginMap;

    protected AbstractPluginSupplier pluginSupplier;
    protected AbstractController controller;

    public AbstractModel(String pluginRepository) throws IOException {
        this.pluginMap = new HashMap<>();

        pluginSupplier = new SimplePluginSupplier(pluginRepository);
        pluginSupplier.addPluginListener(this);
        pluginSupplier.start();
    }

    public String applyPlugin(String pluginID, String source) {
        Plugin plugin = pluginMap.get(pluginID);
        logger.debug("Applying plugin: " + plugin.getLabel());

        return plugin.transform(source);
    }


    @Override
    public void onPluginAdded(PluginEvent pluginEvent) {
        final Plugin plugin = getPluginInstance(pluginEvent);
        if (plugin != null && getIDFromPlugin(plugin) == null) {
            String pluginID = UUID.randomUUID().toString();
            this.pluginMap.put(pluginID, plugin);
            controller.notifyPluginAdded(pluginID, plugin);
        } else {
            logger.debug("Plugin already exists or could not instantiate plugin" + pluginEvent.getSource());
        }
    }

    @Override
    public void onPluginRemoved(PluginEvent pluginEvent) {
        Plugin plugin = getPluginInstance(pluginEvent);
        if (plugin != null) {

            String pluginID = getIDFromPlugin(plugin);
            if (pluginID == null) {
                throw new RuntimeException("Cannot find id for the removed plugin");
            }
            this.pluginMap.remove(pluginID);
            controller.notifyPluginRemoved(pluginID);
        } else {
            logger.debug("Could not instantiate plugin" + pluginEvent.getSource());
        }
    }

    private String getIDFromPlugin(Plugin plugin) {
        for (Map.Entry<String, Plugin> entry : pluginMap.entrySet()) {
            if (entry.getValue().getClass() == plugin.getClass()) {
                return entry.getKey();
            }
        }
        return null;
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
