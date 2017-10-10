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

    private final String name;
    private TakeResourceAction<Basket> basketTakeResourceAction;
    private TakeResourceAction<Cubicle> cubicleTakeResourceAction;
    private FreeResourceAction<Basket> basketFreeResourceAction;
    private FreeResourceAction<Cubicle> cubicleFreeResourceAction;

    private ResourceUser<Basket> basketResourceUser;
    private ResourceUser<Cubicle> cubicleResourceUser;

    private ResourcePool<Basket> basketPool;
    private ResourcePool<Cubicle> cubiclePool;
    private final int timeToUndress;
    private final int timeToSwim;
    private final int timeToDress;

    private ForeseeableAction swimAction;
    private ForeseeableAction dressAction;
    private ForeseeableAction undressAction;

    public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool, int timeToUndress, int timeToSwim,
                   int timeToDress) {

        this.name = name;
        this.basketPool = basketPool;
        this.cubiclePool = cubiclePool;
        this.timeToUndress = timeToUndress;
        this.timeToSwim = timeToSwim;
        this.timeToDress = timeToDress;

        initResourceUsers();
        initActionList();
    }

    /**
     * Create the {@link ResourceUser} for the baskets and cubicles
     */
    private void initResourceUsers() {
        basketResourceUser = new ResourceUser<>();
        cubicleResourceUser = new ResourceUser<>();
    }

    /**
     * Add the predefined actions that all swimmers will do
     */
    private void initActionList() {

        initForeseeableActions();
        initTakeFreeResourceAction();

        actions.add(basketTakeResourceAction);
        actions.add(cubicleTakeResourceAction);

        // undress
        actions.add(undressAction);
        actions.add(cubicleFreeResourceAction);

        // swim
        actions.add(swimAction);
        actions.add(cubicleTakeResourceAction);

        // dress
        actions.add(dressAction);
        actions.add(basketFreeResourceAction);
        actions.add(cubicleFreeResourceAction);
    }

    /**
     * Creates the actions to take and free the basket/cubicle resources.
     */
    private void initTakeFreeResourceAction() {
        basketTakeResourceAction = new TakeResourceAction<>(basketResourceUser, basketPool);
        cubicleTakeResourceAction = new TakeResourceAction<>(cubicleResourceUser,
                cubiclePool);

        basketFreeResourceAction = new FreeResourceAction<>(basketResourceUser, basketPool);
        cubicleFreeResourceAction = new FreeResourceAction<>(cubicleResourceUser,
                cubiclePool);
    }

    /**
     * Create the actions to  undress, swim and dress.
     */
    private void initForeseeableActions() {
        undressAction = new ForeseeableAction(timeToUndress);
        swimAction = new ForeseeableAction(timeToSwim);
        dressAction = new ForeseeableAction(timeToDress);

    }

    public ResourceUser<Basket> getBasketResourceUser() {
        return basketResourceUser;
    }

    public ResourceUser<Cubicle> getCubicleResourceUser() {
        return cubicleResourceUser;
    }

    public ForeseeableAction getUndressAction() {
        return undressAction;
    }

    public ForeseeableAction getSwimAction() {
        return swimAction;
    }

    public ForeseeableAction getDressAction() {
        return dressAction;
    }
}
