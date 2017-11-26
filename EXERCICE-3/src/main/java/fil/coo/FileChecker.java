package fil.coo;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileChecker {

    private static final String REPOSITORY_PATH = "plugins";

    private static final int CHECK_DELAY = 1000;

    private Timer timer;
    private final FilenameFilter filenameFilter;
    private List<FileListener> listeners;
    private List<String> memory;

    public FileChecker(FilenameFilter filenameFilter) {
        this.filenameFilter = filenameFilter;

        initList();
        initTimer();
    }

    private void initList() {
        listeners = new ArrayList<>();
        memory = new ArrayList<>();
    }

    /**
     * Initializes {@link #timer} to call {@link #checkChangedFiles()} every {@link #CHECK_DELAY} milliseconds
     */
    private void initTimer() {
        timer = new Timer(CHECK_DELAY, e -> checkChangedFiles());
    }


    /**
     * Starts repeatedly checking {@link #REPOSITORY_PATH} with {@link #timer}
     */
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
     * @return the list of current files in {@link #REPOSITORY_PATH} or an empty list if an IO error occurs
     */
    private List<String> getCurrentContents() {
        File dir = new File(REPOSITORY_PATH);
        String[] list = dir.list(this.filenameFilter);
        return list == null ? new ArrayList<>() : Arrays.asList(list);
    }

    /**
     * Iterates over currentFiles and calls {@link #fireFileAdded(String)} if the file did NOT exist
     * previously
     *
     * @param currentFiles the list of files currently in {@link #REPOSITORY_PATH}
     */
    private void checkNewFiles(List<String> currentFiles) {
        for (String filename : currentFiles) {
            if (!(memory.contains(filename))) {
                fireFileAdded(filename);
            }
        }
    }

    /**
     * Iterates over {@link #memory} and calls {@link #fireFileRemoved(String)}} if the file did exist
     * previously
     *
     * @param currentFiles the list of files currently in {@link #REPOSITORY_PATH}
     */
    private void checkRemovedFiles(List<String> currentFiles) {
        for (String preExistingFile : memory) {
            if (!(currentFiles.contains(preExistingFile))) {
                fireFileRemoved(preExistingFile);
            }
        }
    }

    /**
     * Notifies all listeners in {@link #listeners} about an added file
     *
     * @param addedFile the filename of the added file
     */
    private void fireFileAdded(String addedFile) {
        FileEvent event = new FileEvent(addedFile);
        for (FileListener listener : listeners) {
            listener.fileAdded(event);
        }
    }

    /**
     * Notifies all listeners in {@link #listeners} about a deleted file
     *
     * @param deletedFile the filename of the deleted file
     */
    private void fireFileRemoved(String deletedFile) {
        FileEvent event = new FileEvent(deletedFile);
        for (FileListener listener : listeners) {
            listener.fileRemoved(event);
        }
    }

    /**
     * Subscribes listener to events fired by this instance
     *
     * @param listener the instance that will receive to events
     */
    public void addFileListener(FileListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Unsubscribres the listener from events fired by this instance
     *
     * @param listener the instance that will stop receiving events
     */
    public void removeFileListener(FileListener listener) {
        this.listeners.remove(listener);
    }
}
