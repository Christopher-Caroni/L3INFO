package fil.coo.controller;

import fil.coo.model.AbstractModel;
import fil.coo.view.AbstractView;
import fil.coo.view.impl.CustomJMenuItem;

public abstract class AbstractController {

    protected AbstractModel model;

    protected AbstractView view;

    public AbstractController() {
    }

    public void onPluginRequest(CustomJMenuItem source) {
        // TODO
        String result = model.applyPlugin(0, view.getText());
        view.updateText(result);
    }


    public void setModel(AbstractModel model) {
        this.model = model;
    }

    public void setView(AbstractView view) {
        this.view = view;
    }
}
