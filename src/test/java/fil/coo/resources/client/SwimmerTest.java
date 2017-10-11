package fil.coo.resources.client;

import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.actions.interfaces.SchedulerTest;
import fil.coo.exception.*;
import fil.coo.resources.pools.BasketPool;
import fil.coo.resources.pools.CubiclePool;
import fil.coo.resources.resource.Basket;
import fil.coo.resources.resource.Cubicle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwimmerTest extends SchedulerTest {

    /**
     * Make pools have only one resource so we can empty them easily
     */
    private static final int NB_RESOURCES = 1;

    private static final int TIME_TO_UNDRESS = 6;
    private static final int TIME_TO_SWIM = 4;
    private static final int TIME_TO_DRESS = 8;

    private BasketPool basketPool;
    private CubiclePool cubiclePool;
    private Swimmer swimmer;

    @Before
    public void setup() {
        this.swimmer = initSwimmer();
    }

    @Override
    protected Scheduler createScheduler() {
        return initSwimmer();
    }

    /**
     * Initializes the class field resource pools for the swimmer and returns a new swimmer with these pools.
     *
     * @return a swimmer with pools from this test instance.
     */
    private Swimmer initSwimmer() {
        basketPool = new BasketPool(NB_RESOURCES);
        cubiclePool = new CubiclePool(NB_RESOURCES);
        return new Swimmer("chris", basketPool, cubiclePool, TIME_TO_UNDRESS, TIME_TO_SWIM, TIME_TO_DRESS);
    }

    /**
     * Tests that the swimmer's {@link ResourceUser}s take the resources correctly when the pools have resources available.
     *
     * @throws ActionFinishedException should not be thrown
     */
    @Test
    public void testTakeBasketAndCubicleWhenPoolsOK() throws ActionFinishedException {
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

    /**
     * Tests that the {@link Swimmer} executes actions until they are finished. Makes sure that the Swimmer has the "necessary" resources for dress/swim...
     * Here we empty the pools to prevent the {@link fil.coo.actions.action.TakeResourceAction} from finishing.
     *
     * @throws ActionFinishedException    should not be thrown
     * @throws NoFreeResourcesException   should not be thrown
     * @throws IllegalArgumentException   should not be thrown
     * @throws TooManyResourcesException  should not be thrown
     * @throws ForeignResourceException   should not be thrown
     * @throws DuplicateRecoveryException should not be thrown
     */
    @Test
    public void testTakeBasketAndCubicleWhenFail() throws ActionFinishedException, NoFreeResourcesException, IllegalArgumentException, TooManyResourcesException, ForeignResourceException, DuplicateRecoveryException {
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

    /**
     * Tests that the {@link Swimmer} executes the proper amount of steps and that these steps are executed in a specific order.
     *
     * @throws ActionFinishedException if an action is already finished. Should never encounter this
     */
    @Test
    public void testSwimmerOrderOfExecution() throws ActionFinishedException {

        Action undressAction = swimmer.getUndressAction();
        Action swimAction = swimmer.getSwimAction();
        Action dressAction = swimmer.getDressAction();

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
        assertTrue(swimmer.stopCondition());
    }
}