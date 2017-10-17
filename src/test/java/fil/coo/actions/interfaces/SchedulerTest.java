package fil.coo.actions.interfaces;

import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class SchedulerTest extends MultipleStepActionTest {

    protected Scheduler scheduler;

    /**
     * Initializes {@link #scheduler} with {@link #createScheduler()}
     */
    @Before
    public void setupScheduler() {
        this.scheduler = createScheduler();
    }

    /**
     * @return a scheduler created with {@link #createScheduler()}
     */
    @Override
    protected Action createAction() {
        return createScheduler();
    }

    protected abstract Scheduler createScheduler();

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

        @Override
        public String getActionExecutionTrace(String name) {
            return name + " trying to execute one step mock action..." + (isFinished ? "finished" : "in progress");
        }
    }

}
