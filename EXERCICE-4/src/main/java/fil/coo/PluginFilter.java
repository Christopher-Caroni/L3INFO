package fil.coo;

import java.io.File;
import java.io.FilenameFilter;

/**
 * An implementation of {@link FilenameFilter} that only accepts compiled java .class files
 */
public class PluginFilter implements FilenameFilter {

    @Override
    public boolean accept(File file, String s) {
        // TODO
        return false;
    }

}
