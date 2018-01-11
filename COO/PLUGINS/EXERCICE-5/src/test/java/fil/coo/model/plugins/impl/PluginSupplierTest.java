package fil.coo.model.plugins.impl;

import fil.coo.FileEvent;
import fil.coo.model.plugins.AbstractPluginEmitter;
import fil.coo.model.plugins.AbstractPluginEmitterTest;
import fil.coo.model.plugins.impl.PluginSupplier;
import org.junit.Before;
import org.junit.Test;
import plugin.Plugin;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class PluginSupplierTest extends AbstractPluginEmitterTest {

    public static final String CESAR_CODE = "CesarCode";
    public static final String CESAR_CODE_CLASS = CESAR_CODE + ".class";
    public static final String PLUGIN_PACKAGE = "plugin.";


    protected PluginSupplier pluginSupplier;

    @Before
    public void setupSupplier() throws IOException {
        this.pluginSupplier = new PluginSupplier("repository");
    }

    @Override
    protected AbstractPluginEmitter getPluginEmitter(String dirToWatch) throws IOException {
        return new PluginSupplier(dirToWatch);
    }

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