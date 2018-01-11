package fil.coo.other;


/**
 * Any class that could be selected by the user must implement this interface.
 */
public interface Selectable {

    /**
     * @return a description of this {@link Selectable} that will be given to the user if it is selectable through the menu.
     */
    String getMenuDescription();
}
