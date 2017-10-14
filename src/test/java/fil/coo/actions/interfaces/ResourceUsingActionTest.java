package fil.coo.actions.interfaces;

import fil.coo.resources.client.ResourceUser;
import fil.coo.resources.pools.ResourcePool;
import fil.coo.resources.resource.interfaces.Resource;
import org.junit.Before;

public abstract class ResourceUsingActionTest extends SingleStepActionTest {

    protected static final int NB_RESOURCES = 2;

    protected ResourceUsingAction<MockResource> resourceUsingAction;
    protected ResourceUser<MockResource> resourceUser;
    protected ResourcePool<MockResource> resourcePool;

    @Before
    public void setupResourceUsingAction() {
        this.resourceUsingAction = this.initResourceUsingAction();
    }

    protected ResourceUsingAction<MockResource> initResourceUsingAction() {
        resourceUser = getResourceResourceUser();
        resourcePool = getResourcePool();

        ResourceUsingAction<MockResource> resourceUsingAction = getResourceUsingAction(resourceUser, resourcePool);
        prepareResourceUsingAction(resourceUsingAction);

        return resourceUsingAction;
    }

    protected abstract ResourceUsingAction<MockResource> getResourceUsingAction(ResourceUser<MockResource> resourceUser, ResourcePool<MockResource> resourcePool);

    /**
     * Do any preparations necessary for the resourceUsingAction. For example, the {@link fil.coo.actions.action.FreeResourceAction}
     * can only be executed if the user already has a resource from the pool
     *
     * @param resourceUsingAction the action to prepare
     */
    protected abstract void prepareResourceUsingAction(ResourceUsingAction<MockResource> resourceUsingAction);

    private ResourceUser<MockResource> getResourceResourceUser() {
        return new ResourceUser<>();
    }

    private ResourcePool<MockResource> getResourcePool() {
        return new MockPool(NB_RESOURCES);
    }


    @Override
    protected Action createAction() {
        resourceUser = getResourceResourceUser();
        resourcePool = getResourcePool();
        return initResourceUsingAction();
    }

    public class MockResource implements Resource {

        @Override
        public String description() {
            return "Mock Resource";
        }
    }

    protected class MockPool extends ResourcePool<MockResource> {

        /**
         * @param nbMaxResources the initial and max amount of resources that this pools will hold.
         */
        public MockPool(int nbMaxResources) {
            super(nbMaxResources);
        }

        @Override
        protected MockResource createOneResource() {
            return new MockResource();
        }
    }

}