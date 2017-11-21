package fil.coo;

import java.util.EventListener;

public interface FileListener extends EventListener {

    void fileAdded(FileEvent e);
    void fileRemoved(FileEvent e);
}
