package fil.coo.actions.scheduler;

import fil.coo.actions.ForeseeableAction;
import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.actions.interfaces.SchedulerTest;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SequentialSchedulerTest extends SchedulerTest {

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