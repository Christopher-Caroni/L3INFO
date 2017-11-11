package fil.coo.gui;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class QuizFrame extends JFrame {

    private static final Logger logger = Logger.getLogger(QuizFrame.class.getSimpleName());

    private Dimension frameDim;

    public QuizFrame(int nbQuestions) {

        setBasicProperties(nbQuestions);


//        pack() must come before setLocationRelativeTo
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    protected void setBasicProperties(int nbQuestions) {
        setTitle("Quiz");
        frameDim = new Dimension(600, 600);
        setPreferredSize(frameDim);

        setLayout(new GridLayout(nbQuestions, 1));
    }

    public void addQuestionPanel(QuestionPanel questionPanel, boolean refresh) {
        logger.debug("Added question panel");
        add(questionPanel);

        if (refresh) {
            pack();
            repaint();
        }
    }
}
