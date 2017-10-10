package fil.coo.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fil.coo.actions.ForeseeableAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.actions.scheduler.AbstractSequentialSchedulerTest;
import fil.coo.client.interfaces.ResourceUser;
import fil.coo.exception.ActionFinishedException;
import fil.coo.resource.Basket;
import fil.coo.resource.Cubicle;
import fil.coo.resource.pools.BasketPool;
import fil.coo.resource.pools.CubiclePool;

public class SwimmerTest extends AbstractSequentialSchedulerTest{

	private static final int NB_RESOURCES = 1;
	private static final int TIME_TO_UNDRESS = 6;
	private static final int TIME_TO_SWIM = 4;
	private static final int TIME_TO_DRESS = 8;
	
	private BasketPool basketPool;
	private CubiclePool cubiclePool;
	private Swimmer swimmer;
	
	@Override
	protected Scheduler createScheduler() {
		return new Swimmer("chris", basketPool, cubiclePool, TIME_TO_UNDRESS, TIME_TO_SWIM, TIME_TO_DRESS);
	}
	
	@Before
	public void setup(){
		 basketPool = new BasketPool(NB_RESOURCES);
		 cubiclePool = new CubiclePool(NB_RESOURCES);
		 swimmer = new Swimmer("chris", basketPool, cubiclePool, TIME_TO_UNDRESS, TIME_TO_SWIM, TIME_TO_DRESS);
	}
	
	@Test
	public void testGotResource() throws ActionFinishedException{
		ForeseeableAction undressAction = swimmer.getUndressAction();
		ForeseeableAction swimAction = swimmer.getSwimAction();
		ForeseeableAction dressAction = swimmer.getDressAction();

		assertFalse(swimmer.isFinished());
		for(int i=0; i<TIME_TO_UNDRESS; i++){
			assertFalse(undressAction.isFinished());
			swimmer.doStep();
		}
		for(int i=0; i<TIME_TO_SWIM; i++){
			assertFalse(swimAction.isFinished());
			swimmer.doStep();
		}
		for(int i=0; i<TIME_TO_DRESS; i++){
			assertFalse(dressAction.isFinished());
			swimmer.doStep();
		}
		assertTrue(swimmer.isFinished());
	}
	
	@Test
	public void testTakeBasketAndCubicle(){
		ResourceUser<Basket> resourcesBasket = swimmer.getBasketResourceUser();
		ResourceUser<Cubicle> resourcesCublicle = swimmer.getCubicleResourceUser();
	}
}