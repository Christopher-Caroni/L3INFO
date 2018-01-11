package fil.coo;

import java.util.EventListener;

public interface FileListener extends EventListener {

    /**
     * Reacts to an added file in the directory watched by the {@link FileChecker} this instance is subscribed to
     *
     * @param event the added file
     */
    void fileAdded(FileEvent event);

    /**
     * Reacts to a deleted file in the directory watched by the {@link FileChecker} this instance is subscribed to
     *
     * @param event the deleted file
     */
    void fileRemoved(FileEvent event);
}
