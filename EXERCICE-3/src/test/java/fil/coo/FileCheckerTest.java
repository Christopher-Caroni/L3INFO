package fil.coo;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class FileCheckerTest {

    private static final Logger logger = Logger.getLogger(FileCheckerTest.class.getSimpleName());

    private Path rootTestingFolder;

    protected FileChecker fileChecker;
    protected MockFileListener mockFileListener;

    @Before
    public void setup() {
        setupTestDir();
        setupFileChecker();
    }

    private void setupTestDir() {
        try {
            rootTestingFolder = TestingFileUtils.setupTestDir(Paths.get("testing"), true);
        } catch (IOException e) {
            logger.debug(e);
        }
    }

    private void setupFileChecker() {
        // accept all files
        fileChecker = new FileChecker((dir, name) -> true);
        mockFileListener = new MockFileListener();
        fileChecker.addFileListener(mockFileListener);
    }

    @After
    public void removeTestingDir() {
        TestingFileUtils.deleteDirectory(rootTestingFolder);
    }

    @Test
    public void testDetectFileAdded() {
        assertThat(mockFileListener.fileAddedCounter, is(0));
        assertThat(mockFileListener.lastEvent, is(nullValue()));

        // TODO
    }

    @Test
    public void testDetectFileDeleted() {
        // TODO
    }


    protected class MockFileListener implements FileListener {

        protected int fileAddedCounter;
        protected int fileDeletedCounter;
        protected FileEvent lastEvent;

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