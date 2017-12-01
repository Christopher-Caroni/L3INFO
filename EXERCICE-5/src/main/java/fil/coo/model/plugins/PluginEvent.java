package fil.coo.model.plugins;

import plugin.Plugin;

import java.util.EventObject;

/**
 * Contains the {@link Class} of the {@link Plugin}
 */
public class PluginEvent extends EventObject {

    public PluginEvent(Class<? extends Plugin> pluginClass) {
        super(pluginClass);
    }
    
    public Class<? extends Plugin> getPluginClass() {
        return (Class<? extends Plugin>) getSource();
    }


}
