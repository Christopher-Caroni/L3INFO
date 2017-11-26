package fil.coo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryInspector {

    private FilenameFilter startsWithCFilter;
    private FilenameFilter classFilter;
    private File directory;

    public DirectoryInspector(String filePath) {
        initCFilter();
        initClassFilter();
        directory = new File(filePath);
    }

    private void initCFilter() {
        startsWithCFilter = (dir, s) -> s.startsWith("C") || s.startsWith("c");
    }

    private void initClassFilter() {
        classFilter = (dir, s) -> s.endsWith(".class");
    }

    /**
     * @return all the files that start with "C" or an empty list if an {@link IOException} occurs
     */
    public List<String> getFilesThatStartWithC() {
        String[] list = directory.list(startsWithCFilter);
        return list == null ? new ArrayList<>() : Arrays.asList(list);
    }

    /**
     * @return all the files that end with ".class" or an empty list if an {@link IOException} occurs
     */
    public List<String> getClassFiles() {
        String[] list = directory.list(classFilter);
        return list == null ? new ArrayList<>() : Arrays.asList(list);
    }
}
