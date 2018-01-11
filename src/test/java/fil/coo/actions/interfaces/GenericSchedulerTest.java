package fil.coo.actions.interfaces;

import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;
import fil.coo.resources.client.Swimmer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for all classes extending {@link Scheduler} by using a predefined amount of {@link OneStepMockAction} according to {@link #NB_ACTIONS}.
 * <br>All concrete schedulers that have their own predefined actions such as {@link Swimmer} should not extend this test class.
 */
public abstract class GenericSchedulerTest extends SchedulerTest {

    private static final int NB_ACTIONS = 2;

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

    @Test
    public void testAddActionWhenReadyIsOk() throws ActionFinishedException, SchedulerStartedException {
        assertEquals(NB_ACTIONS, this.scheduler.getRemainingActions().size());
        this.scheduler.addAction(new OneStepMockAction());
        assertEquals(NB_ACTIONS + 1, this.scheduler.getRemainingActions().size());
    }

    @Test(expected = ActionFinishedException.class)
    public void testGetNextActionThrowsExceptionAfterAllActionsTreated() throws ActionFinishedException {
        try {
            scheduler.doStep();
            scheduler.doStep();
        } catch (ActionFinishedException e) {
            fail("Manual setup should ensure two actions that finish in one step so that this always succeeds");
        }

        Action inexistantAction = scheduler.getNextAction();
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
}
