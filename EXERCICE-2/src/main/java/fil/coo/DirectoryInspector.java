package fil.coo;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryInspector {

    private static final Logger logger = Logger.getLogger(DirectoryInspector.class.getSimpleName());

    private FilenameFilter startsWithCFilter;
    private FilenameFilter classFilter;
    private File directory;

    public DirectoryInspector(String filePath) throws IOException {
        initCFilter();
        initClassFilter();
        initDir(filePath);
    }

    private void initDir(String filePath) throws IOException {
        if (filePath == null) {
            throw new NullPointerException("filepath is null");
        }


        directory = new File(filePath);
        if (!directory.isDirectory()) {
            throw new IOException("\"" + filePath + "\" is not a directory");
        }

        logger.debug("Watching " + directory.getAbsolutePath());
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
