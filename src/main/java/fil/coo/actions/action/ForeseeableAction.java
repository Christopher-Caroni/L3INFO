package fil.coo.actions.action;

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


    @Override
    public String toString() {
        return "ForeseeableAction{" +
                "timeRemaining=" + timeRemaining +
                ", state=" + state +
                '}';
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }
}
