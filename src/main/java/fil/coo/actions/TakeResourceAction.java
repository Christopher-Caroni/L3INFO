package fil.coo.actions;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.client.interfaces.ResourceUser;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.resource.Resource;
import fil.coo.resource.pools.ResourcePool;

/**
 * This class specifies how a {@link ResourceUser} will take resources from a {@link Scheduler}
 *
 * @param <R> the type of {@link Resource} this instance will be dealing with on behalf of the {@link ResourceUser}
 */
public class TakeResourceAction<R extends Resource> extends ResourceUsingAction<R> {

    public TakeResourceAction(ResourceUser<R> resourceUser, ResourcePool<R> resourcePool) {
        super(resourceUser, resourcePool);
    }

    @Override
    protected void execute() {
        R resource = null;
        try {
            resource = resourcePool.provideResource();
        } catch (NoFreeResourcesException e) {
            return;
        }
        resourceUser.setResource(resource);
    }

    @Override
    protected boolean stopCondition() {
        return resourceUser.getResource() != null;
    }
}
