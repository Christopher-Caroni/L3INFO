package fil.coo;

import org.apache.log4j.Logger;
import plugins.CesarCode;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

/**
 * An implementation of {@link FilenameFilter} that only accepts compiled java .class files
 */
public class PluginFilter implements FilenameFilter {

    private Logger logger = Logger.getLogger(PluginFilter.class.getSimpleName());

    private static final String EXTENSION_CLASS = ".class";


    @Override
    public boolean accept(File file, String s) {
        // TODO

        Class<?> aClass = canBeInstantiate(s);
        boolean classExists = aClass != null;


        return endWithClass(s) && classExists && canGetConstructor(aClass);
    }

    private boolean canGetConstructor(Class<?> s) {

        try {
            Constructor<?> constructor = s.getConstructor(null);
        } catch (NoSuchMethodException e) {
            return false;
        }

        return true;
    }

    private Class<?> canBeInstantiate(String s) {
        Class<?> c;
        try {
            c = Class.forName("plugins." + getClassName(s));
        } catch (ClassNotFoundException | ClassFormatError e) {
            logger.debug(e);
            return null;
        }
        return c;
    }

    private String getClassName(String s) {
        if(!(s.length() > EXTENSION_CLASS.length())){
            return null;
        }
        return s.substring(0, s.length() - EXTENSION_CLASS.length());
    }

    private boolean endWithClass(String s) {
        return s.endsWith(EXTENSION_CLASS);
    }

}
