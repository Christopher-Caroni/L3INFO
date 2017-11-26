package fil.coo;

import java.util.EventObject;

public class FileEvent extends EventObject{

    public FileEvent(String filename) {
        super(filename);
    }

}
