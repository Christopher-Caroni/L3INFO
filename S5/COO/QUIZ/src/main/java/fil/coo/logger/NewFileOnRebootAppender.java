package fil.coo.logger;

import org.apache.log4j.RollingFileAppender;

import java.time.LocalDateTime;

public class NewFileOnRebootAppender extends RollingFileAppender {

    @Override
    public void setFile(String file) {
        super.setFile(prependDate(file));
    }

    private static String prependDate(String filename) {
        String date = "_" + LocalDateTime.now().toString().replace(":", ".");

        StringBuilder filenameWithDate = new StringBuilder(filename);
        int extensionIndex = filename.indexOf(".log");
        filenameWithDate.insert(extensionIndex, date);

        return filenameWithDate.toString();
    }
}