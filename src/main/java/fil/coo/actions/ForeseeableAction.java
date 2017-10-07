package fil.coo.actions;

import fil.coo.actions.interfaces.Action;

public class ForeseeableAction extends Action {

	private int timeRemaining;

	public ForeseeableAction(int timeToFinish) {
		this.timeRemaining = timeToFinish;
	}

	protected void execute() {
		this.timeRemaining--;
	}

	public boolean stopCondition() {
		return this.timeRemaining == 0;
	}

}
