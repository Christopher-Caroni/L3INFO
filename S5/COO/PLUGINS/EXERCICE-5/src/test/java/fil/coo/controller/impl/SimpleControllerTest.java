package fil.coo.controller.impl;

import fil.coo.controller.AbstractController;
import fil.coo.controller.AbstractControllerTest;
import fil.coo.model.AbstractModel;
import fil.coo.view.AbstractView;

import static org.junit.Assert.*;

public class SimpleControllerTest extends AbstractControllerTest {

    @Override
    protected AbstractController getController(AbstractModel model, AbstractView view) {
        return new SimpleController(model, view);
    }
}