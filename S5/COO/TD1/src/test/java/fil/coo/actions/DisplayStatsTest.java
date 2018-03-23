package fil.coo.actions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DisplayStatsTest extends AlwaysAvailableActionTest {

    @Override
    protected Action getAction() {
        return new DisplayStats();
    }

}