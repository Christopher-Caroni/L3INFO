package fil.coo.actions;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.ResourceUsingActionTest;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resource.Basket;
import fil.coo.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeResourceActionTest extends ResourceUsingActionTest {

    @Override
    protected ResourceUsingAction<Basket> createResourceUsingAction() {
        return new FreeResourceAction<>(this.resourceUser, this.resourcePool);
    }

    @Before
    public void makeResourceUserHaveResourceFromPool() throws TooManyResourcesException {
        Basket basket = null;
        try {
            basket = resourcePool.provideResource();
        } catch (NoFreeResourcesException e) {
            fail("Manual setup must not have error to setup tests");
        }
        resourceUser.setResource(basket);
    }

    @Test
    public void testAfterDoStepUserDoesNotHaveResource() throws ActionFinishedException {
        assertNotNull(resourceUser.getResource());
        resourceUsingAction.doStep();
        assertTrue(resourceUsingAction.isFinished());
        assertNull(resourceUser.getResource());
    }

}