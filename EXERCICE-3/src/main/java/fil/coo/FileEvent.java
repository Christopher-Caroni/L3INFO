package fil.coo;

import java.util.EventObject;

public class FileEvent extends EventObject{

    private String filename;


    public FileEvent(String filename) {
        super(filename);
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
