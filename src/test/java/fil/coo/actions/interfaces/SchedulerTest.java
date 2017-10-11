package fil.coo.actions.interfaces;

import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class SchedulerTest extends MultipleStepActionTest {

    private static final int NB_ACTIONS = 2;

    protected Scheduler scheduler;

    protected abstract Scheduler createScheduler();

    /**
     * Creates the scheduler and calls adds {@link #NB_ACTIONS} of {@link OneStepMockAction}
     */
    @Before
    public void setupScheduler() {
        this.scheduler = createScheduler();
        initScheduler(this.scheduler);
    }

    /**
     * @return a scheduler created with {@link #initScheduler(Scheduler)}
     */
    @Override
    protected Action createAction() {
        Scheduler scheduler = createScheduler();
        initScheduler(scheduler);
        return scheduler;
    }

    private void initScheduler(Scheduler scheduler) {
        for (int i = 0; i < NB_ACTIONS; i++) {
            try {
                scheduler.addAction(new OneStepMockAction());
            } catch (ActionFinishedException | SchedulerStartedException e) {
                e.printStackTrace();
            }
        }
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


    protected class OneStepMockAction extends Action {

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
