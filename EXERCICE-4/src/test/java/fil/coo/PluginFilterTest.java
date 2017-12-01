package fil.coo;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PluginFilterTest {

    private static final String RELATIVE_CLASS_FOLDER_NAME = "resources/plugin";

    private static final String FILE_WITHOUT_CLASS_EXTENSION = "fake";
    private static final String FILE_WITHOUT_CONSTRUCTOR = "FakeWithoutEmptyConstructor.class";
    private static final String FILE_WITH_CONSTRUCTOR = "CesarCode.class";

    private PluginFilter pluginFilter;
    private File folder;

    @Before
    public void setupPluginFilter() {
        folder = new File(RELATIVE_CLASS_FOLDER_NAME);
        this.pluginFilter = new PluginFilter();
    }

    @Test
    public void testDoesNotAcceptWithWrongExtension() {
        boolean accepted = pluginFilter.accept(folder, FILE_WITHOUT_CLASS_EXTENSION);
        assertThat(accepted, is(false));
    }

    @Test
    public void testDoesAcceptClassWithGoodNameAndConstructor() {
        boolean accepted = pluginFilter.accept(folder, FILE_WITH_CONSTRUCTOR);
        assertThat(accepted, is(true));
    }

    @Test
    public void testDoesNotAcceptClassWithoutConstructor() {
        boolean accepted = pluginFilter.accept(folder, FILE_WITHOUT_CONSTRUCTOR);
        assertThat(accepted, is(false));
    }

}