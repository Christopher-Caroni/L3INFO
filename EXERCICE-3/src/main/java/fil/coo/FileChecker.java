package fil.coo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileChecker {


    private Timer timer;
    private FilenameFilter filenameFilter;
    private List<FileListener> listeners;
    private List<String> memory;

    public FileChecker() {
        initList();
        initTimer();
        initFilenameFilter();
    }

    private void initFilenameFilter() {
        filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                if(s.endsWith(".class")){
                    return true;
                }
                return false;
            }
        };
    }

    private void initTimer() {
        timer = new Timer(1000, new FileActionLister());
    }

    private void initList() {
        listeners = new ArrayList<>();
        memory = new ArrayList<>();
    }

    public void start(){
        timer.start();
    }

    private void checkFiles() {

    }

    private class FileActionLister implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            checkFiles();
        }
    }
}
