package fil.coo.actions.scheduler;

import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.Scheduler;
import fil.coo.exception.ActionFinishedException;

/**
 * Iterates over the the list of actions one by one by doing one step for each one
 */
public class FairScheduler extends Scheduler {

    public FairScheduler() {
        super();
    }

    @Override
    public String getActionExecutionTrace(String name) {
        return "fair scheduler, executing action index: " + currentActionIndex;
    }

    @Override
    protected void initStartIndex() {
        currentActionIndex = -1;
    }

    @Override
    protected Action getNextAction() throws ActionFinishedException {
        if (isFinished()) {
            throw new ActionFinishedException("This scheduler is finished. There is no next action to execute");
        }

        currentActionIndex++;
        if (currentActionIndex == actions.size()) {
            currentActionIndex = 0;
        }
        if (actions.get(currentActionIndex).isFinished()) {
            return getNextAction(); // increment again
        }
        return actions.get(currentActionIndex);
    }

}
