package fil.coo.actions.scheduler;

import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.exception.ActionFinishedException;

/**
 * Finishes actions one by one
 */
public class SequentialScheduler extends Scheduler {

    public SequentialScheduler() {
        super();
    }

    @Override
    public String getActionExecutionTrace(String name) {
        return "sequential scheduler, executing action index: " + currentActionIndex;
    }

    @Override
    protected void initStartIndex() {
        currentActionIndex = 0;
    }

    @Override
    protected Action getNextAction() throws ActionFinishedException {
        if (isFinished()) {
            throw new ActionFinishedException("This scheduler is finished. There is no next action to execute");
        }

        if (actions.get(currentActionIndex).isFinished()) {
            currentActionIndex++;
        }
        return actions.get(currentActionIndex);
    }

}
