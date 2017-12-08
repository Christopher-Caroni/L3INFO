package fil.coo.model;

import fil.coo.controller.AbstractController;
import fil.coo.exception.PluginAlreadyExistsException;
import fil.coo.exception.PluginNotFoundException;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.model.plugins.PluginListener;
import fil.coo.model.plugins.impl.PluginSupplier;
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

    /**
     * @param pluginID the id of the plugin you want to call {@link Plugin#transform(String)} on
     * @param source   the original text
     * @return the transformed string
     * @throws PluginNotFoundException if the plugin is not contained by this model
     */
    public String getPluginTransformation(String pluginID, String source) throws PluginNotFoundException {
        Plugin plugin = pluginMap.get(pluginID);
        if (plugin == null) {
            throw new PluginNotFoundException("Cannot apply non-existent plugin");
        }
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

    /**
     * @param plugin the instance to compare against existing plugins
     * @throws PluginAlreadyExistsException if an instance of the same class already exists in {@link #pluginMap}
     */
    private void verifyPluginDoesNotExist(Plugin plugin) throws PluginAlreadyExistsException {
        if (getIDAssociatedToPluginClass(plugin) != null) {
            throw new PluginAlreadyExistsException("This plugin has already been loaded");
        }
    }

    /**
     * Records the plugin instance in {@link #pluginMap} and notifies the controller
     *
     * @param plugin the instance of the plugin that has been added
     */
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

    /**
     * Removed a plugin by checking if a plugin of the same class already exists
     *
     * @param plugin the instance of the plugin, whose class will be removed
     * @throws PluginNotFoundException if the plugin has not previously been added to this model
     */
    protected void removePlugin(Plugin plugin) throws PluginNotFoundException {
        String pluginID = getIDAssociatedToPluginClass(plugin);
        if (pluginID == null) {
            throw new PluginNotFoundException("Cannot find id for the removed plugin: plugin wasn't added before this");
        }

        this.pluginMap.remove(pluginID);
        controller.notifyPluginRemoved(pluginID);
    }

    /**
     * @param plugin an instance of a plugin that should already exist in {@link #pluginMap}
     * @return the id associated to the plugin class or null if does not exist
     */
    protected String getIDAssociatedToPluginClass(Plugin plugin) {
        for (Map.Entry<String, Plugin> entry : pluginMap.entrySet()) {
            if (entry.getValue().getClass() == plugin.getClass()) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * @param pluginEvent the event that contains the class of the plugin
     * @return a {@link Plugin} instance associated to the class in pluginEvent
     * @throws PluginNotFoundException if the class could not be instantiated
     */
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
