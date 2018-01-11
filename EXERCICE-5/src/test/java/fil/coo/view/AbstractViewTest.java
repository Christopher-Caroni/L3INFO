package fil.coo.view;

import fil.coo.Mocks;
import fil.coo.controller.AbstractController;
import fil.coo.model.AbstractModel;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.*;

public abstract class AbstractViewTest {

    protected AbstractView view;

    @Before
    public void setup() {
        this.view = getSpecificView();
    }

    protected abstract AbstractView getSpecificView();

    @Test
    public void testGetUpdateText() {
        assertThat(view.getText(), is(""));

        String newText = "dummy";
        view.updateText(newText);
        assertThat(view.getText(), is(newText));
    }

    @Test
    public void testSetController() throws IOException {
        assertThat(view.getController(), nullValue());

        Mocks.MockController mockController = new Mocks.MockController(new Mocks.MockModel("repository"), view);
        assertThat(view.getController(), sameInstance(mockController));
    }

    @Test
    public void testAddPlugin() {
        assertThat(view.getCurrentPluginIDs().isEmpty(), is(true));
        String expectedID = "dummyID";

        view.addPlugin(expectedID, "dummyLabel");
        assertThat(view.getCurrentPluginIDs().size(), is(1));
        String actualID = view.getCurrentPluginIDs().get(0);
        assertThat(actualID, is(expectedID));
    }

}