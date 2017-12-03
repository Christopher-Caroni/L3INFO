package fil.coo.files;

import fil.coo.FileChecker;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

public class CustomFileChecker extends FileChecker {

    public CustomFileChecker(String directoryToWatch, FilenameFilter filenameFilter) throws IOException {
        super(directoryToWatch, filenameFilter);
    }

    @Override
    protected File createDirFile(String directoryToWatch) {
        return new CustomFile(directoryToWatch);
    }

    @Override
    protected List<String> getFileContents() {
        return ((CustomFile) dirFile).list(this.filenameFilter, this.memory);
    }
}
