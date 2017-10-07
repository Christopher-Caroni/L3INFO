package fil.coo.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.actions.interfaces.Action;
import fil.coo.exception.ActionFinishedException;

public class ForeseeableActionActionTest extends ActionTest {

	  private final int NB_STEP = 2;

	  protected Action createAction() {
	    return new ForeseeableAction(NB_STEP);
	  }

	  @Test
	  public void isFinishedAfterNDoStep() throws ActionFinishedException {
	    for(int i = 0; i < NB_STEP; i++) {
	      assertFalse(this.action.isFinished());
	      this.action.doStep();
	    }

	    assertTrue(this.action.isFinished());
	  }

	}
