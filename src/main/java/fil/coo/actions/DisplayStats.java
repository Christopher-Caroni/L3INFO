package fil.coo.actions;

import fil.coo.spawnables.beings.GamePlayer;

public class DisplayStats extends Action {
    @Override
    public boolean isPossible(GamePlayer currentPlayer) {
        return true;
    }

    @Override
    public void execute(GamePlayer player) {
        System.out.println("You have " + player.getHP() + " HP and " + player.getStrength() + " strength.");
        System.out.println("You have visited " + player.getUniqueRoomCount() + " separate room(s).");
    }

    @Override
    public String getMenuDescription() {
        return "Show my stats";
    }
}
