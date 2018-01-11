package fil.coo.model;

import fil.coo.Mocks.MockController;
import fil.coo.Mocks.MockPlugin;
import fil.coo.Mocks.MockView;
import fil.coo.exception.PluginNotFoundException;
import fil.coo.model.plugins.PluginEvent;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static fil.coo.Mocks.MockPlugin.MOCK_PLUGIN_RESULT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public abstract class AbstractModelTest {

    protected static final Class<MockPlugin> MOCK_PLUGIN_CLASS = MockPlugin.class;

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

    protected MockPlugin getMockPluginInstance() throws IllegalAccessException, InstantiationException {
        return MOCK_PLUGIN_CLASS.newInstance();
    }

    @Test
    public void testOnPluginAddedNotifiesController() {
        assertThat(mockController.totalPlugin, is(0));
        assertThat(mockController.onPluginAddedCounter, is(0));
        assertThat(mockController.onPluginRemovedCounter, is(0));

        model.onPluginAdded(new PluginEvent(MOCK_PLUGIN_CLASS));
        assertThat(mockController.totalPlugin, is(1));
        assertThat(mockController.onPluginAddedCounter, is(1));
        assertThat(mockController.onPluginRemovedCounter, is(0));
    }

    @Test
    public void testOnPluginAddedDoesNothingWhenAlreadyExists() {
        // setup
        assertThat(mockController.totalPlugin, is(0));
        assertThat(mockController.onPluginAddedCounter, is(0));
        assertThat(mockController.onPluginRemovedCounter, is(0));

        model.onPluginAdded(new PluginEvent(MOCK_PLUGIN_CLASS));
        assertThat(mockController.totalPlugin, is(1));
        assertThat(mockController.onPluginAddedCounter, is(1));
        assertThat(mockController.onPluginRemovedCounter, is(0));

        // add again and assert not notified
        model.onPluginAdded(new PluginEvent(MOCK_PLUGIN_CLASS));
        assertThat(mockController.totalPlugin, is(1));
        assertThat(mockController.onPluginAddedCounter, is(1));
        assertThat(mockController.onPluginRemovedCounter, is(0));
    }

    @Test
    public void testOnPluginRemovedNotifiesController() {
        // setup
        assertThat(mockController.totalPlugin, is(0));
        assertThat(mockController.onPluginAddedCounter, is(0));
        assertThat(mockController.onPluginRemovedCounter, is(0));

        model.onPluginAdded(new PluginEvent(MOCK_PLUGIN_CLASS));
        assertThat(mockController.totalPlugin, is(1));
        assertThat(mockController.onPluginAddedCounter, is(1));
        assertThat(mockController.onPluginRemovedCounter, is(0));

        // actual test
        model.onPluginRemoved(new PluginEvent(MOCK_PLUGIN_CLASS));
        assertThat(mockController.totalPlugin, is(0));
        assertThat(mockController.onPluginAddedCounter, is(1));
        assertThat(mockController.onPluginRemovedCounter, is(1));
    }

    @Test
    public void testOnPluginRemovedDoesNothingWhenPluginNotInitiallyAdded() {
        // setup
        assertThat(mockController.totalPlugin, is(0));
        assertThat(mockController.onPluginAddedCounter, is(0));
        assertThat(mockController.onPluginRemovedCounter, is(0));

        model.onPluginRemoved(new PluginEvent(MOCK_PLUGIN_CLASS));
        assertThat(mockController.totalPlugin, is(0));
        assertThat(mockController.onPluginAddedCounter, is(0));
        assertThat(mockController.onPluginRemovedCounter, is(0));
    }

    @Test
    public void testGetPluginTransformationWhenOK() throws PluginNotFoundException, InstantiationException, IllegalAccessException {
        // setup
        model.onPluginAdded(new PluginEvent(MOCK_PLUGIN_CLASS));
        assertThat(mockController.totalPlugin, is(1));
        assertThat(mockController.onPluginAddedCounter, is(1));
        assertThat(mockController.onPluginRemovedCounter, is(0));

//        Get the associated ID so we can then use it to get the transformation
        String mockID = model.getIDAssociatedToPluginClass(getMockPluginInstance());

        String actual = model.getPluginTransformation(mockID, "");
        assertThat(actual, is(MOCK_PLUGIN_RESULT));
    }


    @Test(expected = PluginNotFoundException.class)
    public void testGetPluginTransformationWhenPluginNotInitiallyAdded() throws PluginNotFoundException {

        // Use empty string for plugin ID, same thing as a bad ID, because it hasn't been recorded by the model
        String actual = model.getPluginTransformation("", "");
    }

    @Test
    public void testGetIDAssociatedToPluginClassReturnsActualValue() throws InstantiationException, IllegalAccessException {
        // setup
        model.onPluginAdded(new PluginEvent(MOCK_PLUGIN_CLASS));
        assertThat(mockController.totalPlugin, is(1));
        assertThat(mockController.onPluginAddedCounter, is(1));
        assertThat(mockController.onPluginRemovedCounter, is(0));

        String actualID = model.getIDAssociatedToPluginClass(getMockPluginInstance());
        assertThat(actualID, notNullValue());
    }

    @Test
    public void testGetIDAssociatedToPluginClassReturnsNullWhenPluginNotInitiallyContained() throws InstantiationException, IllegalAccessException {
        String actualID = model.getIDAssociatedToPluginClass(getMockPluginInstance());
        assertThat(actualID, nullValue());
    }

}
