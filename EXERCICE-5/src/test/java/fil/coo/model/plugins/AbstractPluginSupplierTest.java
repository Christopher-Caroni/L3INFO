package fil.coo.model.plugins;

import fil.coo.FileEvent;
import org.junit.Before;
import org.junit.Test;
import plugin.Plugin;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public abstract class AbstractPluginSupplierTest {

    public static final String CESAR_CODE = "CesarCode";
    public static final String CESAR_CODE_CLASS = CESAR_CODE + ".class";
    public static final String PLUGIN_PACKAGE = "plugin.";


    protected AbstractPluginSupplier pluginSupplier;

    @Before
    public void setupSupplier() throws IOException {
        this.pluginSupplier = getPluginSupplier("repository");
    }

    protected abstract AbstractPluginSupplier getPluginSupplier(String repository) throws IOException;

    @Test
    public void testGetPluginClassReturnsGoodInstance() {
        Class<? extends Plugin> expectedClass = null;
        try {
            expectedClass = (Class<? extends Plugin>) Class.forName(PLUGIN_PACKAGE + CESAR_CODE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<? extends Plugin> pluginClass = pluginSupplier.getPluginClass(new FileEvent(CESAR_CODE_CLASS));

        assertThat(pluginClass.getCanonicalName(), is(expectedClass.getCanonicalName()));
    }

    @Test
    public void testGetPluginClassWithBadNameIsNull() {
        Class<? extends Plugin> pluginClass = pluginSupplier.getPluginClass(new FileEvent("FakeClass.class"));
        assertThat(pluginClass, is(nullValue()));
    }

    @Test
    public void testExtractPluginClassNameWithGoodName() {
        String expectedName = PLUGIN_PACKAGE + CESAR_CODE;
        String result = pluginSupplier.extractPluginClassName(CESAR_CODE_CLASS, PLUGIN_PACKAGE);

        assertThat(result, is(expectedName));
    }

}