package fil.coo.resources.client;

import fil.coo.actions.action.ForeseeableAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.actions.interfaces.SchedulerTest;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.ForeignResourceException;
import fil.coo.exception.NoFreeResourcesException;
import fil.coo.exception.TooManyResourcesException;
import fil.coo.resources.resource.Basket;
import fil.coo.resources.resource.Cubicle;
import fil.coo.resources.pools.BasketPool;
import fil.coo.resources.pools.CubiclePool;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwimmerTest extends SchedulerTest {

    private static final int NB_RESOURCES = 1;
    private static final int TIME_TO_UNDRESS = 6;
    private static final int TIME_TO_SWIM = 4;
    private static final int TIME_TO_DRESS = 8;

    private BasketPool basketPool;
    private CubiclePool cubiclePool;
    private Swimmer swimmer;

    @Before
    public void setup() {
        basketPool = new BasketPool(NB_RESOURCES);
        cubiclePool = new CubiclePool(NB_RESOURCES);
        swimmer = new Swimmer("chris", basketPool, cubiclePool, TIME_TO_UNDRESS, TIME_TO_SWIM, TIME_TO_DRESS);
    }

    @Override
    protected Scheduler createScheduler() {
        if (swimmer == null) {
            setup();
        }
        return swimmer;
    }

    @Test
    public void testTakeBasketAndCubicle() throws ActionFinishedException {
        ResourceUser<Basket> basketResourceUser = swimmer.getBasketResourceUser();
        ResourceUser<Cubicle> cubicleResourceUser = swimmer.getCubicleResourceUser();

        assertNull(basketResourceUser.getResource());
        assertNull(cubicleResourceUser.getResource());

        swimmer.doStep();

        assertNotNull(basketResourceUser.getResource());
        assertNull(cubicleResourceUser.getResource());

        swimmer.doStep();

        assertNotNull(basketResourceUser.getResource());
        assertNotNull(cubicleResourceUser.getResource());

    }

    @Test
    public void testTakeBasketAndCubicleWhenFail() throws ActionFinishedException, NoFreeResourcesException, IllegalArgumentException, TooManyResourcesException, ForeignResourceException {
        ResourceUser<Basket> basketResourceUser = swimmer.getBasketResourceUser();
        ResourceUser<Cubicle> cubicleResourceUser = swimmer.getCubicleResourceUser();
        Basket basket = basketPool.provideResource();

        assertNull(basketResourceUser.getResource());
        assertNull(cubicleResourceUser.getResource());

        // pool is empty
        swimmer.doStep();

        assertNull(basketResourceUser.getResource());
        assertNull(cubicleResourceUser.getResource());

        basketPool.recoverResource(basket);

        swimmer.doStep();

        assertNotNull(basketResourceUser.getResource());
        assertNull(cubicleResourceUser.getResource());

        swimmer.doStep();

        assertNotNull(basketResourceUser.getResource());
        assertNotNull(cubicleResourceUser.getResource());

    }

    @Test
    public void testGotResources() throws ActionFinishedException {


        ForeseeableAction undressAction = swimmer.getUndressAction();
        ForeseeableAction swimAction = swimmer.getSwimAction();
        ForeseeableAction dressAction = swimmer.getDressAction();

        // take resources basket and cubicle
        swimmer.doStep();
        swimmer.doStep();

        assertNotNull(swimmer.getBasketResourceUser());
        assertNotNull(swimmer.getCubicleResourceUser());

        assertFalse(swimmer.isFinished());
        for (int i = 0; i < TIME_TO_UNDRESS; i++) {
            assertFalse(undressAction.isFinished());
            swimmer.doStep();
        }

        //free the cubicle
        swimmer.doStep();

        for (int i = 0; i < TIME_TO_SWIM; i++) {
            assertFalse(swimAction.isFinished());
            swimmer.doStep();
        }

        //take a cubicle
        swimmer.doStep();

        for (int i = 0; i < TIME_TO_DRESS; i++) {
            assertFalse(dressAction.isFinished());
            swimmer.doStep();
        }

        //free resources basket and cubicle
        swimmer.doStep();
        swimmer.doStep();

        assertTrue(swimmer.isFinished());
    }
}