package fil.coo;

import java.util.NoSuchElementException;

public class BasketPool extends ResourcePool<Basket>{

	
	
	public BasketPool(int nbResources) {
		super(nbResources);
	}
	@Override
	protected Basket createOneResource() {
		return new Basket();
	}
	

}
