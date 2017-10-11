package fil.coo.actions.action;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.DuplicateRecoveryException;
import fil.coo.exception.ForeignResourceException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resources.client.ResourceUser;
import fil.coo.resources.pools.ResourcePool;
import fil.coo.resources.resource.interfaces.Resource;

/**
 * This class specifies how a {@link ResourceUser} will give back resources to a {@link Scheduler}
 *
 * @param <R> the type of {@link Resource} this instance will be dealing with on behalf of the {@link ResourceUser}
 */
public class FreeResourceAction<R extends Resource> extends ResourceUsingAction<R> {

    public FreeResourceAction(ResourceUser<R> resourceUser, ResourcePool<R> resourcePool) {
        super(resourceUser, resourcePool);
    }

    @Override
    protected void execute() throws ActionFinishedException {
        try {
            resourcePool.recoverResource(resourceUser.getResource());
        } catch (TooManyResourcesException | ForeignResourceException | DuplicateRecoveryException ignored) {
        }
        resourceUser.resetResource();
    }

    @Override
    protected boolean stopCondition() {
        return resourceUser.getResource() == null;
    }

    @Override
    public String toString() {
        return "FreeResourceAction{" +
                "state=" + state +
                '}';
    }
}
