package fil.coo.run;

import fil.coo.FileEvent;
import fil.coo.FileListener;
import org.apache.log4j.Logger;

public class PrintListener implements FileListener {

    private static final Logger logger = Logger.getLogger(PrintListener.class.getSimpleName());

    @Override
    public void fileAdded(FileEvent event) {
        logger.info("New .class detected: \"" + event.getSource() + "\"");
    }

    @Override
    public void fileRemoved(FileEvent event) {
        logger.info(".class deleted: \"" + event.getSource() + "\"");
    }
}
