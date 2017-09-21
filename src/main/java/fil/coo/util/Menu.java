package fil.coo.util;

import fil.coo.other.Direction;
import fil.coo.other.Selectable;
import fil.coo.structures.Room;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Menu instance;

    private static final String CORNER = "+";
    private static final String VERTICAL_SEPARATOR = "|";
    private static final String HORIZONTAL_SEPARATOR = "=";
    private static final String DOOR = "D";
    private static final String SPACE = " ";

    private Menu() {
    }

    public static Menu getInstance() {
        if (instance == null) {
            synchronized (Menu.class) {
                if (instance == null) {
                    instance = new Menu();
                }
            }
        }
        return instance;
    }

    /**
     * Prints the list of elements and asks the user to choose one with {@link #readChoiceInt(int)}
     *
     * @param elementList the list of elements to choose from
     * @param <T>         must be a selectable type of class
     * @return the element the user chose
     */
    public <T extends Selectable> T chooseElement(List<T> elementList) {
        System.out.println("Choose an element between 0 and " + (elementList.size() - 1));
        for (int i = 0; i < elementList.size(); i++) {
            System.out.println(i + " - " + elementList.get(i).getMenuDescription());
        }

        int choice = readChoiceInt(elementList.size());
        return elementList.get(choice);
    }

    /**
     * @param upperBound excluded
     * @return the user's choice
     */
    private int readChoiceInt(int upperBound) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice <= 0 || choice >= upperBound) {
            System.out.println("Enter a choice from 0 to " + (upperBound - 1));
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                // consume the input (that is not an integer)
                scanner.skip(".*");
            }
        }
        return choice;
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
            System.out.println("Printing room at position: " + room.coordsToString());
            System.out.println(room.neighboursToString());
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
            System.out.println("");
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
        System.out.println("");
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
        stringBuilder.append(currentRoom.getNumberOfItems());
        stringBuilder.append(" items, ");
        stringBuilder.append(currentRoom.getNumberOfMonsters());
        stringBuilder.append(" monsters, and has");
        stringBuilder.append(currentRoom.getNumberOfNeighbours());
        stringBuilder.append(" neighbours");
        System.out.println(stringBuilder.toString());
    }
}
