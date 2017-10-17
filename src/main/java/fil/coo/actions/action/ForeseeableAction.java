package fil.coo.actions.action;

import fil.coo.actions.interfaces.Action;

public class ForeseeableAction extends Action {

	private int stepCount;
	private int totalTime;
    private String name;

    public ForeseeableAction(int timeToFinish) {
		this.totalTime = timeToFinish;
		this.stepCount = 0;
	}

    public ForeseeableAction(int totalTime, String name) {
        this(totalTime);
        this.name = name;
    }

    protected void execute() {
		this.stepCount++;
	}

	public boolean stopCondition() {
		return this.stepCount == totalTime;
	}

	@Override
	public String getActionExecutionTrace(String schedulerName) {
		return this.name + "(" + stepCount + "/" + totalTime + ")";
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
