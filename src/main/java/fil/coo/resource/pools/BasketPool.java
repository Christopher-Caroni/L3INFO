package fil.coo.resource.pools;

import fil.coo.resource.Basket;

public class BasketPool extends ResourcePool<Basket>{

	
	
	public BasketPool(int nbResources) {
		super(nbResources);
	}
	@Override
	protected Basket createOneResource() {
		return new Basket();
	}
	

}
