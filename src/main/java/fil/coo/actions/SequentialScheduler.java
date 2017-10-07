package fil.coo.actions;

import fil.coo.actions.interfaces.Scheduler;

public class SequentialScheduler extends Scheduler {

	@Override
	protected int nextAction() {
		return 0;
	}

}
