package fil.coo;

import plugin.Plugin;

import javax.swing.*;
import java.util.HashMap;

public class AbstractController {

    protected AbstractModel model;

    protected AbstractView view;

    public void onPluginRequest(CustomJMenuItem source) {
        // TODO
        String result = model.applyPlugin(source.getID());
        view.updateText(result);
    }


}
