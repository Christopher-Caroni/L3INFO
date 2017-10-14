package fil.coo.actions.action;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.exception.DuplicateResourceException;
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

    /**
     * Frees the resource from the {@link #resourceUser} and gives it back to {@link #resourcePool}
     *
     * @throws IllegalArgumentException if the Resource to free and recover in the pool is null. Is not declared in super method because it is an unchecked exception.
     */
    @Override
    protected void execute() throws IllegalArgumentException {
        try {
            resourcePool.recoverResource(resourceUser.getResource()); // throws IllegalArgumentException
            resourceUser.resetResource();
        } catch (TooManyResourcesException | ForeignResourceException | DuplicateResourceException ignored) {
        }
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
