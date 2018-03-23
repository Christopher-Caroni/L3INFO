package fil.coo.model.plugins;

public interface PluginListener {

    void onPluginAdded(PluginEvent pluginEvent);

    void onPluginRemoved(PluginEvent pluginEvent);

}
