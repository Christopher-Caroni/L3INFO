package fil.coo;

import org.apache.log4j.Logger;

import java.io.IOException;

public class SimplePluginObserver implements FileListener {

    private static final Logger logger = Logger.getLogger(SimplePluginObserver.class.getSimpleName());

    private FileChecker fileChecker;

    public SimplePluginObserver(String dirToWatch) throws IOException {
        fileChecker = new FileChecker(dirToWatch, new PluginFilter());
        fileChecker.addFileListener(this);
    }

    @Override
    public void fileAdded(FileEvent event) {
        logger.info("Plugin " + event.getSource() + " added");
    }

    @Override
    public void fileRemoved(FileEvent event) {
        logger.info("Plugin " + event.getSource() + " removed");
    }

    public void start() {
        fileChecker.start();
    }
}
