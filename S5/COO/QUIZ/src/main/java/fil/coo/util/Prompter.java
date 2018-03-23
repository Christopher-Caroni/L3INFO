package fil.coo.util;

import java.util.Scanner;

/**
 * Static instance to access properties that need to be kept alive during the whole app lifecycle.
 */
public class Prompter {

    private static final Prompter INSTANCE = new Prompter();

    private Scanner scanner;

    private Prompter() {
        scanner = new Scanner(System.in);
    }

    public static Prompter getInstance() {
        return INSTANCE;
    }

    public void close() {
        scanner.close();
    }

    public String nextLine() {
        return scanner.nextLine();
    }
}
