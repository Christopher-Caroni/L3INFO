package fil.coo.client.interfaces;

import fil.coo.exception.TooManyResourcesException;
import fil.coo.resource.Resource;

public class ResourceUser<R extends Resource> {

    protected R resource;

    public R getResource() {
        return resource;
    }

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
