package fil.coo.actions.interfaces;

import fil.coo.client.interfaces.ResourceUser;
import fil.coo.resource.Resource;

/**
 * This type of action acts upon a type R of resource(s)
 *
 * @param <R> the type of {@link Resource} this instance will be using
 */
public abstract class ResourceUsingAction<R extends Resource> extends Action {

    protected ResourceUser<R> resourceUser;
    protected Scheduler scheduler;

    public ResourceUsingAction(ResourceUser<R> resourceUser, Scheduler scheduler) {
        this.resourceUser = resourceUser;
        this.scheduler = scheduler;
    }

}
