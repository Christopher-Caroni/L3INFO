package fil.coo.actions;

import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.ResourceUsingActionTest;

public class TakeResourceActionTest extends ResourceUsingActionTest {

    @Override
    protected ResourceUsingAction createResourceUsingAction() {
        return new TakeResourceAction(this.resourceUser, this.resourcePool);
    }
}