package fil.coo.resources.pools;

import fil.coo.exception.DuplicateResourceException;
import fil.coo.exception.ForeignResourceException;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resources.resource.interfaces.Resource;

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
    public T provideResource() throws NoFreeResourcesException {
        if (!freeResources.isEmpty()) {
            T first = freeResources.remove(0);
            busyResources.add(first);
            return first;
        } else {
            throw new NoFreeResourcesException("No free resources in " + this.toString());
        }
    }

    /**
     * The pools recovers the resource provided.
     *
     * @param resource the resource that will be recovered
     * @throws IllegalArgumentException   if the resource parameter is incorrect
     * @throws TooManyResourcesException  if the pools already contains {@link #nbMaxResources} resources
     * @throws DuplicateResourceException if the resource has already been recovered
     * @throws ForeignResourceException   if the resource did not belong to the pool originally
     */
    public void recoverResource(T resource) throws IllegalArgumentException, TooManyResourcesException, DuplicateResourceException, ForeignResourceException {
        if (resource == null) {
            throw new IllegalArgumentException();
        } else if (freeResources.size() == nbMaxResources) {
            throw new TooManyResourcesException("Cannot add above max number of resources");
        } else if (freeResources.contains(resource)) {
            throw new DuplicateResourceException("Cannot recover a same resource twice");
        } else if (!busyResources.contains(resource)) {
            throw new ForeignResourceException("Cannot add a resource to a pool that it did not originate from");
        } else {
            busyResources.remove(resource);
            freeResources.add(resource);
        }
    }

    public int getNbAvailableResources() {
        return freeResources.size();
    }

    /**
     *
     * @return a description of what this pool is ex: "cubicle pool"
     */
    public abstract String getDescription();
}
