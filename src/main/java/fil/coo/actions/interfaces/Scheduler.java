package fil.coo.actions.interfaces;

import fil.coo.actions.ActionState;
import fil.coo.exception.ActionFinishedException;
import fil.coo.exception.SchedulerStartedException;

import java.util.ArrayList;
import java.util.List;

public abstract class Scheduler extends Action {

    protected List<Action> actions;
    private int nbActionsFinished;
    protected int currentActionIndex;

    public Scheduler() {
        this.actions = new ArrayList<Action>();
        nbActionsFinished = 0;
        initStartIndex();
    }

    /**
     * Set the {@link #currentActionIndex} according to what the implementation depends on in {@link #getNextAction()}
     */
    protected abstract void initStartIndex();

    /**
     *
     * Gets the next action using {@link #getNextAction()} and calls {@link Action#doStep()}
     * @throws ActionFinishedException if the next action to execute is already finished
     */
    protected void execute() throws ActionFinishedException {
        Action action = getNextAction();
        if (action.isFinished()) {
            throw new ActionFinishedException("Tried to execute action with index " + currentActionIndex + " but was finished");
        }
        try {
            action.doStep();
            if (action.isFinished()) {
                nbActionsFinished++;
            }
        } catch (ActionFinishedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the next action that {@link Action#doStep()} will be called on in this scheduler
     * @throws ActionFinishedException if this scheduler is already finished
     */
    protected abstract Action getNextAction() throws ActionFinishedException;

    /**
     * @param action
     * @throws ActionFinishedException   if the action to add is already finished
     * @throws SchedulerStartedException if this scheduler is already started
     */
    public void addAction(Action action) throws ActionFinishedException, SchedulerStartedException {
        if (this.getState() != ActionState.READY) {
            throw new SchedulerStartedException();
        }
        if (action.isFinished()) {
            throw new ActionFinishedException("Action " + action + " is already finished");
        }
        this.actions.add(action);
    }

    public boolean stopCondition() {
        return nbActionsFinished == actions.size();
    }

    protected List<Action> getRemainingActions() {
        return this.actions;
    }

    @Override
    public String toString() {
        return "Scheduler{" +
                "nb actions=" + actions.size() +
                actionsToString() +
                ", nbActionsFinished=" + nbActionsFinished +
                ", state=" + state +
                '}';
    }

    private String actionsToString() {
        StringBuilder stringBuilder = new StringBuilder("actions{");
        for (int i = 0; i < actions.size(); i++) {
            stringBuilder.append("\n")
                    .append(actions.toString());
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
