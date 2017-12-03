package fil.coo.files;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFile extends File {

    public CustomFile(String pathname) {
        super(pathname);
    }


    /**
     * Calls {@link File#list(FilenameFilter)} but will not test the any filenames in filesToIgnore
     *
     * @param filter        the filter to test the files in this dir with
     * @param filesToIgnore the list of files that, if present in this dir, will not be tested again
     * @return the files contained by this directory
     */
    public List<String> list(FilenameFilter filter, List<String> filesToIgnore) {
        String[] contents = super.list();
        if (contents == null) {
            return new ArrayList<>();
        }

        List<String> ogFiles = Arrays.asList(contents);

        return ogFiles.stream()
                .filter(fileName -> filesToIgnore.contains(fileName) || filter.accept(this, fileName))
                .collect(Collectors.toList());
    }
}
