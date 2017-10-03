package fil.coo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ResourcePool<T extends Resource> {

    protected int nbResources;

    protected List<T> resourceList;

    /**
     * @param nbResources the initial amount of resources that this pool will hold.
     */
    public ResourcePool(int nbResources) {
        if (nbResources <= 0) {
            throw new IllegalArgumentException("Cannot create pool of 0 resources");
        }
        this.nbResources = nbResources;
        initResources();
    }

    /**
     * Creates the resources that this pool will hold.
     */
    private void initResources() {
        resourceList = new ArrayList<T>();
        for (int i = 0; i < nbResources; i++) {
            T resource = createOneResource();
        }
    }

    /**
     * @return one instance of a <b>T</b> resource
     */
    protected abstract T createOneResource();

    /**
     * @return a resource from the pool
     * @throws NoSuchElementException if no resources are available
     */
    public T provideResource() throws NoSuchElementException{
    	if(!resourceList.isEmpty()){
    		T first = resourceList.remove(0);
    		return first;
    	}else
    		throw new NoSuchElementException();   		
    }

    /**
     * The pool recovers the resource provided.
     *
     * @param resource the resource that will be recovered
     * @throws IllegalArgumentException  if the resource parameter is incorrect
     */
    public void recoverResource(T resource) throws IllegalArgumentException{
    	if(resource != null)
    		resourceList.add(resource);
    	else
    		throw new IllegalArgumentException();
    }
}
