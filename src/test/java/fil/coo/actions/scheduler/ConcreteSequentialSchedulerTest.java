package fil.coo.actions.scheduler;

import fil.coo.actions.interfaces.Scheduler;

public class ConcreteSequentialSchedulerTest extends AbstractSequentialSchedulerTest {

    @Override
    protected Scheduler createScheduler() {
        return new SequentialScheduler();
    }
}