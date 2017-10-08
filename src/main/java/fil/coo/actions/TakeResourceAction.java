package fil.coo.actions;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.client.interfaces.ResourceUser;
import fil.coo.exception.ActionFinishedException;
import fil.coo.resource.Resource;
import fil.coo.resource.pools.ResourcePool;

/**
 * This class specifies how a {@link ResourceUser} will take resources from a {@link Scheduler}
 *
 * @param <R> the type of {@link Resource} this instance will be dealing with on behalf of the {@link ResourceUser}
 */
public class TakeResourceAction<R extends Resource> extends ResourceUsingAction<R> {

    public TakeResourceAction(ResourceUser<R> resourceUser, ResourcePool resourcePool) {
        super(resourceUser, resourcePool);
    }

    @Override
    protected void execute() throws ActionFinishedException {
        try {
            Resource resource = resourcePool.provideResource();
        } catch (fil.coo.exception.NoFreeResourcesException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean stopCondition() {
        return false;
    }
}
