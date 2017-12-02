package fil.coo;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DirectoryInspectorTest {

    private static final Logger logger = Logger.getLogger(DirectoryInspector.class.getSimpleName());


    private static final String FILENAME_STARTS_WITH_C = "Cexample.test";
    private static final String FILENAME_ENDS_WITH_CLASS = "example.class";


    private DirectoryInspector directoryInspector;

    /**
     * The path of the newly created testing folder
     */
    private Path tempRootDirPath;

    /**
     * Creates a temp dir in the default system temporary directory and temporary files in our temp dir.
     */
    @Before
    public void setupTestDir() throws Exception {

        List<String> files = Arrays.asList(FILENAME_STARTS_WITH_C, FILENAME_ENDS_WITH_CLASS);

        try {
            tempRootDirPath = TestingFileUtils.setupTestDir(Paths.get("testing"), files, true);
            logger.debug("created test dir: " + tempRootDirPath.toAbsolutePath().toString());
        } catch (IOException e) {
            logger.debug(e);
        }


        directoryInspector = new DirectoryInspector(tempRootDirPath.toAbsolutePath().toString());
    }

    @After
    public void deleteTempFilesAndFolder() {
        TestingFileUtils.deleteContentsOfDirectory(tempRootDirPath);
        TestingFileUtils.deleteFile(tempRootDirPath);
    }

    @Test(expected = NullPointerException.class)
    public void testDoesNotAcceptNullDir() throws Exception {
        DirectoryInspector directoryInspector = new DirectoryInspector(null);
    }

    @Test(expected = IOException.class)
    public void testDoesNotAcceptNonDir() throws Exception {
        DirectoryInspector directoryInspector = new DirectoryInspector("pom.xml");
    }

    @Test
    public void getFilesThatStartWithC() throws Exception {
        List<String> files = directoryInspector.getFilesThatStartWithC();

        assertThat(files.size(), is(1));
        assertThat(files.get(0), is(FILENAME_STARTS_WITH_C));
    }

    @Test
    public void getClassFiles() throws Exception {
        List<String> files = directoryInspector.getClassFiles();

        assertThat(files.size(), is(1));
        assertThat(files.get(0), is(FILENAME_ENDS_WITH_CLASS));
    }

}