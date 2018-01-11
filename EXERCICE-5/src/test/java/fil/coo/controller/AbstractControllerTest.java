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

    protected static final Class<MockPlugin> MOCK_PLUGIN_CLASS = MockPlugin.class;


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

    protected MockPlugin getMockPluginInstance() throws IllegalAccessException, InstantiationException {
        return MOCK_PLUGIN_CLASS.newInstance();
    }

    @Test
    public void testOnPluginRequestReturnsCorrectPluginEffect() {
        this.model.onPluginAdded(new PluginEvent(MockPlugin.class));
        assertThat(view.lastAddedOrDeletedID, not(""));

        assertThat(view.getText(), is(""));

        controller.onPluginRequest(view.lastAddedOrDeletedID);
        assertThat(view.getText(), is(MOCK_PLUGIN_RESULT));
    }

    @Test
    public void testOnPluginRequestDoesNothingWhenPluginDoesNotExist() {
        assertThat(view.getText(), is(""));

        controller.onPluginRequest(view.lastAddedOrDeletedID);
        assertThat(view.getText(), is(""));
    }

    @Test
    public void testNotifyPluginAddedCallsView() throws InstantiationException, IllegalAccessException {
        String dummyID = "dummy";
        controller.notifyPluginAdded(dummyID, getMockPluginInstance());
        assertThat(view.lastAddedOrDeletedID, is(dummyID));
    }

    @Test(expected = RuntimeException.class)
    public void testNotifyPluginAddedThrowsWithNullID() throws InstantiationException, IllegalAccessException {
        controller.notifyPluginAdded(null, getMockPluginInstance());
    }

    @Test(expected = RuntimeException.class)
    public void testNotifyPluginAddedThrowsWithEmptyID() throws InstantiationException, IllegalAccessException {
        controller.notifyPluginAdded("", getMockPluginInstance());
    }

    @Test
    public void testNotifyPluginRemovedCallsView() {
        String dummyID = "dummy";
        controller.notifyPluginRemoved(dummyID);
        assertThat(view.lastAddedOrDeletedID, is(dummyID));
    }

    @Test(expected = RuntimeException.class)
    public void testNotifyPluginRemovedThrowsWithNullID() {
        controller.notifyPluginRemoved(null);
    }

    @Test(expected = RuntimeException.class)
    public void testNotifyPluginRemovedThrowsWithEmptyID() {
        controller.notifyPluginRemoved("");
    }

}
