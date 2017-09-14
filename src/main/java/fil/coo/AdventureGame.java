package fil.coo;

import fil.coo.beings.Monster;
import fil.coo.beings.Player;
import fil.coo.objects.Item;
import fil.coo.objects.Room;
import fil.coo.other.Direction;

/**
 * Hello world!
 *
 */
public class AdventureGame {

    private static final int WIDTH_DUNGEON = 10;
    private static final int HEIGHT_DUNGEON = 10;


    private Player player;

    /**
     * The 2D array of rooms that compose the dungeon.
     */
    private Room[][] dungeon;

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

    /**
     * Initializes the dungeon and links the rooms together.
     */
    private void generateDungeon() {
//        [row][column] = [height][width]
        dungeon = new Room[HEIGHT_DUNGEON][WIDTH_DUNGEON];
        for (int row=0;row<HEIGHT_DUNGEON;row++) {
            for (int column=0;column<WIDTH_DUNGEON;column++) {
                dungeon[row][column] = new Room();
            }
        }
    }
}
