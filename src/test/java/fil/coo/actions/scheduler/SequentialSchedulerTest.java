package fil.coo.actions.scheduler;

import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.actions.interfaces.SchedulerTest;

import static org.junit.Assert.*;

public class SequentialSchedulerTest extends SchedulerTest {

    @Override
    protected Scheduler createScheduler() {
        return new SequentialScheduler();
    }

}