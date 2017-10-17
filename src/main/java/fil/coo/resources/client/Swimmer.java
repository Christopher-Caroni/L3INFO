package fil.coo.resources.client;

import fil.coo.actions.action.ForeseeableAction;
import fil.coo.actions.action.FreeResourceAction;
import fil.coo.actions.action.TakeResourceAction;
import fil.coo.actions.interfaces.Action;
import fil.coo.actions.scheduler.SequentialScheduler;
import fil.coo.exception.ActionFinishedException;
import fil.coo.resources.pools.BasketPool;
import fil.coo.resources.pools.CubiclePool;
import fil.coo.resources.pools.ResourcePool;
import fil.coo.resources.resource.Basket;
import fil.coo.resources.resource.Cubicle;
import org.apache.log4j.Logger;

public class Swimmer extends SequentialScheduler {

    final static Logger logger = Logger.getLogger(Swimmer.class);

    private final String name;

    private ResourceUser<Basket> basketResourceUser;
    private ResourceUser<Cubicle> cubicleResourceUser;

    private ResourcePool<Basket> basketPool;
    private ResourcePool<Cubicle> cubiclePool;

    private final int timeToUndress;
    private final int timeToSwim;
    private final int timeToDress;

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
     * Add the predefined actions that all swimmers will do. Only one method because a swimmer's actions are predefined and depend on one another because of the order of execution.
     */
    private void initActionList() {

        actions.add(new TakeResourceAction<>(basketResourceUser, basketPool));
        actions.add(new TakeResourceAction<>(cubicleResourceUser, cubiclePool));

        // undress
        actions.add(new ForeseeableAction(timeToUndress, "undress"));
        actions.add(new FreeResourceAction<>(cubicleResourceUser, cubiclePool));

        // swim
        actions.add(new ForeseeableAction(timeToSwim, "swim"));
        actions.add(new TakeResourceAction<>(cubicleResourceUser, cubiclePool));

        // dress
        actions.add(new ForeseeableAction(timeToDress, "dress"));
        actions.add(new FreeResourceAction<>(basketResourceUser, basketPool));
        actions.add(new FreeResourceAction<>(cubicleResourceUser, cubiclePool));
    }

    protected ResourceUser<Basket> getBasketResourceUser() {
        return basketResourceUser;
    }

    protected ResourceUser<Cubicle> getCubicleResourceUser() {
        return cubicleResourceUser;
    }

    protected Action getUndressAction() {
        return actions.get(2);
    }

    protected Action getSwimAction() {
        return actions.get(4);
    }

    protected Action getDressAction() {
        return actions.get(6);
    }

    @Override
    protected void execute() throws ActionFinishedException {
        logger.info(name + "'s turn");

        Action action = getNextAction();
        if (action.isFinished()) {
            throw new ActionFinishedException("Tried to execute " + action + " with index " + currentActionIndex +
                    " but was finished");
        }
        action.doStep();

        String desc = "\t" + action.getActionExecutionTrace(name);
        logger.info(desc);

        if (action.isFinished()) {
            nbActionsFinished++;
        }
    }
}
