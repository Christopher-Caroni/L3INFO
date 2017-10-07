package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.actions.Action;
import fil.coo.actions.Foreseeable;
import fil.coo.exception.ActionFinishedException;

public class ForeseeableActionTest extends ActionTest {

	  private final int NB_STEP = 2;

	  protected Action createAction() {
	    return new Foreseeable(NB_STEP);
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
