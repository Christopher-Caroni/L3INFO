package fil.coo.view;

import org.junit.Before;

import static org.junit.Assert.*;

public abstract class AbstractViewTest {

    protected AbstractView view;

    @Before
    public void setup() {
        this.view = getSpecificView();
    }

    protected abstract AbstractView getSpecificView();

    // TODO test all methods

}