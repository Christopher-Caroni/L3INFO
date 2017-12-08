package fil.coo.model;

import fil.coo.Mocks.MockController;
import fil.coo.Mocks.MockPlugin;
import fil.coo.Mocks.MockView;
import fil.coo.model.plugins.PluginEvent;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class AbstractModelTest {

    protected AbstractModel model;
    private MockController mockController;
    private MockView mockView;

    @Before
    public void setup() throws IOException {
        model = getSpecificModel("repository");
        mockView = new MockView();
        mockController = new MockController(model, mockView);
    }

    public abstract AbstractModel getSpecificModel(String repository) throws IOException;

    @Test
    public void testAddPlugin() {
        assertThat(mockController.totalPlugin, is(0));
        assertThat(mockController.onPluginAddedCounter, is(0));

        model.onPluginAdded(new PluginEvent(MockPlugin.class));
        assertThat(mockController.totalPlugin, is(1));
        assertThat(mockController.onPluginAddedCounter, is(1));
    }


}
