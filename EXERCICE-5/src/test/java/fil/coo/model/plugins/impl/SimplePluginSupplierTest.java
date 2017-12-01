package fil.coo.model.plugins.impl;

import fil.coo.model.plugins.PluginEmitter;
import fil.coo.model.plugins.PluginEmitterTest;

public class SimplePluginSupplierTest extends PluginEmitterTest {

    @Override
    protected PluginEmitter getPluginEmitter(String dirToWatch) {
        return new SimplePluginSupplier(dirToWatch);
    }
}