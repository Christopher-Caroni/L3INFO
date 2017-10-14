package fil.coo.actions.action;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.exception.DuplicateResourceException;
import fil.coo.exception.ForeignResourceException;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resources.client.ResourceUser;
import fil.coo.resources.pools.ResourcePool;
import fil.coo.resources.resource.interfaces.Resource;

/**
 * This class specifies how a {@link ResourceUser} will take resources from a {@link Scheduler}
 *
 * @param <R> the type of {@link Resource} this instance will be dealing with on behalf of the {@link ResourceUser}
 */
public class TakeResourceAction<R extends Resource> extends ResourceUsingAction<R> {

    public TakeResourceAction(ResourceUser<R> resourceUser, ResourcePool<R> resourcePool) {
        super(resourceUser, resourcePool);
    }

    /**
     * Attempts to take a resource from the {@link #resourcePool}. If it can, it tries to call {@link ResourceUser#setResource(Resource)}. If this method throws,
     * {@link TooManyResourcesException} make the resourcePool recover the resource.
     */
    @Override
    protected void execute() {
        R resource = null;
        try {
            resource = resourcePool.provideResource(); // throws NoFreeResourcesException
            resourceUser.setResource(resource); // throws TooManyResourcesException
        } catch (NoFreeResourcesException e) {
            // do nothing
        } catch (TooManyResourcesException e) {
            // if the user already had a resource, make the pool recover the resource we just got from it
            try {
                resourcePool.recoverResource(resource);
            } catch (TooManyResourcesException | DuplicateResourceException | ForeignResourceException ignored) {
            }
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
