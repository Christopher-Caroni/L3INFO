package fil.coo.actions;

import fil.coo.exception.ActionFinishedException;

public abstract class Action {

	protected ActionState state;

	public Action() {
		state = ActionState.READY;
	}
	
    public void doStep() throws ActionFinishedException {
        if (this.isFinished()) throw new ActionFinishedException();
        this.state = ActionState.IN_PROGRESS ;
        this.realStep() ;
        if (this.stopCondition()) this.state = ActionState.FINISHED;
    }

    protected abstract void realStep();

    public abstract boolean stopCondition();

    public boolean isFinished() {return this.state == ActionState.FINISHED ;}

    public ActionState getState() {return this.state ;}
}
