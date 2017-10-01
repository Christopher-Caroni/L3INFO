package fil.coo.structures;

import com.rits.cloning.Cloner;
import fil.coo.exception.RoomsAreNotNeighboursException;
import fil.coo.gui.GenerationFrame;
import fil.coo.util.AdventureGameOptions;
import fil.coo.util.Menu;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Dungeon {

    final static Logger logger = Logger.getLogger(Dungeon.class);

    protected static final int DEFAULT_WIDTH_DUNGEON = 5;
    protected static final int DEFAULT_HEIGHT_DUNGEON = 5;

    /**
     * The 2D array of rooms that compose the dungeon.
     */
    private Room[][] roomsArray;

    private int dungeonHeight;
    private int dungeonWidth;

    private AdventureGameOptions options;
    private GenerationFrame generationFrame;

    /**
     * Applies the custom sizes if different from {@link #DEFAULT_HEIGHT_DUNGEON} & {@link #DEFAULT_WIDTH_DUNGEON}. Creates the array of rooms and defines exit.
     *
     * @param options the {@link AdventureGameOptions} containing the options for the custom sizes.
     */
    public Dungeon(AdventureGameOptions options) {
        this.options = options;
        setCustomSizes();
        generateRooms();
        markExitRoom();
    }

    private void setCustomSizes() {
        logger.debug("Custom sizes w,h=" + options.customDungeonWidth + "," + options.customDungeonHeight);
        if (options.customDungeonHeight == 0 || options.customDungeonHeight == DEFAULT_HEIGHT_DUNGEON) {
            logger.debug("using default height=" + DEFAULT_HEIGHT_DUNGEON);
            this.dungeonHeight = DEFAULT_HEIGHT_DUNGEON;
        } else {
            logger.debug("using custom height=" + options.customDungeonHeight);
            this.dungeonHeight = options.customDungeonHeight;
        }
        if (options.customDungeonWidth == 0 || options.customDungeonWidth == DEFAULT_WIDTH_DUNGEON) {
            logger.debug("using default width=" + DEFAULT_WIDTH_DUNGEON);
            this.dungeonWidth = DEFAULT_WIDTH_DUNGEON;
        } else {
            logger.debug("using custom width=" + options.customDungeonWidth);
            this.dungeonWidth = options.customDungeonWidth;
        }
    }

    /**
     * Starts the process to link the rooms together.
     */
    public void generateLinks() {
        boolean[][] visitedRooms = new boolean[dungeonHeight][dungeonWidth];

        if (options.displayGeneration) {
            generationFrame = new GenerationFrame(roomsArray);
        }

        initializeNeighbours(visitedRooms);
    }

    /**
     * Generates the individual {@link Room}s of the roomsArray.
     */
    private void generateRooms() {
//        [row][column] = [height][width]
        roomsArray = new Room[dungeonHeight][dungeonWidth];

        RoomFactory roomFactory = new RoomFactory();

        for (int row = 0; row < dungeonHeight; row++) {
            for (int column = 0; column < dungeonWidth; column++) {
                roomsArray[row][column] = roomFactory.generateRoom(column, row);
            }
        }
    }

    /**
     * Trigger for the recursive algorithm that sets rooms as neighbours.
     *
     * @param visitedRooms the array of rooms already linked as neighbours
     * @see <a href="http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking">http://weblog.jamisbuck.org: The algorithm online</a>
     */
    private void initializeNeighbours(boolean[][] visitedRooms) {
        Random random = new Random();
        Stack<Room> stack = new Stack<>();

        // Step 1: choose random cell
        markStartingRoom(stack, visitedRooms, random);

        // Step 1: get random neighbours and assign them
        // further steps in scanNonVisitedRooms()
        scanNonVisitedRooms(stack, visitedRooms, random);

        if (options.displayGeneration) {
            logger.info("Finished generation");
        }
        if (isInBounds(options.debugRoomX, options.debugRoomY)) {
            Menu.getInstance().printRoom(getRoom(options.debugRoomX, options.debugRoomY), true);
        }
    }

    private void markExitRoom() {
        Random random = new Random();

        int x = random.nextInt(roomsArray[0].length);
        int y = random.nextInt(roomsArray.length);
        roomsArray[y][x].setIsExitRoom(true);
    }

    /**
     * Gets a random room to start with, marks it as visited and pushes it to the stack
     *
     * @param stack        the stack of rooms that will be used to get neighbours from
     * @param visitedRooms the grid of visited rooms
     * @param random       our Random number generator
     */
    private void markStartingRoom(Stack<Room> stack, boolean[][] visitedRooms, Random random) {
        int x = random.nextInt(dungeonWidth);
        int y = random.nextInt(dungeonHeight);

//        [row][column] = [height][width]
        Room startingRoomForGeneration = roomsArray[y][x];
        visitedRooms[y][x] = true;

        // add it to the stack
        stack.push(startingRoomForGeneration);
        if (options.displayGeneration) {
            generationFrame.addInitialRoom(startingRoomForGeneration);
        }
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

            tryDisplay();
            verifyUnlinkedNeighbours(stack, visitedRooms, random);
        }
        // END: we reached the the first room again and it didn't have any unlinked neighbours so all rooms have been visited and linked
    }

    /**
     * Tries to refresh the dungeonFrame if it was already initialized and then calls wait so you can see the maze algorithm progression.
     */
    private void tryDisplay() {
        if (options.displayGeneration && generationFrame != null) {
            generationFrame.repaint();
            try {
                Thread.sleep(options.generationWaitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

        if (!neighbours.isEmpty()) {
            // Step 2b: choose random neighbour, link the rooms and repeat step 2a
            Room randomNeighbour = neighbours.get(random.nextInt(neighbours.size()));
            linkNeighbours(stack, visitedRooms, randomNeighbour);
        } else {
            // Step 2c: no valid neighbour, backtrack by popping the stack and calling this method again
            stack.pop();
            if (options.displayGeneration) {
                generationFrame.pop();
            }
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
            if (options.displayGeneration) {
                generationFrame.push(new Cloner().deepClone(randomNeighbour)); // deep clone so we don't accidentally modify the instance
            }
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
        int nextX;
        int nextY;

        // above
        nextX = x;
        nextY = y - 1;
        if (isInBounds(nextX, nextY) && !visited[nextY][nextX]) {
            neighbours.add(roomsArray[nextY][nextX]);
        }

        // below
        nextX = x;
        nextY = y + 1;
        if (isInBounds(nextX, nextY) && !visited[nextY][nextX]) {
            neighbours.add(roomsArray[nextY][nextX]);
        }

        // left
        nextX = x - 1;
        nextY = y;
        if (isInBounds(nextX, nextY) && !visited[nextY][nextX]) {
            neighbours.add(roomsArray[nextY][nextX]);
        }

        // right
        nextX = x + 1;
        nextY = y;
        if (isInBounds(nextX, nextY) && !visited[nextY][nextX]) {
            neighbours.add(roomsArray[nextY][nextX]);
        }

        return neighbours;
    }


    /**
     * @param x the horizontal coordinate to check
     * @param y the vertical coordinate to check
     * @return if x and y are in the bounds of the roomsArray
     */
    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < dungeonWidth && y >= 0 && y < dungeonHeight;
    }

    public Room getRoom(int xCoord, int yCoord) {
        return roomsArray[yCoord][xCoord];
    }

    /**
     * @return a random room in the dungeon
     */
    public Room getRandomRoom() {
        Random random = new Random();
        int x = random.nextInt(roomsArray[0].length);
        int y = random.nextInt(roomsArray.length);
        return roomsArray[y][x];
    }

    /**
     * @return the width of the dungeon (the array).
     */
    public int getWidth() {
        return roomsArray[0].length;
    }

    /**
     * @return the height of the dungeon (the array).
     */
    public int getHeight() {
        return roomsArray.length;
    }

    public Room[][] getRoomsArray() {
        return roomsArray;
    }
}
