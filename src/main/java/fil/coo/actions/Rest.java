package fil.coo.actions;

import fil.coo.exception.ActionCannotBeExecutedException;
import fil.coo.spawnables.beings.GamePlayer;

import java.util.Random;

public class Rest implements Action {

    private int cost;
    private int hpRestoration;

    public Rest() {
        Random random = new Random();
        cost = random.nextInt(10);
        hpRestoration = random.nextInt(5) + 5;
    }

    public boolean isPossible(GamePlayer currentPlayer) {
        return !currentPlayer.getCurrentRoom().hasMonsters() && currentPlayer.hasEnoughGold(1) && currentPlayer.hasRoomRevealed();
    }

    /**
     * Restores {@link #hpRestoration} and makes the player use {@link #cost} gold.
     *
     * @param player the player that will rest.
     */
    public void execute(GamePlayer player) throws ActionCannotBeExecutedException {
        if (player.hasEnoughGold(cost)) {
            player.changeStrength(cost);
            player.changeHP(hpRestoration);
            System.out.println("You used " + Math.abs(cost) + " strength and restored " + hpRestoration + " HP");
            System.out.println("You now have " + player.getStrength() + " strength and " + player.getHP() + " HP");
        } else {
            throw new ActionCannotBeExecutedException("Cannot execute " + this.getClass().getSimpleName());
        }
    }

    @Override
    public String getMenuDescription() {
        return "Rest here";
    }
}
