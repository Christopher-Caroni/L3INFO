package fil.coo;

import fil.coo.controller.AbstractController;
import fil.coo.controller.impl.SimpleController;
import fil.coo.model.AbstractModel;
import fil.coo.model.impl.SimpleModel;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.view.AbstractView;
import fil.coo.view.impl.EditorFrame;
import org.apache.log4j.Logger;

import java.io.IOException;

import static fil.coo.SingleDirArg.getResourceDir;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getSimpleName());

    public static void main(String[] args) {
        AbstractModel model = null;
        try {
            String dir = getResourceDir(args);
            model = new SimpleModel(dir);
        } catch (IOException | IllegalArgumentException e) {
            logger.info("Error in specified repository");
            logger.info("Usage: java -jar XXX.jar <repository>");
            logger.info("!! The repository directory must be in the classpath for the plugins to be instantiated");
            System.exit(1);
        }
        AbstractView editor = new EditorFrame();

        AbstractController controller = new SimpleController(model, editor);

        editor.setVisible(true);

        model.onPluginAdded(new PluginEvent(DummyPlugin.class));
    }

}
