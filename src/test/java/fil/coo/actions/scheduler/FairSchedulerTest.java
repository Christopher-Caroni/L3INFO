package fil.coo.actions.scheduler;

import fil.coo.actions.interfaces.Scheduler;
import fil.coo.actions.interfaces.SchedulerTest;

public class FairSchedulerTest extends SchedulerTest {

    @Override
    protected Scheduler createScheduler() {
        return new FairScheduler();
    }
}