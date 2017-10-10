package fil.coo.client;

import fil.coo.actions.ForeseeableAction;
import fil.coo.actions.scheduler.SequentialScheduler;
import fil.coo.client.interfaces.ResourceUser;
import fil.coo.resource.Basket;
import fil.coo.resource.Cubicle;
import fil.coo.resource.pools.BasketPool;
import fil.coo.resource.pools.CubiclePool;

public class Swimmer extends SequentialScheduler {

    public Swimmer(String string, BasketPool basketPool, CubiclePool cubiclePool, int timeToUndress, int timeToSwim,
			int timeToDress) {
		// TODO Auto-generated constructor stub
	}
	private ResourceUser<Basket> basketResourceUser;
    private ResourceUser<Cubicle> cubicleResourceUser;
    
	public ForeseeableAction getUndressAction() {
		// TODO Auto-generated method stub
		return null;
	}
	public ForeseeableAction getSwimAction() {
		// TODO Auto-generated method stub
		return null;
	}
	public ForeseeableAction getDressAction() {
		// TODO Auto-generated method stub
		return null;
	}


}
