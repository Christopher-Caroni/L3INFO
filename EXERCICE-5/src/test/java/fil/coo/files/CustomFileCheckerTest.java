package fil.coo.files;

import fil.coo.FileChecker;
import fil.coo.AbstractFileCheckerTest;
import org.apache.log4j.Logger;

import java.io.FilenameFilter;
import java.io.IOException;

public class CustomFileCheckerTest extends AbstractFileCheckerTest {

    private static final Logger logger = Logger.getLogger(CustomFileCheckerTest.class.getSimpleName());

    @Override
    protected FileChecker getSpecificFileChecker(String directoryToWatch, FilenameFilter filenameFilter) throws IOException {
        return new CustomFileChecker(directoryToWatch, filenameFilter);
    }

}