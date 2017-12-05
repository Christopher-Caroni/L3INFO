package fil.coo.model.plugins;

import fil.coo.FileChecker;
import fil.coo.FileEvent;
import fil.coo.FileListener;
import fil.coo.PluginFilter;
import fil.coo.files.CustomFileChecker;
import org.apache.log4j.Logger;
import plugin.Plugin;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Uses a {@link FileChecker} associated with a {@link PluginFilter} to
 * detect added or removed plugins in the concerned directory.
 * Once these changes are detected, by extending {@link PluginEmitter},
 * it emits {@link PluginEvent}s to all observers.
 */
public class AbstractPluginSupplier extends PluginEmitter implements FileListener {

    private static final Logger logger = Logger.getLogger(AbstractPluginSupplier.class.getSimpleName());


    private static final String CLASS_FILENAME_EXTENSION = ".class";
    private static final String PLUGIN_PACKAGE = "plugin.";

    /**
     * The directory this instance is watching. Given in the constructor
     */
    protected final String dirToWatch;
    protected FileChecker fileChecker;

    /**
     * Initializes {@link #fileChecker} to the dir dirToWatch.
     *
     * @param dirToWatch the directory to watch plugin for
     */
    public AbstractPluginSupplier(String dirToWatch) throws IOException {
        this.dirToWatch = dirToWatch;
        pluginListeners = new ArrayList<>();

        fileChecker = new CustomFileChecker(dirToWatch, new PluginFilter());
        fileChecker.addFileListener(this);
    }

    @Override
    public void fileAdded(FileEvent event) {
        Class<? extends Plugin> pluginClass = getPluginClass(event);
        firePluginAdded(pluginClass);
    }

    @Override
    public void fileRemoved(FileEvent event) {
        Class<? extends Plugin> pluginClass = getPluginClass(event);
        firePluginRemoved(pluginClass);
    }

    /**
     * Extracts the {@link Class} of a {@link Plugin} from the filename of the plugin
     *
     * @param event the event containing the filename
     * @return the {@link Class} of the {@link Plugin}
     */
    protected Class<? extends Plugin> getPluginClass(FileEvent event) {
        String pluginClassName = extractPluginClassName((String) event.getSource(), PLUGIN_PACKAGE);
        return getPluginClassInstance(pluginClassName);
    }

    /**
     * Transforms a filename to a class name. Example: "CesarCode.class" to "CesarCode"
     *
     * @param filename    the filename of the plugin
     * @param packageName the name of the package this plugin is expected to be in
     * @return the class name of the plugin
     */
    protected String extractPluginClassName(String filename, String packageName) {
        return packageName + filename.substring(0, filename.length() - CLASS_FILENAME_EXTENSION.length());
    }

    /**
     * Concatenates the package {@link #PLUGIN_PACKAGE} to pluginClassName to create a
     * {@link Class} instance of the plugin
     *
     * @return an instance of {@link Plugin }{@link Class}
     */
    protected Class<? extends Plugin> getPluginClassInstance(String pluginClassName) {
        try {
            return (Class<? extends Plugin>) Class.forName(pluginClassName);
        } catch (ClassNotFoundException | ClassFormatError e) {
            logger.debug(e);
            return null;
        }
    }

    /**
     * Starts watching {@link #dirToWatch}
     */
    public void start() {
        logger.debug("Asking fileChecker to start watching dir");
        fileChecker.start();
    }


}
