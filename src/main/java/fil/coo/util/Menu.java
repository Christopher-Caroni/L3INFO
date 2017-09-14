package fil.coo.util;

import fil.coo.other.Selectable;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Menu instance;

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
}
