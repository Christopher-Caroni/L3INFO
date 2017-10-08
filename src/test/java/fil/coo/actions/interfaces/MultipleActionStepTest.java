package fil.coo.actions.interfaces;

import fil.coo.actions.ActionState;
import fil.coo.exception.ActionFinishedException;
import org.junit.Before;
import org.junit.Test;

import static fil.coo.actions.ActionState.IN_PROGRESS;
import static fil.coo.actions.ActionState.READY;
import static org.junit.Assert.*;

/**
 * Tests for actions that do NOT finish in one {@link Action#doStep()}
 */
public abstract class MultipleActionStepTest extends SingleActionStepTest {

    @Test
    public void testOneDoStepChangesStateToInProgress() throws ActionFinishedException {
        assertEquals(READY, action.getState());
        action.doStep();
        assertEquals(IN_PROGRESS, action.getState());
    }

}
