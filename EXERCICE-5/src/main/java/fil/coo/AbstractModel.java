package fil.coo;

import plugin.Plugin;

import java.util.List;

public abstract class AbstractModel implements FileListener {

    private static final String REPO_DIR = "repository";
    protected List<Plugin> plugins;
    protected FileChecker pluginChecker;


    public AbstractModel() {
        pluginChecker = new FileChecker(REPO_DIR, new PluginFilter());
        pluginChecker.addFileListener(this);
    }

    public abstract String applyPlugin(String pluginIndex);

    @Override
    public void fileAdded(FileEvent event) {
        // TODO
    }

    @Override
    public void fileRemoved(FileEvent event) {
        // TODO
    }
}
