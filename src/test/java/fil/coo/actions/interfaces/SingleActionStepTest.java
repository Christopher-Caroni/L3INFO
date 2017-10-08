package fil.coo.actions.interfaces;

import fil.coo.actions.ActionState;
import fil.coo.exception.ActionFinishedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public abstract class SingleActionStepTest {

    protected abstract Action createAction();

    protected Action action;

    @Before
    public void setupAction() {
        this.action = this.createAction();
    }

    @Test
    public void stateIsReadyWhenCreated() {
        assertEquals(this.action.getState(), ActionState.READY);
    }

    @Test(timeout = 500)
    public void isFinishedOnlyWhenStopConditionIsReached() throws ActionFinishedException {
        assertFalse(this.action.isFinished());
        assertFalse(this.action.stopCondition());

        while (!this.action.stopCondition()) {
            assertFalse(this.action.isFinished());
            this.action.doStep();
        }

        assertTrue(this.action.isFinished());
    }

    @Test(expected = ActionFinishedException.class, timeout = 500)
    public void doStepThrowsExceptionOnlyWhenIsFinished() throws ActionFinishedException {
        // On déroule l'action et si exception, le test échoue
        while (!this.action.isFinished()) {
            try {
                this.action.doStep();
            } catch (ActionFinishedException e) {
                fail();
            }
        }

        assertTrue(this.action.isFinished());
        // Lance l'exception
        this.action.doStep();
    }
}
