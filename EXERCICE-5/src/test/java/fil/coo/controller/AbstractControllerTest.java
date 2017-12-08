package fil.coo.controller;

import fil.coo.model.AbstractModel;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.view.AbstractView;
import org.junit.Before;
import org.junit.Test;
import plugin.Plugin;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public abstract class AbstractControllerTest {


    private static final String MOCK_PLUGIN_RESULT = "mock_result";


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


    private class MockModel extends AbstractModel {
        public MockModel(String pluginRepository) throws IOException {
            super(pluginRepository);
        }
    }

    private class MockView extends AbstractView {

        String lastPluginID;

        String contentText;

        public MockView() {
            contentText = "";
            lastPluginID = "";
        }

        @Override
        public void updateText(String text) {
            this.contentText = text;
        }

        @Override
        public void setVisible(boolean visible) {

        }

        @Override
        public String getText() {
            return contentText;
        }

        @Override
        public void addPlugin(String pluginID, String label) {
            lastPluginID = pluginID;
        }

        @Override
        public void removePlugin(String pluginID) {
            lastPluginID = "";
        }
    }

    public static class MockPlugin implements Plugin {

        @Override
        public String transform(String source) {
            return MOCK_PLUGIN_RESULT;
        }

        @Override
        public String getLabel() {
            return "";
        }

        @Override
        public String helpMessage() {
            return "";
        }
    }
}
