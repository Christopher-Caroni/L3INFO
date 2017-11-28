package fil.coo.view.impl;

import fil.coo.view.AbstractView;
import fil.coo.view.CustomJMenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditorFrame extends AbstractView {

    private JFrame rootFrame;
    private Dimension frameDim;

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuTools;
    private JMenu menuHelp;
    private List<CustomJMenuItem> itemsMenu;

    private JScrollPane mainPanel;
    private JTextArea textField;

    public EditorFrame() {

        rootFrame = new JFrame();
        setBasicProperties();
        setupRootPanel();
        doFinalPrep();
    }

    /**
     * Set the different basic properties of the Editor
     */
    private void setBasicProperties() {
        rootFrame.setTitle("Extendable Editor");
        frameDim = new Dimension(1000, 1000);
        rootFrame.setPreferredSize(frameDim);
        rootFrame.setLayout(new BorderLayout());

        rootFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    /**
     * Sets up the whole panel hierarchy
     *
     */
    private void setupRootPanel() {
        setupJMenuBar();
        setupScrollPane();
    }

    /**
     * set up the {@link JScrollPane} to write on our editor
     */
    private void setupScrollPane() {
        textField = new JTextArea();
        mainPanel = new JScrollPane(textField);
        rootFrame.add(mainPanel);
    }

    /**
     * Add and set the different {@link JMenu} on the {@link JMenuBar}
     */
    private void setupJMenuBar() {
        menuBar  = new JMenuBar();
        setJMenu();
        menuBar.add(menuFile);
        menuBar.add(menuTools);
        menuBar.add(menuHelp);

        rootFrame.setJMenuBar(menuBar);
    }

    /**
     * Initialize the different {@link JMenu}
     */
    private void setJMenu() {
        menuFile = new JMenu("File");
        menuTools = new JMenu("Tools");
        menuHelp = new JMenu("Help");
    }

    /**
     * Some final preparations must be do at the end like Packs
     */
    private void doFinalPrep() {
        rootFrame.pack();
        rootFrame.setLocationRelativeTo(null);
    }

    @Override
    public void updateText(String text) {
    }

    @Override
    public void setVisible(boolean visible) {
        rootFrame.setVisible(visible);
    }

    public static void main(String[] args) {
        EditorFrame e = new EditorFrame();
        e.setVisible(true);
    }
}
