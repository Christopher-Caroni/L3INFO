package fil.coo.model;

import fil.coo.controller.AbstractController;
import fil.coo.exception.PluginAlreadyExistsException;
import fil.coo.exception.PluginNotFoundException;
import fil.coo.model.plugins.impl.PluginSupplier;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.model.plugins.PluginListener;
import org.apache.log4j.Logger;
import plugin.Plugin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractModel implements PluginListener {

    private static final Logger logger = Logger.getLogger(AbstractModel.class.getSimpleName());

    protected Map<String, Plugin> pluginMap;

    protected PluginSupplier pluginSupplier;
    protected AbstractController controller;

    public AbstractModel(String pluginRepository) throws IOException {
        this.pluginMap = new HashMap<>();

        pluginSupplier = new PluginSupplier(pluginRepository);
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
        final Plugin plugin;
        try {
            plugin = getPluginInstance(pluginEvent);
            verifyPluginDoesNotExist(plugin);
            addPlugin(plugin);
        } catch (PluginNotFoundException | PluginAlreadyExistsException e) {
            logger.debug(e.getMessage());
        }
    }

    private void verifyPluginDoesNotExist(Plugin plugin) throws PluginAlreadyExistsException {
        if (getIDFromPlugin(plugin) != null) {
            throw new PluginAlreadyExistsException("This plugin has already been loaded");
        }
    }

    private void addPlugin(Plugin plugin) {
        String pluginID = UUID.randomUUID().toString();
        this.pluginMap.put(pluginID, plugin);
        controller.notifyPluginAdded(pluginID, plugin);
    }

    @Override
    public void onPluginRemoved(PluginEvent pluginEvent) {
        try {
            Plugin plugin = getPluginInstance(pluginEvent);
            removePlugin(plugin);
        } catch (PluginNotFoundException e) {
            logger.debug(e);
        }
    }

    protected void removePlugin(Plugin plugin) throws PluginNotFoundException {
        String pluginID = getIDFromPlugin(plugin);
        if (pluginID == null) {
            throw new PluginNotFoundException("Cannot find id for the removed plugin");
        }

        this.pluginMap.remove(pluginID);
        controller.notifyPluginRemoved(pluginID);
    }

    protected String getIDFromPlugin(Plugin plugin) {
        for (Map.Entry<String, Plugin> entry : pluginMap.entrySet()) {
            if (entry.getValue().getClass() == plugin.getClass()) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected Plugin getPluginInstance(PluginEvent pluginEvent) throws PluginNotFoundException {
        Class<Plugin> pluginClass = (Class<Plugin>) pluginEvent.getSource();
        try {
            return pluginClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new PluginNotFoundException(e);
        }
    }

    public void setController(AbstractController controller) {
        this.controller = controller;
    }
}
