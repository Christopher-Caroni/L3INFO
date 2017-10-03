package fil.coo.resource.pools;

import fil.coo.resource.Resource;
import fil.coo.exception.TooManyResourcesException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ResourcePool<T extends Resource> {

    protected int nbMaxResources;

    protected List<T> resourceList;

    /**
     * @param nbMaxResources the initial and max amount of resources that this pools will hold.
     */
    public ResourcePool(int nbMaxResources) {
        if (nbMaxResources <= 0) {
            throw new IllegalArgumentException("Cannot create pools of 0 resources");
        }
        this.nbMaxResources = nbMaxResources;
        initResources();
    }

    /**
     * Creates the resources that this pools will hold.
     */
    private void initResources() {
        resourceList = new ArrayList<T>();
        for (int i = 0; i < nbMaxResources; i++) {
            resourceList.add(createOneResource());
        }
    }

    /**
     * @return one instance of a <b>T</b> resource
     */
    protected abstract T createOneResource();

    /**
     * @return a resource from the pools
     * @throws NoSuchElementException if no resources are available
     */
    public T provideResource() throws NoSuchElementException {
        if (!resourceList.isEmpty()) {
            T first = resourceList.remove(0);
            return first;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * The pools recovers the resource provided.
     *
     * @param resource the resource that will be recovered
     * @throws IllegalArgumentException  if the resource parameter is incorrect
     * @throws TooManyResourcesException if the pools already contains {@link #nbMaxResources} resources
     */
    public void recoverResource(T resource) throws IllegalArgumentException, TooManyResourcesException {
        if (resource != null) {
            if (resourceList.size() == nbMaxResources) {
                throw new TooManyResourcesException("Cannot add above max number of resources");
            } else {
                resourceList.add(resource);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
