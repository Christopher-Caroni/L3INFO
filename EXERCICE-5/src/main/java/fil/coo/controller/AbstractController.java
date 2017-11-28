package fil.coo.controller;

import fil.coo.model.AbstractModel;
import fil.coo.view.AbstractView;
import plugin.Plugin;

public abstract class AbstractController {

    protected AbstractModel model;

    protected AbstractView view;

    public AbstractController() {
    }

    public void onPluginRequest(int pluginIndex) {
        String result = model.applyPlugin(pluginIndex, view.getText());
        view.updateText(result);
    }


    public void setModel(AbstractModel model) {
        this.model = model;
    }

    public void setView(AbstractView view) {
        this.view = view;
    }

    public void notifyPluginAdded(Plugin plugin) {
        this.view.addPlugin(plugin.getLabel());
    }
}
