package fil.coo.resource.pools;

import fil.coo.resource.Cubicle;

public class CubiclePool extends ResourcePool<Cubicle> {

    public CubiclePool(int nbResources) {
        super(nbResources);
    }

    protected Cubicle createOneResource() {
        return new Cubicle();
    }
}
