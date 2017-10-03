package fil.coo;

public abstract class Action {

	private ActionState state;
	int time; 
	
	public Action(){
		this.state = ActionState.READY;
		time = 0;
	}
	
	public ActionState getState(){
		return state;
	}
	
	public boolean isFinished(){
		return state == ActionState.FINISHED;
	}
	
	public void doStep() throws ActionFinishedException{
		
		if(this.isFinished()){
			throw new ActionFinishedException("can't doStep when finished");
		}
		
		if(this.state == ActionState.READY){
			this.state = ActionState.IN_PROGRESS;
		}
		
		this.executeOneStep();
		
		if(this.stopCondition())
			this.state = ActionState.FINISHED;
	}


	public void executeOneStep() {
		this.time ++;
	}
	
	abstract boolean stopCondition();
}
