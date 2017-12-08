package fil.coo.controller;

import fil.coo.Mocks.MockModel;
import fil.coo.Mocks.MockPlugin;
import fil.coo.Mocks.MockView;
import fil.coo.model.AbstractModel;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.view.AbstractView;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static fil.coo.Mocks.MockPlugin.MOCK_PLUGIN_RESULT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public abstract class AbstractControllerTest {


    protected MockModel model;
    protected MockView view;

    protected AbstractController controller;

    @Before
    public void setup() throws IOException {
        this.model = new MockModel("repository");
        this.view = new MockView();

        this.controller = getController(model, view);
    }

    protected abstract AbstractController getController(AbstractModel model, AbstractView view);

    @Test
    public void testOnPluginRequestReturnsCorrectPluginEffect() {
        this.model.onPluginAdded(new PluginEvent(MockPlugin.class));
        assertThat(view.lastPluginID, not(""));

        assertThat(view.getText(), is(""));

        controller.onPluginRequest(view.lastPluginID);
        assertThat(view.getText(), is(MOCK_PLUGIN_RESULT));
    }

    // TODO test all methods


}
