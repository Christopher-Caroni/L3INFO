package fil.coo.model.impl;

import fil.coo.model.AbstractModel;
import fil.coo.model.AbstractModelTest;

import java.io.IOException;

public class SimpleModelTest extends AbstractModelTest {

    @Override
    public AbstractModel getSpecificModel(String repository) throws IOException {
        return new SimpleModel(repository);
    }

}