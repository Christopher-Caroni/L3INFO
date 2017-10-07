package fil.coo.actions.scheduler;

import fil.coo.actions.interfaces.Scheduler;

/**
 * Always finishes the first action in the list.
 */
public class SequentialScheduler extends Scheduler {

	@Override
	protected int nextAction() {
		return 0;
	}

}
