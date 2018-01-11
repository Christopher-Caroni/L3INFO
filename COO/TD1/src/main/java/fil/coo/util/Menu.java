package fil.coo.util;

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
        initialize();
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
