package fil.coo.resources.client;

import fil.coo.exception.TooManyResourcesException;
import fil.coo.resources.resource.interfaces.Resource;

public class ResourceUser<R extends Resource> {

    protected R resource;

    public R getResource() {
        return resource;
    }

    /**
     * Sets {@link #resource} to the one passed in parameter
     *
     * @param resource the {@link Resource} that this instance will hold
     * @throws TooManyResourcesException if this instance already has a resource in {@link #resource}
     */
    public void setResource(R resource) throws TooManyResourcesException {
        if (this.resource != null) {
            throw new TooManyResourcesException("This ResourceUser already has a resource");
        }
        this.resource = resource;
    }

    public void resetResource() {
        resource = null;
    }
}
