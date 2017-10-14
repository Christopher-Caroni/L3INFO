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

        assertEquals(2, firstAction.getTimeRemaining());
        assertEquals(1, secondAction.getTimeRemaining());
        assertEquals(2, thirdAction.getTimeRemaining());

        // start first
        scheduler.doStep();
        assertEquals(1, firstAction.getTimeRemaining());
        assertEquals(1, secondAction.getTimeRemaining());
        assertEquals(2, thirdAction.getTimeRemaining());
        assertFalse(firstAction.isFinished());
        assertFalse(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        scheduler.doStep();
        assertEquals(0, firstAction.getTimeRemaining());
        assertEquals(1, secondAction.getTimeRemaining());
        assertEquals(2, thirdAction.getTimeRemaining());
        assertTrue(firstAction.isFinished());
        assertFalse(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        // start second
        scheduler.doStep();
        assertEquals(0, firstAction.getTimeRemaining());
        assertEquals(0, secondAction.getTimeRemaining());
        assertEquals(2, thirdAction.getTimeRemaining());
        assertTrue(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        // start third
        scheduler.doStep();
        assertEquals(0, firstAction.getTimeRemaining());
        assertEquals(0, secondAction.getTimeRemaining());
        assertEquals(1, thirdAction.getTimeRemaining());
        assertTrue(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        scheduler.doStep();
        assertEquals(0, firstAction.getTimeRemaining());
        assertEquals(0, secondAction.getTimeRemaining());
        assertEquals(0, thirdAction.getTimeRemaining());
        assertTrue(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertTrue(thirdAction.isFinished());
    }
}
