package fil.coo.model.plugins;

import fil.coo.FileChecker;
import fil.coo.FileEvent;
import fil.coo.FileListener;
import fil.coo.PluginFilter;
import org.apache.log4j.Logger;
import plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses a {@link FileChecker} associated with a {@link PluginFilter} to
 * notify observers about added or removed plugins the the concerned directory
 */
public class AbstractPluginSupplier implements FileListener {

    private static final Logger logger = Logger.getLogger(AbstractPluginSupplier.class.getSimpleName());
    private static final String EXTENSION_CLASS = ".class";
    private static final String PLUGIN_PACKAGE = "plugins.";

    protected List<PluginListener> pluginListeners;

    protected FileChecker fileChecker;

    /**
     * Starts {@link #fileChecker} in dirToWatch
     *
     * @param dirToWatch the directory to watch plugins for
     */
    public AbstractPluginSupplier(String dirToWatch) {
        pluginListeners = new ArrayList<>();

        fileChecker = new FileChecker(dirToWatch, new PluginFilter());
        fileChecker.addFileListener(this);
        fileChecker.start();
    }

    @Override
    public void fileAdded(FileEvent event) {
        Class<Plugin> pluginClass = getPluginClass(event);
        firePluginAdded(pluginClass);
    }

    @Override
    public void fileRemoved(FileEvent event) {
        Class<Plugin> pluginClass = getPluginClass(event);
        firePluginRemoved(pluginClass);
    }

    /**
     * Extracts a {@link Plugin} {@link Class} instance from the filename of the plugin
     *
     * @param event the event containing the filename
     * @return an instance of the {@link Plugin} {@link Class}
     */
    private Class<Plugin> getPluginClass(FileEvent event) {
        String pluginClassName = extractPluginClassName((String) event.getSource());
        return getPluginClassInstance(pluginClassName);
    }

    /**
     * Transforms a filename to a class name. Example: "CesarCode.class" to "CesarCode"
     *
     * @param filename the filename of the plugin
     * @return the class name of the plugin
     */
    private String extractPluginClassName(String filename) {
        return filename.substring(0, filename.length() - EXTENSION_CLASS.length());
    }

    /**
     * Concatenates the package {@link #PLUGIN_PACKAGE} to pluginClassName to create a
     * {@link Class} instance of the plugin
     *
     * @return an instance of {@link Plugin }{@link Class}
     */
    private Class<Plugin> getPluginClassInstance(String pluginClassName) {
        Class<Plugin> instantiatedClass;
        try {
            instantiatedClass = (Class<Plugin>) Class.forName(PLUGIN_PACKAGE + pluginClassName);
        } catch (ClassNotFoundException | ClassFormatError e) {
            logger.debug(e);
            return null;
        }
        return instantiatedClass;
    }

    /**
     * Notifies all {@link #pluginListeners} about the added plugin
     *
     * @param pluginClass the class of the added plugin
     */
    private void firePluginAdded(Class<Plugin> pluginClass) {
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
    private void firePluginRemoved(Class<Plugin> pluginClass) {
        logger.debug("Notifying about deleted file: " + pluginClass);

        PluginEvent event = new PluginEvent(pluginClass);
        for (PluginListener listener : pluginListeners) {
            listener.onPluginRemoved(event);
        }
    }


}
