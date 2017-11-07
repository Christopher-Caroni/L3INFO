package fil.coo.logger;

import org.apache.log4j.FileAppender;

import java.time.LocalDateTime;

public class NewFileOnRebootAppender extends FileAppender {

    public NewFileOnRebootAppender() {
    }

    @Override
    public void setFile(String file) {
        super.setFile(prependDate(file));
    }

    private static String prependDate(String filename) {
        return filename + "_" + LocalDateTime.now().toString();
    }
}