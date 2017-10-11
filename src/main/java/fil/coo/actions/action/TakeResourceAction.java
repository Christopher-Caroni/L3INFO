package fil.coo.actions.action;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.resources.client.ResourceUser;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resources.resource.interfaces.Resource;
import fil.coo.resources.pools.ResourcePool;

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
        try {
            resourceUser.setResource(resource);
        } catch (TooManyResourcesException ignored) {
            // TODO cant override exceptions from inherited method
        }
    }

    @Override
    protected boolean stopCondition() {
        return resourceUser.getResource() != null;
    }

    @Override
    public String toString() {
        return "TakeResourceAction{" +
                "state=" + state +
                '}';
    }
}
