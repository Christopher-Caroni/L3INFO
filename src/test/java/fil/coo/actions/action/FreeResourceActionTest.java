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

public class FreeResourceActionTest extends ResourceUsingActionTest {

    @Override
    protected ResourceUsingAction<MockResource> getResourceUsingAction(ResourceUser<MockResource> resourceUser, ResourcePool<MockResource> resourcePool) {
        return new FreeResourceAction<>(resourceUser, resourcePool);
    }

    /**
     * We need the resourceUser to have a resource from this instance's resourcePool
     *
     * @param resourceUsingAction the action to prepare
     */
    @Override
    protected void prepareResourceUsingAction(ResourceUsingAction<MockResource> resourceUsingAction) {
        MockResource resource = null;
        try {
            resource = resourcePool.provideResource();
        } catch (NoFreeResourcesException e) {
            fail("Manual setup must not have error to setup tests");
        }
        try {
            resourceUser.setResource(resource);
        } catch (TooManyResourcesException ignored) {
        }
    }

    @Test
    public void testAfterDoStepUserDoesNotHaveResource() throws ActionFinishedException {
        assertNotNull(resourceUser.getResource());
        resourceUsingAction.doStep();
        assertTrue(resourceUsingAction.isFinished());
        assertNull(resourceUser.getResource());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfResourceUserDidNotHaveResourceThrowsException() throws ActionFinishedException, IllegalArgumentException {
        resourceUser.resetResource();
        assertNull(resourceUser.getResource());

        resourceUsingAction.doStep();
        assertFalse(resourceUsingAction.isFinished());
    }

}