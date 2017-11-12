package fil.coo.util;

import java.util.Scanner;

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
