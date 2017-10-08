package fil.coo.actions;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.ResourceUsingActionTest;
import fil.coo.resource.Basket;

public class FreeResourceActionTest extends ResourceUsingActionTest {

    @Override
    protected ResourceUsingAction<Basket> createResourceUsingAction() {
        return new FreeResourceAction<>(this.resourceUser, this.resourcePool);
    }

}