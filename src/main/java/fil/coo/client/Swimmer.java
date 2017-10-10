package fil.coo.client;

import fil.coo.actions.ForeseeableAction;
import fil.coo.actions.FreeResourceAction;
import fil.coo.actions.TakeResourceAction;
import fil.coo.actions.scheduler.SequentialScheduler;
import fil.coo.client.interfaces.ResourceUser;
import fil.coo.resource.Basket;
import fil.coo.resource.Cubicle;
import fil.coo.resource.pools.BasketPool;
import fil.coo.resource.pools.CubiclePool;
import fil.coo.resource.pools.ResourcePool;

public class Swimmer extends SequentialScheduler {

    public Swimmer(String string, BasketPool basketPool, CubiclePool cubiclePool, int timeToUndress, int timeToSwim,
			int timeToDress) {
		// TODO Auto-generated constructor stub
	}
	private ResourceUser<Basket> basketResourceUser;
    private ResourceUser<Cubicle> cubicleResourceUser;
    
    private ResourcePool<Basket> basketPool;
    private ResourcePool<Cubicle> cubiclePool;

    private void initResourceUsers() {
        TakeResourceAction<Basket> basketTakeResourceAction = new TakeResourceAction<>(basketResourceUser, basketPool);
        TakeResourceAction<Cubicle> cubicleTakeResourceAction = new TakeResourceAction<>(cubicleResourceUser,
                cubiclePool);

        FreeResourceAction<Basket> basketFreeResourceAction = new FreeResourceAction<>(basketResourceUser, basketPool);
        FreeResourceAction<Cubicle> cubicleFreeResourceAction = new FreeResourceAction<>(cubicleResourceUser,
                cubiclePool);
    }

    public ResourceUser<Basket> getBasketResourceUser() {
        return basketResourceUser;
    }

    public ResourceUser<Cubicle> getCubicleResourceUser() {
        return cubicleResourceUser;
    }
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
