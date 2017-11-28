package fil.coo.view.impl;

import fil.coo.view.AbstractView;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends AbstractView {

    private JFrame rootFrame;
    private Dimension frameDim;

    private CustomJMenuBar menuBar;

    private JScrollPane mainPanel;
    private JTextArea textArea;

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
        frameDim = new Dimension(700, 500);
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

    private void setupJMenuBar() {
        menuBar = new CustomJMenuBar();
        rootFrame.setJMenuBar(menuBar);
    }

    /**
     * set up the {@link JScrollPane} to write on our editor
     */
    private void setupScrollPane() {
        textArea = new JTextArea();
        mainPanel = new JScrollPane(textArea);
        rootFrame.add(mainPanel);
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

    @Override
    public String getText() {
        return textArea.getText();
    }



}
