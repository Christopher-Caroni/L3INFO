package fil.coo.actions.interfaces;

import java.util.ArrayList;
import java.util.List;

import fil.coo.actions.ActionState;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;

public abstract class Scheduler extends Action{

	protected List<Action> actions;
	
	public Scheduler(){
		this.actions = new ArrayList<Action>();
	}
	
	protected void execute() {
		Action action = this.actions.get(this.nextAction()) ;
		try {
			action.doStep();
		} catch (ActionFinishedException e) {
		    e.printStackTrace();
        }
		if (action.isFinished()) {
			this.actions.remove(action);
		}
	}

	protected abstract int nextAction();

    /**
     *
     * @param action
     * @throws ActionFinishedException if the action to add is already finished
     * @throws SchedulerStartedException if this scheduler is already started
     */
	public void addAction(Action action) throws ActionFinishedException, SchedulerStartedException {
		if (this.getState() != ActionState.READY) {
			throw new SchedulerStartedException() ;
		}
		if (action.isFinished()) {
			throw new ActionFinishedException() ;
		}
		this.actions.add(action);
	}

	public boolean stopCondition() {
		return this.actions.isEmpty();
	}

	protected List<Action> getRemainingActions() {
		return this.actions;
	}
	
}
