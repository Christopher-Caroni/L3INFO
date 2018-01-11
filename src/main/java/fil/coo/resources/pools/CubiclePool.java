package fil.coo.resources.pools;

import fil.coo.resources.resource.Cubicle;

public class CubiclePool extends ResourcePool<Cubicle> {

    public CubiclePool(int nbResources) {
        super(nbResources);
    }

    protected Cubicle createOneResource() {
        return new Cubicle();
    }

    @Override
    public String getDescription() {
        return "cubicle pool";
    }
}
