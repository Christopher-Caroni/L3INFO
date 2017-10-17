package fil.coo.resources.pools;

import fil.coo.resources.resource.Basket;

public class BasketPool extends ResourcePool<Basket>{

	public BasketPool(int nbResources) {
		super(nbResources);
	}

	@Override
	protected Basket createOneResource() {
		return new Basket();
	}

	@Override
	public String getDescription() {
		return "basket pool";
	}
}
