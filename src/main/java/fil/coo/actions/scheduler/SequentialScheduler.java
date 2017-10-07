package fil.coo.actions.scheduler;

import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.exception.ActionFinishedException;

/**
 * Finishes actions one by one
 */
public class SequentialScheduler extends Scheduler {

    private int currentActionIndex;

    public SequentialScheduler() {
        super();
        currentActionIndex = 0;
    }

    @Override
    protected Action getNextAction() throws ActionFinishedException {
        if (isFinished()) {
            throw new ActionFinishedException();
        }

        if (actions.get(currentActionIndex).isFinished()) {
            currentActionIndex++;
        }
        return actions.get(currentActionIndex);
    }

}
