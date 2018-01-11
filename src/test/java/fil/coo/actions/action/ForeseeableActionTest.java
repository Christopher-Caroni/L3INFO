package fil.coo.actions.action;

import fil.coo.actions.action.ForeseeableAction;
import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.MultipleStepActionTest;
import fil.coo.exception.ActionFinishedException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForeseeableActionTest extends MultipleStepActionTest {

    private final int NB_STEP = 2;

    protected Action createAction() {
        return new ForeseeableAction(NB_STEP);
    }

    @Test
    public void isFinishedAfterNDoStep() throws ActionFinishedException {
        for (int i = 0; i < NB_STEP; i++) {
            assertFalse(this.action.isFinished());
            this.action.doStep();
        }

        assertTrue(this.action.isFinished());
    }

    @Test
    public void testStepCountIsIncremented() throws ActionFinishedException {
        ForeseeableAction foreseeableAction = new ForeseeableAction(NB_STEP);
        assertEquals(0, foreseeableAction.getStepCount());

        for (int i=1;i<=NB_STEP;i++) {
            foreseeableAction.doStep();
            assertEquals(i, foreseeableAction.getStepCount());
        }
        assertEquals(NB_STEP, foreseeableAction.getStepCount());
    }

}
