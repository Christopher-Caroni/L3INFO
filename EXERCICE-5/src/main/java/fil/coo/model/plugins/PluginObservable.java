package fil.coo.model.plugins;

import org.apache.log4j.Logger;
import plugin.Plugin;

import java.util.List;

public abstract class PluginObservable {

    private static final Logger logger = Logger.getLogger(PluginObservable.class.getSimpleName());

    protected List<PluginListener> pluginListeners;

    /**
     * Notifies all {@link #pluginListeners} about the added plugin
     *
     * @param pluginClass the class of the added plugin
     */
    protected void firePluginAdded(Class<Plugin> pluginClass) {
        logger.debug("Notifying about deleted file: " + pluginClass);

        PluginEvent event = new PluginEvent(pluginClass);
        for (PluginListener listener : pluginListeners) {
            listener.onPluginAdded(event);
        }
    }


    /**
     * Notifies all {@link #pluginListeners} about the removed plugin
     *
     * @param pluginClass the class of the removed plugin
     */
    protected void firePluginRemoved(Class<Plugin> pluginClass) {
        logger.debug("Notifying about deleted file: " + pluginClass);

        PluginEvent event = new PluginEvent(pluginClass);
        for (PluginListener listener : pluginListeners) {
            listener.onPluginRemoved(event);
        }
    }

    /**
     * Adds pluginListener to the notifying list
     *
     * @param pluginListener the listener to notify in the future
     */
    public void addPluginListener(PluginListener pluginListener) {
        this.pluginListeners.add(pluginListener);
    }


    /**
     * Removes pluginListener from the notifying list
     *
     * @param pluginListener the listener that shouldn't receive future events
     */
    public void removePluginListener(PluginListener pluginListener) {
        this.pluginListeners.remove(pluginListener);
    }
}
