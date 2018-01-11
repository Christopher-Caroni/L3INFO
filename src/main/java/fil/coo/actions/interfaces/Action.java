package fil.coo.actions.interfaces;

import fil.coo.actions.ActionState;
import fil.coo.exception.ActionFinishedException;

public abstract class Action {

    protected ActionState state;

    public Action() {
        state = ActionState.READY;
    }

    /**
     * @throws ActionFinishedException if this action is already finished
     */
    public void doStep() throws ActionFinishedException {
        if (this.isFinished()) {
            throw new ActionFinishedException("This action/implementation is already finished");
        }
        this.state = ActionState.IN_PROGRESS;
        this.execute();
        if (this.stopCondition()) {
            this.state = ActionState.FINISHED;
        }
    }

    /**
     * Execution specific to the implementing class
     *
     * @throws ActionFinishedException if this action is already finished or in the case of a scheduler, if the next action is already finished
     */
    protected abstract void execute() throws ActionFinishedException;


    /**
     * Internal method to know whether this instance should go to state {@link ActionState#FINISHED}
     *
     * @return if this action should be finished in the sense of {@link #isFinished()}
     */
    protected abstract boolean stopCondition();

    /**
     * @return if this action's state == {@link ActionState#FINISHED}
     */
    public boolean isFinished() {
        return this.state == ActionState.FINISHED;
    }

    public ActionState getState() {
        return this.state;
    }

    /**
     * Method for schedulers to call on their actions to get a trace of their execution
     *
     * @param schedulerName the name of the scheduler calling this method
     */
    public abstract String getActionExecutionTrace(String schedulerName);
}
