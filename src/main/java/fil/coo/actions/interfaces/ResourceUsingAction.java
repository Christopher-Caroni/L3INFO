package fil.coo.actions.interfaces;

import fil.coo.client.interfaces.ResourceUser;
import fil.coo.exception.ActionFinishedException;
import fil.coo.resource.Resource;
import fil.coo.resource.pools.ResourcePool;

/**
 * This type of action acts upon a type R of resource(s)
 *
 * @param <R> the type of {@link Resource} this instance will be using
 */
public abstract class ResourceUsingAction<R extends Resource> extends Action {

    protected ResourceUser<R> resourceUser;
    protected ResourcePool<R> resourcePool;

    protected R resource;

    public ResourceUsingAction(ResourceUser<R> resourceUser, ResourcePool<R> resourcePool) {
        this.resourceUser = resourceUser;
        this.resourcePool = resourcePool;
    }

}
