package fil.coo;

import fil.coo.controller.AbstractController;
import fil.coo.controller.impl.SimpleController;
import fil.coo.model.AbstractModel;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.model.plugins.impl.SimpleModel;
import fil.coo.view.AbstractView;
import fil.coo.view.impl.EditorFrame;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getSimpleName());

    public static void main(String[] args) {

        AbstractModel model = null;
        try {
            model = new SimpleModel("repository");
        } catch (IOException e) {
            logger.info(e.getMessage());
            System.exit(1);
        }
        AbstractView editor = new EditorFrame();

        AbstractController controller = new SimpleController(model, editor);

        editor.setVisible(true);

        model.onPluginAdded(new PluginEvent(DummyPlugin.class));
    }

}
