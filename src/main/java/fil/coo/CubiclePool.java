package fil.coo;

import java.util.NoSuchElementException;

public class CubiclePool extends ResourcePool<Cubicle> {

    public CubiclePool(int nbResources) {
        super(nbResources);
    }

    protected Cubicle createOneResource() {
        return new Cubicle();
    }
}
