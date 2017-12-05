package fil.coo.model.plugins.impl;

import fil.coo.model.plugins.AbstractPluginSupplier;
import fil.coo.model.plugins.AbstractPluginSupplierTest;

import java.io.IOException;

import static org.junit.Assert.*;

public class SimplePluginSupplierTestSecond extends AbstractPluginSupplierTest {

    @Override
    protected AbstractPluginSupplier getPluginSupplier(String repository) throws IOException {
        return new SimplePluginSupplier(repository);
    }
}