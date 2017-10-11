package fil.coo.actions.interfaces;

import fil.coo.exception.ActionFinishedException;
import org.junit.Test;

import static fil.coo.actions.ActionState.IN_PROGRESS;
import static fil.coo.actions.ActionState.READY;
import static org.junit.Assert.*;

/**
 * Tests for actions that do NOT finish in one {@link Action#doStep()}
 */
public abstract class MultipleStepActionTest extends SingleStepActionTest {

    @Test
    public void testOneDoStepChangesStateToInProgress() throws ActionFinishedException {
        assertEquals(READY, action.getState());
        action.doStep();
        assertEquals(IN_PROGRESS, action.getState());
    }

}
