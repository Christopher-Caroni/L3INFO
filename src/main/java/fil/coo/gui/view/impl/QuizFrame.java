package fil.coo.gui.view.impl;

import fil.coo.gui.view.AbstractQuestionView;
import fil.coo.gui.view.AbstractQuizView;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class QuizFrame extends AbstractQuizView {

    private static final Logger logger = Logger.getLogger(QuizFrame.class.getSimpleName());

    private JFrame quizFrame;

    private Dimension frameDim;
    private JScrollPane scrollPane;
    private JPanel questionsPanel;
    private JPanel mainPanel;
    private JButton validateButton;

    public QuizFrame(int nbQuestions) {
        super(nbQuestions);

        quizFrame = new JFrame();

        setBasicProperties();
        setupRootPanel(nbQuestions);
        doFinalPrep();
    }

    private void setBasicProperties() {
        quizFrame.setTitle("Quiz");
        frameDim = new Dimension(800, 800);
        quizFrame.setPreferredSize(frameDim);
        quizFrame.setLayout(new BorderLayout());

        quizFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Sets up the whole panel hierarchy
     *
     * @param nbQuestions the number of questions that the questions panel will hold
     */
    private void setupRootPanel(int nbQuestions) {
        setupScrollPane(nbQuestions);
        setupValidatePanel();
    }

    private void doFinalPrep() {
        //        pack() must come before setLocationRelativeTo
        quizFrame.pack();
        quizFrame.setLocationRelativeTo(null);
    }

    /**
     * Sets up the bottom panel that has the validate button
     */
    private void setupValidatePanel() {
        JPanel validatePanel = new JPanel();
        validateButton = new JButton("Validate");
        validatePanel.add(validateButton);

        quizFrame.add(validatePanel, BorderLayout.SOUTH);
    }

    /**
     * Sets up the scroll pane with the actual model
     *
     * @param nbQuestions the number of questions in the model
     */
    private void setupScrollPane(int nbQuestions) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        scrollPane = new JScrollPane(mainPanel);
        quizFrame.add(scrollPane, BorderLayout.CENTER);

        setupQuestionsPanel(nbQuestions);
        setupMainPanel();
    }

    /**
     * Sets up the panel containing the rows of {@link JPanel}s of questions
     *
     * @param nbQuestions the number of questions in the model
     */
    private void setupQuestionsPanel(int nbQuestions) {
        questionsPanel = new JPanel();
        questionsPanel.setLayout(new GridLayout(nbQuestions, 1));
    }

    /**
     * Sets up the mainPanel that contains the questionsPanel with glue on the sides.
     */
    private void setupMainPanel() {
        mainPanel.add(Box.createHorizontalGlue(), BorderLayout.LINE_START);
        mainPanel.add(questionsPanel, BorderLayout.CENTER);
        mainPanel.add(Box.createHorizontalGlue(), BorderLayout.LINE_END);
    }

    /**
     * Adds a {@link QuestionPanel} to this frame
     *  @param questionView the panel to add
     * @param refresh       if this frame should repaint right away
     */
    public void addQuestionPanel(AbstractQuestionView questionView, boolean refresh) {
        logger.debug("Added question panel");
        questionsPanel.add(questionView.getView());

        if (refresh) {
            quizFrame.pack();
            quizFrame.repaint();
        }
    }

    @Override
    public void setVisible(boolean visible) {
        quizFrame.setVisible(visible);
    }

    @Override
    public Component getView() {
        return quizFrame;
    }
}
