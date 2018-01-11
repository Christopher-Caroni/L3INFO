package fil.coo.actions.scheduler;

import fil.coo.actions.action.ForeseeableAction;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.actions.interfaces.GenericSchedulerTest;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FairSchedulerTest extends GenericSchedulerTest {

    @Override
    protected Scheduler createScheduler() {
        return new FairScheduler();
    }

    @Test
    public void testFairOrder() throws ActionFinishedException, SchedulerStartedException {
        FairScheduler fairScheduler = new FairScheduler();
        ForeseeableAction firstAction = new ForeseeableAction(2);
        ForeseeableAction secondAction = new ForeseeableAction(1);
        ForeseeableAction thirdAction = new ForeseeableAction(2);

        fairScheduler.addAction(firstAction);
        fairScheduler.addAction(secondAction);
        fairScheduler.addAction(thirdAction);

        assertEquals(0, firstAction.getStepCount());
        assertEquals(0, secondAction.getStepCount());
        assertEquals(0, thirdAction.getStepCount());

        // first
        fairScheduler.doStep();
        assertEquals(1, firstAction.getStepCount());
        assertEquals(0, secondAction.getStepCount());
        assertEquals(0, thirdAction.getStepCount());
        assertFalse(firstAction.isFinished());
        assertFalse(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        // second, finishes right away
        fairScheduler.doStep();
        assertEquals(1, firstAction.getStepCount());
        assertEquals(1, secondAction.getStepCount());
        assertEquals(0, thirdAction.getStepCount());
        assertFalse(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        // third
        fairScheduler.doStep();
        assertEquals(1, firstAction.getStepCount());
        assertEquals(1, secondAction.getStepCount());
        assertEquals(1, thirdAction.getStepCount());
        assertFalse(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        // first, finishes
        fairScheduler.doStep();
        assertEquals(2, firstAction.getStepCount());
        assertEquals(1, secondAction.getStepCount());
        assertEquals(1, thirdAction.getStepCount());
        assertTrue(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertFalse(thirdAction.isFinished());

        // third, finishes
        fairScheduler.doStep();
        assertEquals(2, firstAction.getStepCount());
        assertEquals(1, secondAction.getStepCount());
        assertEquals(2, thirdAction.getStepCount());
        assertTrue(firstAction.isFinished());
        assertTrue(secondAction.isFinished());
        assertTrue(thirdAction.isFinished());
    }
}