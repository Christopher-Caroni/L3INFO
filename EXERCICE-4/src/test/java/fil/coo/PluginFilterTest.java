package fil.coo;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PluginFilterTest {

    protected PluginFilter pluginFilter;
    protected static final String CLASS_FOLDER_NAME = "resources";
    protected  static final String CLASS_FILE_NAME = "CesarCode.class";
    private File folder;


    @Before
    public void setupPluginFilter() {
        folder = new File(CLASS_FOLDER_NAME);
        this.pluginFilter = new PluginFilter();
    }

    @Test
    public void testAccept(){
        boolean accepted = pluginFilter.accept(folder, CLASS_FILE_NAME);
        assertThat(accepted, is(true));
    }


}