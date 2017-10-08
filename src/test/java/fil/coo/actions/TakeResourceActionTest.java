package fil.coo.actions;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.ResourceUsingActionTest;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.resource.Basket;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TakeResourceActionTest extends ResourceUsingActionTest {

    @Override
    protected ResourceUsingAction<Basket> createResourceUsingAction() {
        return new TakeResourceAction<>(this.resourceUser, this.resourcePool);
    }

    @Test
    public void testAfterSuccessfulDoStepResourceUserHasResource() throws ActionFinishedException {
        assertNull(resourceUser.getResource());
        resourceUsingAction.doStep();
        assertNotNull(resourceUser.getResource());
    }

    @Test
    public void testAfterFailedDoStepResourceUserStillDoesNotHaveResource() throws NoFreeResourcesException, ActionFinishedException {
        for (int i = 0; i < NB_RESOURCES; i++) {
            // empty the pool
            resourcePool.provideResource();
        }

        assertNull(resourceUser.getResource());
        resourceUsingAction.doStep();
        assertNull(resourceUser.getResource());
    }
}