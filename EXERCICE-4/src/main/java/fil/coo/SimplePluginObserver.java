package fil.coo;

import org.apache.log4j.Logger;

public class SimplePluginObserver implements FileListener {

    private static final Logger logger = Logger.getLogger(SimplePluginObserver.class.getSimpleName());

    private FileChecker fileChecker;

    public SimplePluginObserver() {
        fileChecker = new FileChecker("resources", new PluginFilter());
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

    private void start() {
        fileChecker.start();
    }

    public static void main(String[] args) {
        SimplePluginObserver simplePluginObserver = new SimplePluginObserver();
        simplePluginObserver.start();
        while (true) ;
    }
}
