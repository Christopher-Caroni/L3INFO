package fil.coo.actions;

import fil.coo.actions.interfaces.Action;

public class ForeseeableAction extends Action {

	private int waitingTime;

	public ForeseeableAction(int waiting) {
		this.waitingTime = waiting;
	}

	protected void realStep() {
		this.waitingTime--;
	}

	public boolean stopCondition() {
		return this.waitingTime == 0;
	}

}
