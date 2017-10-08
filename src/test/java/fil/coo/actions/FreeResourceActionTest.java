package fil.coo.actions;

import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.ResourceUsingActionTest;

public class FreeResourceActionTest extends ResourceUsingActionTest {

    @Override
    protected ResourceUsingAction createResourceUsingAction() {
        return new FreeResourceAction(this.resourceUser, this.resourcePool);
    }

    @Override
    protected Action createAction() {
        return createResourceUsingAction();
    }
}