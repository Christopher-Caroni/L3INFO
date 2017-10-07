package fil.coo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fil.coo.actions.Action;
import fil.coo.actions.Scheduler;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStardedException;

public abstract class SchedulerTest extends ActionTest {

	  private static final int NB_ACTIONS = 2;

	  protected Scheduler scheduler;

	  protected abstract Scheduler createScheduler();

	  protected void addActions(int nb) throws ActionFinishedException, SchedulerStardedException {
	    for (int i = 0; i < nb; i++) {
	      this.scheduler.addAction(new OneStepMockAction());
	    }
	  }

	  @Before
	  public void setup() {
	    this.scheduler = this.createScheduler();
	    try {
			this.addActions(NB_ACTIONS);
		} catch (ActionFinishedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SchedulerStardedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  @Test
	  public void testAddActionWhenOk() throws ActionFinishedException, SchedulerStardedException {
	    assertEquals(NB_ACTIONS, this.scheduler.getRemainingActions().size());
	    this.scheduler.addAction(new OneStepMockAction());
	    assertEquals(NB_ACTIONS + 1, this.scheduler.getRemainingActions().size());
	  }

	  @Test(expected = SchedulerStardedException.class)
	  public void cantAddActionWhenAlreadyStarted() throws ActionFinishedException, SchedulerStardedException {
	    this.scheduler.doStep();
	    this.scheduler.addAction(new OneStepMockAction());
	  }

	  @Test(expected = ActionFinishedException.class)
	  public void cantAddFinishedAction() throws ActionFinishedException, SchedulerStardedException {
	    OneStepMockAction action = new OneStepMockAction();

	    action.doStep();
	    this.scheduler.addAction(action);
	  }

	  @Test
	  public void isFinishedWhenAllActionsAreFinished() throws ActionFinishedException {
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
	      this.isFinished = false;
	    }

	    protected void executeOneStep() {
	      this.isFinished = true;
	    }

	    public boolean stopCondition() {
	      return this.isFinished;
	    }

		@Override
		protected void realStep() {
			// TODO Auto-generated method stub	
		}

	  }

	}
