package fil.coo.view.impl;

import fil.coo.view.AbstractView;
import fil.coo.view.AbstractViewTest;

import static org.junit.Assert.*;

public class EditorFrameTest extends AbstractViewTest {
    @Override
    protected AbstractView getSpecificView() {
        return new EditorFrame();
    }

}