package fil.coo.actions.scheduler;

import fil.coo.actions.interfaces.Scheduler;

/**
 * Iterates of the the list of actions
 */
public class FairScheduler extends Scheduler {

	protected int currentIndex;
	
	public FairScheduler() {
		this.currentIndex = 0;
	}

	@Override
	protected int nextAction() {
		int index = this.currentIndex ;
		this.currentIndex++ ;
		if (this.currentIndex == this.actions.size()) {
			this.currentIndex = 0 ;
		}
		return index ;
	}

}
