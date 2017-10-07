package fil.coo.actions.scheduler;

import fil.coo.actions.interfaces.Action;
import fil.coo.actions.interfaces.Scheduler;

/**
 * Iterates over the the list of actions one by one by doing one step for each one
 */
public class FairScheduler extends Scheduler {

    private int currentActionIndex;

    public FairScheduler() {
        super();
        currentActionIndex = -1;
    }

    @Override
    protected Action getNextAction() {
        currentActionIndex++;
        if (currentActionIndex == actions.size()) {
            currentActionIndex = 0;
        }
        return actions.get(currentActionIndex);
    }

}
