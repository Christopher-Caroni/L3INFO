package fil.coo.controller;

import fil.coo.model.AbstractModel;
import fil.coo.view.AbstractView;
import fil.coo.view.impl.CustomJMenuItem;

public class AbstractController {

    protected AbstractModel model;

    protected AbstractView view;

    public void onPluginRequest(CustomJMenuItem source) {
        // TODO
        String result = model.applyPlugin(source.getID());
        view.updateText(result);
    }


}
