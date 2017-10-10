package fil.coo.client;

import static org.junit.Assert.*;

import fil.coo.actions.interfaces.Scheduler;
import fil.coo.actions.scheduler.AbstractSequentialSchedulerTest;
import fil.coo.actions.scheduler.ConcreteSequentialSchedulerTest;

public class SwimmerTest extends AbstractSequentialSchedulerTest{

	@Override
	protected Scheduler createScheduler() {
		return new Swimmer();
	}

		
}