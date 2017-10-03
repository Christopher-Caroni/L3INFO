package fil.coo;

import java.util.List;

public abstract class Scheduler extends Action{

	protected List<Action> listActions;
	
	public Scheduler(List<Action> listActions){
		this.listActions = listActions;
	}
	
	public void addAction(Action a){
		listActions.add(a);
	}

	@Override
	boolean stopCondition() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
