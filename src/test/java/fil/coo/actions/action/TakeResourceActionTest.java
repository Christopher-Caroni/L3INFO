package fil.coo.actions.action;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.ResourceUsingActionTest;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resources.client.ResourceUser;
import fil.coo.resources.pools.ResourcePool;
import org.junit.Test;

import static org.junit.Assert.*;

public class TakeResourceActionTest extends ResourceUsingActionTest {

    @Override
    protected ResourceUsingAction<MockResource> getResourceUsingAction(ResourceUser<MockResource> resourceUser, ResourcePool<MockResource> resourcePool) {
        return new TakeResourceAction<>(resourceUser, resourcePool);
    }

    @Override
    protected void prepareResourceUsingAction(ResourceUsingAction<MockResource> resourceUsingAction) {
        // No preparations necessary
    }

    @Test
    public void testAfterSuccessfulDoStepResourceUserHasResource() throws ActionFinishedException {
        assertNull(resourceUser.getResource());
        int initialNbFreeResources = resourcePool.getNbAvailableResources();

        resourceUsingAction.doStep();
        assertEquals(initialNbFreeResources - 1, resourcePool.getNbAvailableResources());
        assertTrue(resourceUsingAction.isFinished());
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
        assertFalse(resourceUsingAction.isFinished());
        assertNull(resourceUser.getResource());
    }

    @Test
    public void testDoStepWhenResourceUserAlreadyHasResource() throws TooManyResourcesException, ActionFinishedException {
        MockResource firstResource = new MockResource();
        resourceUser.setResource(firstResource);
        assertSame(firstResource, resourceUser.getResource());
        int initialNbFreeResources = resourcePool.getNbAvailableResources();

        resourceUsingAction.doStep();
        assertSame(firstResource, resourceUser.getResource());
        assertEquals(initialNbFreeResources, resourcePool.getNbAvailableResources());
    }
}