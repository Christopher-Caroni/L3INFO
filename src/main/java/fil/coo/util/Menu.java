package fil.coo.util;

import fil.coo.other.Selectable;

import java.util.List;

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

    public <T extends Selectable> T chooseElement(List<? extends Selectable> possibleMonsters) {
        // TODO
        return null;
    }
}
