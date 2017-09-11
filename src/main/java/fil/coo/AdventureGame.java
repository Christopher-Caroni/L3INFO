package fil.coo;

import fil.coo.alive.Monster;
import fil.coo.alive.Player;
import fil.coo.objects.Item;
import fil.coo.objects.Room;
import fil.coo.other.Direction;

/**
 * Hello world!
 *
 */
public class AdventureGame {

    private Player player;

    private AdventureGame() {
    }

    public static void main( String[] args ) {
        AdventureGame adventureGame = new AdventureGame();
        adventureGame.startGame();
    }

    /**
     *
     * @param player the next player who's turn it is to act
     */
    public void play(Player player) {

    }

    public void addMonster(Monster monster, Room room) {

    }

    public void addItem(Item item, Room room) {

    }

    public boolean isFinished() {
        // TODO
        return false;
    }

    public void playerMoveTo(Direction direction) {

    }


    /**
     * Starts a game
     */
    public void startGame() {
        // TODO
    }
}
