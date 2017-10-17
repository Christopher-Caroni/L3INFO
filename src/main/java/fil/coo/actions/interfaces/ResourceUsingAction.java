package fil.coo.actions.interfaces;

import fil.coo.resources.client.ResourceUser;
import fil.coo.resources.resource.interfaces.Resource;
import fil.coo.resources.pools.ResourcePool;

/**
 * This type of action acts upon a type R of resource(s)
 *
 * @param <R> the type of {@link Resource} this instance will be using
 */
public abstract class ResourceUsingAction<R extends Resource> extends Action {

    protected ResourceUser<R> resourceUser;
    protected ResourcePool<R> resourcePool;

    public ResourceUsingAction(ResourceUser<R> resourceUser, ResourcePool<R> resourcePool) {
        this.resourceUser = resourceUser;
        this.resourcePool = resourcePool;
    }


    public String getActionExecutionTrace(String schedulerName) {
        return schedulerName + " trying to "+ getActionType() + " resource from " + resourcePool.getDescription() +
                "... " +
                "" +
                getExecutionStatus();
    }

    protected abstract String getActionType();

    protected String getExecutionStatus() {
        return isFinished() ? "success" : "failed";
    }

}
