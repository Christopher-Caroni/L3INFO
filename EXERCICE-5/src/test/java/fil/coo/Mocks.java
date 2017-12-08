package fil.coo;

import fil.coo.controller.AbstractController;
import fil.coo.model.AbstractModel;
import fil.coo.model.plugins.PluginEvent;
import fil.coo.model.plugins.PluginListener;
import fil.coo.view.AbstractView;
import plugin.Plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mocks {

    public static class MockPluginListener implements PluginListener {

        public int onPluginAddedCounter;
        public int onPluginRemovedCounter;
        public PluginEvent lastEvent;

        public MockPluginListener() {
            onPluginAddedCounter = 0;
            onPluginRemovedCounter = 0;
            lastEvent = null;
        }

        @Override
        public void onPluginAdded(PluginEvent pluginEvent) {
            onPluginAddedCounter++;
            this.lastEvent = pluginEvent;
        }

        @Override
        public void onPluginRemoved(PluginEvent pluginEvent) {
            onPluginRemovedCounter++;
            this.lastEvent = pluginEvent;
        }
    }


    public static class MockController extends AbstractController {

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
            onPluginAddedCounter++;
            totalPlugin++;
        }

        @Override
        public void notifyPluginRemoved(String pluginID) {
            onPluginRemovedCounter++;
            totalPlugin--;
        }
    }


    public static class MockModel extends AbstractModel {
        public MockModel(String pluginRepository) throws IOException {
            super(pluginRepository);
        }
    }

    public static class MockView extends AbstractView {

        public String lastAddedOrDeletedID;

        String contentText;

        public MockView() {
            contentText = "";
            lastAddedOrDeletedID = "";
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
            lastAddedOrDeletedID = pluginID;
        }

        @Override
        public void removePlugin(String pluginID) {
            lastAddedOrDeletedID = pluginID;
        }

        @Override
        protected List<String> getCurrentPluginIDs() {
            return new ArrayList<>();
        }
    }

    public static class MockPlugin implements Plugin {

        public static final String MOCK_PLUGIN_RESULT = "mock_result";

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
