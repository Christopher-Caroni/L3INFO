package fil.coo.resource.pools;

import fil.coo.exception.ForeignResourceException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resource.Resource;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ResourcePool<T extends Resource> {

    protected int nbMaxResources;

    protected List<T> freeResources;
    protected List<T> busyResources;

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
        freeResources = new LinkedList<T>();
        busyResources = new LinkedList<T>();
        for (int i = 0; i < nbMaxResources; i++) {
            freeResources.add(createOneResource());
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
        if (!freeResources.isEmpty()) {
            T first = freeResources.remove(0);
            busyResources.add(first);
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
     * @throws ForeignResourceException  if the resource did not belong to the pool originally
     */
    public void recoverResource(T resource) throws IllegalArgumentException, TooManyResourcesException, ForeignResourceException {
        if (resource != null) {
            if (freeResources.size() == nbMaxResources) {
                throw new TooManyResourcesException("Cannot add above max number of resources");
            } else {
                if (busyResources.contains(resource)) {
                    busyResources.remove(resource);
                    freeResources.add(resource);
                } else {
                    throw new ForeignResourceException("Cannot add a resource to a pool that it did not originate from");
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
