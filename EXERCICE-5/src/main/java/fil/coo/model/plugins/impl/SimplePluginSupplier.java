package fil.coo.model.plugins.impl;

import fil.coo.model.plugins.AbstractPluginSupplier;

public class SimplePluginSupplier extends AbstractPluginSupplier {

    /**
     * Starts {@link #fileChecker} in dirToWatch
     *
     * @param dirToWatch the directory to watch plugin for
     */
    public SimplePluginSupplier(String dirToWatch) throws Exception {
        super(dirToWatch);
    }

}
