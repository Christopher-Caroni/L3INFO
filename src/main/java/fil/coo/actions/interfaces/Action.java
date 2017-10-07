package fil.coo.actions.interfaces;

import fil.coo.actions.ActionState;
import fil.coo.exception.ActionFinishedException;

public abstract class Action {

	protected ActionState state;

	public Action() {
		state = ActionState.READY;
	}

    /**
     *
     * @throws ActionFinishedException if this action is already finished
     */
    public void doStep() throws ActionFinishedException {
        if (this.isFinished()) {
        	throw new ActionFinishedException();
        }
        this.state = ActionState.IN_PROGRESS ;
        this.execute() ;
        if (this.stopCondition()) {
        	this.state = ActionState.FINISHED;
        }
    }

    /**
     * Execution specific to the implementing class
     */
    protected abstract void execute();

    public abstract boolean stopCondition();

    public boolean isFinished() {return this.state == ActionState.FINISHED ;}

    public ActionState getState() {return this.state ;}
}
