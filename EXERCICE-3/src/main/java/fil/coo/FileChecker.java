package fil.coo;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FileChecker {

    private static final Logger logger = Logger.getLogger(FileChecker.class.getSimpleName());

    private static final int CHECK_DELAY = 1000;

    private Timer timer;
    private String directoryToWatch;
    private File dirFile;

    private final FilenameFilter filenameFilter;
    private List<FileListener> listeners;
    private List<String> memory;

    public FileChecker(String directoryToWatch, FilenameFilter filenameFilter) throws IOException {
        initDir(directoryToWatch);
        this.listeners = new ArrayList<>();
        this.memory = new ArrayList<>();
        this.filenameFilter = filenameFilter;

        initTimer();
    }

    private void initDir(String directoryToWatch) throws IOException {
        if (directoryToWatch == null) {
            throw new NullPointerException("filepath is null");
        }

        this.directoryToWatch = directoryToWatch;
        dirFile = new File(directoryToWatch);

        if (!dirFile.isDirectory()) {
            throw new IOException(dirFile.getAbsolutePath() + "\" is not a directory");
        }
    }

    /**
     * Initializes {@link #timer} to call {@link #checkChangedFiles()} every {@link #CHECK_DELAY} milliseconds
     */
    private void initTimer() {
        timer = new Timer(CHECK_DELAY, e -> checkChangedFiles());
    }


    /**
     * Starts repeatedly checking {@link #directoryToWatch} with {@link #timer}
     */
    public void start() {
        logger.debug("Started watching directory: " + dirFile.getAbsolutePath());
        timer.start();
    }

    /**
     * Checks for changes in the repository folder
     */
    protected void checkChangedFiles() {

        List<String> filenames = getCurrentContents();

        checkNewFiles(filenames);
        checkRemovedFiles(filenames);
    }


    /**
     * @return the list of current files in {@link #directoryToWatch} or an empty list if an IO error occurs
     */
    protected List<String> getCurrentContents() {
        logger.debug("listing files in dir: " + dirFile.getAbsolutePath());

        String[] list = dirFile.list(this.filenameFilter);
        return list == null ? new ArrayList<>() : Arrays.asList(list);
    }

    /**
     * Iterates over currentFiles and calls {@link #fireFileAdded(String)} if the file did NOT exist
     * previously
     *
     * @param currentFiles the list of files currently in {@link #directoryToWatch}
     */
    protected void checkNewFiles(List<String> currentFiles) {
        for (String filename : currentFiles) {
            if (!(memory.contains(filename))) {
                memory.add(filename);
                fireFileAdded(filename);
            }
        }
    }

    /**
     * Iterates over {@link #memory} and calls {@link #fireFileRemoved(String)}} if the file did exist
     * previously
     *
     * @param currentFiles the list of files currently in {@link #directoryToWatch}
     */
    protected void checkRemovedFiles(List<String> currentFiles) {

        for (Iterator<String> it = memory.iterator(); it.hasNext();) {
            String preExistingFile = it.next();
            if (!currentFiles.contains(preExistingFile)) {
                fireFileRemoved(preExistingFile);
                it.remove();
            }
        }
    }

    /**
     * Notifies all listeners in {@link #listeners} about an added file
     *
     * @param addedFile the filename of the added file
     */
    protected void fireFileAdded(String addedFile) {
        logger.debug("Notifying about added file: " + addedFile);

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
    protected void fireFileRemoved(String deletedFile) {
        logger.debug("Notifying about deleted file: " + deletedFile);

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
