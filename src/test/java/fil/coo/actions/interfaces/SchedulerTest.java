package fil.coo.actions.interfaces;

import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class SchedulerTest extends ActionTest {

    private static final int NB_ACTIONS = 2;

    protected Scheduler scheduler;

    protected abstract Scheduler createScheduler();

    /**
     * Creates the scheduler and calls adds {@link #NB_ACTIONS} {@link OneStepMockAction}
     */
    @Before
    public void setupScheduler() {
        if (this.scheduler == null) {
            this.scheduler = this.createScheduler();
            for (int i = 0; i < NB_ACTIONS; i++) {
                try {
                    this.scheduler.addAction(new OneStepMockAction());
                } catch (ActionFinishedException | SchedulerStartedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Calls {@link #setupScheduler()} if the scheduler is null
     *
     * @return the scheduler created from {@link #setupScheduler()}
     */
    @Override
    protected Action createAction() {
        if (scheduler == null) ;
        setupScheduler();
        return this.scheduler;
    }

    @Test
    public void testAddActionWhenReadyIsOk() throws ActionFinishedException, SchedulerStartedException {
        assertEquals(NB_ACTIONS, this.scheduler.getRemainingActions().size());
        this.scheduler.addAction(new OneStepMockAction());
        assertEquals(NB_ACTIONS + 1, this.scheduler.getRemainingActions().size());
    }

    @Test(expected = SchedulerStartedException.class)
    public void testAddActionWhenAlreadyStartedThrowsException() throws ActionFinishedException, SchedulerStartedException {
        this.scheduler.doStep();
        this.scheduler.addAction(new OneStepMockAction());
    }

    @Test(expected = ActionFinishedException.class)
    public void testAddFinishedActionThrowsException() throws ActionFinishedException {
        OneStepMockAction action = new OneStepMockAction();
        try {
            action.doStep();
        } catch (ActionFinishedException e) {
            fail("Manual setup should ensure correct conditions for test");
        }
        try {
            this.scheduler.addAction(action);
        } catch (SchedulerStartedException e) {
            fail("Manual setup should ensure correct conditions for test");
        }
    }

    /**
     * Tests that the scheduler finishes only when all actions are finished.
     * We use {@link OneStepMockAction} that finish in one step so that this test will work with any implementation of {@link Scheduler}
     *
     * @throws ActionFinishedException
     */
    @Test
    public void testIsFinishedWhenAllActionsAreFinished() throws ActionFinishedException {
        Action a1 = this.scheduler.getRemainingActions().get(0);
        Action a2 = this.scheduler.getRemainingActions().get(1);

        // 1st step
        this.scheduler.doStep();
        assertFalse(this.scheduler.isFinished());
        assertTrue(a1.isFinished());
        assertFalse(a2.isFinished());

        // 2nd step
        this.scheduler.doStep();
        assertTrue(this.scheduler.isFinished());
        assertTrue(a2.isFinished());
    }

    private class OneStepMockAction extends Action {

        private boolean isFinished;

        public OneStepMockAction() {
            super();
            isFinished = false;
        }

        @Override
        protected void execute() throws ActionFinishedException {
            isFinished = true;
        }

        @Override
        public boolean stopCondition() {
            return isFinished;
        }
    }

}
