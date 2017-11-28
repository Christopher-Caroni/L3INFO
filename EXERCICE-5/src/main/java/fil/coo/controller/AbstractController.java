package fil.coo.controller;

import fil.coo.model.AbstractModel;
import fil.coo.view.AbstractView;
import fil.coo.view.impl.CustomJMenuItem;

public abstract class AbstractController {

    protected AbstractModel model;

    protected AbstractView view;

    public AbstractController(AbstractModel model, AbstractView view) {
        this.model = model;
        this.view = view;
        this.view.attachController(this);
    }

    public void onPluginRequest(CustomJMenuItem source) {
        // TODO
        String result = model.applyPlugin(0, view.getText());
        view.updateText(result);
    }


}
