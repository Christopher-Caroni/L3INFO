package fil.coo;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PluginFilterTest {

    protected PluginFilter pluginFilter;
    private static final String GOOD_CLASS_FILE_NAME = "CesarCode.class";
    private static final String CLASS_FOLDER_NAME = "resources/plugins";
    private  static final String CLASS_FILE_NAME = "fake.class";
    private  static final String WRONG_FILE_NAME = "fake";
    private File folder;


    @Before
    public void setupPluginFilter() {
        folder = new File(CLASS_FOLDER_NAME);
        this.pluginFilter = new PluginFilter();
    }


    @Test
    public void testAcceptClassCharged(){
        boolean accepted = pluginFilter.accept(folder, GOOD_CLASS_FILE_NAME);

        assertThat(accepted, is(true));
    }


    @Test
    public void testNotAccept(){
        boolean accepted = pluginFilter.accept(folder, WRONG_FILE_NAME);
        assertThat(accepted, is(false));
    }

    @Test
    public void testNotAcceptClassNotCharged(){
        boolean accepted = pluginFilter.accept(folder, CLASS_FILE_NAME);
        assertThat(accepted, is(false));
    }


}