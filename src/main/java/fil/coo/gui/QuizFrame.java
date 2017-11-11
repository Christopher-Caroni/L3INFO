package fil.coo.gui;

import fil.coo.gui.panels.QuestionPanel;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class QuizFrame extends JFrame {

    private static final Logger logger = Logger.getLogger(QuizFrame.class.getSimpleName());

    private Dimension frameDim;

    private JScrollPane scrollPane;

    private JPanel questionsPanel;

    public QuizFrame(int nbQuestions) {

        setBasicProperties();

        setupRootPanel(nbQuestions);

//        pack() must come before setLocationRelativeTo
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void setupRootPanel(int nbQuestions) {
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());

        scrollPane = new JScrollPane(rootPanel);
        add(scrollPane);

        questionsPanel = new JPanel();
        questionsPanel.setLayout(new GridLayout(nbQuestions, 1));

        rootPanel.add(Box.createHorizontalGlue(), BorderLayout.LINE_START);
        rootPanel.add(questionsPanel, BorderLayout.CENTER);
        rootPanel.add(Box.createHorizontalGlue(), BorderLayout.LINE_END);
    }

    protected void setBasicProperties() {
        setTitle("Quiz");
        frameDim = new Dimension(800, 800);
        setPreferredSize(frameDim);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addQuestionPanel(QuestionPanel questionPanel, boolean refresh) {
        logger.debug("Added question panel");
        questionsPanel.add(questionPanel);

        if (refresh) {
            pack();
            repaint();
        }
    }
}
