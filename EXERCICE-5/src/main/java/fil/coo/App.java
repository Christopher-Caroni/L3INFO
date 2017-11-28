package fil.coo;

import fil.coo.controller.AbstractController;
import fil.coo.controller.impl.SimpleController;
import fil.coo.model.AbstractModel;
import fil.coo.model.plugins.impl.SimpleModel;
import fil.coo.view.AbstractView;
import fil.coo.view.impl.EditorFrame;

public class App {

    public static void main(String[] args) {
        AbstractController controller = new SimpleController();

        AbstractModel model = new SimpleModel(controller);
        AbstractView editor = new EditorFrame(controller);



        editor.setVisible(true);
    }
}
