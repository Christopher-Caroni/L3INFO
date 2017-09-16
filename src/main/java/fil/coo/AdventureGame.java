package fil.coo;

import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.other.Direction;
import fil.coo.spawnables.beings.Monster;
import fil.coo.spawnables.beings.Player;
import fil.coo.spawnables.items.interfaces.Item;
import fil.coo.structures.Room;
import fil.coo.structures.RoomFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Hello world!
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

    public static void main(String[] args) {
        AdventureGame adventureGame = new AdventureGame();
        adventureGame.startGame();
    }

    /**
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
        boolean[][] visitedRooms = new boolean[HEIGHT_DUNGEON][WIDTH_DUNGEON];
        generateRooms(visitedRooms);
        initializeNeighbours(visitedRooms);
    }

    /**
     * Generates the individual {@link Room}s of the dungeon.
     *
     * @param visitedRooms
     */
    private void generateRooms(boolean[][] visitedRooms) {
//        [row][column] = [height][width]
        dungeon = new Room[HEIGHT_DUNGEON][WIDTH_DUNGEON];

        RoomFactory roomFactory = new RoomFactory();

        for (int row = 0; row < HEIGHT_DUNGEON; row++) {
            for (int column = 0; column < WIDTH_DUNGEON; column++) {
                dungeon[row][column] = roomFactory.generateRoom();
                visitedRooms[row][column] = false;
            }
        }
    }

    /**
     * Trigger for the recursive algorithm that sets rooms as neighbours.
     *
     * @param visitedRooms
     * @see <a href>http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking</a>
     */
    private void initializeNeighbours(boolean[][] visitedRooms) {
        Random random = new Random();
        Stack<Room> stack = new Stack<>();

        // Step 1: choose random cell
        markStartingRoom(stack, visitedRooms, random);

        // Step 1: get random neighbours and assign them
        scanNonVisitedRooms(stack, visitedRooms, random);
    }

    /**
     * Gets a random room to start with, marks it as visited and pushes it to the stack
     *
     * @param stack        the stack of rooms that will be used to get neighbours from
     * @param visitedRooms the grid of visited rooms
     * @param random       our Random number generator
     */
    private void markStartingRoom(Stack<Room> stack, boolean[][] visitedRooms, Random random) {
        int x = random.nextInt(WIDTH_DUNGEON);
        int y = random.nextInt(HEIGHT_DUNGEON);

//        [row][column] = [height][width]
        Room startingRoom = dungeon[y][x];
        visitedRooms[y][x] = true;

        // add it to the stack
        stack.push(startingRoom);
    }

    /**
     * The entry point for the recursive algorithm. Will self-call until the stack is empty.
     *
     * @param stack        the stack of rooms to verify unlinked neighbours
     * @param visitedRooms the grid of visited rooms
     * @param random       our Random number generator
     */
    private void scanNonVisitedRooms(Stack<Room> stack, boolean[][] visitedRooms, Random random) {
        if (!stack.isEmpty()) {
            // Step 2
            verifyUnlinkedNeighbours(stack, visitedRooms, random);
        }
        // END: we reached the the first room again and it didn't have any unlinked neighbours so all rooms have been visited and linked
    }

    /**
     * Gets neighbours for the top room on the stack and either
     * <ul>
     * <li>links the neighbour to the room, pushes it to the stack and calls {@link #scanNonVisitedRooms(Stack, boolean[][], Random)}</li>
     * <li>removes the top room from the stack if its neighbours have already been linked and calls {@link #scanNonVisitedRooms(Stack, boolean[][], Random)} which will then use the previous room in the stack</li>
     * </ul>
     *
     * @param stack        the stack of rooms to verify unlinked neighbours
     * @param visitedRooms the grid of visited rooms
     * @param random       our Random number generator
     */
    private void verifyUnlinkedNeighbours(Stack<Room> stack, boolean[][] visitedRooms, Random random) {
        // Step 2a: get neighbours that haven't been visited
        Room currentRoom = stack.peek();
        List<Room> neighbours = getNonVisitedNeighbours(currentRoom.getX(), currentRoom.getY(), visitedRooms);

        if (neighbours.size() != 0) {
            // Step 2b: choose random neighbour, link the rooms and repeat step 2a
            Room randomNeighbour = neighbours.get(random.nextInt(neighbours.size()));
            linkNeighbours(stack, visitedRooms, randomNeighbour);
        } else {
            // Step 2c: no valid neighbour, backtrack by popping the stack and calling this method again
            stack.pop();
        }

        scanNonVisitedRooms(stack, visitedRooms, random);
    }

    /**
     * Attempt to link the randomNeighbour to the top Room in the stack and then pushes it to the stack.
     *
     * @param stack           the stack of rooms to verify unlinked neighbours
     * @param visitedRooms    the grid of visited rooms
     * @param randomNeighbour the random neighbour that has not been visited nor been linked to another room and which we will now attempt to link to the top of the stack.
     */
    private void linkNeighbours(Stack<Room> stack, boolean[][] visitedRooms, Room randomNeighbour) {
        Room currentRoom = stack.peek();
        try {
            Room.setRoomsAsNeighbours(currentRoom, randomNeighbour);

            visitedRooms[randomNeighbour.getY()][randomNeighbour.getX()] = true;
            stack.push(randomNeighbour);
        } catch (RoomsAreNotNeighboursException e) {
            e.printStackTrace();
        }
    }


    /**
     * Checks the four neighbours of a {@link Room} using its coordinates and returns those that have NOT been visited.
     * Neighbours in this context refers to the Rooms neighbour strictly by their position in the grid.
     *
     * @param x       the vertical coordinate of the current {@link Room}
     * @param y       the vertical coordinate of the current {@link Room}
     * @param visited the grid of visited neighbours so we don't select a same {@link Room} twice.
     * @return a list of neighbours that haven't been visited
     */
    private List<Room> getNonVisitedNeighbours(int x, int y, boolean[][] visited) {
        List<Room> neighbours = new ArrayList<>();
        int nextX, nextY;

        // above
        nextX = x;
        nextY = y - 1;
        if (isInBounds(nextX, nextY) && !visited[nextY][nextX]) {
            neighbours.add(dungeon[nextY][nextX]);
        }

        // below
        nextX = x;
        nextY = y + 1;
        if (isInBounds(nextX, nextY) && !visited[nextY][nextX]) {
            neighbours.add(dungeon[nextY][nextX]);
        }

        // left
        nextX = x - 1;
        nextY = y;
        if (isInBounds(nextX, nextY) && !visited[nextY][nextX]) {
            neighbours.add(dungeon[nextY][nextX]);
        }

        // right
        nextX = x + 1;
        nextY = y;
        if (isInBounds(nextX, nextY) && !visited[nextY][nextX]) {
            neighbours.add(dungeon[nextY][nextX]);
        }

        return neighbours;
    }


    /**
     * @param x the horizontal coordinate to check
     * @param y the vertical coordinate to check
     * @return if x and y are in the bounds of the dungeon
     */
    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < WIDTH_DUNGEON && y >= 0 && y < HEIGHT_DUNGEON;
    }

}
