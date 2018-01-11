package fil.coo.actions.scheduler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fil.coo.actions.interfaces.Scheduler;
import fil.coo.actions.interfaces.GenericSchedulerTest;
import org.junit.Test;

import fil.coo.actions.action.ForeseeableAction;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;

public abstract class SequentialSchedulerTest extends GenericSchedulerTest {

    @Override
    protected Scheduler createScheduler() {
        return new SequentialScheduler();
    }

    @Test
    public void testSequentialOrder() throws ActionFinishedException, SchedulerStartedException {
        SequentialScheduler scheduler = new SequentialScheduler();
        ForeseeableAction firstAction = new ForeseeableAction(2);
        ForeseeableAction secondAction = new ForeseeableAction(1);
        ForeseeableAction thirdAction = new ForeseeableAction(2);

        scheduler.addAction(firstAction);
        scheduler.addAction(secondAction);
        scheduler.addAction(thirdAction);

        assertEquals(0, firstAction.getStepCount());
        assertEquals(0, secondAction.getStepCount());
        assertEquals(0, thirdAction.getStepCount());

        // start first
        scheduler.doStep();
        assertEquals(1, firstAction.getStepCount());
        assertEquals(0, secondAction.getStepCount());
        assertEquals(0, thirdAction.getStepCount());
        assertFalse(firstAction.isFinished());
        assertFalse(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        scheduler.doStep();
        assertEquals(2, firstAction.getStepCount());
        assertEquals(0, secondAction.getStepCount());
        assertEquals(0, thirdAction.getStepCount());
        assertTrue(firstAction.isFinished());
        assertFalse(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        // start second
        scheduler.doStep();
        assertEquals(2, firstAction.getStepCount());
        assertEquals(1, secondAction.getStepCount());
        assertEquals(0, thirdAction.getStepCount());
        assertTrue(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        // start third
        scheduler.doStep();
        assertEquals(2, firstAction.getStepCount());
        assertEquals(1, secondAction.getStepCount());
        assertEquals(1, thirdAction.getStepCount());
        assertTrue(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        scheduler.doStep();
        assertEquals(2, firstAction.getStepCount());
        assertEquals(1, secondAction.getStepCount());
        assertEquals(2, thirdAction.getStepCount());
        assertTrue(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertTrue(thirdAction.isFinished());
    }
}
