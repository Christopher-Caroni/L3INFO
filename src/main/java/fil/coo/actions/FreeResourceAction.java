package fil.coo.actions;

import fil.coo.actions.interfaces.ResourceUsingAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.client.interfaces.ResourceUser;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.ForeignResourceException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resource.Resource;
import fil.coo.resource.pools.ResourcePool;

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
        } catch (TooManyResourcesException | ForeignResourceException e) {
            // This shouldn't ever be thrown
        }
        resourceUser.resetResource();
        System.out.println("free execution success");
    }

    @Override
    protected boolean stopCondition() {
        System.out.println("testing if free finished");
        return resourceUser.getResource() == null;
    }

    @Override
    public String toString() {
        return "FreeResourceAction{" +
                "state=" + state +
                '}';
    }
}
