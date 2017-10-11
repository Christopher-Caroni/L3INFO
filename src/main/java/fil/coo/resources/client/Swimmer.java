package fil.coo.resources.client;

import fil.coo.actions.action.ForeseeableAction;
import fil.coo.actions.action.FreeResourceAction;
import fil.coo.actions.action.TakeResourceAction;
import fil.coo.actions.scheduler.SequentialScheduler;
import fil.coo.resources.resource.Basket;
import fil.coo.resources.resource.Cubicle;
import fil.coo.resources.pools.BasketPool;
import fil.coo.resources.pools.CubiclePool;
import fil.coo.resources.pools.ResourcePool;

public class Swimmer extends SequentialScheduler {

    private final String name;

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

        actions.add(new TakeResourceAction<>(basketResourceUser, basketPool));
        actions.add(new TakeResourceAction<>(cubicleResourceUser, cubiclePool));

        // undress
        actions.add(undressAction);
        actions.add(new FreeResourceAction<>(cubicleResourceUser, cubiclePool));

        // swim
        actions.add(swimAction);
        actions.add(new TakeResourceAction<>(cubicleResourceUser, cubiclePool));

        // dress
        actions.add(dressAction);
        actions.add(new FreeResourceAction<>(basketResourceUser, basketPool));
        actions.add(new FreeResourceAction<>(cubicleResourceUser, cubiclePool));
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
