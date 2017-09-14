package fil.coo.beings;

import fil.coo.actions.Action;
import fil.coo.other.Direction;
import fil.coo.util.Menu;

import java.util.List;

public class Player extends Character {

    private List actions;

    public void act() {

        List<Action> possibleActions = getPossibleActions();
        Action action = Menu.getInstance().chooseElement(possibleActions);

        action.execute(this);

        // TODO

    }

    public void moveToDirection(Direction direction) {
        // TODO
    }

    public List<Action> getPossibleActions() {
        // TODO
        return null;
    }
}
