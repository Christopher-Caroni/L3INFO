package fil.coo.model.plugins;

import plugin.Plugin;

import java.util.EventObject;

public class PluginEvent extends EventObject {

    public PluginEvent(Class<Plugin> pluginClass) {
        super(pluginClass);
    }

}
