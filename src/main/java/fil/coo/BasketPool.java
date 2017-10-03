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
	
	@Override
	Basket provideResource() throws NoSuchElementException {
		Basket first;
		if(!resourceList.isEmpty()){
			first = resourceList.remove(0);
		}else{
			throw new NoSuchElementException();
		}
		return first;
	}

	@Override
	void recoverResource(Basket basket) throws IllegalArgumentException {
		throw new IllegalArgumentException();		
	}

	

}
