package fil.coo;

import org.junit.Test;

public class FileCheckerTest {

    protected FileChecker fileChecker;

    @Test
    public void testDetectFileAdded() {
        // TODO
    }

    @Test
    public void testDetectFileDeleted() {
        // TODO
    }


    protected class MockFileListener implements FileListener {

        private int fileAddedCounter;
        private int fileDeletedCounter;
        private FileEvent lastEvent;

        @Override
        public void fileAdded(FileEvent event) {
            fileAddedCounter++;
            lastEvent = event;
        }

        @Override
        public void fileRemoved(FileEvent event) {
            fileDeletedCounter++;
            lastEvent = event;
        }
    }

}