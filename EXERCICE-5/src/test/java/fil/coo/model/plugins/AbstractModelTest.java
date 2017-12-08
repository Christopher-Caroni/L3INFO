package fil.coo.model.plugins;

import fil.coo.controller.AbstractController;
import fil.coo.model.AbstractModel;
import fil.coo.view.AbstractView;
import org.junit.Before;
import org.junit.Test;
import plugin.Plugin;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class AbstractModelTest {

    protected AbstractModel model;
    protected AbstractView view;
    private MockController mockController;
    private AbstractModel simpleModel;

    @Before
    public void setup() {
        model = getSimpleModel();
        view = getSimpleView();
        mockController = new MockController(model, view);
    }

    public abstract AbstractModel getSimpleModel();
    public abstract AbstractView getSimpleView();


    @Test
    public void testAddPlugin(){
        assertThat(mockController.totalPlugin, is(0));
    }
    protected class MockController extends AbstractController{
        public int onPluginAddedCounter;
        public int onPluginRemovedCounter;
        public int totalPlugin;

        public MockController(AbstractModel model, AbstractView view) {
            super(model, view);
            onPluginAddedCounter = 0;
            onPluginRemovedCounter = 0;
            totalPlugin = 0;
        }

        @Override
        public void notifyPluginAdded(String pluginID, Plugin plugin) {
            onPluginAddedCounter ++;
            totalPlugin ++;
        }

        @Override
        public void notifyPluginRemoved(String pluginID) {
            onPluginRemovedCounter ++;
            totalPlugin --;
        }
    }
}
