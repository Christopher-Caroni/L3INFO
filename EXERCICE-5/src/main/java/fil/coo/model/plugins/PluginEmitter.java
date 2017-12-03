package fil.coo.model.plugins;

import org.apache.log4j.Logger;
import plugin.Plugin;

import java.util.List;

/**
 * This class is the "observable" that will emit {@link PluginEvent}s to listeners
 */
public abstract class PluginEmitter {

    private static final Logger logger = Logger.getLogger(PluginEmitter.class.getSimpleName());

    protected List<PluginListener> pluginListeners;

    /**
     * Notifies all {@link #pluginListeners} about the added plugin
     *
     * @param pluginClass the class of the added plugin
     */
    protected void firePluginAdded(Class<? extends Plugin> pluginClass) {
        logger.debug("Notifying about added plugin: \"" + pluginClass + "\"");

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
    protected void firePluginRemoved(Class<? extends Plugin> pluginClass) {
        logger.debug("Notifying about deleted plugin: \"" + pluginClass + "\"");

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

    protected List<PluginListener> getPluginListeners() {
        return pluginListeners;
    }
}
