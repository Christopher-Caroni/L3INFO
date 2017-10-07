package fil.coo.actions;

import java.util.ArrayList;
import java.util.List;

import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStardedException;

public abstract class Scheduler extends Action{

	protected List<Action> actions;
	
	public Scheduler(){
		this.actions = new ArrayList<Action>();
	}
	
	protected void realStep() {		
		Action action = this.actions.get(this.nextAction()) ;
		try {
			action.doStep();
		} catch (ActionFinishedException e) {
			// cannot happen since there is no finished action in a scheduler
		}
		if (action.isFinished()) this.actions.remove(action);
	}

	protected abstract int nextAction();

	public void addAction(Action action) throws ActionFinishedException, SchedulerStardedException {
		if (this.getState() != ActionState.READY) {
			throw new SchedulerStardedException() ;
		}
		if (action.isFinished()) {
			throw new ActionFinishedException() ;
		}
		this.actions.add(action);
	}

	public boolean stopCondition() {
		return this.actions.isEmpty();
	}

	public List<Action> getRemainingActions() {
		return this.actions;
	}
	
}
