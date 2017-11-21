package fil.coo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileChecker {

    private static final String FOLDER_PATH = "/plugins";
    private Timer timer;
    private FilenameFilter filenameFilter;
    private List<FileListener> listeners;
    private List<String> memory;

    public FileChecker(FilenameFilter filenameFilter) {
        initList();
        initTimer();
        this.filenameFilter = filenameFilter;
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

    private void checkFiles() {

        List<String> filenames = getFilenames();

        checkNewFiles(filenames);
        checkRemovedFiles(filenames);
    }


    private List<String> getFilenames() {
        List<String> filenames = new ArrayList<>();
        File dir = new File(FOLDER_PATH);
        File[] files = dir.listFiles(this.filenameFilter);

        for (File f : files) {
            filenames.add(f.getName());
        }
        return filenames;
    }

    private void checkNewFiles(List<String> filenames) {

        for (String filename : filenames) {
            if (!(memory.contains(filename))) {
                fireAdded();
            }
        }
    }

    private void fireAdded() {
        //TODO
    }


    private void checkRemovedFiles(List<String> filenames) {
        for (String filename : memory) {
            if (!(filenames.contains(filename))) {
                fireRemoved();
            }
        }
    }

    private void fireRemoved() {
        //TODO
    }

    private class FileActionLister implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            checkFiles();
        }
    }
}
