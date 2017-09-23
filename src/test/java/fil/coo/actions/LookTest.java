package fil.coo.actions;

import static org.junit.Assert.assertTrue;

public class LookTest extends AlwaysAvailableActionTest {

    @Override
    protected Action getAction() {
        return new Look();
    }

}