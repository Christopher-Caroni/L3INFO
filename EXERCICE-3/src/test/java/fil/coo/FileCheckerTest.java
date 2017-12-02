package fil.coo;

import org.apache.log4j.Logger;
import org.awaitility.Awaitility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class FileCheckerTest {

    private static final Logger logger = Logger.getLogger(FileCheckerTest.class.getSimpleName());

    private Path rootTestingFolder;

    protected FileChecker fileChecker;
    protected MockFileListener mockFileListener;

    @Before
    public void setup() throws Exception {
        setupTestDir();
        setupFileChecker();
    }

    private void setupTestDir() throws IOException {
        try {
            rootTestingFolder = TestingFileUtils.setupTestDir(Paths.get("testing"), true);
        } catch (IOException e) {
            logger.debug(e);
            throw e;
        }
    }

    private void setupFileChecker() throws Exception {
        // accept all files
        fileChecker = new FileChecker(rootTestingFolder.normalize().toString(), (dir, name) -> true);
        mockFileListener = new MockFileListener();
        fileChecker.addFileListener(mockFileListener);
        fileChecker.start();
    }

    @After
    public void removeTestingDir() {
        TestingFileUtils.deleteDirectory(rootTestingFolder);
    }

    @Test(expected = NullPointerException.class)
    public void testDoesNotAcceptNullDir() throws IOException {
        FileChecker fileChecker = new FileChecker(null, (dir, name) -> true);
    }

    @Test(expected = IOException.class)
    public void testDoesNotAcceptNonDir() throws IOException {
        FileChecker fileChecker = new FileChecker("pom.xml", (dir, name) -> true);
    }

    @Test
    public void testDetectFileAdded() throws IOException {
        final String fileToCreate = "testFile";
        assertThat(mockFileListener.fileAddedCounter, is(0));
        assertThat(mockFileListener.lastEvent, is(nullValue()));

        TestingFileUtils.createFileInDirectory(rootTestingFolder, fileToCreate);


        Awaitility.await()
                .atMost(3, TimeUnit.SECONDS)
                .until(() -> mockFileListener.fileAddedCounter == 1);

        assertThat(mockFileListener.fileAddedCounter, is(1));
        assertThat(mockFileListener.lastEvent.getSource(), is(fileToCreate));
    }

    @Test
    public void testDetectFileDeleted() throws IOException {
        final String fileToCreate = "testFile";

        assertThat(mockFileListener.fileAddedCounter, is(0));
        assertThat(mockFileListener.fileDeletedCounter, is(0));
        assertThat(mockFileListener.lastEvent, is(nullValue()));


//        We need the file that will be deleted to have already been in the memory to be considered as deleted
//        when the event happens, otherwise the filechecker didn't even know it existed
        TestingFileUtils.createFileInDirectory(rootTestingFolder, fileToCreate);
        Awaitility.await()
                .atMost(3, TimeUnit.SECONDS)
                .until(() -> mockFileListener.fileAddedCounter == 1);

        assertThat(mockFileListener.fileAddedCounter, is(1));
        assertThat(mockFileListener.fileDeletedCounter, is(0));
        assertThat(mockFileListener.lastEvent.getSource(), is(fileToCreate));


        /* DELETE */
        TestingFileUtils.deleteFileInDirectory(rootTestingFolder, fileToCreate);
        Awaitility.await()
                .atMost(3, TimeUnit.SECONDS)
                .until(() -> mockFileListener.fileDeletedCounter == 1);

        assertThat(mockFileListener.fileAddedCounter, is(1));
        assertThat(mockFileListener.fileDeletedCounter, is(1));
        assertThat(mockFileListener.lastEvent.getSource(), is(fileToCreate));
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