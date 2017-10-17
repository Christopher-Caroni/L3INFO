package fil.coo.actions.action;

import fil.coo.actions.interfaces.Action;

public class ForeseeableAction extends Action {

	private int stepCount;
	private int totalTime;

	public ForeseeableAction(int timeToFinish) {
		this.totalTime = timeToFinish;
		this.stepCount = 0;
	}

	protected void execute() {
		this.stepCount++;
	}

	public boolean stopCondition() {
		return this.stepCount == totalTime;
	}

	@Override
	public String getActionExecutionTrace(String name) {
		return name + "(" + stepCount + "/" + totalTime + ")";
	}

    @Override
    public String toString() {
        return "ForeseeableAction{" +
                "stepCount=" + stepCount +
                ", totalTime=" + totalTime +
                ", state=" + state +
                '}';
    }

    public int getStepCount() {
        return stepCount;
    }
}
