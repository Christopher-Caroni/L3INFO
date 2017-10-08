package fil.coo.client.interfaces;

import fil.coo.resource.Resource;

public class ResourceUser<R extends Resource> {

    protected R resource;

    public R getResource() {
        return resource;
    }

    public void setResource(R resource) {
        this.resource = resource;
    }

    public void resetResource() {
        resource = null;
    }
}
