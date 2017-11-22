package fil.coo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileChecker implements FileListener {

    private static final String REPOSITORY_PATH = "plugins";
    
    private Timer timer;
    private final FilenameFilter filenameFilter;
    private List<FileListener> listeners;
    private List<String> memory;

    public FileChecker(FilenameFilter filenameFilter) {
        this.filenameFilter = filenameFilter;

        initList();
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(1000, new FileActionLister());
    }

    private void initList() {
        listeners = new ArrayList<>();
        memory = new ArrayList<>();
    }

    public void start() {
        timer.start();
    }

    /**
     * Checks for changes in the repository folder
     */
    private void checkChangedFiles() {

        List<String> filenames = getCurrentContents();

        checkNewFiles(filenames);
        checkRemovedFiles(filenames);
    }


    /**
     * @return the list of current files in {@link #REPOSITORY_PATH}
     */
    private List<String> getCurrentContents() {
        File dir = new File(REPOSITORY_PATH);
        return Arrays.asList(dir.list(this.filenameFilter));
    }

    /**
     * Iterates over currentFiles and calls {@link #fileAdded(FileEvent)} if the file did NOT exist
     * previously
     *
     * @param currentFiles the list of files currently in {@link #REPOSITORY_PATH}
     */
    private void checkNewFiles(List<String> currentFiles) {
        for (String filename : currentFiles) {
            if (!(memory.contains(filename))) {
                fireAdded(filename);
            }
        }
    }

    /**
     * Iterates over {@link #memory} and calls {@link #fileRemoved(FileEvent)}} if the file did exist
     * previously
     *
     * @param currentFiles the list of files currently in {@link #REPOSITORY_PATH}
     */
    private void checkRemovedFiles(List<String> currentFiles) {
        for (String preExistingFile : memory) {
            if (!(currentFiles.contains(preExistingFile))) {
                fireRemoved();
            }
        }
    }

    private void fireAdded(String filename) {
        FileEvent event = new FileEvent(filename);
        // TODO notify
    }

    private void fireRemoved() {
        //TODO
    }

    @Override
    public void fileAdded(FileEvent e) {

    }

    @Override
    public void fileRemoved(FileEvent e) {

    }

    private class FileActionLister implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            checkChangedFiles();
        }
    }
}
