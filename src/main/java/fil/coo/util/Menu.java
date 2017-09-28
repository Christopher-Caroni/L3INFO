package fil.coo.util;

import fil.coo.other.Direction;
import fil.coo.other.Selectable;
import fil.coo.structures.Room;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    final static Logger logger = Logger.getLogger(Menu.class);

    private static Menu instance;

    private Scanner scanner;

    private static final String CORNER = "+";
    private static final String VERTICAL_SEPARATOR = "|";
    private static final String HORIZONTAL_SEPARATOR = "=";
    private static final String DOOR = "D";
    private static final String SPACE = " ";

    private Menu() {
        scanner = new Scanner(System.in);
    }

    public static synchronized Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    /**
     * Prints the list of elements and asks the user to choose one with {@link #readChoiceInt(int, List)}
     *
     * @param elementList the list of elements to choose from
     * @param <T>         must be a selectable type of class
     * @return the element the user chose
     */
    public <T extends Selectable> T chooseElement(List<T> elementList) {
        informChoice(elementList.size());
        for (int i = 0; i < elementList.size(); i++) {
            logger.info(i + " - " + elementList.get(i).getMenuDescription());
        }

        int choice = readChoiceInt(elementList.size(), elementList);
        logger.info("You chose \"" + elementList.get(choice).getMenuDescription() + "\"");
        return elementList.get(choice);
    }

    /**
     * @param upperBound  excluded
     * @param elementList the list of the choices
     * @return the user's choice
     */
    private int readChoiceInt(int upperBound, List<? extends Selectable> elementList) {
        int choice = -1;
        boolean invalidChoice = true;
        while (invalidChoice) {
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                // consume the input (that is not an integer)
                scanner.skip(".*");
            }
            invalidChoice = choice < 0 || choice >= upperBound;
            if (invalidChoice) {
                logger.info("Invalid choice.");
                informChoice(elementList.size());
                for (int i = 0; i < elementList.size(); i++) {
                    logger.info(i + " - " + elementList.get(i).getMenuDescription());
                }
            }
        }
        return choice;
    }

    private void informChoice(int upperBound) {
        logger.info("\nPlease enter a choice from 0 to " + (upperBound - 1));
    }

    /**
     * Prints a room with doors to available neighbours
     *
     * @param room the {@link Room} to print.
     */
    public void printRoom(Room room, boolean debug) {
        int roomHeight = 5; // only use odd numbers
        int roomWidth = (roomHeight * 2) + 1; // only use odd numbers

        int horizontalCenter = roomWidth / 2;

        if (debug) {
            logger.info("Printing room at position: " + room.coordsToString());
            logger.info(room.neighbourDirectionsToString());
        }

        // TOP OF BOX
        printHorizontalEdges(horizontalCenter, room.hasLinkedNeighbourForDirection(Direction.NORTH));

        // INSIDE
        for (int i = 0; i < roomHeight - 2; i++) {
            int insideMiddle = ((roomHeight - 2) / 2);
            if (i == insideMiddle) {
                boolean hasWest = room.hasLinkedNeighbourForDirection(Direction.WEST);
                boolean hasEast = room.hasLinkedNeighbourForDirection(Direction.EAST);
                printInside(roomWidth, hasWest, hasEast);
            } else {
                printInside(roomWidth, false, false);
            }
            logger.info("");
        }

        // BOTTOM
        printHorizontalEdges(horizontalCenter, room.hasLinkedNeighbourForDirection(Direction.SOUTH));

    }

    /**
     * Prints the inside of the box, including the vertical sides, without the top and bottom edges
     *
     * @param roomWidth the width of the room of which will be spaces
     * @param hasWest   if it should print a door for the west side
     * @param hasEast   if it should print a door for the east side
     */
    private void printInside(int roomWidth, boolean hasWest, boolean hasEast) {
        System.out.print(hasWest ? DOOR : VERTICAL_SEPARATOR);
        printMultipleString(SPACE, roomWidth);
        System.out.print(hasEast ? DOOR : VERTICAL_SEPARATOR);
    }

    /**
     * Prints the top and bottom edges.
     *
     * @param horizontalCenter the center where it will print the door if there is one
     * @param door             if it should print a door
     */
    private void printHorizontalEdges(int horizontalCenter, boolean door) {
        System.out.print(CORNER);
        printMultipleString(HORIZONTAL_SEPARATOR, horizontalCenter);

        System.out.print(door ? DOOR : HORIZONTAL_SEPARATOR);

        printMultipleString(HORIZONTAL_SEPARATOR, horizontalCenter);
        System.out.print(CORNER);
        logger.info("");
    }

    /**
     * Prints <b>string</b>, <b>amount</b> times consecutively without any newline
     *
     * @param string the String to print
     * @param amount the times it will print
     */
    private void printMultipleString(String string, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(string);
        }
    }

    public void printRoomDescription(Room currentRoom) {
        StringBuilder stringBuilder = new StringBuilder("This rooms contains:\n");
        stringBuilder.append("\t");
        stringBuilder.append(currentRoom.getNumberOfItems());
        stringBuilder.append(" items, ");
        stringBuilder.append(currentRoom.getNumberOfMonsters());
        stringBuilder.append(" monsters, and has ");
        stringBuilder.append(currentRoom.getNumberOfNeighbours());
        stringBuilder.append(" neighbours.");
        logger.info(stringBuilder.toString());
    }

    /**
     * Prompts the user for a name and returns it once he confirms that he wants to use it.
     *
     * @return a name
     */
    public String chooseName() {
        String playerName = "choose-name";
        boolean confirmed = false;

        while (!confirmed) {
            System.out.print("Enter your username: ");
            playerName = scanner.nextLine().trim();
            logger.info("Your username is " + playerName);

            logger.info("Do you want to use this name? [Y]es/[N]o");
            String confirmationString = scanner.nextLine().trim();
            if (confirmationString.equalsIgnoreCase("no") || confirmationString.equalsIgnoreCase("n")) {
                confirmed = false;
            } else if (confirmationString.equalsIgnoreCase("yes") || confirmationString.equalsIgnoreCase("y")) {
                confirmed = true;
            }
        }

        return playerName;
    }

    public void closeScanner() {
        scanner.close();
    }

    public void initialize() {
        scanner = new Scanner(System.in);
    }
}
