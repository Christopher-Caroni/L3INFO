package fil.coo;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FilenameFilter;

/**
 * An implementation of {@link FilenameFilter} that only accepts compiled java .class files
 */
public class PluginFilter implements FilenameFilter {

    private Logger logger = Logger.getLogger(PluginFilter.class.getSimpleName());

    private static final String EXTENSION_CLASS = ".class";


    @Override
    public boolean accept(File file, String s) {
        // TODO

        return endWithClass(s) && canBeInstantiate(s);
    }

    private boolean canBeInstantiate(String s) {
        String className = s.substring(0, s.length()-EXTENSION_CLASS.length());
        try {
            Class<?> c = Class.forName("plugins."+className);
        } catch (ClassNotFoundException e) {
            logger.debug(e);
            return false;
        }
        return true;
    }

    private boolean endWithClass(String s) {
        return s.endsWith(EXTENSION_CLASS);
    }

}
