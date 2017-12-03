package fil.coo;

import java.io.FilenameFilter;
import java.io.IOException;

public class FileCheckerTest extends AbstractFileCheckerTest {
    @Override
    protected FileChecker getSpecificFileChecker(String directoryToWatch, FilenameFilter filenameFilter) throws IOException {
        return new FileChecker(directoryToWatch, filenameFilter);
    }
}
