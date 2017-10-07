package fil.coo;

import java.util.NoSuchElementException;

public class CubiclePool extends ResourcePool<Cubicle> {

    public CubiclePool(int nbResources) {
        super(nbResources);
    }

    protected Cubicle createOneResource() {
        return new Cubicle();
    }

    @Override
	public Cubicle provideResource() throws NoSuchElementException {
        if (!resourceList.isEmpty()) {
            Cubicle first = resourceList.get(0);
            resourceList.remove(first);
            return first;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void recoverResource(Cubicle resource) throws IllegalArgumentException {
        if (resource == null) {
            throw new IllegalArgumentException("Cannot recover a null resource");
        } else {
            resourceList.add(resource);
        }
    }
}
